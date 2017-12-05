
package businesslogic;

import dataaccess.UserDB;
import domainmodel.Company;
import domainmodel.Role;
import domainmodel.User;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class UserService {
    
    private UserDB userDB;
    
    public UserService() {
        userDB = new UserDB();
    }
    
    public User get(String username) throws Exception {
        return  userDB.getUser(username);
    }
    
    public List<User> getAll() throws Exception {
        return userDB.getAll();
    }
    
    public User getByUUID(String uuid) throws Exception {
        return userDB.getByUUID(uuid);
    }
    
    public User getUserByEmail(String email) throws Exception {
        return userDB.getUserByEmail(email);
    }
    
    public int update(String username, String email, String password, String firstname, String lastname, boolean activation) throws Exception {
       
        User user = userDB.getUser(username);
        
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        user.setActive(activation);
        user.setFirstname(firstname);
        user.setLastname(lastname);
        
        return userDB.update(user);
    }
    
    public int update(String username, String email, String password, String firstname, String lastname) throws Exception {
       
        User user = userDB.getUser(username);
        
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        user.setFirstname(firstname);
        user.setLastname(lastname);
        
        return userDB.update(user);
    }
    
     public int update(String username, int roleid) throws Exception {
       
        User user = userDB.getUser(username);  
        Role role = null;
        RoleService rs = new RoleService();
        role = rs.get(roleid);        
        user.setRole(role);
        return userDB.update(user);
    }
     
    public int update(User user) throws Exception 
    {
        return userDB.update(user);
    }
     
    public int delete(String username) throws Exception {
        User deleteUser = userDB.getUser(username);
        return userDB.delete(deleteUser);
    }
    
    //Read on how it works
    public int logicallyDelete(String username, boolean active) throws Exception {        
        //Have to set the acttive with false to logically delete
        User user = userDB.getUser(username);
        user.setActive(false);
        return userDB.update(user);
        //return userDB.delete(deleteUser);
    }
    
    public int insert(String username, String password, String email, boolean active, String firstname, 
            String lastname, int companyid) throws Exception {        
        
        User user = new User(username, password, email, active, firstname, lastname);
        Role role = new Role(2);  // default regular user role
        user.setRole(role);  
        Company comp = new Company(companyid); //belongs to little pony company by default
        user.setCompany(comp);
        return  userDB.insert(user);
    }
    
    public int register(String username, String password, String email, String firstname, 
            String lastname, int companyid) throws Exception {
        
        User user = new User(username, password, email, firstname, lastname);
        Role role = new Role(2);  // default regular user role
        user.setRole(role);
        Company comp = new Company(companyid); //belongs to little pony company by default
        user.setCompany(comp);
        user.setActive(true);
        return  userDB.insert(user);
    }
}
