package servlets;

import businesslogic.CompanyService;
import businesslogic.UserService;
import domainmodel.Company;
import domainmodel.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegistrationServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        CompanyService cs = new CompanyService();
        List<Company> companies = null;
        try {
            companies = cs.getAll();
        } catch (Exception ex) {
            Logger.getLogger(AccountServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        request.setAttribute("companies", companies);
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

        String selectedCompany = request.getParameter("company");
        int compId = Integer.parseInt(selectedCompany);

        UserService us = new UserService();

        if (action != null && action.equals("register")) {
            if (username.trim().isEmpty() || password.trim().isEmpty() || email.trim().isEmpty()
                    || firstname.trim().isEmpty() || lastname.trim().isEmpty() || selectedCompany.isEmpty()) {
                request.setAttribute("message", "Please fill in the form.");
                doGet(request, response);
                return;
            } else {
                try {
                    us.register(username, password, email, firstname, lastname, compId);
                    request.setAttribute("message", "You registered successfully. Please login with the account you created.");
                    getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
                } catch (Exception ex) {
                    request.setAttribute("message", "Could not perform that action.");
                }
            }
        }
        getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
    }
}
