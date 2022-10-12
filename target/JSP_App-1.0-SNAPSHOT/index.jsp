<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:home_wrapper>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/index.css" type="text/css"/>

    <div id="container">
    <h1>Log In Page</h1>

    <form action="/login" method="post">
        <label class="label_login">Email:</label><br>
        <input type="text" style="text-align:center;" name="email" placeholder="email@email.com" value="${email}"><br>
        <label class="label_login">Password:</label><br>
        <input type="password" style="text-align:center;" name="password" placeholder="xxxxxxxxx" value="${password}"><br>
            ${logInMessage} <br>
        <input type="submit" value="Log In"><br>
    </form>
<br><br>
    <form action="/signup" method="post">
    <input type="submit" value="Sign Up">
    </form>

    </div>
</t:home_wrapper>