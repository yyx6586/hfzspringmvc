package yyx.scene_picture.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ScenePictureDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    //保存景点图片到数据库
    public String insertImg(String picture, String site_name){
        String sql = "insert into scene_picture (picture,site_name) values('"+picture+"', '"+site_name+"')";
        try{
            jdbcTemplate.execute(sql);
        }catch (Exception e){
            return e.getMessage();
        }
        return null;
    }
}
