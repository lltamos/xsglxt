package service;

import bean.Students;

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
public interface StudentsDao {

    List<Students> queryAllStudents();

    Students queryStudentsBySid(String sid);

    boolean addStudents(Students s);

    boolean updateStudents(Students s);

    void deleteStudents(String s);

    String getNewSid();
}
