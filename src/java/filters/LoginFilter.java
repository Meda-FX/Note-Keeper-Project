package filters;

import businesslogic.UserService;
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

/**
 *
 * @author 608964
 */
public class LoginFilter implements Filter {    
   
    private FilterConfig filterConfig = null;
 
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {     
        
        UserService us = new UserService();
        HttpSession session = ((HttpServletRequest)request).getSession();
        String username = (String) session.getAttribute("username");
        
        try {
        if(username != null)
        {
             chain.doFilter(request, response);
        }
        else
        {
            ((HttpServletResponse)response).sendRedirect("login");
        }
        } catch (Exception ex) {
            Logger.getLogger(LoginFilter.class.getName()).log(Level.SEVERE, null, ex);
        }          
    }
 
    public void destroy() {        
    }

    /**
     * Init method for this filter
     */
    public void init(FilterConfig filterConfig) {        
        this.filterConfig = filterConfig;
        
    }    
}
