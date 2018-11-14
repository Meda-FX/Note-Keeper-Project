package servlets;

import businesslogic.CompanyService;
import businesslogic.RoleService;
import businesslogic.UserService;
import domainmodel.Company;
import domainmodel.Role;
import domainmodel.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CompanyRoleManager extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        UserService us = new UserService();
        CompanyService cs = new CompanyService();
        String action = request.getParameter("action");

        if (action != null && action.equals("view")) {
            String selectedUser = request.getParameter("selectedUser");
            try {
                User user = us.get(selectedUser);
                request.setAttribute("selectedUser", user);
            } catch (Exception ex) {
                Logger.getLogger(AccountServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        RoleService rs = new RoleService();
        List<Role> roles = null;
        try {
            roles = rs.getAll();
        } catch (Exception ex) {
            Logger.getLogger(RoleManagerServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        List<User> users = null;
        try {
            users = us.getAll();
        } catch (Exception ex) {
            Logger.getLogger(AccountServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        List<Company> companies = null;
        try {
            companies = (List<Company>) cs.getAll();
        } catch (Exception ex) {
            Logger.getLogger(CompanyMangerServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        request.setAttribute("companies", companies);
        request.setAttribute("roles", roles);
        request.setAttribute("users", users);
        getServletContext().getRequestDispatcher("/WEB-INF/companyAdmin/rolemanager.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        RoleService rs = new RoleService();
        CompanyService cs = new CompanyService();
        String username = request.getParameter("username");
        String selectedRole = request.getParameter("userRoles");
        int roleid = Integer.parseInt(selectedRole);

        UserService us = new UserService();
        try {
            if (action != null && action.equals("edit")) {
                us.update(username, roleid);
                doGet(request, response);
            }
        } catch (Exception ex) {
            request.setAttribute("message", "Could not perform that action.");
        }

        List<Role> roles = null;
        try {
            roles = rs.getAll();
        } catch (Exception ex) {
            Logger.getLogger(RoleManagerServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        List<User> users = null;
        try {
            users = (List<User>) us.getAll();
        } catch (Exception ex) {
            Logger.getLogger(AccountServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        List<Company> companies = null;
        try {
            companies = cs.getAll();
        } catch (Exception ex) {
            Logger.getLogger(CompanyMangerServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        request.setAttribute("companies", companies);
        request.setAttribute("roles", roles);
        request.setAttribute("users", users);
        getServletContext().getRequestDispatcher("/WEB-INF/companyAdmin/rolemanager.jsp").forward(request, response);
    }
}
