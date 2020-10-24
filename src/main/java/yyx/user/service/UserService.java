package yyx.user.service;

import org.springframework.stereotype.Service;
import yyx.user.bean.AuthUser;

@Service
public interface UserService {
    AuthUser login(String account, String password) throws Exception;
}
