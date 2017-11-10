package dataaccess;

import domainmodel.User;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class UserDB {
    
    public int insert(User user) throws UserDBException {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        
        try {
        trans.begin();
        em.persist(user);
        trans.commit();
        return 1;
        }catch (Exception ex) {
            trans.rollback();
            Logger.getLogger(UserDB.class.getName()).log(Level.SEVERE, "Cannot insert " + user.toString(), ex);
            throw new UserDBException("Error inserting user");
        } finally {
            em.close();
        }
    }
    
    public int update(User user) throws UserDBException {
              
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();

        try {
            trans.begin();
            em.merge(user);
            trans.commit();
            return 1;
        } catch (Exception ex) {
            trans.rollback();
            Logger.getLogger(UserDB.class.getName()).log(Level.SEVERE, "Cannot update " + user.toString(), ex);
            throw new UserDBException("Error updating user");
        } finally {
            em.close();
        }        
    }
    
    public List<User> getAll() throws UserDBException {
        
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        
        try {
            List<User> users = em.createNamedQuery("User.findAll", User.class).getResultList();
            return users;
        } catch (Exception ex) {
            Logger.getLogger(UserDB.class.getName()).log(Level.SEVERE, "Cannot read user", ex);
            throw new UserDBException("Error getting users");
        } finally {
            em.close();
        }
    }
    
    public User getUser(String username) throws UserDBException {
        
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        
        try {
            //the parameters are Entity call and Object primary key
            User user = em.find(User.class, username);            
            return user;
        } catch (Exception ex) {
            Logger.getLogger(UserDB.class.getName()).log(Level.SEVERE, "Cannot read users", ex);
            throw new UserDBException("Error getting user");
        } finally {
            em.close();
        }
    }
    
    public int delete(User user) throws UserDBException {
        
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        
        try {
            trans.begin();
            em.remove(em.merge(user));
            trans.commit();
            return 1;
        } catch (Exception ex) {
            trans.rollback();
            Logger.getLogger(UserDB.class.getName()).log(Level.SEVERE, "Cannot delete " + user.toString(), ex);
            throw new UserDBException("Error deleting user");
        } finally {
            em.close();
        }
    }
    
//    public int logicallyDelete(User user) throws UserDBException
//    {
//        EntityManager em = DBUtil.getEmFactory().createEntityManager();
//        EntityTransaction trans = em.getTransaction();
//        
//        trans.begin();
//        
//    }
}
