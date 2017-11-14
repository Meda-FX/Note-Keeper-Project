
package businesslogic;

import dataaccess.UserDB;
import domainmodel.Role;
import domainmodel.User;
import java.util.List;

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
    
    public int update(String username, String email, String password, String firstname, String lastname) throws Exception {
       
        User user = userDB.getUser(username);
        
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        user.setFirstname(firstname);
        user.setLastname(lastname);
        
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
    
    public int insert(String username, String password, String email, boolean active, String firstname, String lastname) throws Exception {
        Role role = new Role();
        RoleService rs = new RoleService();
        role = rs.get(2);
        User user = new User(username, password, email, active, firstname, lastname, role);
        return  userDB.insert(user);
    }
}
