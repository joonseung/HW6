<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/stylesheet.css"/>
        <title>JSP Page</title>

    </head>

    <% String table = (String) request.getAttribute("table");%>

    <body>
        <div class="wrap"> <!--div to hold all other divs -->

            <%@ include file="includes/header.jsp" %>

            <%@ include file="includes/menu.jsp" %>

            <div class="main"> <!--main div -->
                <h1>League of Legends Champions</h1>
                <%= table%>

                <br><br>


            </div> <!-- close main div -->

            <%@ include file="includes/footer.jsp" %>

        </div> <!-- close wrap div -->

    </body>
</html>
