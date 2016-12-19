package action;

import bean.Users;
import com.opensymphony.xwork2.ModelDriven;
import service.UsersDao;
import service.impl.UsersDaoImpl;

/**
 * <p>Title:${type_inName}<p/>
 * <p>Description:<p/>
 * <p>Company: </p>
 *
 * @author litao
 * @mail llsmpsvn@gmail.com
 * @date on 2016/12/4
 */
public class UsersAction extends SuperAction implements ModelDriven<Users> {

    private Users users = new Users();


    public String login() {

        System.out.println("usersaction 执行");
        UsersDao dao = new UsersDaoImpl();
        if (dao.usersLogin(users)) {
            session.setAttribute("userName", users.getUsername());
            return SUCCESS;
        } else{
            return LOGIN;
        }

    }

    public Users getModel() {
        return this.users;
    }
}
