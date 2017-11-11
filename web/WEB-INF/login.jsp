<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="c" %>

<%--<c:header></c:header>--%>
    
        <h1>Users Login</h1>
        <form action="login?action=login" method="post">
            <p>Username: <input type="text" name="username" value="${user.username}"/></p>
            <p>Password: <input type="password" name="password" /></p>
            <p><input type="submit" value="Login"></p>
        </form>  
        ${message}
    </body>
</html>
