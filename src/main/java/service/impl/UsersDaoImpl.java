package service.impl;

import bean.Users;
import db.HibernateSessinFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import service.UsersDao;

import java.util.List;


public class UsersDaoImpl implements UsersDao {
    public boolean usersLogin(Users u) {


        //事务对象
        Transaction tx;
        String sql;

        Session currentSession = HibernateSessinFactory.builder().getCurrentSession();
        tx = currentSession.beginTransaction();
        sql = "from Users where username=? and password=?";

        Query query = currentSession.createQuery(sql);
        query.setParameter(0, u.getUsername());
        query.setParameter(1, u.getPassword());

        List list = query.list();

        tx.commit();

        return list.size() > 0;


    }
}
