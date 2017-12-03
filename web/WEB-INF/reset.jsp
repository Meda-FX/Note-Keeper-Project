<%@ include file="/WEB-INF/includes/header_no_nav.jsp" %>

<form id="form-resetpass"  action="reset?action=resetpass" method="post">
    <div class="form-header">
        <h1>Reset Password</h1>         
    </div>             
    <div class="form-group">
        <h5>Please enter the email address you use when you register to NotesKeepr.</h5><br>
        <input type="text" class="form-control" id="resetpass" name="toResetEmail" placeholder="email address">
    </div>            
    <div>
        <p class="error">${message}</p>   
    </div>
    <input class="login-button" type="submit" value="Submit">            
    <p><a id="login-footer-link" href="login">&LT;GO BACK</a></p>
</form> 
<br>  
</div>  <!--Container ends here -->
</body>
</html>