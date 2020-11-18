package yyx.news.service;

import org.springframework.stereotype.Service;
import yyx.news.bean.News;

import java.util.List;

@Service
public interface NewsService {

    //获取旅游资讯
    List<News> newsList() throws Exception;
}
