<%-- 
    Document   : deleteassetactivity
    Created on : 04 6, 23, 7:28:59 PM
    Author     : ccslearner
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*, assetmanagement.*, java.sql.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Delete an Asset Activity</title>
        <link rel="stylesheet" href="style.css" />
        <link rel="stylesheet" href="reset.css" />
    </head>
    <body>
        <header>
            <div class="logo">Joenh Co. Realty</div>
            <div class="pages">
              <button class="inAction">
                <a href="index.html">Return to Home</a>
              </button>
            </div>
        </header>
        <div class="asset_form">
            <form action="deleteactivity_processing.jsp" class="form_class">
                <jsp:useBean id= "B" class="assetmanagement.assetactivity" scope="session" />
                <h2 class="titleLabel">Delete Activity</h2>
                <div class="fields">
                    <span class="title">Asset Activity</span>
                    <div class="input-field">
                        <select id="assetactivity" name="assetactivity" class="select_class">
                            <%
                                B.activity_date = java.sql.Date.valueOf(request.getParameter("activity_date"));
                                B.assetactivity_for_deletion();
                                for(int i = 0; i < B.activity_dateList.size(); i++){
                            %>
                            <option value="<%=B.asset_idList.get(i)%>"><%=B.activity_descriptionList.get(i)%></option>
                            <%
                                }
                            %>
                        </select>
                    </div>
                </div>
                <input type="submit" value="Delete Asset Activity" class="btn-submit"/>
            </form>
        </div>
        
    </body>
</html>