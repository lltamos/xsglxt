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
            transaction.commit();
            return studentses;
        }


    }

    public Students queryStudentsBySid(String sid) {

        Students s = null;
        Transaction transaction = null;
        try {
            Session currentSession = HibernateSessinFactory.builder().getCurrentSession();
            transaction = currentSession.beginTransaction();
            s = (Students) currentSession.get(Students.class, sid);
            transaction.commit();
            return s;
        } catch (Exception e) {
            e.printStackTrace();
            transaction.commit();
            return s;
        }
    }

    public boolean addStudents(Students s) {
        Transaction transaction = null;
        s.setSid(getNewSid());
        try {
            Session currentSession = HibernateSessinFactory.builder().getCurrentSession();
            transaction = currentSession.beginTransaction();
            currentSession.save(s);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            transaction.commit();
            return false;
        } finally {
            transaction = null;
        }

    }

    public boolean updateStudents(Students s) {
        Transaction transaction = null;
        try {
            Session currentSession = HibernateSessinFactory.builder().getCurrentSession();
            transaction = currentSession.beginTransaction();
            currentSession.update(s);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            transaction.commit();
            return false;
        } finally {
            transaction = null;
        }


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

    /**
     * @return 返回一个新的学号
     * <p>
     * 查询数据库获取当前最大学号 +1
     */
    public String getNewSid() {
        String hql;
        String sid;
        Transaction transaction = null;
        try {
            Session currentSession = HibernateSessinFactory.builder().getCurrentSession();
            transaction = currentSession.beginTransaction();
            hql = "select max(sid) from Students";
            Query query = currentSession.createQuery(hql);
            sid = (String) query.uniqueResult();
            transaction.commit();
            if (sid == null || "".equals(sid)) {
                sid = "S0000001";
            } else {
                String temp = sid.substring(1);//取出后七位
                int i = Integer.parseInt(temp);
                i++;
                temp = String.valueOf(i);

                int len = temp.length();
                //凑够七位
                for (int j = 0; j < 7 - len; j++) {
                    temp = "0" + temp;
                }

                sid = "S" + temp;

            }
            return sid;
        } catch (Exception e) {
            e.printStackTrace();
            transaction.commit();
            return null;
        } finally {
            if (transaction != null) {
                transaction = null;
            }
        }


    }
}
