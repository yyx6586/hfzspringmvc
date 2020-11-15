package yyx.user.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import yyx.user.bean.User;

import java.util.List;

@Repository
public class UserDao {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    //登录
    public List<User> selectUser(String account){
        String sql = "select * from user where account = '"+account+"'";

//        String sql = String.format("select * from user where account = %s",account);

        List<User> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class));
        return list;
    }

    //注册
    public String insertUser(String account, String password){
        String sql = "insert into user(account,password) values('"+account+"','"+password+"')";

        try{
            jdbcTemplate.execute(sql);
        }catch (Exception e){
            return e.getMessage();
        }
        return null;
    }
}
