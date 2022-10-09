package com.jsp_app.servlets.notes;

import com.jsp_app.database.Database;
import com.jsp_app.entities.Note;
import com.jsp_app.entities.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "DeleteNoteServlet", value = "/DeleteNoteServlet")
public class DeleteNoteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url              = "/WEB-INF/pages/notes.jsp";
        int note_id             = Integer.parseInt(request.getParameter("note_id"));

        // Get the current user data
        HttpSession session     = request.getSession(true);
        User currentUser        = (User)session.getAttribute("currentUser");

        // Delete the note from db with note_id
        Database db             = new Database();
        boolean noteDeleted     = db.deleteNote(note_id);

        if (noteDeleted) {
            // action for successful deletion
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
}
