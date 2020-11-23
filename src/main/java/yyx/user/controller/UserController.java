package yyx.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import yyx.user.bean.AuthUser;
import yyx.user.service.UserService;
import yyx.util.JSONUtil;
import yyx.util.StringUtils;

@Controller
@RequestMapping("/user")
@CrossOrigin("*")      //允许跨域请求
public class UserController {

    @Autowired
    UserService userService;

    JSONUtil jsonUtil = new JSONUtil();

    @RequestMapping("/login")
    @ResponseBody
    public JSONUtil login(String account, String password){

        jsonUtil.setCode(-1);

        if(StringUtils.isNullOrEmpty(account)){
            jsonUtil.setMsg("账号不能为空");
            return jsonUtil;
        }

        if(StringUtils.isNullOrEmpty(password)){
            jsonUtil.setMsg("姓名不能为空");
            return jsonUtil;
        }

        try{
            AuthUser authUser = userService.login(account,password);

            if(authUser.getUserPassword().equals(password)){
                jsonUtil.setCode(1);
                jsonUtil.setMsg("登录成功");
                jsonUtil.setData(authUser);
            }else {
                jsonUtil.setMsg("密码错误，请重新登录");
            }
        }catch (Exception e){
            jsonUtil.setMsg(e.getMessage());
        }
        return jsonUtil;
    }

    @RequestMapping("/register")
    @ResponseBody
    public JSONUtil register(String account, String password){
        jsonUtil.setCode(-1);

        if(StringUtils.isNullOrEmpty(account)){
            jsonUtil.setMsg("账号不能为空");
            return jsonUtil;
        }

        if(StringUtils.isNullOrEmpty(password)){
            jsonUtil.setMsg("密码不能为空");
            return jsonUtil;
        }

        try{
            userService.register(account, password);
            jsonUtil.setCode(1);
            jsonUtil.setMsg("注册成功");
        } catch (Exception e) {
            jsonUtil.setMsg("注册失败，请重新注册" + e.getMessage());
        }
        return jsonUtil;
    }
}
