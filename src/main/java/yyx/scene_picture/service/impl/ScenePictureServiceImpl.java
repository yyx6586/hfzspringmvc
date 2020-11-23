package yyx.scene_picture.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import yyx.scene_picture.dao.ScenePictureDao;
import yyx.scene_picture.service.ScenePictureService;

public class ScenePictureServiceImpl implements ScenePictureService {

    @Autowired
    ScenePictureDao scenePictureDao;

    @Override
    public String saveImg(String picture, String site_name) throws Exception {
        try{
            scenePictureDao.insertImg(picture, site_name);
        }catch (Exception e){
            return e.getMessage();
        }
        return null;
    }
}
