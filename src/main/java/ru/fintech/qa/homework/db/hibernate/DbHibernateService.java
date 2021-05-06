package ru.fintech.qa.homework.db.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import ru.fintech.qa.homework.db.models.Zoo;

import java.math.BigInteger;

public class DbHibernateService {
    public static Session openSession() {
        SessionFactory sessionFactory = DbClient.getSessionFactory();
        return sessionFactory.openSession();
    }

    public final BigInteger countRows(final String sqlQuery, final String tableName) {
        Session session = DbHibernateService.openSession();
        BigInteger result = (BigInteger) session.createNativeQuery(sqlQuery + tableName).uniqueResult();
        session.close();
        return result;
    }

    public final void addRowWithSameID(final String sqlQuery) {
        Session session = DbHibernateService.openSession();
        Transaction transaction = session.beginTransaction();
        session
                .createNativeQuery(sqlQuery)
                .executeUpdate();
        transaction.commit();
        session.close();
    }

    public final void addRowWithNameNull(final String sqlQuery) {
        Session session = DbHibernateService.openSession();
        Transaction transaction = session.beginTransaction();
        session
                .createNativeQuery(sqlQuery)
                .executeUpdate();
        transaction.commit();
        session.close();
    }

    public final void addOneRow(final String sqlQuery) {
        Session session = DbHibernateService.openSession();
        Transaction transaction = session.beginTransaction();
        session
                .createNativeQuery(sqlQuery)
                .executeUpdate();
        transaction.commit();
        session.close();
    }

    public static String getNameByID(final int id, final String sqlQuery) {
        Session session = DbHibernateService.openSession();
        String result = session.createNativeQuery(sqlQuery + id, Zoo.class)
                .getResultList().get(0).getName();
        session.close();
        return result;
    }
}