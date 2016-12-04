package db;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 * Created by hign on 2016/11/30.
 */
public class HibernateSessinFactory {

    private static SessionFactory sessinFactory;

    private HibernateSessinFactory() {
    }

    public static synchronized SessionFactory builder() {
        if (sessinFactory != null) {
            return sessinFactory;
        }

        Configuration cfg = new Configuration().configure();
        StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build();
        sessinFactory = cfg.buildSessionFactory(ssr);

        return sessinFactory;
    }
}
