<%-- 
    Document   : deleteassetactivity
    Created on : 04 6, 23, 7:28:59 PM
    Author     : ccslearner
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*, assetmanagement.*, java.sql.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Delete an Asset Activity</title>
    </head>
    <body>
        <form action="deleteactivity_processing.jsp">
            <jsp:useBean id= "B" class="assetmanagement.assetactivity" scope="session" />
            Asset Activity:<select id="assetactivity" name="assetactivity">
                <%
                    B.activity_date = java.sql.Date.valueOf(request.getParameter("activity_date"));
                    B.assetactivity_for_deletion();
                    for(int i = 0; i < B.activity_dateList.size(); i++){
                %>
                <option value="<%=B.asset_idList.get(i)%>"><%=B.activity_descriptionList.get(i)%></option>
                <%
                    }
                %>
            </select><br>
            <input type="submit" value="Delete Asset Activity">
        
    </body>
</html>