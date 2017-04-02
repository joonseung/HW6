<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/stylesheet.css"/>
        <title>JSP Page</title>
        
    </head>
    
    <% String table = (String) request.getAttribute("table"); %>
    
    <body>
        <h1>League of Legends Champions</h1>
        <%= table %>
        
        <br><br>
        
        <a href ="add"> Add A New Champion </a>
        <br><br>
        <a href="search.jsp"> Search Champions</a>
        
    </body>
</html>
