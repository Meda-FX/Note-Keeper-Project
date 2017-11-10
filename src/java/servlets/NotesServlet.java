package servlets;

import businesslogic.NoteService;
import domainmodel.Note;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NotesServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        NoteService ns = new NoteService();
        String action = request.getParameter("action");

        if (action != null && action.equals("view")) {
            String selectdId = request.getParameter("action");

            try {
                Note note = ns.get(Integer.parseInt(selectdId));
                request.setAttribute("selectedNote", note);
            } catch (Exception ex) {
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

        if(action == null)
        {
            action = "";
        }
        NoteService ns = new NoteService();

        try {
            if (action.equals("delete")) {
                int selectedId = Integer.parseInt(request.getParameter("selectedId"));
                ns.delete(selectedId);
            }
            else if(action.equals("edit"))
            {
                int noteId = Integer.parseInt(request.getParameter("noteid"));
                String contents = request.getParameter("contents");
                ns.update(noteId, contents);
            }
            else if (action.equals("add"))
            {
                String contents = request.getParameter("contents");
                String title = request.getParameter("title");
                ns.insert(title, contents);
            }
        } catch (Exception ex) {
            Logger.getLogger(NotesServlet.class.getName()).log(Level.SEVERE, null, ex);
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
}
