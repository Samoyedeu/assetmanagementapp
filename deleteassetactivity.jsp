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
            <jsp:useBean id= "A" class="assetmanagement.assetactivity" scope="session" />
            Asset Activity:<select id="assetactivity" name="assetactivity">
                <%
                    A.activity_date = java.sql.Date.valueOf(request.getParameter("activity_date"));
                    A.assetactivity_for_deletion();
                    for(int i = 0; i < A.activity_dateList.size(); i++){
                %>
                <option value="<%=A.asset_idList.get(i)%>"><%=A.activity_descriptionList.get(i)%></option>
                <%
                    }
                %>
            </select><br>
            <input type="submit" value="Delete Asset Activity">
        
    </body>
</html>