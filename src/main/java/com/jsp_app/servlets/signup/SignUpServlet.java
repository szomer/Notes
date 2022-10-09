package com.jsp_app.servlets.signup;

import com.jsp_app.database.Database;
import com.jsp_app.entities.User;
import com.jsp_app.UserInputValidator;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "SignUpServlet", value = "/SignUpServlet")
public class SignUpServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String url = "/WEB-INF/pages/signup.jsp";

        // Change the url with attributes
        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
    }

}
