<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:home_wrapper>

    <h1>Log In Page</h1>
    <br/>
    <form action="/login" method="post">
        <label>Email: </label>
        <input type="text" name="email" value="${email}"><br>

        <label>Password: </label>
        <input type="text" name="password" value="${password}"><br>
        <input type="submit" value="Log In">
    </form>
    <br>
    ${logInMessage}

    <form action="/signup" method="post">
    <input type="submit" value="Sign Up">
    </form>

</t:home_wrapper>