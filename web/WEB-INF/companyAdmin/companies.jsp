<%@ include file="/WEB-INF/includes/header.jsp" %>
<br>  
<div class="row">
    <div class="col-md-9"><h1>System Admin - Manage Companies</h1></div>
    <div class="col-md-3"><h3>Welcome ${display}</h3></div>
</div>
<hr>
<div class="row"><!-- row starts here -->
    <div class="col-xm-12 col-md-8">
        <c:if test="${selectedCompany != null}">
            <h3>Edit Company</h3>        
            <form action="managecompanies" method="post">
                <div class="form-group">
                    <label for="companyID"> Company ID</label>
                    <input type="text" class="form-control" id="companyID" name="companyID" value="${selectedCompany.companyID}" readonly>
                </div>
                <div class="form-group">
                    <label for="companyName"> Company Name:</label>
                    <input type="text" class="form-control" id="companyName" name="companyName" value="${selectedCompany.companyName}">
                </div>           
                <input id="table-buttons_se" type="hidden" name="action" value="edit">
                <input id="table-buttons_se" type="submit" value="Save">
            </form>  
        </c:if>

        <c:if test="${selectedCompany == null}">
            <h3>Add Company</h3>        
            <form action="managecompanies" method="post">
                <div class="form-group">
                    <label for="companyID"> Company ID</label>
                    <input type="text" class="form-control" id="companyID" name="companyID" readonly>
                </div>
                <div class="form-group">
                    <label for="companyName"> Company Name:</label>
                    <input type="text" class="form-control" id="companyName" name="companyName">
                </div>      
                <p class="error">${message}</p>   
                <input id="table-buttons_se" type="hidden" name="action" value="add">
                <input id="table-buttons_se" type="submit" value="Save">
            </form> 
        </c:if>
    </div>
</div> <!-- row finishes here -->
<br>    
</div> <!-- End of Container one -->

<div class="container-fluid "><!-- Begin of container two -->
    <table class="table">
        <thead class="thead-dark">
            <tr>
                <th>Company ID</th>
                <th>Company Name</th>   
                <th>Remove Company</th>
                <th>Edit Info</th>
            </tr>   
        </thead>
        <br>
        <c:forEach var="user" items="${companies}">
            <%--<c:if test = "${user.company.companyID == copmID}">--%>
            <tr>
                <td>${user.companyID}</td>
                <td>${user.companyName}</td>
                <td>
                    <form action="managecompanies" method="post" >
                        <input id="table-buttons_se2" type="submit" value="Delete">
                        <input id="table-buttons_se2" type="hidden" name="action" value="delete">
                        <input type="hidden" name="selectedID" value="${user.companyID}">
                    </form>
                </td>
                <!--This is to update the fields-->
                <td>
                    <form action="managecompanies" method="get">
                        <input id="table-buttons_se2" type="submit" value="Edit">
                        <input id="table-buttons_se2" type="hidden" name="action" value="view">
                        <input type="hidden" name="selectedID" value="${user.companyID}">
                    </form>
                </td>
            </tr>
            <%--</c:if>--%>
        </c:forEach>
    </table>
</div>
</div> <!-- End of Container two -->
<br><br>
<%@ include file="/WEB-INF/includes/footer.jsp" %>
