<%-- Document : deleteactivity_processing Created on : 04 6, 23, 8:02:20 PM
Author : ccslearner --%> <%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*, assetmanagement.*, java.sql.*" %>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>Delete Asset Activity Processing</title>
    <link rel="stylesheet" href="style.css" />
    <link rel="stylesheet" href="reset.css" />
  </head>
  <body>
    <header>
      <div class="logo">Joenh Co. Realty</div>
    </header>
    <div class="asset_form">
      <form action="index.html" class="form_class">
        <jsp:useBean
          id="B"
          class="assetmanagement.assetactivity"
          scope="session"
        />
        <% //Receive the values from register.html B.asset_id =
        Integer.parseInt(request.getParameter("assetactivity")); int status =
        B.delete_assetactivity(); if(status == 1){ %>
        <h1>Deleting Asset Activity Successful</h1>
        <% } else { %>
        <h1>Deleting Asset Activity Failed</h1>
        <% } %>
        <input type="submit" value="Return to Menu" class="btn-submit" />
      </form>
    </div>
  </body>
</html>
