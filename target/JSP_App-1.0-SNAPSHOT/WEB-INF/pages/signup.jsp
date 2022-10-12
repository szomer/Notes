<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:home_wrapper>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/signup.css" type="text/css"/>
  <div id="container">
    <h1>Account Creation</h1>
      <form action="/user/create" method="post">
        <label class="label_signup">First Name: </label>
        <input type="text" name="firstName" placeholder="first name" value="${user.firstName}">
        <br>
        <label class="label_signup">Last Name: </label>
        <input type="text" name="lastName" placeholder="last name" value="${user.lastName}">
        <br>
        <label class="label_signup">Email: </label>
        <input type="text" name="email" placeholder="email@email.com" value="${user.email}">
        <br>
        <label class="label_signup">Phone: </label>
        <input type="text" name="phone" placeholder="xx xx xx xx" value="${user.phone}">
        <br>
        <label class="label_signup">Street: </label>
        <input type="text" name="street" placeholder="street name" value="${user.street}">
        <br>
        <label class="label_signup">Zipcode: </label>
        <input type="text" name="zipcode" placeholder="zipcode" value="${user.zipcode}">
        <br>
        <label class="label_signup">City: </label>
        <input type="text" name="city" placeholder="city" value="${user.city}">
        <br>
        <label class="label_signup">Country: </label>
        <input type="text" name="country" placeholder="country" value="${user.country}">
        <br>
        <label class="label_signup">Password: </label>
        <input type="password" name="password" placeholder="xxxxxxx" value="${user.password}">
        <br>${signUpConfirmationMessage}<br>
        <input type="submit" value="Create Account">
      </form>

      <br><br>
      <form action="/" method="post">
        <input type="submit" value="Log In"/>
      </form>
  </div>
</t:home_wrapper>