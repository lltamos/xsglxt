package service;

import bean.Students;
import org.junit.Test;
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
public class StudentDaoImplTest {
    @Test
    public void queryAllStudents() {
        StudentsDao dap = new StudentsDaoImpl();
        List<Students> allStudents = dap.queryAllStudents();

        for (Students s : allStudents) {
            System.out.println(s.toString());
        }
    }
}
