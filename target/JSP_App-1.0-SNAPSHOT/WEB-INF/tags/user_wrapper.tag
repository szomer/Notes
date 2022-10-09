<%@ tag description="User Pages Wrapper" pageEncoding="UTF-8"%>

<html>
<head>
    <title>Welcome</title>
</head>
<body>
<div>
    <h1>Welcome User</h1>
    <form action="/note" method="post">
        <input type="submit" value="Notes"/>
    </form>
    <form action="/profile" method="post">
        <input type="submit" value="Profile"/>
    </form>
    <form action="/logout" method="post">
        <input type="submit" value="Log Out"/>
    </form>
    <br>
    <jsp:doBody/>
</div>
</body>
</html>