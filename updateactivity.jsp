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
        <title>Update Asset Information</title>
    </head>
    <body>
        <form action="updateact_processing.jsp">
            <jsp:useBean id= "A" class="assetmanagement.assetactivity" scope="session" />
            Activity:<select id="activity" name="activity">
                <%
                    A.activity_for_update();
                    for(int i = 0; i < A.asset_activityidList.size(); i++){
                %>
                <option value="<%=A.asset_activityidList.get(i)%>"><%=A.descriptionList.get(i)%></option>
                <%
                    }
                %>
            </select><br>
            Asset ID:<input type="number" id="assetid" name="assetid"><br>
            Description: <input type="text" id="description" name="description"><br>
            HOA Officer ID: <input type="number" id="hoa_officer" name="hoa_officer"><br>
            Tent Start Date: <input type="date" id="tent_start" name="tent_start"><br>
            Tent End Date: <input type="date" id="tent_end" name="tent_end"><br>
            Actual Start Date: <input type="date" id="actual_start" name="actual_start"><br>
            Actual End Date: <input type="date" id="actual_end" name="actual_end"><br>
            Official Receipt Number: <input type="number" id="location_assetid" name="orno"><br>
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
