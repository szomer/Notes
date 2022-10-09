package com.jsp_app.servlets.signup;

import com.jsp_app.UserInputValidator;
import com.jsp_app.database.Database;
import com.jsp_app.entities.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "CreateUserServlet", value = "/CreateUserServlet")
public class CreateUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url                          = "/signup.jsp";
        String signUpConfirmationMessage    = "Account Could Not Be Created";
        int user_id                         = 0;

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

        // Store the data in user
        User user = new User(user_id, firstName, lastName, email,
                phone, street, zipcode, city, country, password);

        // Check the format of the user input
        UserInputValidator validator = new UserInputValidator();
        boolean validated = validator.checkFormat(user, true);
        if(validated) {
            // Add user to db and retrieve the user id
            Database db = new Database();
            user_id     = db.createUser(user);

            // Confirm new user creation in db
            if(user_id != 0) {
                // Set the confirmation message String
                user.setUser_id(user_id);
                signUpConfirmationMessage = "New Account Created!";
            }
        }

        // Set the info of attributes for the page
        request.setAttribute("signUpConfirmationMessage", signUpConfirmationMessage);
        request.setAttribute("user", user);

        // Change the url with attributes
        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
    }
}
