package bean;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.Test;

/**
 * Created by hign on 2016/11/30.
 */
public class UserTest {

    @Test
    public void TestUser() {
        Configuration cfg = new Configuration().configure();

//        StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build();

//        SessionFactory ssesion = cfg.buildSessionFactory(ssr);

        SchemaExport se = new SchemaExport(cfg);
        se.create(true, true);
    }
}
