<%-- 
    Document   : disposeasset
    Created on : 04 6, 23, 3:39:46 PM
    Author     : ccslearner
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*, assetmanagement.*, java.sql.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Dispose An Asset</title>
    </head>
    <body>
        <form action="disposeasset_processing.jsp">
            <jsp:useBean id= "A" class="assetmanagement.asset" scope="session" />
            Asset:<select id="asset" name="asset">
                <%
                    A.asset_for_disposal();
                    for(int i = 0; i < A.assetidlist.size(); i++){
                %>
                <option value="<%=A.assetidlist.get(i)%>"><%=A.namelist.get(i)%></option>
                <%
                    }
                %>
            </select><br>
            <input type="submit" value="Dispose Asset">
        
    </body>
</html>