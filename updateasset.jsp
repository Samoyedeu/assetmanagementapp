<%-- Document : updateasset Created on : 04 6, 23, 1:55:09 AM Author :
ccslearner --%> <%@page contentType="text/html" pageEncoding="UTF-8"%> 
<%@page import="java.util.*, assetmanagement.*, java.sql.*" %>
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
          <% 
              A.asset_id = Integer.parseInt(request.getParameter("asset_id"));
              A.asset_for_update();
          %>
          <div class="col1">
            <h2 class="titleLabel">Update Asset</h2>
            <div class="fields">
                <span class="title">Asset ID:</span>
                <div class="input-field">
                    <input type="text" id="asset_id" name="asset_id" value="${A.assetId}" readonly/>
                </div>
            </div>

            <div class="fields">
              <span class="title">Asset Name</span>
              <div class="input-field">
                  <input type="text" id="asset_name" name="asset_name" value="${A.name}"/>
              </div>
            </div>

            <div class="fields">
              <span class="title">Description</span>
              <div class="input-field">
                  <input type="text" id="description" name="description" value="${A.description}" />
              </div>
            </div>

            <div class="fields">
              <span class="title">Acquisition Date</span>
              <div class="input-field">
                  <input type="date" id="acq_date" name="acq_date" value="${A.acquisitionDate}"/>
              </div>
            </div>

            <span class="title">For Rent?</span>
            <div class="fields">
              <div class="input-field">
                <input
                  type="number"
                  id="forrent"
                  name="forrent"
                  min="0"
                  max="1"
                  value="${A.forrent}"
                />
              </div>
            </div>

            <div class="fields">
              <span class="title">Value</span>
              <div class="input-field">
                  <input type="text" id="value" name="value" value="${A.assetValue}" />
              </div>
            </div>
          </div>

          <div class="col1">
            <div class="fields">
              <span class="title">Type</span>
              <div class="input-field">
                  <select name="type" id="type" class="select_class">
                  <option value="P"  ${A.typeAsset eq 'P' ? 'selected' : ''}>Property</option>
                  <option value="E"  ${A.typeAsset eq 'E' ? 'selected' : ''}>Equipment</option>
                  <option value="F"  ${A.typeAsset eq 'F' ? 'selected' : ''}>Furniture and Fixtures</option>
                  <option value="O"  ${A.typeAsset eq 'O' ? 'selected' : ''}>Other Assets</option>
                </select>
              </div>
            </div>

            <div class="fields">
              <span class="title">Status:</span>
              <div class="input-field">
                  <select name="status" id="type" class="select_class">
                  <option value="W"  ${A.status eq 'W' ? 'selected' : ''}>Working Condition</option>
                  <option value="D"  ${A.status eq 'D' ? 'selected' : ''}>Deteriorated</option>
                  <option value="P"  ${A.status eq 'P' ? 'selected' : ''}>For Repair</option>
                  <option value="S"  ${A.status eq 'S' ? 'selected' : ''}>For Disposal</option>
                </select>
              </div>
            </div>

            <div class="fields">
              <span class="title">Location Latitude</span>
              <div class="input-field">
                  <input type="text" id="location_mapx" name="location_mapx" value="${A.lattitude}" />
              </div>
            </div>

            <div class="fields">
              <span class="title">Location Longitude</span>
              <div class="input-field">
                  <input type="text" id="location_mapy" name="location_mapy" value="${A.longitude}" />
              </div>
            </div>

            <div class="fields">
              <span class="title">Enclosing Asset</span>
              <div class="input-field">
                <input
                  type="number"
                  id="location_assetid"
                  name="location_assetid"
                  value="${A.enclosingAsset}"
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

