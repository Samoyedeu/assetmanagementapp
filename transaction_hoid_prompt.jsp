<%-- 
    Document   : transaction_hoid_prompt
    Created on : 04 15, 23, 3:50:14 AM
    Author     : ccslearner
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%> 
<%@page import="java.util.*, assetmanagement.*, java.sql.*" %>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>Transaction Homeowner ID Prompt</title>
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
        id="C"
        class="assetmanagement.transaction"
        scope="session"
      />
      <form action="transaction_position_prompt.jsp" class="form_class">
        <h2 class="titleLabel">Transaction Homeowner ID Prompt</h2>

        <div class="fields">
            <span class="title">Transaction Homeowner ID</span>

            <div class="input-field">
              <select id="trans_hoid" name="trans_hoid" class="select_class">
                <% C.homeowner_id_dropdown(); 
                for(int i = 0; i < C.homeowner_idList.size(); i++){ %>
                <option value="<%=C.homeowner_idList.get(i)%>">
                  <%=C.homeowner_idList.get(i)%>
                </option>
                <% } %>
              </select>
            </div>
          </div>

        <input type="submit" value="Submit" class="btn-submit" />
      </form>
    </div>
  </body>
</html>