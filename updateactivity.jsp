<%-- 
    Document   : updateactivity
    Created on : 04 6, 23, 7:01:09 PM
    Author     : ccslearner
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*, assetmanagement.*, java.sql.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Asset Activity Information</title>
    </head>
    <body>
        <form action="updateactivity_processing.jsp">
            <jsp:useBean id= "B" class="assetmanagement.assetactivity" scope="session" />
            Activity:<select id="activity" name="activity">
                <%
                    B.activity_date = java.sql.Date.valueOf(request.getParameter("activity_date"));
                    B.activity_for_update2();
                    for(int i = 0; i < B.activity_dateList.size(); i++){
                %>
                <option value="<%=B.asset_idList.get(i)%>"><%=B.activity_descriptionList.get(i)%></option>
                <%
                    }
                %>
            </select><br>
            Activity Description: <input type="text" id="activity_description" name="activity_description"><br>
            Tent Start Date: <input type="date" id="tent_start" name="tent_start"><br>
            Tent End Date: <input type="date" id="tent_end" name="tent_end"><br>
            Actual Start Date: <input type="date" id="act_start" name="act_start"><br>
            Actual End Date: <input type="date" id="act_end" name="act_end"><br>
            Cost: <input type="text" id="cost" name="cost"><br>
            <label for="status">Status:</label>
                <select name="status" id="type">
                  <option value="S">Scheduled</option>
                  <option value="O">Ongoing</option>
                  <option value="C">Completed</option>
                </select><br>
                
            <input type="submit" value="Submit">
        </form>
    </body>
</html>
