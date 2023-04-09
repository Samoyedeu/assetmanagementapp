<%-- 
    Document   : record_processing
    Created on : 04 6, 23, 5:30:16 PM
    Author     : ccslearner
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*, assetmanagement.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Record Asset Activity Processing</title>
    </head>
    <body>
        <form>
            <jsp:useBean id= "A" class="assetmanagement.assetactivity" scope="session" />
            <% //Receive the values from register.html
                Integer v_assetid = Integer.parseInt(request.getParameter("assetid"));
                java.sql.Date v_activity_date = java.sql.Date.valueOf(request.getParameter("activity_date"));
                String v_activity_description = request.getParameter("activity_description");
                
                
                java.sql.Date v_tent_start_date = java.sql.Date.valueOf(request.getParameter("tent_start"));
                java.sql.Date v_tent_end_date = java.sql.Date.valueOf(request.getParameter("tent_start"));
               
                java.sql.Date v_act_start_date = java.sql.Date.valueOf(request.getParameter("act_start"));
                java.sql.Date v_act_end_date = java.sql.Date.valueOf(request.getParameter("act_end"));
               
                Double v_cost = Double.parseDouble(request.getParameter("cost"));
                String v_status = request.getParameter("status");

                A.asset_id = v_assetid;
                A.activity_date = v_activity_date;
                A.activity_description = v_activity_description;
                A.tent_start = v_tent_start_date;
                A.tent_end = v_tent_end_date;
                A.act_start = v_act_start_date;
                A.act_end = v_act_end_date;
                A.cost = v_cost;
                A.status = v_status;


                int status = A.record_assetactivity();
                if(status == 1){
            %>
                <h1>Recording Asset Activity Successful</h1>
            <% } else {
            %>
                <h1>Recording Asset Activity Failed</h1>
            <% }
            %>
            <input type="submit" value="Return to Menu">
        </form>
    </body>
</html>
