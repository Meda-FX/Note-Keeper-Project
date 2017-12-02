package servlets;

import businesslogic.CompanyService;
import businesslogic.RoleService;
import businesslogic.UserService;
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
import javax.servlet.http.HttpSession;

public class CompanyAdminServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        UserService us = new UserService();
        String action = request.getParameter("action");
        HttpSession session = request.getSession();
        
        //// causing issue
        int compId = 0;
        if(session != null)
        {
            compId = (int) session.getAttribute("compID");
            request.setAttribute("copmID", compId);
        }
        //(int) session.getAttribute("compID");
        
        
        if (action != null && action.equals("view")) {
            String selectedUser = request.getParameter("selectedUser");
            try {
                User user = us.get(selectedUser);
                request.setAttribute("selectedUser", user);
            } catch (Exception ex) {
                Logger.getLogger(AccountServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        List<User> users = null;
        try {
            users = us.getAll();
        } catch (Exception ex) {
            Logger.getLogger(AccountServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        request.setAttribute("users", users);
        getServletContext().getRequestDispatcher("/WEB-INF/companyAdmin/users.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        HttpSession session = request.getSession();
        int compId = (int) session.getAttribute("compID");
        User user;
        String accountHolder = (String) session.getAttribute("username");
        String selectedUser = request.getParameter("selectedUser");

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String status = request.getParameter("active");
        boolean activation = true;
        
        if(status != null) {
            if(status.equals("true")) {
                activation = true;
            }
            else if (status.equals("false")){
                activation = false;
            }
        }     
        
//        if(status != null && status.equals("true"))
//        {
//            activation = true;
//        }
//        else
//        {
//            activation = false;
//        }

        UserService us = new UserService();
        //CompanyService cs = new CompanyService();
        try {
            if (action != null && action.equals("delete")) {
                user = us.get(selectedUser);
                if (user.getUsername().equals(accountHolder)) {
                    request.setAttribute("message", "You cannot delete yourself.");
                    doGet(request, response);
                } else {                    
                    us.delete(selectedUser);
                    request.setAttribute("message", "Deleted Successfuly.");
                    doGet(request, response);
                }
            } else if (action != null && action.equals("edit")) {
                
                us.update(username, email, password, firstname, lastname, activation);
                doGet(request, response);

            } else if (action != null && action.equals("add")) {
                if (username.trim().isEmpty() || password.trim().isEmpty() || email.trim().isEmpty()
                        || firstname.trim().isEmpty() || lastname.trim().isEmpty()) {
                    request.setAttribute("message", "Please fill in the form.");
                    doGet(request, response);
                    return;
                }
                
                us.insert(username, password, email, activation, firstname, lastname, compId);
                doGet(request, response);
            }
        } catch (Exception ex) {
            request.setAttribute("message", "Could not perform that action.");
        }

        List<User> users = null;
        try {
            users = (List<User>) us.getAll();
        } catch (Exception ex) {
            Logger.getLogger(AccountServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        request.setAttribute("users", users);
        getServletContext().getRequestDispatcher("/WEB-INF/companyAdmin/users.jsp").forward(request, response);
    }
}
