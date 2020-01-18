package dao;

import model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.DBHelper;

import javax.persistence.NoResultException;
import java.util.ArrayList;
import java.util.List;

public class UsersDAOHibernate implements UsersDAO {
    private SessionFactory sessionFactory;

    public UsersDAOHibernate() {
        this.sessionFactory = DBHelper.getInstance().getSessionFactory();
    }


    public List<User> getAllUsers() {
        Session session = sessionFactory.openSession();
        List<User> usersList = new ArrayList<>();
        try {
            Transaction transaction = session.beginTransaction();
            usersList = (List<User>) session.createQuery("from User").list();
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return usersList;
    }

    public User getUser(long userId) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        String hql = "from User where id = :userId";
        Query query = session.createQuery(hql);
        query.setParameter("userId", userId);
        User user = (User) query.getSingleResult();
        transaction.commit();
        session.close();
        return user;
    }

    public User getUserByLogin(String userLogin) {
        Session session = sessionFactory.openSession();
        try {
            Transaction transaction = session.beginTransaction();
            String hql = "from User where login = :userLogin";
            Query query = session.createQuery(hql);
            query.setParameter("userLogin", userLogin);
            User user = (User) query.getSingleResult();
            transaction.commit();
            session.close();
            return user;
        } catch (NoResultException e) {
            return null;
        }
    }

    public void addUser(User user) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(user);
        transaction.commit();
        session.close();
    }

    public void deleteUser(long userId) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        String hql = "delete User where id = :userId";
        Query query = session.createQuery(hql);
        query.setParameter("userId", userId);
        query.executeUpdate();
        transaction.commit();
        session.close();
    }

    public void update(User user) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(user);
        transaction.commit();
        session.close();
    }
}
