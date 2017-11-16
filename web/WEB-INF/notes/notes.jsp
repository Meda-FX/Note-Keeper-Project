<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="c" %>
<%@taglib prefix="d" uri="http://java.sun.com/jsp/jstl/core" %>

<c:headerLogout></c:headerLogout>

    <div class="container">
        <br>
        <h1>Notes Manager</h1>
        <hr>
        <h3>Notes</h3>

    <d:if test="${selectedNote != null}">
        <h3>Edit Note</h3>
        <form action="notes" method="POST">
            Note ID: <br> <input type="text" name="noteid" value="${selectedNote.noteID}" readonly><br>
            Title: <br> <input type="text" name="title" value="${selectedNote.title}" ><br>                
            Date Created: <br> <input type="text" name="dateCreated" value="${selectedNote.dateCreated}" readonly><br>
            Contents: <br> <input type="text" name="contents" value="${selectedNote.contents}"><br>
            <input type="hidden" name="action" value="edit"> <br>
            <input type="submit" value="Save">
        </form>
    </d:if>

    <d:if test="${selectedNote == null}">
        <h3>Add Note</h3>
        <form action="notes" method="POST">
            Note Id: <br> <input type="text" name="noteid" readonly><br>
            Note Title: <br> <input type="text" name="title"><br>
            Date Created: <br> <input type="text" name="dateCreated" readonly><br>
            Contents: <br> <input type="text" name="contents"><br>
            <input type="hidden" name="action" value="add">
            <input type="submit" value="Save">
        </form>
    </d:if>

    <br>
    <p class="error">${message}</p>   
    <table class="table table-dark">
        <tr>
            <th>Note Id</th>
            <th>Note Title</th>
            <th>Date Created</th>
            <th>Contents</th>
            <th>Owner</th>
        </tr>
       
        <d:forEach var="note" items="${notes}">
            <d:if test = "${note.owner.username == user.username}">
            <tr>
                <td>${note.noteID}</td>
                <td>${note.title}</td>
                <td>${note.dateCreated}</td>
                <td>${note.contents}</td>
                <td>${note.owner.username}</td>
                <td>
                    <form action="notes" method="post" >
                        <input type="submit" value="Delete">
                        <input type="hidden" name="action" value="delete">
                        <input type="hidden" name="selectedId" value="${note.noteID}">
                    </form>
                </td>
                <!--This is to update the fields-->
                <td>
                    <form action="notes" method="get">
                        <input type="submit" value="Edit">
                        <input type="hidden" name="action" value="view">
                        <input type="hidden" name="selectedId" value="${note.noteID}">
                    </form>
                </td>
            </tr>
            </d:if>
        </d:forEach>
    </table>
</div>
</body>
</html>
