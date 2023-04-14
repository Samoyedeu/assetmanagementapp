<%-- 
    Document   : updateasset_processing
    Created on : 04 6, 23, 2:07:49 AM
    Author     : ccslearner
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*, assetmanagement.*, java.sql.*" %>
<!DOCTYPE html>
<html> 
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Asset Processing</title>
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
                String v_name = request.getParameter("asset_name");
                String v_description = request.getParameter("description");
                java.sql.Date v_acq_date = java.sql.Date.valueOf(request.getParameter("acq_date"));
                Integer v_forrent = Integer.parseInt(request.getParameter("forrent"));
                Float v_value = Float.parseFloat(request.getParameter("value"));
                String v_type = request.getParameter("type");
                String v_status = request.getParameter("status");
                String v_location_mapx = request.getParameter("location_mapx");
                String v_location_mapy = request.getParameter("location_mapy");
                String v_location_assetid = request.getParameter("location_assetid");
                A.asset_name = v_name;
                A.asset_description = v_description;
                A.acquisition_date = v_acq_date;
                A.forrent = v_forrent;
                A.asset_value = v_value;
                A.type_asset = v_type;
                A.status = v_status;
                A.loc_lattitude = v_location_mapx;
                A.loc_longitude = v_location_mapy;
                A.enclosing_asset = v_location_assetid;
                A.asset_id = Integer.parseInt(request.getParameter("asset"));
                int status = A.update_asset();
                if(status == 1){
                %>
                    <h1>Updating Asset Successful</h1>
                <% } else {
                %>
                    <h1>Updating Asset Failed</h1>
                <% }
                %>
                <input type="submit" value="Return to Menu" class="btn-submit">
            </form>
        </div>
        
    </body>
</html>