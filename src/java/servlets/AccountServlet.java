package servlets;

import businesslogic.UserService;
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

public class AccountServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        UserService us = new UserService();
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

        User user = null;
        String accountHolder;
        HttpSession session = request.getSession();
        accountHolder = (String) session.getAttribute("username");

        try {
            user = us.get(accountHolder);
        } catch (Exception ex) {
            Logger.getLogger(AccountServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        request.setAttribute("user", user);
        getServletContext().getRequestDispatcher("/WEB-INF/account/account.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        HttpSession session = request.getSession();
        User user;
        String accountHolder = (String) session.getAttribute("username");

        if (action == null) {
            action = "";
        }

        UserService us = new UserService();
        try {
            if (action.equals("delete")) {
                user = us.get(accountHolder);
                user.setActive(false);
                String selectedUser = request.getParameter("selectedUser");
                session.removeAttribute("username");
                us.logicallyDelete(selectedUser, false);
                getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
            } else if (action.equals("edit")) {
                String username = request.getParameter("username");
                String password = request.getParameter("password");
                String email = request.getParameter("email");
                String firstname = request.getParameter("firstname");
                String lastname = request.getParameter("lastname");
                //us.update(username, email, password, firstname, lastname);
                doGet(request, response);
            }
        } catch (Exception ex) {
            request.setAttribute("message", "Could not perform that action.");
        }
        getServletContext().getRequestDispatcher("/WEB-INF/account/account.jsp").forward(request, response);
    }
}
