package com.jsp_app;

import com.jsp_app.entities.User;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserInputValidator {

    // ^        start of string
    // $        end of string
    // A-Za-z   can contain upper A-Z and lower case a-z letters
    // \\.      can contain periods
    // \\'      can contain quotes
    // \\       can contain spaces
    // \\-      can contain dashes
    // {2,30}   must be between 2 and 30 characters


    public boolean checkFormat(User user, boolean validated) {
        // Check format for user input
        if (!regularExpressionChecker(
                "^[A-Za-z\\.\\'\\ \\-]{2,30}$",
                user.getFirstName())) {
            user.setFirstName("Try Again");
            validated = false;
        } if (!regularExpressionChecker(
                "^[A-Za-z\\.\\'\\ \\-]{2,30}$",
                user.getLastName())) {
            user.setLastName("Try Again");
            validated = false;
        } if (!regularExpressionChecker(
                "^[A-Za-z0-9._\\%-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}$",
                user.getEmail())) {
            user.setEmail("Try Again");
            validated = false;
        } if (!regularExpressionChecker(
                "^[0-9\\.\\'\\ \\-]{2,20}$",
                user.getPhone())) {
            user.setPhone("Try Again");
            validated = false;
        } if (!regularExpressionChecker(
                "^[A-Za-z0-9\\.\\'\\ \\-]{2,30}$",
                user.getStreet())) {
            user.setStreet("Try Again");
            validated = false;
        } if (!regularExpressionChecker(
                "^[A-Za-z0-9\\-]{2,10}$",
                user.getZipcode())) {
            user.setZipcode("Try Again");
            validated = false;
        } if (!regularExpressionChecker(
                "^[A-Za-z\\.\\'\\ \\-]{2,30}$",
                user.getCity())) {
            user.setCity("Try Again");
            validated = false;
        } if (!regularExpressionChecker(
                "^[A-Za-z\\.\\'\\ \\-]{2,30}$",
                user.getCountry())) {
            user.setCountry("Try Again");
            validated = false;
        } if (!regularExpressionChecker( // Must have 1 uppercase, 1 lowercase, 1 number and a special
                "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{5,30}$",
                user.getPassword())) {
            user.setPassword("Try Again");
            validated = false;
        }

        return validated;
    }

    private boolean regularExpressionChecker(String regex, String strCheck){
        Pattern regexPattern = Pattern.compile(regex);
        Matcher regexMatcher = regexPattern.matcher(strCheck);
        if(regexMatcher.matches())
            return true;

        return false;
    }

    public User getUpdatedUser(User currentUser, String firstName,
                                String lastName, String email, String phone,
                                String street, String zipcode, String city,
                                String country, String password){

        // When input field is null use the old value of the user
        if (firstName == null) {
            firstName = currentUser.getFirstName();
        } if (lastName == null) {
            lastName = currentUser.getLastName();
        } if (email == null) {
            email = currentUser.getEmail();
        } if (phone == null) {
            phone = currentUser.getPhone();
        } if (street == null) {
            street = currentUser.getStreet();
        } if (zipcode == null) {
            zipcode = currentUser.getZipcode();
        } if (city == null) {
            city = currentUser.getCity();
        } if (country == null) {
            country = currentUser.getCountry();
        } if (password == null) {
            password = currentUser.getPassword();
        }

        // Return the updated user
        return new User(currentUser.getUser_id(), firstName, lastName,
                email, phone, street, zipcode, city, country, password);
    }
}
