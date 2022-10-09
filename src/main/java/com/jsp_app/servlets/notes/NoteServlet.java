package com.jsp_app.servlets.notes;

import com.jsp_app.database.Database;
import com.jsp_app.entities.Note;
import com.jsp_app.entities.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "NoteServlet", value = "/NoteServlet")
public class NoteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = "/WEB-INF/pages/notes.jsp";

        // Get the current user data
        HttpSession session = request.getSession(true);
        User currentUser = (User)session.getAttribute("currentUser");

        // Retrieve notes for current user from db
        Database db = new Database();
        ArrayList<Note> notes = db.getNotes(currentUser.getUser_id());

        // Set arraylist notes as attribute to request
        request.setAttribute("notes", notes);

        // Pass the attributes to the url profile.jsp
        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
    }
}
