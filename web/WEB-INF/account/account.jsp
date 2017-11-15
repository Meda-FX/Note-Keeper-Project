<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="c" %>
<%@taglib prefix="d" uri="http://java.sun.com/jsp/jstl/core" %>

<c:headerLogout></c:headerLogout>
    
<div class="container">
        <h1>User Account</h1>
        <h2>Welcome ${username}</h2>       

        <p class="error">${message}</p>     
        <hr>
      
            <h3>Edit Your Account Information</h3>
            <form action="account" method="POST">
                User Name: <input type="text" name="username" value="${selectedUser.username}" readonly><br>
                Password: <input type="password" name="password" value="${selectedUser.password}" ><br>                
                Email: <input type="text" name="email" value="${selectedUser.email}" readonly><br>
                Active: <input type="text" name="active" value="${selectedUser.active}" readonly><br>
                First Name: <input type="text" name="firstname" value="${selectedUser.firstname}"><br>
                Last Name: <input type="text" name="lastname" value="${selectedUser.lastname}"><br>
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
            
        <%--<d:forEach var="user" items="${users}">--%>
            <tr>
                <td>${user.username}</td>
                <td>${user.password}</td>
                <td>${user.email}</td>
                <td>${user.active}</td>
                <td>${user.firstname}</td>
                <td>${user.lastname}</td>
                <td>
                    <form action="account" method="post" >
                        <input type="submit" value="Delete">
                        <input type="hidden" name="action" value="delete">
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
           <%--</d:forEach>--%>
        </table>
</div>  
    </body>
</html>
