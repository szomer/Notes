<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:home_wrapper>

  <h1>Account Creation</h1>
    <form action="/user/create" method="post">
      <label>First Name: </label>
      <input type="text" name="firstName" value="${user.firstName}">
      <br>
      <label>Last Name: </label>
      <input type="text" name="lastName" value="${user.lastName}">
      <br>
      <label>Email: </label>
      <input type="text" name="email" value="${user.email}">
      <br>
      <label>Phone: </label>
      <input type="text" name="phone" value="${user.phone}">
      <br>
      <label>Street: </label>
      <input type="text" name="street" value="${user.street}">
      <br>
      <label>Zipcode: </label>
      <input type="text" name="zipcode" value="${user.zipcode}">
      <br>
      <label>City: </label>
      <input type="text" name="city" value="${user.city}">
      <br>
      <label>Country: </label>
      <input type="text" name="country" value="${user.country}">
      <br>
      <label>Password: </label>
      <input type="text" name="password" value="${user.password}">
      <br>
      <input type="submit" value="Sign Up">
    </form>

    <br>
    ${signUpConfirmationMessage}

    <br>
    <form action="/" method="post">
      <input type="submit" value="Log In"/>
    </form>


</t:home_wrapper>