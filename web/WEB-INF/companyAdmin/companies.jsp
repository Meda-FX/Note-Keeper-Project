<%@ include file="/WEB-INF/includes/header.jsp" %>
   
        <h1>System Admin - Manage Companies</h1>
        <hr>
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
            <input type="hidden" name="action" value="edit">
            <input type="submit" value="Save">
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
            <input type="hidden" name="action" value="add">
            <input type="submit" value="Save">
        </form> 
    </c:if>
    <br>
    <p class="error">${message}</p>   
    </div> <!-- End of Container one -->
    
    <div class="container-fluid "><!-- Begin of container two -->
    <table class="table table-dark">
        <tr>
            <th>Company ID</th>
            <th>Company Name</th>           
        </tr>          
        <br>
        <c:forEach var="user" items="${companies}">
             <%--<c:if test = "${user.company.companyID == copmID}">--%>
            <tr>
                <td>${user.companyID}</td>
                <td>${user.companyName}</td>
                <td>
                    <form action="managecompanies" method="post" >
                        <input type="submit" value="Delete">
                        <input type="hidden" name="action" value="delete">
                        <input type="hidden" name="selectedID" value="${user.companyID}">
                    </form>
                </td>
                <!--This is to update the fields-->
                <td>
                    <form action="managecompanies" method="get">
                        <input type="submit" value="Edit">
                        <input type="hidden" name="action" value="view">
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
