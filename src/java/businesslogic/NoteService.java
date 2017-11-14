package businesslogic;

import dataaccess.NoteDB;
import domainmodel.Note;
import domainmodel.User;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpSession;

public class NoteService {
    
    private NoteDB noteDB;
    
    public NoteService() {
        noteDB = new NoteDB();
    }
    
    public Note get(int noteId) throws Exception {
        return noteDB.getNote(noteId);
    }
    
    public List<Note> getAll() throws Exception {
        return noteDB.getAll();
    }
    
    public int update(int noteId, String contents, String title) throws Exception {
        Note note = noteDB.getNote(noteId);
        note.setTitle(title);
        note.setContents(contents);
        return noteDB.update(note);
    }
    
    public int delete(int noteId) throws Exception {
        Note deleteNote = noteDB.getNote(noteId);
        return noteDB.delete(deleteNote);
    }
    
    //user will edit the title and the content or only the content
    public int insert(String title, String contents, User owner) throws Exception {
        java.util.Date uDate = new java.util.Date();
        //Date date = new Date();
        java.sql.Date sDate = new java.sql.Date(uDate.getTime());
       //HttpSession httpSession = request.getSession(true);
        Note note = new Note(0, sDate, title, contents, owner);
        return noteDB.insert(note);
    }
}
