<%-- 
    Document   : delete_activity_prompt
    Created on : 04 9, 23, 3:43:15 PM
    Author     : ccslearner
--%>

<%@page import="java.util.*, assetmanagement.*, java.sql.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Delete Activity Prompt</title>
    </head>
    <body>
        <jsp:useBean id= "B" class="assetmanagement.assetactivity" scope="session" />
        <form action="deleteassetactivity.jsp">
            Asset ID:<select id="activity_date" name="activity_date">
                <%
                    B.asset_activity_dropdown();
                    for(int i = 0; i < B.activity_dateList.size(); i++){
                %>
                <option value="<%=B.activity_dateList.get(i)%>"><%=B.activity_dateList.get(i)%></option>
                <%
                    }
                %>
                <input type="submit" value="Submit">
        </form>
    </body>
</html>
