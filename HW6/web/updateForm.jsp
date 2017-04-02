<%@page import="model.lolChampions"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% lolChampions champ = (lolChampions) request.getAttribute("champ");%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/stylesheet.css"/>
        <title>Update A Champion</title>
    </head>
    <body>
        <div class="wrap"> <!--div to hold all other divs -->

            <%@ include file="includes/header.jsp" %>

            <%@ include file="includes/menu.jsp" %>

            <div class="main"> <!--main div -->

                <h1>Update A Champion Record</h1>

                <div class="update">
                    <form name="updateForm" action="updateChamp" method="get">

                        <table>
                            <tr>
                                <td> Champ ID:</td>
                                <td><input type ="text" name="champID" value="<%= champ.getChampID()%>" readonly/></td>
                            </tr>

                            <tr>
                                <td> Name:</td>
                                <td><input type ="text" name="champName" value="<%= champ.getChampName()%>"/></td>
                            </tr>

                            <tr>
                                <td> Role:</td>
                                <td><input type ="text" name="champRole" value="<%= champ.getChampRole()%>"/></td>
                            </tr>

                            <tr>
                                <td> Price:</td>
                                <td><input type ="text" name="price" value="<%= champ.getPrice()%>"/></td>
                            </tr>

                            <tr>
                                <td> Skins:</td>
                                <td><input type ="text" name="skins" value="<%= champ.getSkins()%>"/></td>
                            </tr>
                        </table>

                        <br><br>    
                        <input type ="reset" name="reset" value="Clear"/>
                        <input type ="submit" name="submit" value="Update" />
                    </form>
                </div>

            </div> <!-- close main div -->

            <%@ include file="includes/footer.jsp" %>

        </div> <!-- close wrap div -->

    </body>
</html>
