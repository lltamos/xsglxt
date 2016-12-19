package action;

import bean.Students;
import service.StudentsDao;
import service.impl.StudentsDaoImpl;

import java.util.List;

/**
 * <p>Title:${type_inName}<p/>
 * <p>Description:<p/>
 * <p>Company: </p>
 *
 * @author litao
 * @mail llsmpsvn@gmail.com
 * @date on 2016/12/18
 */
public class StudentsAction extends SuperAction {

    public String query() {

        StudentsDao dao = new StudentsDaoImpl();
        List<Students> studentses = dao.queryAllStudents();
        if (studentses != null && studentses.size() > 0) {
            session.setAttribute("students", studentses);
        }
        return SUCCESS;
    }

    /**
     * @return 返回界面
     */
    public String delete() {
        StudentsDao s = new StudentsDaoImpl();
        //获取参数
        String sid = request.getParameter("sid");
        s.deleteStudents(sid);
        return "DELETE_SUCCESE";
    }
}
