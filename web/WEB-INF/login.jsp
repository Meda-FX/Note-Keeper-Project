<%@ include file="includes/header_no_nav.jsp" %>

<section>
    <div class="row justify-content-md-center">
        <div class="col-xs-12 col-sm-12 col-md-8 col-lg-12">
            <form id="form-login" action="login?action=login" method="post">
                <div class="form-header">
                    <h2>NOTESKEEPR</h2>
                </div>
                <div class="row justify-content-md-center">
                    <div class="col-md-10">
                        <div class="form-group">
                            <input type="text" class="form-control" name="username" value="${username}" placeholder="Enter username">
                        </div>
                        <div class="form-group">
                            <input type="password" name="password" class="form-control" placeholder="Password">
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
                                <a href="register?action=register">New user Register</a> | 
                                <a href="reset">Reset Password</a>
                            </p>
                        </label>                
                    </div>
                </div>
            </form>  
        </div>
    </div>    
</section>

</div>
</div>  <!--Container ends here -->
</body>
</html>
