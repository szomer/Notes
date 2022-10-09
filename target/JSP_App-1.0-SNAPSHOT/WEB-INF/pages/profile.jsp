<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:user_wrapper>
    <h1>Profile</h1>

    <h1>Your personal information</h1>
    First Name: ${currentUser.firstName}
    <br>
    Last Name: ${currentUser.lastName}
    <br>
    Email: ${currentUser.email}
    <br>
    Phone: ${currentUser.phone}
    <br>
    Street: ${currentUser.street}
    <br>
    Zipcode: ${currentUser.zipcode}
    <br>
    City: ${currentUser.city}
    <br>
    Country: ${currentUser.country}
    <br>
    Password: ${currentUser.password}

    <br>
    <br>

    <h1>Change User Information</h1>
    <form action="/profile/update" method="post">
        <label>New First Name: </label>
        <input type="text" name="firstName" value="${currentUser.firstName}">
        <br>
        <label>New Last Name: </label>
        <input type="text" name="lastName" value="${currentUser.lastName}">
        <br>
        <label>New Email: </label>
        <input type="text" name="email" value="${currentUser.email}">
        <br>
        <label>New Phone: </label>
        <input type="text" name="phone" value="${currentUser.phone}">
        <br>
        <label>New Street: </label>
        <input type="text" name="street" value="${currentUser.street}">
        <br>
        <label>New Zipcode: </label>
        <input type="text" name="zipcode" value="${currentUser.zipcode}">
        <br>
        <label>New City: </label>
        <input type="text" name="city" value="${currentUser.city}">
        <br>
        <label>New Country: </label>
        <input type="text" name="country" value="${currentUser.country}">
        <br>
        <label>New Password: </label>
        <input type="text" name="password" value="${currentUser.password}">
        <br>
        <input type="submit" value="Update Info">
    </form>

    ${updateUserConfirmationMessage}
    <br>

    <h1>Delete Account</h1>
    <form action="/user/delete" method="post">
        <input type="submit" value="Delete Account">
    </form>
</t:user_wrapper>
