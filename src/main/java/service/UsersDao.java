package service;

import bean.Users;

/**
 * Created by hign on 2016/11/30.
 * 用户业务逻辑接口
 */

public interface UsersDao {
    //用户登录方法
    boolean usersLogin(Users users);

}
