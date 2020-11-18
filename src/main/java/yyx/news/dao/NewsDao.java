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

    //获取旅游资讯
    public List<News> selectNews(){
        String sql = "select * from news";
        List<News> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(News.class));
        return list;
    }
}
