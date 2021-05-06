package ru.fintech.qa.homework.db.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ru.fintech.qa.homework.db.models.Zoo;

import java.math.BigInteger;

public class DbHibernateService {
    public static Session openSession() {
        SessionFactory sessionFactory = DbClient.getSessionFactory();
        return sessionFactory.openSession();
    }

    public final BigInteger countRows(String sqlQuery, String tableName) {
        Session session = DbHibernateService.openSession();
        BigInteger result = (BigInteger) session.createNativeQuery(sqlQuery + tableName).uniqueResult();
        session.close();
        return result;
    }

    public final void addRowWithSameID(int id) {
        Session session = DbHibernateService.openSession();
        session
                .createNativeQuery("insert into animal (id) values (" + id + ")")
                .executeUpdate();
        session.close();
    }

    public final void addRowWithNameNull(String workmanName) {
        Session session = DbHibernateService.openSession();
        session
                .createNativeQuery("insert into workman (\"name\") values (" + workmanName + ")")
                .executeUpdate();
        session.close();
    }

    public final void addOneRow(int id) {
        Session session = DbHibernateService.openSession();
        session
                .createNativeQuery("insert into places (id) values (" + id + ")")
                .executeUpdate();
        session.close();
    }

    public static String getNameByID(int id, String sqlQuery) {
        Session session = DbHibernateService.openSession();
        String result = session.createNativeQuery(sqlQuery + id, Zoo.class)
                .getResultList().get(0).getName();
        session.close();
        return result;
    }
}