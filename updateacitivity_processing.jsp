<%-- Document : updateactivity_processing Created on : 04 6, 23, 5:30:16 PM
Author : ccslearner --%> <%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*, assetmanagement.*" %>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>Update Asset Activity Processing</title>
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
        <% //Receive the values from updateactivity.jsp String
        v_activity_description = request.getParameter("activity_description");
        java.sql.Date v_tent_start_date =
        java.sql.Date.valueOf(request.getParameter("tent_start")); java.sql.Date
        v_tent_end_date =
        java.sql.Date.valueOf(request.getParameter("tent_start")); java.sql.Date
        v_act_start_date =
        java.sql.Date.valueOf(request.getParameter("act_start")); java.sql.Date
        v_act_end_date = java.sql.Date.valueOf(request.getParameter("act_end"));
        String v_cost = request.getParameter("cost"); String v_status =
        request.getParameter("status"); B.activity_description =
        v_activity_description; B.tent_start = v_tent_start_date; B.tent_end =
        v_tent_end_date; B.act_start = v_act_start_date; B.act_end =
        v_act_end_date; B.cost = v_cost; B.status = v_status; B.asset_id =
        Integer.parseInt(request.getParameter("activity")); int status =
        B.update_activity(); if(status == 1){ %>
        <h1>Updating Asset Activity Successful</h1>
        <% } else { %>
        <h1>Updating Asset Activity Failed</h1>
        <% } %>
        <input type="submit" value="Return to Menu" class="btn-submit" />
      </form>
    </div>
  </body>
</html>
