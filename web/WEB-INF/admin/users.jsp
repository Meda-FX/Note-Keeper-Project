<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="c" %>
<%@taglib prefix="d" uri="http://java.sun.com/jsp/jstl/core" %>

<c:headerLogout></c:headerLogout>
    <div class="container">
        <h1>Mange Users</h1>
        <hr>

    <d:if test="${selectedUser != null}">
        <h3>Edit User</h3>
        <form action="admin" method="POST">
            User Name: <br> <input type="text" name="username" value="${selectedUser.username}"><br>
            Password: <br> <input type="password" name="password" value="${selectedUser.password}" ><br>                
            Email: <br> <input type="text" name="email" value="${selectedUser.email}"><br>
            Active: <br> <input type="text" name="active" value="${selectedUser.active}" readonly><br>
            First Name: <br> <input type="text" name="firstname" value="${selectedUser.firstname}"><br>
            Last Name: <br> <input type="text" name="lastname" value="${selectedUser.lastname}"><br>
            <input type="hidden" name="action" value="edit"> <br>
            <input type="submit" value="Save">
        </form>
    </d:if>

    <d:if test="${selectedUser == null}">
        <h3>Add User</h3>
        <form action="admin" method="POST">
            User Name: <br> <input type="text" name="username"><br>
            Password: <br> <input type="password" name="password" ><br>                
            Email: <br> <input type="text" name="email"><br>
            Active: <br> <input type="text" name="active" readonly><br>
            First Name: <br> <input type="text" name="firstname" ><br>
            Last Name: <br> <input type="text" name="lastname" ><br>
            <input type="hidden" name="action" value="add">
            <input type="submit" value="Save">
        </form>
    </d:if>
    <br>
    <p class="error">${message}</p>   
    <table class="table table-dark">
        <tr>
            <th>User Name</th>
            <th>Password</th>
            <th>Email</th>
            <th>Active</th>
            <th>First Name</th>
            <th>Last Name</th>
        </tr>          
        <br>
        <d:forEach var="user" items="${users}">
            <tr>
                <td>${user.username}</td>
                <td>${user.password}</td>
                <td>${user.email}</td>
                <td>${user.active}</td>
                <td>${user.firstname}</td>
                <td>${user.lastname}</td>
                <td>
                    <form action="admin" method="post" >
                        <input type="submit" value="Delete">
                        <input type="hidden" name="action" value="delete">
                        <input type="hidden" name="selectedUser" value="${user.username}">
                    </form>
                </td>
                <!--This is to update the fields-->
                <td>
                    <form action="admin" method="get">
                        <input type="submit" value="Edit">
                        <input type="hidden" name="action" value="view">
                        <input type="hidden" name="selectedUser" value="${user.username}">
                    </form>
                </td>
            </tr>
        </d:forEach>
    </table>
</div>
</body>
</html>
