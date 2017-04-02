<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/stylesheet.css"/>
        <title> Add A New Champion</title>

    </head>
    <body>
        <div class="wrap"> <!--div to hold all other divs -->

            <%@ include file="includes/header.jsp" %>

            <%@ include file="includes/menu.jsp" %>

            <div class="main"> <!--main div -->

                <h1>Add A New Champion</h1>

                <div class="add">
                    <form name="addFrom" action="addChampion" method="get">

                        <label> Name: </label><br>
                        <input type ="text" name="champName" value=""/>
                        <br>
                        <label> Role: </label><br>
                        <input type ="text" name="champRole" value=""/>
                        <br>
                        <label> Price: </label><br>
                        <input type ="text" name="price" value=""/>
                        <br>
                        <label> Skins: </label><br>
                        <input type ="text" name="skins" value=""/>
                        <br><br>
                        <input type ="submit" name="submit" value="Submit"/>
                    </form>
                </div>

            </div> <!-- close main div -->

            <%@ include file="includes/footer.jsp" %>

        </div> <!-- close wrap div -->

    </body>
</html>
