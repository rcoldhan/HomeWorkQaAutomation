package ru.fintech.qa.homework.db.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.fintech.qa.homework.db.models.Animal;
import ru.fintech.qa.homework.db.models.Places;
import ru.fintech.qa.homework.db.models.Workman;
import ru.fintech.qa.homework.db.models.Zoo;

public class DbClient {
    private static SessionFactory sessionFactory = null;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            sessionFactory = buildSessionFactory();
        }
        return sessionFactory;
    }

    private static SessionFactory buildSessionFactory() {
        return new Configuration()
                .configure()
                .addAnnotatedClass(Animal.class)
                .addAnnotatedClass(Places.class)
                .addAnnotatedClass(Workman.class)
                .addAnnotatedClass(Zoo.class)
                .buildSessionFactory();
    }
}