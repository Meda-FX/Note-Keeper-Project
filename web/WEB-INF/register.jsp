<%@ include file="/WEB-INF/includes/header.jsp" %>
   
       
       
         <form id="form-register"  action="register" method="post">
            <div class="form-header">
                 <h1>Registration</h1>             
            </div>             
             <div class="form-group">
                <input type="text" class="form-control" id="username" name="username" placeholder="username">
            </div>
            <div class="form-group">
                <input type="password" class="form-control" id="password" name="password" placeholder="password">
            </div>
            <div class="form-group">
                <input type="email" class="form-control" id="email" name="email" placeholder="email">
            </div>            
            <div class="form-group">
                <input type="text" class="form-control" id="firstname" name="firstname" placeholder="first name">
            </div>
            <div class="form-group">
                <input type="text" class="form-control" id="lastname" name="lastname" placeholder="last name">
            </div>    
             <div class="form-group">
                <select id="company-select" name="company">
                    <option value="-1" ${selected}>Please select your company</option>
                    <c:forEach items="${companies}" var="company">
                      <option value="${company.companyID}" ${selected}>${company.companyName}</option>
                    </c:forEach>
                  </select>
            </div>   
            <input type="hidden" name="action" value="register">
            <input class="login-button" type="submit" value="Register">
            <div>
                <p class="error">${message}</p>   
            </div>
        </form> 
    <br>
      
    </div> <!-- End of Container one -->
    
     <br><br>
    <%@ include file="/WEB-INF/includes/footer.jsp" %>
