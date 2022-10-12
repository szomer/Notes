<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:user_wrapper>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/profile.css" type="text/css"/>

    <div id="user_info_container">
        <h1>Your Personal Details</h1>

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
    </div>

    <div id="user_action_container">
        <h1>Actions</h1>

        <form action="/logout" method="post">
            <input type="submit" value="Log Out"/>
        </form>
        <br>

        <button onclick="replace()">Change Details</button>
        <br>

        <br>
        <form action="/user/delete" method="post">
            <input type="submit" value="Delete Account">
        </form>
    </div>


    <script>
        let i=0;
        function replace(){
            if(i===1){
                document.getElementById("user_info_container").innerHTML =
                    '<h1>Your personal details</h1>First Name: ${currentUser.firstName}<br>Last Name: ${currentUser.lastName}<br>Email: ${currentUser.email}<br>Phone: ${currentUser.phone}<br>Street: ${currentUser.street}<br>Zipcode: ${currentUser.zipcode}<br>City: ${currentUser.city}<br>Country: ${currentUser.country}<br>Password: ${currentUser.password}<br>${updateUserConfirmationMessage}';
                i=0;
            }else{
                document.getElementById("user_info_container").innerHTML =
                    '<h1>Change User Information</h1><form action="/profile/update" method="post"><label>New First Name : </label><input type="text" name="firstName" value="${currentUser.firstName}"><br><label>New Last Name : </label><input type="text" name="lastName" value="${currentUser.lastName}"><br><label>New Email : </label><input type="text" name="email" value="${currentUser.email}"><br><label>New Phone : </label><input type="text" name="phone" value="${currentUser.phone}"><br><label>New Street : </label><input type="text" name="street" value="${currentUser.street}"><br><label>New Zipcode : </label><input type="text" name="zipcode" value="${currentUser.zipcode}"><br><label>New City : </label><input type="text" name="city" value="${currentUser.city}"><br><label>New Country : </label><input type="text" name="country" value="${currentUser.country}"><br><label>New Password : </label><input type="text" name="password" value="${currentUser.password}"><br><br><input type="submit" value="Update Info"></form><br>${updateUserConfirmationMessage}';
                i=1;
            }
        }
    </script>
</t:user_wrapper>
