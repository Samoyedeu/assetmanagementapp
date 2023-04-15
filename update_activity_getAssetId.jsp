<%-- 
    Document   : update_activity_getAssetId
    Created on : 04 16, 23, 1:33:57 AM
    Author     : ccslearner
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%> 
<%@page import="java.util.*, assetmanagement.*, java.sql.*" %>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>Update Activity Prompt</title>
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
      <jsp:useBean
        id="B"
        class="assetmanagement.assetactivity"
        scope="session"
      />
      <form action="updateactivity.jsp" class="form_class">
        <h2 class="titleLabel">Update Activity Get ID</h2>

        <div class="fields">
          <span class="title"> Asset</span>
          <div class="input-field">
            <select id="activity" name="activity">
                        <%
                            B.activity_date = java.sql.Date.valueOf(request.getParameter("activity_date"));
                            B.activity_for_update2();
                            for(int i = 0; i < B.activity_dateList.size(); i++){
                        %>
                        <option value="<%=B.asset_idList.get(i)%>"><%=B.asset_idList.get(i)%></option>
                        <%
                            }
                        %>
            </select>
          </div>
        </div>

        <input type="submit" value="Submit" class="btn-submit" />
      </form>
    </div>
  </body>
</html>

