<%@ include file="/WEB-INF/includes/header.jsp" %>
   
        <h1>Registration</h1>
        <hr> 
        <h3>Welcome New User</h3>        
         <form action="register" method="post">
            <div class="form-group">
                <label for="username"> User Name:</label>
                <input type="text" class="form-control" id="username" name="username" >
            </div>
            <div class="form-group">
                <label for="password"> Password:</label>
                <input type="password" class="form-control" id="password" name="password" >
            </div>
            <div class="form-group">
                <label for="email"> Email:</label>
                <input type="email" class="form-control" id="email" name="email" >
            </div>            
            <div class="form-group">
                <label for="firstname"> First Name: </label>
                <input type="text" class="form-control" id="firstname" name="firstname">
            </div>
            <div class="form-group">
                <label for="lastname"> Last Name: </label>
                <input type="text" class="form-control" id="lastname" name="lastname">
            </div>    
             <div class="form-group">
                <label for="companyID"> Company: </label>
<!--                <input type="text" class="form-control" id="companyID" name="company">-->
                
                <select name="comp" class="custom-select">
                    <option selected>Open this select menu</option>
                    <option value="1">One</option>
                    <option value="2">Two</option>
                    <option value="3">Three</option>
                </select>
                
            </div>   
             
            <input type="hidden" name="action" value="register">
            <input type="submit" value="Register">
        </form> 
    <br>
    <p class="error">${message}</p>   
    </div> <!-- End of Container one -->
    
     <br><br>
    <%@ include file="/WEB-INF/includes/footer.jsp" %>
