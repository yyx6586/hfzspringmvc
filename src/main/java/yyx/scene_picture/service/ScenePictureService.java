package yyx.scene_picture.service;

import org.springframework.stereotype.Service;

@Service
public interface ScenePictureService {

    //保存景点图片到数据库
    String saveImg(String picture, String site_name) throws Exception;
}
