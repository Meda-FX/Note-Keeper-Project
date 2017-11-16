<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="c" %>

<c:header></c:header>

    <div class="container">
        <h1></h1>
        <h1>Users Login</h1>
        
    <form action="login?action=login" method="post">
        <div class="form-group">
            <label for="exampleInputEmail1">User Name</label>
            <input type="text" class="form-control" name="username" value="${username}" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter username">
        </div>
        <div class="form-group">
            <label for="exampleInputPassword1">Password</label>
            <input type="password" name="password" class="form-control" id="exampleInputPassword1" placeholder="Password">
        </div>
        <button type="submit" class="btn btn-dark">Login</button>
    </form>  
    <p class="error">${message}</p>   
</div>
</body>
</html>
