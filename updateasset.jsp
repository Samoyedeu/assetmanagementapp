<%-- Document : updateasset Created on : 04 6, 23, 1:55:09 AM Author :
ccslearner --%> <%@page contentType="text/html" pageEncoding="UTF-8"%> <%@page
import="java.util.*, assetmanagement.*, java.sql.*" %>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>Update Asset Information</title>
    <link rel="stylesheet" href="style.css" />
    <link rel="stylesheet" href="reset.css" />
  </head>
  <body class="updateAsset_body">
    <header>
      <div class="logo">Joenh Co. Realty</div>
      <div class="pages">
        <button class="inAction">
          <a href="index.html">Return to Home</a>
        </button>
      </div>
    </header>

    <div class="asset_form">
      <form action="updateasset_processing.jsp" class="form_class">
        <div class="formEdit">
          <jsp:useBean id="A" class="assetmanagement.asset" scope="session" />
          <div class="col1">
            <h2 class="titleLabel">Update Asset</h2>
            <div class="fields">
              <span class="title">Asset</span>
              <div class="input-field">
                <select id="asset" name="asset" class="select_class">
                  <% A.asset_for_update(); for(int i = 0; i <
                  A.asset_idlist.size(); i++){ %>
                  <option value="<%=A.asset_idlist.get(i)%>">
                    <%=A.asset_namelist.get(i)%>
                  </option>
                  <% } %>
                </select>
              </div>
            </div>

            <div class="fields">
              <span class="title">Asset Name</span>
              <div class="input-field">
                <input type="text" id="asset_name" name="asset_name" />
              </div>
            </div>

            <div class="fields">
              <span class="title">Description</span>
              <div class="input-field">
                <input type="text" id="description" name="description" />
              </div>
            </div>

            <div class="fields">
              <span class="title">Acquisition Date</span>
              <div class="input-field">
                <input type="date" id="acq_date" name="acq_date" />
              </div>
            </div>

            <div class="fields">
              <span class="title">For Rent?</span>
              <div class="input-field">
                <div id="choice">
                  <div id="choice1">
                    <input type="radio" id="Yes" name="forrent" value="1" />
                    <label for="Yes">Yes</label>
                  </div>

                  <div id="choice2">
                    <input type="radio" id="No" name="forrent" value="0" />
                    <label for="No">No</label>
                  </div>
                </div>
              </div>
            </div>

            <div class="fields">
              <span class="title">Value</span>
              <div class="input-field">
                <input type="text" id="value" name="value" />
              </div>
            </div>
          </div>

          <div class="col1">
            <div class="fields">
              <span class="title">Type</span>
              <div class="input-field">
                <select name="type" id="type" class="select_class">
                  <option value="P">Property</option>
                  <option value="E">Equipment</option>
                  <option value="F">Furniture and Fixtures</option>
                  <option value="O">Other Assets</option>
                </select>
              </div>
            </div>

            <div class="fields">
              <span class="title">Status:</span>
              <div class="input-field">
                <select name="status" id="type" class="select_class">
                  <option value="W">Working Condition</option>
                  <option value="D">Deteriorated</option>
                  <option value="P">For Repair</option>
                  <option value="S">For Disposal</option>
                </select>
              </div>
            </div>

            <div class="fields">
              <span class="title">Location Latitude</span>
              <div class="input-field">
                <input type="text" id="location_mapx" name="location_mapx" />
              </div>
            </div>

            <div class="fields">
              <span class="title">Location Longitude</span>
              <div class="input-field">
                <input type="text" id="location_mapy" name="location_mapy" />
              </div>
            </div>

            <div class="fields">
              <span class="title">Enclosing Asset</span>
              <div class="input-field">
                <input
                  type="number"
                  id="location_assetid"
                  name="location_assetid"
                />
              </div>
            </div>

            <input type="submit" value="Submit" class="btn-submit" />
          </div>
        </div>
      </form>
    </div>
  </body>
</html>
