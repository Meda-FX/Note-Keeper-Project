<%@tag description="Includes the navigation header" pageEncoding="UTF-8"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="c" %>
<%@taglib prefix="d" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>NoteKeepr</title>
        <link rel="stylesheet" href="<d:url value='styles/note.css' />" />
    </head>
    <body>
        <a href="admin">Admin</a> | <a href="notes">Notes</a> | <a href="#">Account</a>