<%@ include file="/WEB-INF/includes/header.jsp" %>
  <br>
    <div class="row">
        <div class="col-md-9"><h1>System Admin - Manage Users</h1></div>
        <div class="col-md-3"><h3>Welcome ${display}</h3></div>
    </div>
    <hr>
    <div class="row">
    <div class="col-md-6">
    <c:if test="${selectedUser != null}">
        <h3>Edit User</h3>        
        <form action="admin" method="post">
            <div class="form-group">
                <label for="username"> User Name:</label>
                <input type="text" class="form-control" id="username" name="username" value="${selectedUser.username}">
            </div>
            <div class="form-group">
                <label for="password"> Password:</label>
                <input type="password" class="form-control" id="password" name="password" value="${selectedUser.password}">
            </div>
            <div class="form-group">
                <label for="email"> Email:</label>
                <input type="email" class="form-control" id="email" name="email" value="${selectedUser.email}">
            </div>
            <div class="form-group">
                <label for="active"> Active: </label>
                <input type="text" class="form-control" id="active" name="active" value="${selectedUser.active}">
            </div>
            <div class="form-group">
                <label for="firstname"> First Name: </label>
                <input type="text" class="form-control" id="firstname" name="firstname" value="${selectedUser.firstname}">
            </div>
            <div class="form-group">
                <label for="lastname"> Last Name: </label>
                <input type="text" class="form-control" id="lastname" name="lastname" value="${selectedUser.lastname}">
            </div>            
       
            <input type="hidden" name="action" value="edit"> <br>
            <input type="submit" value="Save">
        </form>  
    </c:if>

    <c:if test="${selectedUser == null}">
        <h3>Add User</h3>
        
         <form action="admin" method="post">
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
                <label for="active"> Active: </label>
                <input type="text" class="form-control" id="active" name="active">
            </div>
            <div class="form-group">
                <label for="firstname"> First Name: </label>
                <input type="text" class="form-control" id="firstname" name="firstname">
            </div>
            <div class="form-group">
                <label for="lastname"> Last Name: </label>
                <input type="text" class="form-control" id="lastname" name="lastname">
            </div>      
            <input type="hidden" name="action" value="add">
            <input type="submit" value="Save">
        </form> 
    </c:if>
    </div>
    
        <div class="col-md-1">
            
        </div>
        
    <div class="col-md-5">
        <h3>Manage Role</h3>
        
        <div class="form-group">
            <label for="company-select"> Users List</label>
            <select id="company-select" name="allusers">
                <option value="-1" ${selected}>Please select a user</option>
                <c:forEach var="user" items="${users}">
                  <option value="${user.username}" ${selected}>${user.username}</option>
                </c:forEach>
              </select>
        </div>   
        
        <form action="admin" method="post">
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
            
            <input type="hidden" name="action" value="add">
            <input type="submit" value="Save">
        </form> 
    </div>
        
        
        
        
        
    </div> <!-- End Of Add User Row -->   
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
                    <form action="admin" method="post" >
                        <input id="table-buttons" type="submit" value="Delete">
                        <input id="table-buttons" type="hidden" name="action" value="delete">
                        <input type="hidden" name="selectedUser" value="${user.username}">
                    </form>
                </td>
                <!--This is to update the fields-->
                <td>
                    <form action="admin" method="get">
                        <input id="table-buttons" type="submit" value="Edit">
                        <input id="table-buttons" type="hidden" name="action" value="view">
                        <input type="hidden" name="selectedUser" value="${user.username}">
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</div> <!-- End of Container two -->
     <br><br>
    <%@ include file="/WEB-INF/includes/footer.jsp" %>
