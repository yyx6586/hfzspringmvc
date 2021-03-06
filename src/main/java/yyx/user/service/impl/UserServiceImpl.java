package yyx.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import yyx.user.bean.AuthUser;
import yyx.user.bean.User;
import yyx.user.dao.UserDao;
import yyx.user.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;

    @Override
    public AuthUser login(String account, String password) throws Exception {
        List<User> list = userDao.selectUser(account);

        if(list.size() <= 0){
            new Exception("该用户不存在");
        }

        if(list.size() > 1){
            new Exception("该用户存在多个，请联系管理员");
        }

        User user = list.get(0);

        AuthUser authUser = new AuthUser();
        authUser.setUserAccount(user.getAccount());
        authUser.setUserPassword(user.getPassword());
        authUser.setUserRole(user.getRole());
        return authUser;
    }

    @Override
    public String register(String account, String password) throws Exception {
//        User user = new User();
//        user.setAccount(account);
//        user.setPassword(password);

        try{
            userDao.insertUser(account,password);
        }catch (Exception e){
            return e.getMessage();
        }
        return null;
    }
}
