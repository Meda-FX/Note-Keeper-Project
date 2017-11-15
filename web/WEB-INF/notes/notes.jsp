<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="c" %>
<%@taglib prefix="d" uri="http://java.sun.com/jsp/jstl/core" %>

<c:headerLogout></c:headerLogout>
<div class="container">
    <br>
        <h1>Notes Manager</h1>
        <h3>Notes</h3>
        <p class="error">${message}</p>   

        <d:if test="${selectedNote != null}">
            <h3>Edit Note</h3>
            <form action="notes" method="POST">
                Note ID: <input type="text" name="noteid" value="${selectedNote.noteID}" readonly><br>
                Title: <input type="text" name="title" value="${selectedNote.title}" ><br>                
                Date Created: <input type="text" name="dateCreated" value="${selectedNote.dateCreated}" readonly><br>
                Contents: <input type="text" name="contents" value="${selectedNote.contents}"><br>
                <input type="hidden" name="action" value="edit">
                <input type="submit" value="Save">
            </form>
        </d:if>
        
        <d:if test="${selectedNote == null}">
            <h3>Add Note</h3>
            <form action="notes" method="POST">
                Note Id: <input type="text" name="noteid" readonly><br>
                Note Title: <input type="text" name="title"><br>
                Date Created: <input type="text" name="dateCreated" readonly><br>
                Contents: <input type="text" name="contents"><br>
                <input type="hidden" name="action" value="add">
                <input type="submit" value="Save">
            </form>
        </d:if>
        
            <br>
        <table class="table table-dark">
            <tr>
                <th>Note Id</th>
                <th>Note Title</th>
                <th>Date Created</th>
                <th>Contents</th>
            </tr>
            
            <d:forEach var="note" items="${notes}">
                <tr>
                    <td>${note.noteID}</td>
                    <td>${note.title}</td>
                    <td>${note.dateCreated}</td>
                    <td>${note.contents}</td>
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
            </d:forEach>
        </table>
</div>
    </body>
</html>
