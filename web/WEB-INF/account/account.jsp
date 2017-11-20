<%@ include file="/WEB-INF/includes/header.jsp" %>

        <h1>User Account</h1>
        <d:set var="name" value = "${username}" />
        <d:set var="display" value = "${e:toUpperCase(name)}" />
        <h2>Welcome ${display}</h2>       

    <p class="error">${message}</p>     
    <hr>

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
            <input type="hidden" name="action" value="edit">
            <input type="submit" value="Save">
        </form>  
    
    
    
<!--    <form action="account" method="POST">
        User Name: <br> <input type="text" name="username" value="${selectedUser.username}" readonly><br>
        Password: <br> <input type="password" name="password" value="${selectedUser.password}" ><br>                
        Email: <br> <input type="text" name="email" value="${selectedUser.email}" readonly><br>
        First Name: <br> <input type="text" name="firstname" value="${selectedUser.firstname}"><br>
        Last Name: <br> <input type="text" name="lastname" value="${selectedUser.lastname}"><br>
        <input type="hidden" name="action" value="edit">
        <input type="submit" value="Save">
    </form>-->

    <br>
    </div> <!-- end of container 1 -->
    <div class="container-fluid">
    <table class="table table-dark">
        <tr>
            <th>User Name</th>
            <th>Password</th>
            <th>Email</th>
            <th>Active</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Company</th>
        </tr>          

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
                        <input type="submit" value="Deactivate">
                        <input type="hidden" name="action" value="deactivate">
                    </c:if>
                    <input type="hidden" name="selectedUser" value="${user.username}">
                </form>

            </td>
            <!--This is to update the fields-->
            <td>
                <form action="account" method="get">
                    <input type="submit" value="Edit">
                    <input type="hidden" name="action" value="view">
                    <input type="hidden" name="selectedUser" value="${user.username}">
                </form>
            </td>
        </tr>
    </table>
</div>  
<%@ include file="/WEB-INF/includes/footer.jsp" %>
