package User_Backend.demo.db;

import User_Backend.demo.bo.UsersEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Collection;

public class UserDB{
    public static Collection findByName(String name)
    {
        Session session = null;
        try{
            session = HibernateUtil.getFactory().openSession();
            session.beginTransaction();
            Collection<UsersEntity> result = (Collection<UsersEntity>)
                    session.createQuery("From UsersEntity where username = '" + name + "'");
            session.getTransaction().commit();
            if(result != null){
                return result;
            }
        }finally{
            session.close();
        }
        return null;
    }

    public static UsersEntity getUser(String uName){
        Session session = null;
        try{
            session = HibernateUtil.getFactory().openSession();
            session.beginTransaction();
            UsersEntity result = (UsersEntity) session.createQuery
                    ("From UsersEntity WHERE username = '" + uName + "'")
                    .uniqueResult();
            session.getTransaction().commit();
            return result;
        }finally{
            session.close();
        }
    }

    public static Collection getAllUsers(){
        Session session = null;
        try{
            session = HibernateUtil.getFactory().openSession();
            session.beginTransaction();
            Collection<UsersEntity> result = (Collection<UsersEntity>) session.createQuery
                    ("From UsersEntity ").list();
            session.getTransaction().commit();
            if(result != null){
                return result;
            }
        }finally{
            session.close();
        }
        return null;
    }

    public static Boolean login(String user, String pass){
        Session session = null;
        try{
            session = HibernateUtil.getFactory().openSession();
            session.beginTransaction();
            UsersEntity result = (UsersEntity) session.createQuery
                    ("From UsersEntity where username = '" + user + "'")
                    .uniqueResult();
            session.getTransaction().commit();
            if(result.getPassword().equals(pass)){
                return true;
            }
        }finally{
            session.close();
        }
        return false;
    }
    public static void createUser(String user, String pass){
        UsersEntity newUser = new UsersEntity();
        newUser.setUsername(user);
        newUser.setPassword(pass);
        Session session = HibernateUtil.getFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(newUser);
        transaction.commit();
        session.close();
    }

    public static UsersEntity getUserById(int id) {
        Session session = null;
        try{
            session = HibernateUtil.getFactory().openSession();
            session.beginTransaction();
            UsersEntity result = (UsersEntity) session.createQuery
                    ("From UsersEntity WHERE id = '" + id + "'")
                    .uniqueResult();
            session.getTransaction().commit();
            return result;
        }finally{
            session.close();
        }
    }
}
