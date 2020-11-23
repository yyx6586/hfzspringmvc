package yyx.scene_picture.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import yyx.scene_picture.service.ScenePictureService;
import yyx.util.JSONUtil;
import yyx.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
@RequestMapping("/scenePicture")
@CrossOrigin("*")      //允许跨域请求
public class ScenePictureController {

    @Autowired
    ScenePictureService scenePictureService;

    JSONUtil jsonUtil = new JSONUtil();

    //接收图片
    @RequestMapping("/imgUpload")
    @ResponseBody
    public JSONUtil imgUpload(HttpServletRequest request, @RequestParam("files")MultipartFile uploadFile){
        jsonUtil.setCode(-1);


        // 使用fileupload组件完成文件上传
        // 1. 指定文件上传保存的位置
        String path = request.getSession().getServletContext().getRealPath("/uploads/");

        // 判断该路径是否存在
        File file = new File(path);
        if (!file.exists() || !file.isDirectory()){
            file.mkdirs();
        }

        // 打印一下文件保存的路径
        System.out.println("path:"+path);

        // 说明上传文件项
        // 获取上传文件的名称
        if(uploadFile == null){
            jsonUtil.setMsg("图片上传为空");
            return jsonUtil;
        }

        String filename = uploadFile.getOriginalFilename();
//        String filename = "1.jpg";

        if(StringUtils.isNullOrEmpty(filename)){
            jsonUtil.setMsg("图片上传失败");
            return jsonUtil;
        }

        // 把文件的名称设置唯一值，uuid
        String uuid = UUID.randomUUID().toString().replace("-", "");
        filename = uuid+"_"+filename;

        // 3.上传文件
        try {
            uploadFile.transferTo(new File(path,filename));
            jsonUtil.setCode(1);
            jsonUtil.setMsg("图片上传成功");
            jsonUtil.setData(filename);
        } catch (IOException e) {
            jsonUtil.setMsg("图片上传失败" + e.getMessage());
        }
        return jsonUtil;
    }


    //保存景点图片到数据库
    @RequestMapping("/saveImg")
    @ResponseBody
    public JSONUtil saveImg(String picture, String site_name){
        jsonUtil.setCode(-1);

        if(StringUtils.isNullOrEmpty(picture)){
            jsonUtil.setMsg("图片名称不能为空");
            return jsonUtil;
        }

        if(StringUtils.isNullOrEmpty(site_name)){
            jsonUtil.setMsg("景点名称不能为空");
            return jsonUtil;
        }

        String[] str = picture.split(",");


        try{
            for(int i = 0; i < str.length; i ++){
                scenePictureService.saveImg(str[i], site_name);
            }
            jsonUtil.setCode(1);
            jsonUtil.setMsg("图片上传成功");
        } catch (Exception e) {
            jsonUtil.setMsg("图片上传失败" + e.getMessage());
        }

        return jsonUtil;
    }
}
