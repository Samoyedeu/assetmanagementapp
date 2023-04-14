<%-- 
    Document   : transaction_position_prompt
    Created on : 04 15, 23, 3:53:22 AM
    Author     : ccslearner
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%> 
<%@page import="java.util.*, assetmanagement.*, java.sql.*" %>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>Transaction Position Prompt</title>
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
      <form action="record_transaction.jsp" class="form_class">
        <h2 class="titleLabel">Transaction Position Prompt</h2>

           <div class="fields">
            <span class="title">Transaction Position</span>

            <div class="input-field">
              <select id="trans_position" name="trans_position" class="select_class">
                
                <%  C.trans_hoid = Integer.parseInt(request.getParameter("trans_hoid"));
                    C.position_dropdown(); 
                for(int i = 0; i < C.position_idList.size(); i++){ %>
                <option value="<%=C.position_idList.get(i)%>">
                  <%=C.position_idList.get(i)%>
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
