package yyx.news.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import yyx.news.bean.News;
import yyx.news.dao.NewsDao;
import yyx.news.service.NewsService;

import java.util.List;

public class NewsServiceImpl implements NewsService {
    @Autowired
    NewsDao newsDao;

    @Override
    public List<News> newsList() throws Exception {
        List<News> list = newsDao.selectNews();
        return list;
    }
}
