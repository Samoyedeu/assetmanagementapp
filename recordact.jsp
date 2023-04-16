<%-- Document : recordact Created on : 04 10, 23, 2:00:19 AM Author : ccslearner
--%> <%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
  <head>
    <title>Record Asset Activity</title>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="style.css" />
    <link rel="stylesheet" href="reset.css" />
  </head>
  <body class="recordAct_body">
    <header>
      <div class="logo">Joenh Co. Realty</div>
      <div class="pages">
        <button class="inAction">
          <a href="index.html">Return to Home</a>
        </button>
      </div>
    </header>

    <div class="asset_form">
      <form action="record_processing.jsp" class="form_class">
        <jsp:useBean
          id="B"
          class="assetmanagement.assetactivity"
          scope="session"
        />
        <div class="col1">
          <h2 class="titleLabel">Record Activity</h2>
          <div class="fields">
            <span class="title">Asset</span>

            <div class="input-field">
              <select id="assetid" name="assetid" class="select_class">
                <% B.asset_id_dropdown(); for(int i = 0; i <
                B.asset_idList.size(); i++){ %>
                <option value="<%=B.asset_idList.get(i)%>">
                  <%=B.asset_idList.get(i)%>
                </option>
                <% } %>
              </select>
            </div>
          </div>
          <div class="fields">
            <span class="title">Activity Date</span>
            <div class="input-field">
              <input type="date" id="activity_date" name="activity_date" />
            </div>
          </div>

          <div class="fields">
            <span class="title">Activity Description</span>
            <div class="input-field">
              <input
                type="text"
                id="activity_description"
                name="activity_description"
              />
            </div>
          </div>

          <div class="fields">
            <span class="title">Tentative Start Date</span>
            <div class="input-field">
              <input type="date" id="tent_start" name="tent_start" value="2000-01-01"/>
            </div>
          </div>

          <div class="fields">
            <span class="title">Tentative End Date</span>

            <div class="input-field">
              <input type="date" id="tent_end" name="tent_end" value="2000-01-01"/>
            </div>
          </div>
        </div>
        <div class="col1">
          <div class="fields">
            <span class="title">Actual Start Date</span>
            <div class="input-field">
              <input type="date" id="actual_start" name="act_start" value="2000-01-01"/>
            </div>
          </div>

          <div class="fields">
            <span class="title">Actual End Date</span>
            <div class="input-field">
              <input type="date" id="actual_end" name="act_end" value="2000-01-01"/>
            </div>
          </div>

          <div class="fields">
            <span class="title">Cost</span>
            <div class="input-field">
              <input type="text" id="cost" name="cost" />
            </div>
          </div>

          <div class="fields">
            <span class="title">Status</span>
            <div class="input-field">
              <select name="status" class="select_class" id="status">
                <option value="S">Scheduled</option>
                <option value="O">Ongoing</option>
                <option value="C">Completed</option>
              </select>
            </div>
          </div>

          <input
            type="submit"
            value="Submit"
            class="btn-submit"
            id="record_submit"
          />
        </div>
      </form>
    </div>
    <script>
        function checkSubmit() {
            var assetid = document.getElementById('assetid').value;
            var activity_date = document.getElementById('activity_date').value;
            var status = document.getElementById('status').value;

            document.querySelector('.btn-submit').disabled = !assetid || !activity_date || !status;
          }

          document.addEventListener('DOMContentLoaded', function() {
            checkSubmit();
            document.querySelectorAll('.input-field input, .input-field select').forEach(function(input) {
              input.addEventListener('input', checkSubmit);
            });
          });
    </script>
  </body>
</html>
