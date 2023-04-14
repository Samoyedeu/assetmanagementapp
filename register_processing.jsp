<%-- 
    Document   : register_processing
    Created on : 04 5, 23, 2:47:16 PM
    Author     : ccslearner
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*, assetmanagement.*, java.sql.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register Asset Processing</title>
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
                    A.enclosing_asset = null;
                    String v_asset_name = request.getParameter("asset_name");
                    String v_asset_description = request.getParameter("description");
                    java.sql.Date v_acquisition_date = java.sql.Date.valueOf(request.getParameter("acq_date"));
                    Integer v_forrent = Integer.parseInt(request.getParameter("forrent"));
                    Float v_asset_value = Float.parseFloat(request.getParameter("value"));
                    String v_type_asset = request.getParameter("type");
                    String v_status = request.getParameter("status");
                    String v_loc_lattitude = request.getParameter("location_mapx");
                    String v_loc_longitude = request.getParameter("location_mapy");
                    String v_enclosing_asset = request.getParameter("location_assetid");
                    String v_hoa_name = request.getParameter("hoaname");
                    A.asset_name = v_asset_name;
                    A.asset_description = v_asset_description;
                    A.acquisition_date = v_acquisition_date;
                    A.forrent = v_forrent;
                    A.asset_value = v_asset_value;
                    A.type_asset = v_type_asset;
                    A.status = v_status;
                    A.loc_lattitude = v_loc_lattitude;
                    A.loc_longitude = v_loc_longitude;
                    A.enclosing_asset = v_enclosing_asset;
                    A.hoa_name = v_hoa_name;

                    int status = A.register_asset();
                    if(status == 1){
                    %>
                        <h1>Registering Asset Successful</h1>
                    <% } else {
                    %>
                        <h1>Registering Asset Failed</h1>
                    <% }
                    %>
                    <input type="submit" value="Return to Menu" class="btn-submit">
            </form>
        </div>
        
    </body>
</html>