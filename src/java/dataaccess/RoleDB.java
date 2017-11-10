package dataaccess;

import domainmodel.Role;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class RoleDB {
    
    public int insert(Role role) throws UserDBException {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        
        try {
        trans.begin();
        em.persist(role);
        trans.commit();
        return 1;
        }catch (Exception ex) {
            trans.rollback();
            Logger.getLogger(RoleDB.class.getName()).log(Level.SEVERE, "Cannot insert " + role.toString(), ex);
            throw new UserDBException("Error inserting role");
        } finally {
            em.close();
        }
    }
    
    public int update(Role role) throws UserDBException {
              
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();

        try {
            trans.begin();
            em.merge(role);
            trans.commit();
            return 1;
        } catch (Exception ex) {
            trans.rollback();
            Logger.getLogger(RoleDB.class.getName()).log(Level.SEVERE, "Cannot update " + role.toString(), ex);
            throw new UserDBException("Error updating role");
        } finally {
            em.close();
        }        
    }
    
    public List<Role> getAll() throws UserDBException {
        
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        
        try {
            List<Role> roles = em.createNamedQuery("Role.findAll", Role.class).getResultList();
            return roles;
        } catch (Exception ex) {
            Logger.getLogger(UserDB.class.getName()).log(Level.SEVERE, "Cannot read role", ex);
            throw new UserDBException("Error getting roles");
        } finally {
            em.close();
        }
    }
    
     public Role getRole(int roleId) throws UserDBException {
        
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        
        try {
            //the parameters are Entity call and Object primary key
            Role role = em.find(Role.class, roleId);            
            return role;
        } catch (Exception ex) {
            Logger.getLogger(RoleDB.class.getName()).log(Level.SEVERE, "Cannot read role", ex);
            throw new UserDBException("Error getting role");
        } finally {
            em.close();
        }
    }
     
    public int delete(Role role) throws UserDBException {
        
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        
        try {
            trans.begin();
            em.remove(em.merge(role));
            trans.commit();
            return 1;
        } catch (Exception ex) {
            trans.rollback();
            Logger.getLogger(RoleDB.class.getName()).log(Level.SEVERE, "Cannot delete " + role.toString(), ex);
            throw new UserDBException("Error deleting role");
        } finally {
            em.close();
        }
    }
    
}
