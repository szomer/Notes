package com.jsp_app.database;

import com.jsp_app.entities.Note;
import com.jsp_app.entities.User;

import java.sql.*;
import java.util.ArrayList;

public class Database {

    private Connection connection   = null;
    private Statement statement     = null;
    private ResultSet resultSet     = null;

    // Constructor: Connect to db
    public Database() {
        try {
            // Connect to db
            Class.forName("com.mysql.jdbc.Driver");
            String url      = "jdbc:mysql://localhost:3306/jee";
            String user     = "dbadmin";
            String pass     = "turtle";
            connection      = DriverManager.getConnection(url, user, pass);

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    // INSERT INTO users
    public int createUser(User user){
        // Query for inserting new user
        String queryAddUser =
                "INSERT INTO users (" +
                        "user_id, firstName, lastName, email, phone, street, " +
                    "zipcode, city, country, password) " +
                    "VALUES (" +
                    "NULL, '" + user.getFirstName() + "', '" + user.getLastName() +
                    "', '" + user.getEmail() + "', '" + user.getPhone() +
                    "', '" + user.getStreet() + "', '" + user.getZipcode() +
                    "', '" + user.getCity() + "', '" + user.getCountry() +
                    "', '" + user.getPassword() + "');";

        // Query returns the id of new user
        String queryGetUserId =
                "SELECT LAST_INSERT_ID() " +
                    "as last_user_id " +
                    "FROM users;";
        try {
            statement = connection.createStatement();
            // Run query to create new user
            statement.executeUpdate(queryAddUser);
            // Run query to get user_id
            resultSet = statement.executeQuery(queryGetUserId);
            if (resultSet.next()) {
                // Return user_id
                return resultSet.getInt(1);
            }
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } finally {
            closeAll();
        }
        // No result
        return 0;
    }

    // INSERT INTO notes
    public int createNote(Note note){

        // Query for inserting new note
        String queryAddNote =
                "INSERT INTO notes (" +
                        "note_id, title, content, created, user_id)" +
                        "VALUES (" +
                        "NULL, '" + note.getTitle() + "', '" + note.getContent() +
                        "', '" + note.getCreated() + "', '" + note.getUser_id() + "');";
        // Query returns the id of new note
        String queryGetNoteId =
                "SELECT LAST_INSERT_ID() " +
                        "as last_notes_id " +
                        "FROM notes;";
        try {
            statement = connection.createStatement();
            // Run query to create new note
            statement.executeUpdate(queryAddNote);
            // Run query to get note_id
            resultSet = statement.executeQuery(queryGetNoteId);
            if (resultSet.next()) {
                // Return note_id
                return resultSet.getInt(1);
            }
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } finally {
            closeAll();
        }
        // No result
        return 0;
    }

    // Check if user exists and return it
    public User logIn(String logInEmail, String logInPassword){
        // Query that selects all users with specified email and password
        String queryGetUser =
                "SELECT * FROM users " +
                        "WHERE email = '"+ logInEmail +"' && " +
                        "password = '"+ logInPassword +"';";
        try{
            statement = connection.createStatement();
            resultSet = statement.executeQuery(queryGetUser);
            if (resultSet.next()) {
                int user_id         = resultSet.getInt("user_id");
                String firstName    = resultSet.getString("firstName");
                String lastName     = resultSet.getString("lastName");
                String email        = resultSet.getString("email");
                String phone        = resultSet.getString("phone");
                String street       = resultSet.getString("street");
                String zipcode      = resultSet.getString("zipcode");
                String city         = resultSet.getString("city");
                String country      = resultSet.getString("country");
                String password     = resultSet.getString("password");
                // Return result as user
                return new User(user_id, firstName, lastName, email, phone,
                        street, zipcode, city, country, password);
            }
        } catch(SQLException se) {
            se.printStackTrace();
        } finally {
            closeAll();
        }
        // No result
        return null;
    }

    // UPDATE user
    public boolean updateUser(User user){
        // Query that updates existing user
        String queryUpdateUser =
                "UPDATE users " +
                        "SET firstName = '" + user.getFirstName() + "', " +
                        "lastName = '" + user.getLastName() + "', " +
                        "email = '" + user.getEmail() + "', " +
                        "phone = '" + user.getPhone() + "', " +
                        "street = '" + user.getStreet() + "', " +
                        "zipcode = '" + user.getZipcode() + "', " +
                        "city = '" + user.getCity() + "', " +
                        "country = '" + user.getCountry() + "', " +
                        "password = '" + user.getPassword() + "' " +
                        "WHERE user_id = " + user.getUser_id() + ";";
        try {
            statement = connection.createStatement();
            // Execute update user info in db
            int result = statement.executeUpdate(queryUpdateUser);
            // Affected rows does not equal zero
            if (result != 0) {
                // Successful user update
                return true;
            }
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } finally {
            closeAll();
        }
        // Unsuccessful user update
        return false;
    }

    // SELECT NOTES
    public ArrayList<Note> getNotes(int user_id) {
        ArrayList<Note> notes = new ArrayList<>();

        // Query that selects all users with specified email and password
        String queryGetNotes =
                "SELECT * FROM notes " +
                        "WHERE user_id = " + user_id + ";";
        try{
            statement = connection.createStatement();
            resultSet = statement.executeQuery(queryGetNotes);

            while (resultSet.next()) {

                System.out.println("GET NOTE: " + resultSet.getInt(1) + ", " +resultSet.getString(2)
                        + ", " +resultSet.getString(3) + ", " +resultSet.getString(4)
                        + ", " +resultSet.getInt(5));

                // Retrieve all values of note from result
                int note_id     = resultSet.getInt("note_id");
                String title    = resultSet.getString("title");
                String content  = resultSet.getString("content");
                String created  = resultSet.getString("created");

                // Add note to ArrayList
                notes.add(new Note(note_id, title, content, created, user_id));
            }
        } catch(SQLException se) {
            se.printStackTrace();
        } finally {
            closeAll();
        }
        // Return ArrayList
        return notes;
    }

    // DELETE USER
    public boolean deleteUser(int user_id){
        // Query that deletes notes of user
        String queryDeleteNotes =
                "DELETE FROM notes " +
                        "WHERE user_id=" + user_id + ";";
        // Query that deletes user
        String queryDeleteUser =
                "DELETE FROM users " +
                        "WHERE user_id=" + user_id + ";";
        try {
            statement = connection.createStatement();
            // Execute delete notes in db
            int result = statement.executeUpdate(queryDeleteNotes);
            // Affected rows does not equal zero
            if (result != 0) {
                statement = connection.createStatement();
                // Execute delete user in db
                result = statement.executeUpdate(queryDeleteUser);
                // Affected rows does not equal zero
                if (result != 0) {
                    // Successful user deletion
                    return true;
                }
            }
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } finally {
            closeAll();
        }
        // Unsuccessful deletion
        return false;
    }

    // DELETE USER
    public boolean deleteNote(int note_id){
        // Query that deletes notes of user
        String queryDeleteNote =
                "DELETE FROM notes " +
                        "WHERE note_id=" + note_id + ";";

        try {
            statement = connection.createStatement();
            // Execute delete note in db
            int result = statement.executeUpdate(queryDeleteNote);
            // Affected rows does not equal zero
            if (result != 0) {
                    return true;
            }
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } finally {
            closeAll();
        }
        // Unsuccessful deletion
        return false;
    }

    // Close the connection, statement and resulSet
    public void closeAll() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
            }
        } if (statement != null) {
            try {
                statement.close();
            } catch(SQLException e){
                System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
            }
        }if(resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                    System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
            }
        }
    }

    public Connection getConnection() {
        return connection;
    }
}