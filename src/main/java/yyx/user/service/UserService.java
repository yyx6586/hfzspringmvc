package yyx.user.service;

import org.springframework.stereotype.Service;
import yyx.user.bean.AuthUser;

@Service
public interface UserService {
    //登录
    AuthUser login(String account, String password) throws Exception;

    //注册
    String regisetr(String account, String password) throws Exception;
}
