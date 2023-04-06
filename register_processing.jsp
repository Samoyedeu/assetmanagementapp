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
    </head>
    <body>
        <form action="index.html">
            <jsp:useBean id= "A" class="assetmanagement.asset" scope="session" />
            <% //Receive the values from register.html
            String v_name = request.getParameter("asset_name");
            String v_description = request.getParameter("description");
            java.sql.Date v_acq_date = java.sql.Date.valueOf(request.getParameter("acq_date"));
            Integer v_forrent = Integer.parseInt(request.getParameter("forrent"));
            Float v_value = Float.parseFloat(request.getParameter("value"));
            String v_type = request.getParameter("type");
            String v_status = request.getParameter("status");
            String v_location = request.getParameter("location");
            String v_location_mapx = request.getParameter("location_mapx");
            String v_location_mapy = request.getParameter("location_mapy");
            Integer v_location_assetid = Integer.parseInt(request.getParameter("location_assetid"));
            String v_hoaname = request.getParameter("hoaname");
            A.name = v_name;
            A.description = v_description;
            A.acq_date = v_acq_date;
            A.forrent = v_forrent;
            A.value = v_value;
            A.type = v_type;
            A.status = v_status;
            A.location = v_location;
            A.location_mapx = v_location_mapx;
            A.location_mapy = v_location_mapy;
            A.location_assetid = v_location_assetid;
            A.hoaname = v_hoaname;
            
            int status = A.register_asset();
            if(status == 1){
            %>
                <h1>Registering Asset Successful</h1>
            <% } else {
            %>
                <h1>Registering Asset Failed</h1>
            <% }
            %>
            <input type="submit" value="Return to Menu">
        </form>
    </body>
</html>
