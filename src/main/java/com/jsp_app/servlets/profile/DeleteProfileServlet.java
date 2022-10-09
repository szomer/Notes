package com.jsp_app.servlets.profile;

import com.jsp_app.database.Database;
import com.jsp_app.entities.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "DeleteProfileServlet", value = "/DeleteProfileServlet")
public class DeleteProfileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url              = "/WEB-INF/pages/index.jsp";

        // Get the current user data
        HttpSession session     = request.getSession(true);
        User currentUser        = (User)session.getAttribute("currentUser");

        // Delete user from db
        Database db             = new Database();
        boolean userDeleted     = db.deleteUser(currentUser.getUser_id());
        // Validation
        if(userDeleted) {
            // Remove the logged-in user in session
            session = request.getSession();
            session.removeAttribute("currentUser");
        }

        // Pass the attributes to the url profile.jsp
        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
    }
}
