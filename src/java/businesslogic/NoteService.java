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

    public int update(int noteId, String contents, String title, boolean noteSahre) throws Exception {
        Note note = noteDB.getNote(noteId);
        note.setTitle(title);
        note.setContents(contents);
        note.setPublicNote(noteSahre);
        return noteDB.update(note);
    }

    public int delete(int noteId) throws Exception {
        Note deleteNote = noteDB.getNote(noteId);
        return noteDB.delete(deleteNote);
    }

    public int insert(String title, String contents, boolean publicNote, User owner) throws Exception {
        java.util.Date uDate = new java.util.Date();
        java.sql.Date sDate = new java.sql.Date(uDate.getTime());
        Note note = new Note(0, sDate, title, contents, publicNote, owner);
        return noteDB.insert(note);
    }
}
