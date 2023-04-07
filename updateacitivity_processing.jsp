<%-- 
    Document   : updateactivity_processing
    Created on : 04 6, 23, 5:30:16 PM
    Author     : ccslearner
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*, assetmanagement.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Asset Activity Processing</title>
    </head>
    <body>
        <form action="index.html">
            <jsp:useBean id= "A" class="assetmanagement.assetactivity" scope="session" />
            <% //Receive the values from updateactivity.jsp
                String v_description = request.getParameter("description");
                
                java.sql.Date v_tent_start_date = java.sql.Date.valueOf(request.getParameter("tent_start"));
                java.sql.Date v_tent_end_date = java.sql.Date.valueOf(request.getParameter("tent_start"));
               
                java.sql.Date v_actual_start_date = java.sql.Date.valueOf(request.getParameter("actual_start"));
                java.sql.Date v_actual_end_date = java.sql.Date.valueOf(request.getParameter("actual_end"));
              
             
                Integer v_orno = Integer.parseInt(request.getParameter("orno"));
                String v_status = request.getParameter("status");

                A.description = v_description;
                A.tent_start = v_tent_start_date;
                A.tent_end = v_tent_end_date;
                A.actual_start = v_actual_start_date;
                A.actual_end = v_actual_end_date;
                A.orno = v_orno;
                A.status = v_status;
                A.asset_activityid = Integer.parseInt(request.getParameter("activity"));


                int status = A.update_activity();
                if(status == 1){
            %>
                <h1>Updating Asset Activity Successful</h1>
            <% } else {
            %>
                <h1>Updating Asset Activity Failed</h1>
            <% }
            %>
            <input type="submit" value="Return to Menu">
        </form>
    </body>
</html>
