package yyx.news.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import yyx.news.bean.News;
import yyx.news.service.NewsService;
import yyx.util.JSONUtil;

import java.util.List;

@Controller
@RequestMapping("/news")
@CrossOrigin("*")      //允许跨域请求
public class NewsController {
    @Autowired
    NewsService newsService;

    JSONUtil jsonUtil = new JSONUtil();


    @RequestMapping("/newsList")
    @ResponseBody
    public JSONUtil newsList(){
        jsonUtil.setCode(-1);

        try{
            List<News> list = newsService.newsList();
            jsonUtil.setCode(1);
            jsonUtil.setData(list);
            jsonUtil.setMsg("获取旅游资讯成功");
        } catch (Exception e) {
            jsonUtil.setMsg("获取旅游资讯失败" + e.getMessage());
        }

        return jsonUtil;
    }
}
