<%@ include file="/WEB-INF/includes/header.jsp" %>
<br> 
<div class="row">
    <div class="col-md-9"><h1>User Account</h1></div>
    <div class="col-md-3"><h3>Welcome ${display}</h3></div>
</div>     
<hr>
<div class="row"><!-- row starts here -->
    <div class="col-xm-12 col-md-8">
        <h3>Edit Your Account Information</h3>

        <form action="account" method="post">
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
                <label for="firstname"> First Name: </label>
                <input type="text" class="form-control" id="firstname" name="firstname" value="${selectedUser.firstname}">
            </div>
            <div class="form-group">
                <label for="lastname"> Last Name: </label>
                <input type="text" class="form-control" id="lastname" name="lastname" value="${selectedUser.lastname}">
            </div> 
            <p class="error">${message}</p>  
            <input id="table-buttons_se" type="hidden" name="action" value="edit">
            <input id="table-buttons_se" type="submit" value="Save">
        </form>  

    </div>
</div> <!-- row finishes here -->

<br>
</div> <!-- end of container 1 -->
<div class="container-fluid">
    <table class="table">
        <thead class="thead-dark">
            <tr>
                <th>User Name</th>
                <th>Password</th>
                <th>Email</th>
                <th>Active</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Company</th>
                <th></th>
                <th></th>
            </tr>          
        </thead>
        <tr>
            <td>${user.username}</td>
            <td>${user.password}</td>
            <td>${user.email}</td>
            <td>${user.active}</td>
            <td>${user.firstname}</td>
            <td>${user.lastname}</td>
            <td>${user.company.companyName}</td>
            <td>

                <form action="account" method="post" >
                    <c:if test="${user.role.roleID != 1}">
                        <input id="table-buttons" type="submit" value="Deactivate">
                        <input id="table-buttons" type="hidden" name="action" value="deactivate">
                    </c:if>
                    <input type="hidden" name="selectedUser" value="${user.username}">
                </form>

            </td>
            <!--This is to update the fields-->
            <td>
                <form action="account" method="get">
                    <input id="table-buttons" type="submit" value="Edit">
                    <input id="table-buttons" type="hidden" name="action" value="view">
                    <input type="hidden" name="selectedUser" value="${user.username}">
                </form>
            </td>
        </tr>
    </table>
</div>  
<%@ include file="/WEB-INF/includes/footer.jsp" %>
