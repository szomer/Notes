<%@ tag description="User Pages Wrapper" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Welcome</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/user.css" type="text/css"/>
    <link href="https://fonts.googleapis.com/css2?family=Abril+Fatface" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Abril+Fatface&family=Quicksand" rel="stylesheet">
</head>
<body>
    <div id="wrapper">
        <div id="header">
            <form name="requestForm" method="post">
                <div id="header_notes" onclick="transferCallToServlet('/note')">
                   Notes
                </div>
                <div id="header_profile" onclick="transferCallToServlet('/profile')">
                   Profile
                </div>
            </form>
        </div>
        <div id="content_container">
            <div id="content">
                <jsp:doBody/>
            </div>
        </div>
    </div>

    <script>
        function transferCallToServlet(i) {
            document.requestForm.action = i;
            document.requestForm.submit();
        }
    </script>
</body>
</html>