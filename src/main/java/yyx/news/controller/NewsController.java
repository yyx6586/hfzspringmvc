package yyx.news.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import yyx.news.bean.News;
import yyx.news.service.NewsService;
import yyx.util.JSONUtil;
import yyx.util.StringUtils;

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
    public JSONUtil newsList(int pageNo, int pageSize){
        jsonUtil.setCode(-1);
        int pageAll = 0;

        try{
            List<List> list = newsService.newsList(pageNo, pageSize);

            List newslists = list.get(0);
            if(newslists.size() % pageSize != 0){
                pageAll = newslists.size() / pageSize + 1;
            }else {
                pageAll = newslists.size() / pageSize;
            }

            List newslist = list.get(1);

            jsonUtil.setCode(1);
            jsonUtil.setNumber(pageAll);
            jsonUtil.setData(newslist);
            jsonUtil.setMsg("获取旅游资讯成功");
        } catch (Exception e) {
            jsonUtil.setMsg("获取旅游资讯失败" + e.getMessage());
        }

        return jsonUtil;
    }

    @RequestMapping("/newsDetail")
    @ResponseBody
    public JSONUtil newsDetail(String id){
        jsonUtil.setCode(-1);

        if(StringUtils.isNullOrEmpty(id)){
            jsonUtil.setMsg("id 不能为空");
            return jsonUtil;
        }

        try{
            List<News> list = newsService.newsDetail(id);
            jsonUtil.setCode(1);
            jsonUtil.setMsg("获取信息成功");
            jsonUtil.setData(list);
        } catch (Exception e) {
            jsonUtil.setMsg("获取信息失败" + e.getMessage());
        }
        return jsonUtil;
    }
}
