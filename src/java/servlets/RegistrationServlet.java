package servlets;

import businesslogic.UserService;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegistrationServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {       
        getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String action = request.getParameter("action");
        
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String company = request.getParameter("company");
           
        UserService us = new UserService();
        
        if (action == null) {
            action = "";
        }
        
        if (action.equals("register")) 
        {
            if (username.trim().isEmpty() || password.trim().isEmpty() || email.trim().isEmpty()
                    || firstname.trim().isEmpty() || lastname.trim().isEmpty() || company.isEmpty()) {
                request.setAttribute("message", "Please fill in the form.");
                doGet(request, response);
                return;
            }
            else  
            {
                try {
                        us.register(username, password, email, firstname, lastname);
                        request.setAttribute("message", "You registered successfully. Please login with the account you created.");
                        getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response); 
                        //doGet(request, response);
                } catch (Exception ex) 
                {
                    request.setAttribute("message", "Could not perform that action.");
                }       
            }     
        }
        getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);        
    }
}
