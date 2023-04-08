<%-- 
    Document   : deletewrongasset
    Created on : 04 6, 23, 3:39:46 PM
    Author     : ccslearner
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*, assetmanagement.*, java.sql.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Delete a Wrongly Encoded Asset</title>
    </head>
    <body>
        <form action="deletewrongasset_processing.jsp">
            <jsp:useBean id= "A" class="assetmanagement.asset" scope="session" />
            Asset:<select id="asset" name="asset">
                <%
                    A.asset_for_deletion();
                    for(int i = 0; i < A.asset_idlist.size(); i++){
                %>
                <option value="<%=A.asset_idlist.get(i)%>"><%=A.asset_namelist.get(i)%></option>
                <%
                    }
                %>
            </select><br>
            <input type="submit" value="Delete Asset">
        
    </body>
</html>
