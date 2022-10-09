package com.jsp_app.servlets.profile;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ProfileServlet", value = "/ProfileServlet")
public class ProfileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = "/WEB-INF/pages/profile.jsp";

        // Pass the attributes to the url profile.jsp
        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
    }
}
