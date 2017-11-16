<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="c" %>
<%@taglib prefix="e" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="d" uri="http://java.sun.com/jsp/jstl/core" %>

<c:headerLogout></c:headerLogout>

    <div class="container">
        <h1>User Account</h1>
        <d:set var="name" value = "${username}" />
        <d:set var="display" value = "${e:toUpperCase(name)}" />
        <h2>Welcome ${display}</h2>       

    <p class="error">${message}</p>     
    <hr>

    <h3>Edit Your Account Information</h3>
    <form action="account" method="POST">
        User Name: <br> <input type="text" name="username" value="${selectedUser.username}" readonly><br>
        Password: <br> <input type="password" name="password" value="${selectedUser.password}" ><br>                
        Email: <br> <input type="text" name="email" value="${selectedUser.email}" readonly><br>
        Active: <br> <input type="text" name="active" value="${selectedUser.active}" readonly><br>
        First Name: <br> <input type="text" name="firstname" value="${selectedUser.firstname}"><br>
        Last Name: <br> <input type="text" name="lastname" value="${selectedUser.lastname}"><br>
        <input type="hidden" name="action" value="edit">
        <input type="submit" value="Save">
    </form>
    <br>
    <table class="table table-dark">
        <tr>
            <th>User Name</th>
            <th>Password</th>
            <th>Email</th>
            <th>Active</th>
            <th>First Name</th>
            <th>Last Name</th>
        </tr>          

        <tr>
            <td>${user.username}</td>
            <td>${user.password}</td>
            <td>${user.email}</td>
            <td>${user.active}</td>
            <td>${user.firstname}</td>
            <td>${user.lastname}</td>
            <td>

                <form action="account" method="post" >
                    <d:if test="${user.role.roleID != 1}">
                        <input type="submit" value="Delete">
                        <input type="hidden" name="action" value="delete">
                    </d:if>
                    <input type="hidden" name="selectedUser" value="${user.username}">
                </form>

            </td>
            <!--This is to update the fields-->
            <td>
                <form action="account" method="get">
                    <input type="submit" value="Edit">
                    <input type="hidden" name="action" value="view">
                    <input type="hidden" name="selectedUser" value="${user.username}">
                </form>
            </td>
        </tr>
    </table>
</div>  
</body>
</html>
