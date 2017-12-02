<%@ include file="/WEB-INF/includes/header.jsp" %>
  <br>
    <div class="row">
        <div class="col-md-9"><h1>Company Admin - Role Manager</h1></div>
        <div class="col-md-3"><h3>Welcome ${display}</h3></div>
    </div>
    <hr>    
    <div class="row"><!-- row starts here -->
    <div class="col-xm-12 col-md-8">
        <h3>Edit Role</h3>        
        <form action="CompanyRoleManager" method="post">
            <div class="form-group">
                <label for="username"> User Name:</label>
                <input type="text" class="form-control" id="username" name="username" value="${selectedUser.username}" readonly>
            </div>  
            <div class="form-group">
                <label for="firstname"> First Name: </label>
                <input type="text" class="form-control" id="firstname" name="firstname" value="${selectedUser.firstname}" readonly>
            </div>
            <div class="form-group">
                <label for="lastname"> Last Name: </label>
                <input type="text" class="form-control" id="lastname" name="lastname" value="${selectedUser.lastname}" readonly>
            </div>            
             <div class="form-group">
                <label for="currrole"> Current Role </label>
                <input type="text" class="form-control" id="firstname" name="currrole" value="${selectedUser.role.roleName}" readonly>
            </div>
             <div class="form-group selectpicker">
                <label for="role-select">Choose Users Role:</label>
                <select id="role-select" name="userRoles">
                    <option value="-1" ${selected}>Please select roles</option>
                    <c:forEach items="${roles}" var="role" begin="1">
                      <option value="${role.roleID}" ${selected}>${role.roleName}</option>
                    </c:forEach>
                  </select>
            </div>   
            
            <input id="table-buttons_se" type="hidden" name="action" value="edit"> <br>
            <input id="table-buttons_se" type="submit" value="Save">
        </form>  
                    
    </div>
    </div> <!-- row finishes here -->
    
    <br>
    <p class="error">${message}</p>   
    </div> <!-- End of Container one -->
    
    <div class="container-fluid "><!-- Begin of container two -->
     <table class="table">
        <thead class="thead-dark">
        <tr>
            <th>User Name</th>
            <th>Password</th>
            <th>Email</th>
            <th>Active</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Role</th>
            <th>Company</th>
            <th></th>
            <th></th>
        </tr>    
        </thead>
        <br>
        <c:forEach var="user" items="${users}">
           <c:if test = "${user.company.companyID == compID}">
            <tr>
                <td>${user.username}</td>
                <td>${user.password}</td>
                <td>${user.email}</td>
                <td>${user.active}</td>
                <td>${user.firstname}</td>
                <td>${user.lastname}</td>                
                <td>${user.role.roleName}</td>
                <td>${user.company.companyName}</td>
                <td>
                    <form action="CompanyRoleManager" method="post" >
                        <input id="table-buttons" type="submit" value="Delete">
                        <input id="table-buttons" type="hidden" name="action" value="delete">
                        <input type="hidden" name="selectedUser" value="${user.username}">
                    </form>
                </td>
                <!--This is to update the fields-->
                <td>
                    <form action="CompanyRoleManager" method="get">
                        <input id="table-buttons" type="submit" value="Edit">
                        <input id="table-buttons" type="hidden" name="action" value="view">
                        <input type="hidden" name="selectedUser" value="${user.username}">
                    </form>
                </td>
            </tr>
            </c:if>
        </c:forEach>
    </table>
</div>
</div> <!-- End of Container two -->
     <br><br>
    <%@ include file="/WEB-INF/includes/footer.jsp" %>
