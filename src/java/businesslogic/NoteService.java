package businesslogic;

import dataaccess.NoteDB;
import domainmodel.Note;
import java.util.List;

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
    
    public int update(int noteId, String contents) throws Exception {
        Note note = noteDB.getNote(noteId);
        note.setContents(contents);
        return noteDB.update(note);
    }
    
    public int delete(int noteId) throws Exception {
        Note deleteNote = noteDB.getNote(noteId);
        return noteDB.delete(deleteNote);
    }
    
    //user will edit the title and the content or only the content
    public int insert(String title, String contents) throws Exception {
        java.util.Date uDate = new java.util.Date();
        java.sql.Date date = new java.sql.Date(uDate.getTime());
        Note note = new Note(0, date, title, contents);
        return noteDB.insert(note);
    }
    
}
