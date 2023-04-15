<%-- 
    Document   : record_transaction_processing
    Created on : 04 15, 23, 1:56:38 AM
    Author     : ccslearner
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*, assetmanagement.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Record Transaction Processing</title>
        <link rel="stylesheet" href="style.css" />
        <link rel="stylesheet" href="reset.css" />
    </head>
    <body>
        <header>
            <div class="logo">Joenh Co. Realty</div>
        </header>
        <div class="asset_form">
            <form action = "recordact.jsp" class="form_class">
                <jsp:useBean id= "C" class="assetmanagement.transaction" scope="session" />
                <% 
                    Integer v_assetid = Integer.parseInt(request.getParameter("assetid"));
                    java.sql.Date v_transaction_date = java.sql.Date.valueOf(request.getParameter("transaction_date"));
                    
                    java.sql.Date v_trans_electiondate = java.sql.Date.valueOf(request.getParameter("trans_electiondate"));
                    Integer v_isdeleted = Integer.parseInt(request.getParameter("isdeleted"));
                    String v_approval_hoid = request.getParameter("approval_hoid");
                    String v_approval_position = request.getParameter("approval_position");
                    java.sql.Date v_approval_electiondate = java.sql.Date.valueOf(request.getParameter("approval_electiondate"));
                    String v_ornum = request.getParameter("ornum");
                    String v_transaction_type = request.getParameter("transaction_type");
                   
                    C.asset_id = v_assetid;
                    C.transaction_date = v_transaction_date;
                    C.trans_electiondate = v_trans_electiondate;
                    C.isdeleted = v_isdeleted;
                    C.approval_hoid = v_approval_hoid;
                    C.approval_position = v_approval_position;
                    C.approval_electiondate = v_approval_electiondate;
                    C.ornum = v_ornum;
                    C.transaction_type = v_transaction_type;
                    
                          
                    int status = C.register();
                    if(status == 1){
                %>
                    <h1>Recording Transaction Successful</h1>
                <% } else {
                %>
                    <h1>Recording Transaction Failed</h1>
                <% }
                %>
                <input type="submit" value="Proceed to Record Asset Activity" class="btn-submit">
            </form>
        </div>
        
    </body>
</html>