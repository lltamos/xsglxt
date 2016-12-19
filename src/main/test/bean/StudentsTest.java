package bean;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import java.util.Date;

/**
 * <p>Title:${type_inName}<p/>
 * <p>Description:<p/>
 * <p>Company: </p>
 *
 * @author litao
 * @mail llsmpsvn@gmail.com
 * @date on 2016/12/18
 */
public class StudentsTest {
    @Test
    public void testSaveStudents() {
        Configuration cfg = new Configuration().configure();
        StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build();
        SessionFactory ssesion = cfg.buildSessionFactory(ssr);
        Session currentSession = ssesion.getCurrentSession();

        Transaction transaction = currentSession.beginTransaction();

        Students s1 = new Students("s00000001", "里斯", "男", new Date(), "北京");
        Students s2 = new Students("s00000002", "阿达", "男", new Date(), "天山");
        Students s3 = new Students("s00000003", "程度", "女", new Date(), "聊城");
        Students s4 = new Students("s00000004", "阿昌", "男", new Date(), "程度");

        currentSession.save(s1);
        currentSession.save(s2);
        currentSession.save(s3);
        currentSession.save(s4);
        transaction.commit();


    }
}
