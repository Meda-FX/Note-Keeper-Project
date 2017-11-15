package filters;

import businesslogic.UserService;
import domainmodel.User;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AdminFilter implements Filter {
    
    private FilterConfig filterConfig = null;      
    
    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {        
        
        User user = new User();
        UserService us = new UserService();
        HttpSession session = ((HttpServletRequest)request).getSession();
        String username = (String) session.getAttribute("username");
        
        try {
            user = us.get(username);
            if(user.getRole().getRoleID() == 1)
            {
                chain.doFilter(request, response);
            }
            else
            {
                ((HttpServletResponse)response).sendRedirect("notes");
            }
        } catch (Exception ex) {
            Logger.getLogger(AdminFilter.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }

    /**
     * Destroy method for this filter
     */
    public void destroy() {        
    }

    /**
     * Init method for this filter
     */
    public void init(FilterConfig filterConfig) {        
        this.filterConfig = filterConfig;        
    }    
}
