<%@ include file="/WEB-INF/includes/header_no_nav.jsp" %>

<form id="form-resetpass" action="reset?action=getnewpassword" method="POST">
    <div class="form-header">
        <h1>New Password</h1>     
    </div> 
    <div class="form-group">
        <h5>Please enter your new password to reset your password.</h5><br>
        <input type="text" class="form-control" id="resetpass" name="newPassord" placeholder="new password">
    </div>  
    <div>
        <p class="error">${message}</p>   
    </div>            
    <input class="login-button" type="hidden" name="uuid" value="${uuid}">
    <input class="login-button" type="submit" value="Submit">
</form>

</body>
</html>