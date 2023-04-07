<%-- 
    Document   : completeassetactivity
    Created on : 04 6, 23, 10:03:00 PM
    Author     : ccslearner
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*, assetmanagement.*, java.sql.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Complete an Asset Activity</title>
    </head>
    <body>
        <form action="completeactivity_processing.jsp">
            <jsp:useBean id= "A" class="assetmanagement.assetactivity" scope="session" />
            Asset Activity:<select id="assetactivity" name="assetactivity">
                <%
                    A.assetactivity_for_completion();
                    for(int i = 0; i < A.asset_activityidList.size(); i++){
                %>
                <option value="<%=A.asset_activityidList.get(i)%>"><%=A.descriptionList.get(i)%></option>
                <%
                    }
                %>
            </select><br>
            <input type="submit" value="Complete Activity">
        
    </body>
</html>