package servlets;

import businesslogic.RoleService;
import businesslogic.UserService;
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

public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
    }

    @Override
    @SuppressWarnings("IncompatibleEquals")
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String action = request.getParameter("action");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        //User user = new User(username);
        User user = null;
        Role role = null;
        UserService us = new UserService();
        RoleService rs = new RoleService();
        
        if(action == null)
            action = "";
        
        if(action.equals("login"))
        {            
            if(username == null || username.trim().isEmpty())
            {
                request.setAttribute("message", "User name cannot be empty.");
                getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
                return;
            }
            if(password == null || password.trim().isEmpty())
            {
                request.setAttribute("message", "Password cannot be empty.");
                getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
                return;
            }
            
            try {    
                user = us.get(username);
                
                if(user == null) //case 1 username exist
                {
                    //System.out.print("User name does  not exist.");
                    request.setAttribute("message", "User name does not exist.");
                    getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
                    return;
                }                
    
                //case 2 username does not exists                
                if(user.getPassword().equals(password))
                {
                    //request.setAttribute("message", "The password is good.");
                    
                    // check if they are admin or regular user
                    if(user.getActive() == true)
                    {
                        role = rs.get(1);
                        //request.setAttribute("message", "The user is active.");
                        //getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
                        if(user.getRole().getRoleID() == 1)
                        {
                            request.setAttribute("message", "The user is active and is an Aminstrator.");
                            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
                            return;
                        }
                        else
                        {
                            request.setAttribute("message", "The user is active and is a Regular user.");
                            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
                            return;
                        }
                                             
                    }
                    else
                    {
                        request.setAttribute("message", "The user is not active.");
                        getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
                        return;
                    }
                    // check if they are active or not
                    
                    
                    
                   // getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
                   // return;
                }
                else
                {
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