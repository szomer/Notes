<%@ tag description="Home Page Wrapper" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Welcome!</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/home.css" type="text/css"/>

</head>
<body>
    <div id="wrapper">
        <div id="login_container">
            <div id="logo">

            </div>
            <jsp:doBody/>
        </div>
    </div>
</body>
</html>