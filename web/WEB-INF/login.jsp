<%@ include file="includes/header.jsp" %>

<h1>Final Project</h1>
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
    <hr>
    <label>
        <a href="register?action=register">New user Register</a>
    </label>
            
</form>  
<p class="error">${message}</p>   
</div>

<%@ include file="includes/footer.jsp" %>