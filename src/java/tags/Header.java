package tags;

import java.io.IOException;
import javax.servlet.ServletRequest;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import static javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE;
import static javax.servlet.jsp.tagext.Tag.SKIP_BODY;
import javax.servlet.jsp.tagext.TagSupport;

public class Header extends TagSupport 
{    
    @Override
    public int doStartTag() throws JspException 
    {
        ServletRequest req = pageContext.getRequest();
        String server = req.getServerName();
        String url = req.getParameter("debug");
        
        if(server.startsWith("login"))
        {
            return SKIP_BODY;            
        }              
        return EVAL_BODY_INCLUDE;
    }  
}
