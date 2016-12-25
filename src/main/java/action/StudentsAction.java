package action;

import bean.Students;
import service.StudentsDao;
import service.impl.StudentsDaoImpl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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

    public String add() {
        Students s = new Students();
        s.setSname(request.getParameter("sname"));
        s.setGender(request.getParameter("gender"));
        s.setAddress(request.getParameter("address"));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date birthday = sdf.parse(request.getParameter("birthday"));
            s.setBirthday(birthday);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        StudentsDao dao = new StudentsDaoImpl();
        dao.addStudents(s);
        return "add_success";
    }


    //修改学生
    public String modify() {
        StudentsDao dao = new StudentsDaoImpl();

        Students s = dao.queryStudentsBySid(request.getParameter("sid"));

        request.setAttribute("modify_students", s);

        return "modify_success";

    }

    //保存修改后的学生资料
    public String save() {
        StudentsDao dao = new StudentsDaoImpl();

        Students s = new Students();
        s.setSid(request.getParameter("sid"));
        s.setSname(request.getParameter("sname"));
        s.setGender(request.getParameter("gender"));
        s.setAddress(request.getParameter("address"));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date birthday = sdf.parse(request.getParameter("birthday"));
            s.setBirthday(birthday);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        dao.updateStudents(s);

        return "save_success";
    }

}
