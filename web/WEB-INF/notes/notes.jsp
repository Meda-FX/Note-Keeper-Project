<%@ include file="/WEB-INF/includes/header.jsp" %>
<br>
<div class="row">
    <div class="col-md-9"><h1>Notes Manager</h1></div>
    <div class="col-md-3"><h3>Welcome ${display}</h3></div>
</div>
<c:set var="name" value = "${username}" />
<c:set var="display" value = "${e:toUpperCase(name)}" />
<hr>
<h3>Notes</h3>

<div class="row"><!-- row starts here -->
    <div class="col-xm-12 col-md-8">
        <c:if test="${selectedNote != null}">
            <h3>Edit Note</h3>      
            <form action="notes" method="post">
                <div class="form-group">
                    <label for="noteid"> Note ID:</label>
                    <input type="text" class="form-control" id="noteid" name="noteid" value="${selectedNote.noteID}" readonly >
                </div>
                <div class="form-group">
                    <label for="title"> Title</label>
                    <input type="text" class="form-control" id="title" name="title" value="${selectedNote.title}" >
                </div>
                <div class="form-group">
                    <label for="content">Contents:</label>
                    <input type="text" class="form-control" id="content" name="contents" value="${selectedNote.contents}" >
                </div>
                <div class="form-group">
                    <label for="dateCreated">Date Created:</label>
                    <input type="text" class="form-control" id="dateCreated" name="dateCreated" value="${selectedNote.dateCreated}" readonly>
                </div>
                <div class="form-group">
                    <label for="active"> Make Note Public:   </label>
                    <input type="radio" name="active" value="true" CHECKED> Public
                    <input type="radio" name="active" value="false"> Private
                </div>
                <input id="table-buttons_se" type="hidden" name="action" value="edit">
                <input id="table-buttons_se" type="submit" value="Save">
            </form> 
        </c:if>

        <c:if test="${selectedNote == null}">
            <h3>Add Note</h3>        
            <form action="notes" method="post">
                <div class="form-group">
                    <label for="noteid">Note ID:</label>
                    <input type="text" class="form-control" id="noteid" name="noteid" readonly>
                </div>
                <div class="form-group">
                    <label for="title"> Title:</label>
                    <input type="text" class="form-control" id="title" name="title" >
                </div>
                <div class="form-group">
                    <label for="content">Contents:</label>
                    <input type="text" class="form-control" id="content" name="contents">
                </div>
                <div class="form-group">
                    <label for="dateCreated">Date Created:</label>
                    <input type="text" class="form-control" id="dateCreated" name="dateCreated" readonly>
                </div>
                <div class="form-group">
                    <label for="active"> Make Note Public: </label>
                    <input type="radio" name="public" value="false" CHECKED> Private
                    <input type="radio" name="public" value="true"> Public
                </div>
                <input id="table-buttons_se" type="hidden" name="action" value="add">
                <input id="table-buttons_se" type="submit" value="Save">
            </form>       
        </c:if>
    </div>
</div> <!-- row finishes here -->
</div> <!-- end of container 1 -->
<div class="container-fluid ">
    <br>
    <p class="error">${message}</p>   
    <table class="table">
        <h5>Private Notes:</h5>
        <thead class="thead-dark">
            <tr>
                <th>Note ID</th>
                <th>Note Title</th>
                <th>Contents</th>
                <th>Date Created</th>
                <th></th>
                <th></th>
            </tr>
        </thead>
        <c:forEach var="note" items="${notes}">            
            <c:if test = "${note.owner.username == user.username}">
                <tr>
                    <td>${note.noteID}</td>
                    <td>${note.title}</td>                
                    <td>${note.contents}</td>
                    <td>${note.dateCreated}</td>
                    <td>${user.company}</td>
                    <td>${compID}</td>
                    <td>
                        <form action="notes" method="post" >
                            <input id="table-buttons" type="submit" value="Delete">
                            <input id="table-buttons" type="hidden" name="action" value="delete">
                            <input type="hidden" name="selectedId" value="${note.noteID}">
                        </form>
                    </td>
                    <!--This is to update the fields-->
                    <td>
                        <form action="notes" method="get">
                            <input id="table-buttons" type="submit" value="Edit">
                            <input id="table-buttons" type="hidden" name="action" value="view">
                            <input type="hidden" name="selectedId" value="${note.noteID}">
                        </form>
                    </td>
                </tr>
            </c:if>
        </c:forEach>
    </table>
    <hr>
     <table class="table">
         <h5>Public Notes:</h5>
        <thead class="thead-dark">
            <tr>
                <th>Note ID</th>
                <th>Note Title</th>
                <th>Contents</th>
                <th>Date Created</th>
                <th>Owner</th>
                <th>Company Name</th>
                <th></th>
            </tr>
        </thead>
        <c:forEach var="note" items="${notes}">            
            <c:if test = "${user.company.companyID == note.owner.company.companyID && note.publicNote == true}">   
                <tr>
                    <td>${note.noteID}</td>  
                    <td>${note.title}</td>                
                    <td>${note.contents}</td>
                    <td>${note.dateCreated}</td>
                    <td>${note.owner.username}</td>
                    <td>${note.owner.company.companyID}</td>
                </tr>
            </c:if>                
        </c:forEach>
    </table>    
</div>
<br><br>
<%@ include file="/WEB-INF/includes/footer.jsp" %>