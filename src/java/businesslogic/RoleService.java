package businesslogic;
import dataaccess.RoleDB;
import domainmodel.Role;
import java.util.List;

public class RoleService {
    
    private RoleDB roleDB;
    
    public RoleService() {
        roleDB = new RoleDB();
    }
    
    public Role get(int roleId) throws Exception {
        return roleDB.getRole(roleId);
    }
    
    public List<Role> getAll() throws Exception {
        return roleDB.getAll();
    }
    
    public int update(int roleId, String roleName) throws Exception {
        Role role = roleDB.getRole(roleId);
        role.setRoleName(roleName);
        return roleDB.update(role);
    }
    
    public int delete(int roleId) throws Exception {
        Role deleteRole = roleDB.getRole(roleId);
        return roleDB.delete(deleteRole);
    }

    public int insert(int roleId, String roleName) throws Exception {
        Role role = new Role(roleId, roleName);
        return roleDB.insert(role);
    }
}
