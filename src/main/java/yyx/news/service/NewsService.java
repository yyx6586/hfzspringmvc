package yyx.news.service;

import org.springframework.stereotype.Service;
import yyx.news.bean.News;

import java.util.List;

@Service
public interface NewsService {

    //获取每页的旅游资讯
    List<List> newsList(int pageNo, int pageSize) throws Exception;

    //获取某一旅游资讯信息
    List<News> newsDetail(String id) throws Exception;
}
