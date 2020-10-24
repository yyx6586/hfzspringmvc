package yyx.service;

import org.springframework.stereotype.Service;
import yyx.bean.AuthUser;

@Service
public interface UserService {
    AuthUser login(String account, String password) throws Exception;
}
