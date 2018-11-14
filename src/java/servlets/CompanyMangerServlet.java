package servlets;

import businesslogic.CompanyService;
import domainmodel.Company;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CompanyMangerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        CompanyService cs = new CompanyService();
        String action = request.getParameter("action");

        if (action != null && action.equals("view")) {
            String selectedID = request.getParameter("selectedID");
            try {
                Company company = cs.getCompany(Integer.parseInt(selectedID));
                request.setAttribute("selectedCompany", company);
            } catch (Exception ex) {
                Logger.getLogger(CompanyMangerServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        List<Company> companies = null;
        try {
            companies = cs.getAll();
        } catch (Exception ex) {
            Logger.getLogger(CompanyMangerServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        request.setAttribute("companies", companies);
        getServletContext().getRequestDispatcher("/WEB-INF/companyAdmin/companies.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        CompanyService cs = new CompanyService();
        try {
            if (action != null && action.equals("delete")) {
                int selectedID = Integer.parseInt(request.getParameter("selectedID"));
                cs.delete(selectedID);
            } else if (action != null && action.equals("edit")) {
                int companyID = Integer.parseInt(request.getParameter("companyID"));
                String companyName = request.getParameter("companyName");
                cs.update(companyID, companyName);
            } else if (action != null && action.equals("add")) {
                String companyName = request.getParameter("companyName");
                cs.insert(companyName);
            }
        } catch (Exception ex) {
            request.setAttribute("message", "Whoops. Could not perform that action.");
        }

        List<Company> companies = null;
        try {
            companies = (List<Company>) cs.getAll();
        } catch (Exception ex) {
            Logger.getLogger(CompanyMangerServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        request.setAttribute("companies", companies);
        getServletContext().getRequestDispatcher("/WEB-INF/companyAdmin/companies.jsp").forward(request, response);
    }
}
