<%-- Document : delete_activity_prompt Created on : 04 9, 23, 3:43:15 PM Author
: ccslearner --%> <%@page import="java.util.*, assetmanagement.*, java.sql.*" %>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>Delete Activity Prompt</title>
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
      <form action="deleteassetactivity.jsp" class="form_class">
        <h2 class="titleLabel">Delete Activity</h2>
        <div class="fields">
          <span class="title">Activity Date</span>
          <div class="input-field">
            <select
              id="activity_date"
              name="activity_date"
              class="select_class"
            >
              <% B.asset_activity_dropdown(); for(int i = 0; i <
              B.activity_dateList.size(); i++){ %>
              <option value="<%=B.activity_dateList.get(i)%>">
                <%=B.activity_dateList.get(i)%>
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
