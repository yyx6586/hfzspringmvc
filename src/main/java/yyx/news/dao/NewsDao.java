package yyx.news.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import yyx.news.bean.News;

import java.util.List;

@Repository
public class NewsDao {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    //获取所有旅游资讯
    public List<News> selectNewsList(){
       String sql = "select * from news ORDER BY id DESC";
       List<News> newsList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(News.class));
       return newsList;
    }

    //获取每页旅游资讯
    public List<News> selectNews(int pageNo, int pageSize){
        String sql = "select * from news ORDER BY id DESC limit "+(pageNo - 1) * pageSize+","+pageSize+"";
        List<News> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(News.class));
        return list;
    }

    //获取某一篇旅游资讯信息
    public List<News> selectNewsDetail(String id){
        String sql = "select * from news where id = "+id+"";
        List<News> list = jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(News.class));
        return list;
    }
}
