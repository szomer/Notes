package com.jsp_app.servlets.notes;

import com.jsp_app.database.Database;
import com.jsp_app.entities.Note;
import com.jsp_app.entities.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

@WebServlet(name = "AddNoteServlet", value = "/AddNoteServlet")
public class AddNoteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url              = "/WEB-INF/pages/notes.jsp";
        int note_id             = 0;

        // Get the current user data
        HttpSession session     = request.getSession(true);
        User currentUser        = (User)session.getAttribute("currentUser");

        // Get the title and content from the user input
        String title            = request.getParameter("title");
        String content          = request.getParameter("content");

        // Get the current date
        String created = getDate();

        // Create a new note
        Note newNote = new Note(note_id, title, content, created, currentUser.getUser_id());

        // ADD NOTE VALIDATION HERE

        // Add note to db and retrieve note id
        Database db     = new Database();
        note_id         = db.createNote(newNote);

        // Confirm new note creation in db
        if(note_id != 0){
            newNote.setNote_id(note_id);
        }

        // Retrieve notes for current user from db
        Database db2            = new Database();
        ArrayList<Note> notes   = db2.getNotes(currentUser.getUser_id());

        // Set arraylist notes as attribute to request
        request.setAttribute("notes", notes);


        // Pass the attributes to the url profile.jsp
        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
    }

    // Returns the current date
    private String getDate(){
        DateTimeFormatter dtf   = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDateTime date      = LocalDateTime.now();
        return dtf.format(date);
    }
}
