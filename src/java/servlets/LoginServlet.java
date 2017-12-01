package servlets;

import businesslogic.CompanyService;
import businesslogic.RoleService;
import businesslogic.UserService;
import domainmodel.Company;
import domainmodel.Role;
import domainmodel.User;
import java.io.IOException;
import java.io.PrintWriter;
import static java.time.Clock.system;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        
        if (action != null && action.equals("logout")) {
            session.removeAttribute(username);
            session.invalidate();
            request.setAttribute("message", "You've been logged out successfully.");
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
            return;
        }
        else if(action != null && action.equals("register"))
        {
            getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
        }
        getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        HttpSession session = request.getSession();

        User user = null;
        User userComp = null;
        Role role = null;
        Company company = null;
        UserService us = new UserService();
        RoleService rs = new RoleService();
        CompanyService cs = new CompanyService();        
        
        if (action == null) {
            action = "";
        }

        if (action.equals("login")) {
            if (username == null || username.trim().isEmpty()) {
                request.setAttribute("message", "User name cannot be empty.");
                getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
                return;
            }
            if (password == null || password.trim().isEmpty()) {
                request.setAttribute("message", "Password cannot be empty.");
                getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
                return;
            }

            try {
                user = us.get(username);               
                if (user == null) //case 1 username exist
                {
                    request.setAttribute("message", "User name does not exist.");
                    getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
                    return;
                }
                //case 2 username does not exists                
                if (user.getPassword().equals(password)) {
                    userComp = us.get(username);                        
                    int compID = userComp.getCompany().getCompanyID();
                    
                    if (user.getActive() == true) {
                        role = rs.get(1);
                        if (user.getRole().getRoleID() == 1) 
                        {      
                            session.setAttribute("username", username);
                            session.setAttribute("user", user);
                            session.setAttribute("compID", compID);
                            response.sendRedirect("admin");
                        } else if (user.getRole().getRoleID() == 2)
                        {
                            session.setAttribute("username", username);
                            session.setAttribute("user", user);
                            response.sendRedirect("notes");
                        } else
                        {                            
                            session.setAttribute("username", username);
                            session.setAttribute("user", user);    
                            session.setAttribute("compID", compID);
                            response.sendRedirect("companyadmin");
                        }
                      
                    } else {
                        request.setAttribute("message", "The user is not active.");
                        getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
                        return;
                    }
                } else {
                    request.setAttribute("message", "The password is not good.");
                    getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
                    return;
                }
            } catch (Exception ex) {
                Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
       
    }

}
