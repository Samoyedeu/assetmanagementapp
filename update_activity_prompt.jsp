<%-- 
    Document   : asset_activity_prompt
    Created on : 04 9, 23, 2:54:11 PM
    Author     : ccslearner
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*, assetmanagement.*, java.sql.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Activity Prompt</title>
    </head>
    <body>
        <jsp:useBean id= "A" class="assetmanagement.assetactivity" scope="session" />
        <form action="updateactivity.jsp">
            Asset ID:<select id="activity_date" name="activity_date">
                <%
                    A.asset_activity_dropdown();
                    for(int i = 0; i < A.activity_dateList.size(); i++){
                %>
                <option value="<%=A.activity_dateList.get(i)%>"><%=A.activity_dateList.get(i)%></option>
                <%
                    }
                %>
                <input type="submit" value="Submit">
        </form>
    </body>
</html>
