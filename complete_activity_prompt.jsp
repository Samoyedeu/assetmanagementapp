<%-- Document : complete_activity_prompt Created on : 04 9, 23, 3:24:39 PM
Author : ccslearner --%> <%@page import="java.util.*, assetmanagement.*,
java.sql.*" %>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>Complete Activity Prompt</title>
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
        class="assetmanagement.assetactivity"
        scope="session"
      />
      <form action="completeassetactivity.jsp" class="form_class">
        <h2 class="titleLabel">Complete Activity Prompt</h2>

        <div class="fields">
          <span class="title">Asset</span>

          <div class="input-field">
            <select
              id="activity_date"
              name="activity_date"
              class="select_class"
            >
              <% A.asset_activity_dropdown(); for(int i = 0; i <
              A.activity_dateList.size(); i++){ %>
              <option value="<%=A.activity_dateList.get(i)%>">
                <%=A.activity_dateList.get(i)%>
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
