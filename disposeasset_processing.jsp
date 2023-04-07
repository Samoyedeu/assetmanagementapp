<%-- 
    Document   : disposeasset_processing
    Created on : 04 6, 23, 7:00:12 PM
    Author     : ccslearner
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*, assetmanagement.*, java.sql.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Delete Wrong Asset Processing</title>
    </head>
    <body>
        <form action="index.html">
            <jsp:useBean id= "A" class="assetmanagement.asset" scope="session" />
            <% 
            A.assetid = Integer.parseInt(request.getParameter("asset"));
            int status = A.dispose_asset();
            if(status == 1){
            %>
                <h1>Disposing Asset Successful</h1>
            <% } else {
            %>
                <h1>Disposing Asset Failed</h1>
            <% }
            %>
            <input type="submit" value="Return to Menu">
        </form>
    </body>
</html>
