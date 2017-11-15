package servlets;

import businesslogic.NoteService;
import businesslogic.UserService;
import domainmodel.Note;
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

public class NotesServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        NoteService ns = new NoteService();
        String action = request.getParameter("action");

        if (action != null && action.equals("view")) {
            String selectedId = request.getParameter("selectedId");

            try 
            {
                Note note = ns.get(Integer.parseInt(selectedId));
                request.setAttribute("selectedNote", note);
            } 
            catch (Exception ex) {
                Logger.getLogger(NotesServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        List<Note> notes = null;
        try {
            notes = ns.getAll();
        } catch (Exception ex) {
            Logger.getLogger(NotesServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        request.setAttribute("notes", notes);
        getServletContext().getRequestDispatcher("/WEB-INF/notes/notes.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
               
        String accountHolder;
        HttpSession session = request.getSession();
        accountHolder = (String) session.getAttribute("username");
         
        if(action == null)
        {
            action = "";
        }
        Note note = null; 
        NoteService ns = new NoteService();        
        try {     
            //int selectedId = Integer.parseInt(request.getParameter("selectedId"));
            //note = ns.get(selectedId);
            if (action.equals("delete")) 
            {    
               int selectedId = Integer.parseInt(request.getParameter("selectedId"));
               note = ns.get(selectedId);
               if(!note.getOwner().getUsername().equals(accountHolder))
               {  
                   request.setAttribute("message", "you can only delete your note.");
                   doGet(request, response);
                   return;
               }
               else
               {
                   ns.delete(selectedId);
                   request.setAttribute("message", "Note deleted successfully.");  
                   doGet( request, response);
               }
            }
            else if(action.equals("edit"))
            {
                int noteId = Integer.parseInt(request.getParameter("noteid"));
                String contents = request.getParameter("contents");
                String title = request.getParameter("title");
                ns.update(noteId, contents, title);
            }
            else if (action.equals("add"))
            {
                String contents = request.getParameter("contents");
                String title = request.getParameter("title");
                if(contents.trim().isEmpty() || contents == null || title.trim().isEmpty())
                {
                    request.setAttribute("message", "Please fill in the form.");
                    doGet(request, response);
                    return;
                }
                UserService us = new UserService();               
                User user;
                //session = request.getSession();
                user = (User) session.getAttribute("user");
                //String username = (String) session.getAttribute("username");
                
                //user = us.get(username);
               
                ns.insert(title, contents, user);
            }
        } catch (Exception ex) {
            request.setAttribute("message", "Could not perform that action. Please try again.");
        }
        
        List<Note> notes = null;
        try 
        {
            notes = (List<Note>) ns.getAll();
        } 
        catch (Exception ex) {
            Logger.getLogger(NotesServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        request.setAttribute("notes", notes);
        getServletContext().getRequestDispatcher("/WEB-INF/notes/notes.jsp").forward(request, response);
    }
}
