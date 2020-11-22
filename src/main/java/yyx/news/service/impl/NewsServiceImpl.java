package yyx.news.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import yyx.news.bean.News;
import yyx.news.dao.NewsDao;
import yyx.news.service.NewsService;

import java.util.ArrayList;
import java.util.List;

public class NewsServiceImpl implements NewsService {
    @Autowired
    NewsDao newsDao;

    @Override
    public List<List> newsList(int pageNo, int pageSize) throws Exception {
        List<List> lists = new ArrayList<>();

        //获取所有的旅游资讯
        List<News> newsList = newsDao.selectNewsList();

        //获取每页的旅游资讯
        List<News> list = newsDao.selectNews(pageNo, pageSize);

        lists.add(newsList);
        lists.add(list);
        return lists;
    }

    @Override
    public List<News> newsDetail(String id) throws Exception{
        List<News> list = newsDao.selectNewsDetail(id);
        return list;
    }
}
