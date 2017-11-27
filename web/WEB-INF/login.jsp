<%@ include file="includes/header.jsp" %>

<form id="form-login" action="login?action=login" method="post">
    <div class="form-header">
        <h2>NOTESKEEPR</h2>
    </div>
    <div class="form-group">
        <input type="text" class="form-control" name="username" value="${username}" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter username">
    </div>
    <div class="form-group">
        <input type="password" name="password" class="form-control" id="exampleInputPassword1" placeholder="Password">
    </div>
    <div>
        <p class="error">${message}</p>   
    </div>
    <div>
        <button class="login-button" type="submit" >Login</button>
    </div>
    <hr>
    <label>
        <p>
        <a id="login-footer-link" href="register?action=register">New user Register</a>
        </p>
    </label>
</form>  
</div>
<%@ include file="includes/footer.jsp" %>