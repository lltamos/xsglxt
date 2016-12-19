package service.impl;

import bean.Students;
import db.HibernateSessinFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import service.StudentsDao;

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
public class StudentsDaoImpl implements StudentsDao {


    /**
     * @return 所有学生
     */
    public List<Students> queryAllStudents() {
        List studentses = null;
        Transaction transaction = null;
        String hql = "from Students";
        try {
            Session currentSession = HibernateSessinFactory.builder().getCurrentSession();
            transaction = currentSession.beginTransaction();
            Query query = currentSession.createQuery(hql);
            studentses = query.list();
            transaction.commit();
            return studentses;
        } catch (Exception e) {
            e.printStackTrace();
            return studentses;
        }


    }

    public Students queryStudentsBySid(String sid) {
        return null;
    }

    public boolean addStudents(Students s) {
        return false;
    }

    public boolean updateStudents(Students s) {
        return false;
    }

    public void deleteStudents(String s) {
        Transaction transaction;
        Session currentSession;
        try {
            currentSession = HibernateSessinFactory.builder().getCurrentSession();
            transaction = currentSession.beginTransaction();
            Students o = (Students) currentSession.get(Students.class, s);
            currentSession.delete(o);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getNewSid() {
        return null;
    }
}
