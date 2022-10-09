package com.jsp_app.servlets.profile;

import com.jsp_app.UserInputValidator;
import com.jsp_app.database.Database;
import com.jsp_app.entities.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "UpdateProfileServlet", value = "/UpdateProfileServlet")
public class UpdateProfileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url          = "/WEB-INF/pages/profile.jsp";

        // Get the current user data
        HttpSession session = request.getSession(true);
        User currentUser    = (User)session.getAttribute("currentUser");

        // Retrieve the user input
        String firstName    = request.getParameter("firstName");
        String lastName     = request.getParameter("lastName");
        String email        = request.getParameter("email");
        String phone        = request.getParameter("phone");
        String street       = request.getParameter("street");
        String zipcode      = request.getParameter("zipcode");
        String city         = request.getParameter("city");
        String country      = request.getParameter("country");
        String password     = request.getParameter("password");

        // Validate the user input
        UserInputValidator validator = new UserInputValidator();
        // Apply the changes to a new user
        User updatedUser = validator.getUpdatedUser(currentUser, firstName, lastName,
                email, phone, street, zipcode, city, country, password);
        // Validate the format of the user input
        boolean validated = validator.checkFormat(updatedUser, true);

        if(validated){
            // Update user in db
            Database db         = new Database();
            boolean updated     = db.updateUser(updatedUser);
            // Confirm updated user db
            if (updated) {
                // Store the logged-in user in session
                // Update the current user attribute
                session.setAttribute("currentUser", updatedUser);

                // Set confirmation message
                String updateUserConfirmationMessage =
                        "Your User Information Has Been Successfully Updated";
                request.setAttribute("updateUserConfirmationMessage",
                        updateUserConfirmationMessage);
            }
        }

        // Pass the attributes to the url profile.jsp
        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
    }
}
