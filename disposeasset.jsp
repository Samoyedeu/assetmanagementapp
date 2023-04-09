<%-- Document : disposeasset Created on : 04 6, 23, 3:39:46 PM Author :
ccslearner --%> <%@page contentType="text/html" pageEncoding="UTF-8"%> <%@page
import="java.util.*, assetmanagement.*, java.sql.*" %>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>Dispose An Asset</title>
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
      <form action="disposeasset_processing.jsp" class="form_class">
        <jsp:useBean id="A" class="assetmanagement.asset" scope="session" />

        <h2 class="titleLabel">Dispose Asset</h2>

        <div class="fields">
          <span class="title">Asset</span>
          <div class="input-field">
            <select id="asset" name="asset" class="select_class">
              <% A.asset_for_disposal(); for(int i = 0; i <
              A.asset_idlist.size(); i++){ %>
              <option value="<%=A.asset_idlist.get(i)%>">
                <%=A.asset_namelist.get(i)%>
              </option>
              <% } %>
            </select>
          </div>
        </div>

        <input type="submit" value="Dispose Asset" class="btn-submit" />
      </form>
    </div>
  </body>
</html>
