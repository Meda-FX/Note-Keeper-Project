
package businesslogic;

import dataaccess.CompanyDB;
import dataaccess.UserDB;
import domainmodel.Company;
import domainmodel.Role;
import domainmodel.User;
import java.util.List;

public class CompanyService {
    
    private CompanyDB companyDB;
    
    public CompanyService() {
        companyDB = new CompanyDB();
    }
    
    public User get(String username) throws Exception {
        return  companyDB.getUser(username);
    }
    
    public List<User> getAll() throws Exception {
        return companyDB.getAll();
    }
    
    public int update(String username, String email, String password, String firstname, String lastname, boolean activation) throws Exception {
       
        User user = companyDB.getUser(username);
        
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        user.setActive(activation);
        user.setFirstname(firstname);
        user.setLastname(lastname);
        
        return companyDB.update(user);
    }
    
    public int update(String username, String email, String password, String firstname, String lastname) throws Exception {
       
        User user = companyDB.getUser(username);
        
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        user.setFirstname(firstname);
        user.setLastname(lastname);
        
        return companyDB.update(user);
    }
    
    public int delete(String username) throws Exception {
        User deleteUser = companyDB.getUser(username);
        return companyDB.delete(deleteUser);
    }
    
    public int insert(String username, String password, String email, boolean active, String firstname, 
            String lastname) throws Exception {
        
        User user = new User(username, password, email, active, firstname, lastname);
        Role role = new Role(2);  // default regular user role
        user.setRole(role);
        Company comp = new Company(3); //belongs to little pony company by default
        user.setCompany(comp);
        return  companyDB.insert(user);
    }
}
