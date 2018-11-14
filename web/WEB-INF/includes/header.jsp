<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="e" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>NotesKeepr</title>        
        <!-- Bootstrap Styles-->       
        <link rel="stylesheet" href="<c:url value='styles/notesKeeprStyle.css' />" />  
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous">        
              
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js" integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js" integrity="sha384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ" crossorigin="anonymous"></script>
        <script src="https://use.fontawesome.com/3a9d38ce6b.js"></script>        
        <!-- Bootstrap Styles ends here -->
    </head>
    <body>       
        <nav id="note-nav" class="navbar navbar-expand-md navbar-dark fixed-top">
            <a class="navbar-brand" href="#">NOTESKEEPR</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarsExampleDefault">
                <ul class="navbar-nav mr-auto">            
                    <li class="nav-item">
                        <a id="nav-link-text" class="nav-link" href="account">ACCOUNT</a>
                    </li>
                    <li class="nav-item">
                        <a  id="nav-link-text" class="nav-link" href="notes">NOTES</a>
                    </li>
                    <li class="nav-item">
                        <a  id="nav-link-text" class="nav-link" href="admin">SYSTEM ADMIN</a>
                    </li>
                    <li class="nav-item">
                        <a id="nav-link-text" class="nav-link" href="companyadmin">COMPANY ADMIN</a>
                    </li>
                    <li class="nav-item">
                        <a id="nav-link-text" class="nav-link" href="managecompanies">COMPANIES</a>
                    </li>
                    <li class="nav-item">
                        <a id="nav-link-text" class="nav-link" href="login?action=logout">LOGOUT</a>
                    </li> 
                </ul>
            </div>
        </nav>
        <br>
        <c:set var="name" value = "${username}" />
        <c:set var="display" value = "${e:toUpperCase(name)}" />  
        <div class="container">    <!-- Content here -->


