package com.jsp_app.servlets.login;

import com.jsp_app.database.Database;
import com.jsp_app.entities.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "LogInServlet", value = "/LogInServlet")
public class LogInServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = "/WEB-INF/pages/profile.jsp";

        // Retrieve the email and password from the request
        String email        = request.getParameter("email");
        String password     = request.getParameter("password");

        // Add attributes to the request
        request.setAttribute("email", email);
        request.setAttribute("password", password);

        // Log in validation with db
        Database db     = new Database();
        User user       = db.logIn(email, password);

        // User does not exist in db
        if (user == null) {
            // Set log in error message
            String logInMessage = "Email or Password Incorrect";
            request.setAttribute("logInMessage", logInMessage);
            url = "/index.jsp";
        } else { // User exists in db
            // Store the logged-in user in session
            HttpSession session = request.getSession();
            session.setAttribute("currentUser", user);
        }

        // Pass the attributes to the url profile.jsp
        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);

    }
}
