<%-- 
    Document   : deletewrongasset_processing
    Created on : 04 6, 23, 5:08:49 PM
    Author     : ccslearner
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*, assetmanagement.*, java.sql.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Delete Wrong Asset Processing</title>
        <link rel="stylesheet" href="style.css" />
        <link rel="stylesheet" href="reset.css" />
    </head>
    <body>
        <header>
            <div class="logo">Joenh Co. Realty</div>
        </header>
        <div class="asset_form">
            <form action="index.html" class="form_class">
                <jsp:useBean id= "A" class="assetmanagement.asset" scope="session" />
                <% //Receive the values from register.html
                A.asset_id = Integer.parseInt(request.getParameter("asset"));
                int status = A.delete_asset();
                if(status == 1){
                %>
                    <h1>Deleting Asset Successful</h1>
                <% } else {
                %>
                    <h1>Deleting Asset Failed</h1>
                <% }
                %>
                <input type="submit" value="Return to Menu" class="btn-submit">
            </form> 
        </div>
        
    </body>
</html>