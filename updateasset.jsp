<%-- 
    Document   : updateasset
    Created on : 04 6, 23, 1:55:09 AM
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
        <form action="updateasset_processing.jsp">
            <jsp:useBean id= "A" class="assetmanagement.asset" scope="session" />
            Asset:<select id="asset" name="asset">
                <%
                    A.asset_for_update();
                    for(int i = 0; i < A.assetidlist.size(); i++){
                %>
                <option value="<%=A.assetidlist.get(i)%>"><%=A.namelist.get(i)%></option>
                <%
                    }
                %>
            </select><br>
            Asset Name:<input type="text" id="asset_name" name="asset_name"><br>
            Description: <input type="text" id="description" name="description"><br>
            Acquisition Date: <input type="date" id="acq_date" name="acq_date"><br>
            For Rent?: <input type="number" id="forrent" name="forrent" min="0" max="1"><br>
            Value: <input type="text" id="value" name="value"><br>
            <label for="type">Type:</label>
                <select name="type" id="type">
                  <option value="P">Property</option>
                  <option value="E">Equipment</option>
                  <option value="F">Furniture and Fixtures</option>
                  <option value="O">Other Assets</option>
                </select><br>
            <label for="status">Status:</label>
                <select name="status" id="type">
                  <option value="W">Working Condition</option>
                  <option value="DE">Deteriorated</option>
                  <option value="FR">For Repair</option>
                  <option value="FD">For Disposal</option>
                  <option value="DI">Disposed</option>
                </select><br>
                            </select><br>
            Location: <input type="text" id="location" name="location"><br>
            X-Coordinate: <input type="text" id="location_mapx" name="location_mapx"><br>
            Y-Coordinate: <input type="text" id="location_mapy" name="location_mapy"><br>
            Inclusion Asset ID: <input type="number" id="location_assetid" name="location_assetid"><br>
                
            <input type="submit" value="Submit">
        </form>
    </body>
</html>
