<%-- 
    Document   : update_asset_prompt
    Created on : 04 15, 23, 4:45:50 PM
    Author     : ccslearner
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%> <%@page
import="java.util.*, assetmanagement.*, java.sql.*" %>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>Update Asset Prompt</title>
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
        id="A"
        class="assetmanagement.asset"
        scope="session"
      />
      <form action="updateasset.jsp" class="form_class">
        <h2 class="titleLabel">Update Asset</h2>

        <div class="fields">
          <span class="title"> Asset</span>
          <div class="input-field">
            <select
              id="asset_name"
              name="asset_name"
              class="select_class"
            >
              <% A.asset_name_dropdown(); for(int i = 0; i <
              A.asset_namelist.size(); i++){ %>
              <option value="<%=A.asset_namelist.get(i)%>">
                <%=A.asset_namelist.get(i)%>
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

