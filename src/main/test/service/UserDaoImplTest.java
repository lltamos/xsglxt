package service;

import bean.Users;
import org.junit.Assert;
import org.junit.Test;
import service.impl.UsersDaoImpl;


public class UserDaoImplTest {

    @Test
    public void UserDaoUser() {
        Users u=new Users(1,"张山","123456");
        UsersDao dao=new UsersDaoImpl();

        Assert.assertEquals(true,dao.usersLogin(u));
    }
}
