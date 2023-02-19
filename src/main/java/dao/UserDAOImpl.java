package dao;

import model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import util.Util;

import javax.persistence.PersistenceException;
import java.util.List;

public class UserDAOImpl implements UserDAO {

    private Transaction transaction;


    @Override
    public void saveUser(User user) {
        SessionFactory sessionFactory = Util.createUtilConnection();
        try(sessionFactory) {
            Session session = sessionFactory.getCurrentSession();
            transaction = session.beginTransaction();
            session.save(user);
            transaction.commit();
            System.out.println("Пользователь сохранен");
        } catch (PersistenceException e) {
            if (transaction!= null) {
                transaction.rollback();
            }
        }
    }

    public void removeUserID(User user) {
        SessionFactory sessionFactory = Util.createUtilConnection();
        try(sessionFactory) {
            Session session = sessionFactory.getCurrentSession();
            transaction = session.beginTransaction();
            session.delete(user);
            transaction.commit();
            System.out.println("Пользователь удален");
        } catch (PersistenceException e) {
            if (transaction!= null) {
                transaction.rollback();
            }
        }
    }

    @Override
    public void createTable() {
        SessionFactory sessionFactory = Util.createUtilConnection();
        try(sessionFactory) {
            Session session = sessionFactory.getCurrentSession();
            transaction = session.beginTransaction();
            session.createSQLQuery("CREATE TABLE IF NOT EXISTS Users " +
                    "(id SERIAL PRIMARY KEY, name VARCHAR(255), age INT)").executeUpdate();
            transaction.commit();
            System.out.println("Таблица создана");
        } catch (PersistenceException e) {
            if (transaction!= null) {
                transaction.rollback();
            }
        }
    }

    @Override
    public void dropTable() {
        SessionFactory sessionFactory = Util.createUtilConnection();
        try(sessionFactory) {
            Session session = sessionFactory.getCurrentSession();
            transaction = session.beginTransaction();
            session.createSQLQuery("DROP TABLE IF EXISTS Users").executeUpdate();
            transaction.commit();
            System.out.println("Таблица удалена");
        } catch (PersistenceException e) {
            if (transaction!= null) {
                transaction.rollback();
            }
        }
    }

    @Override
    public void cleanUserTable() {
        SessionFactory sessionFactory = Util.createUtilConnection();
        try(sessionFactory) {
            Session session = sessionFactory.getCurrentSession();
            transaction = session.beginTransaction();
            session.createSQLQuery("DELETE FROM Users").executeUpdate();
            transaction.commit();
            System.out.println("Таблица очищена");
        } catch (PersistenceException e) {
            if (transaction!= null) {
                transaction.rollback();
            }
        }
    }

    @Override
    public List<User> getAllUsers() {
        SessionFactory sessionFactory = Util.createUtilConnection();
        List<User> list = null;
        try(sessionFactory) {
            Session session = sessionFactory.getCurrentSession();
            transaction = session.beginTransaction();
            list = session.createSQLQuery("SELECT * FROM Users").stream().toList();
            transaction.commit();
            System.out.println("Пользователи получены");
        } catch (PersistenceException e) {
            if (transaction!= null) {
                transaction.rollback();
            }
        }
        return list;
    }

    @Override
    public User getUserByID(int id) {
        SessionFactory sessionFactory = Util.createUtilConnection();
        try(sessionFactory) {
            Session session = sessionFactory.getCurrentSession();
            transaction = session.beginTransaction();
            session.createSQLQuery("SELECT * FROM Users WHERE id = " + id).executeUpdate();
            transaction.commit();
            System.out.println("Пользователь получен");
            return session.get(User.class, id);
        } catch (PersistenceException e) {
            if (transaction!= null) {
                transaction.rollback();
            }
        }
        return new User();
    }

}
