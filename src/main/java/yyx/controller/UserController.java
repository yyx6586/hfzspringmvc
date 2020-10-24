package yyx.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import yyx.bean.AuthUser;
import yyx.service.UserService;
import yyx.util.JSONUtil;
import yyx.util.StringUtils;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    JSONUtil jsonUtil = new JSONUtil();

    @RequestMapping("/login")
    @ResponseBody
    public JSONUtil login(String account, String password){

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

            if(authUser.getUserName().equals(password)){
                jsonUtil.setMsg("登录成功");
            }else {
                jsonUtil.setMsg("密码错误，请重新登录");
            }
        }catch (Exception e){
            jsonUtil.setMsg(e.getMessage());
        }
        return jsonUtil;
    }
}
