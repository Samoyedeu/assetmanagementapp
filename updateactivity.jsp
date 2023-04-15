<%-- 
    Document   : updateactivity
    Created on : 04 6, 23, 7:01:09 PM
    Author     : ccslearner
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*, assetmanagement.*, java.sql.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Asset Activity Information</title>
        <link rel="stylesheet" href="style.css" />
        <link rel="stylesheet" href="reset.css" />
    </head>
    <body class="updateAct_body">
        <header>
            <div class="logo">Joenh Co. Realty</div>
            <div class="pages">
              <button class="inAction">
                <a href="index.html">Return to Home</a>
              </button>
            </div>
        </header>
        
        <div class="asset_form">
            <form action="updateactivity_processing.jsp" class="form_class">
            <jsp:useBean id= "B" class="assetmanagement.assetactivity" scope="session" />
            <%
                B.asset_id = Integer.parseInt(request.getParameter("activity"));
                B.activity_for_update3();
            
            %>
            <div class="container">
                <div class="col1">
                <h2 class="titleLabel">Update Activity</h2>

                <div class="fields">
                    <span class="title">Activity Description</span>
                    <div class="input-field">
                        <input type="text" id="activity_description" name="activity_description" value="${B.activity_description}">
                    </div>
                </div>

                <div class="fields">
                    <span class="title">Tent Start Date</span>
                    <div class="input-field">
                        <input type="date" id="tent_start" name="tent_start" value="${B.tent_start}">
                    </div>
                </div>

                <div class="fields">
                    <span class="title">Tent End Date</span>
                    <div class="input-field">
                        <input type="date" id="tent_end" name="tent_end" value="${B.tent_end}">
                    </div>
                </div>                                              
                </div>
                
                <div class="col1">
                <div class="fields">
                    <span class="title">Actual Start Date</span>
                    <div class="input-field">
                        <input type="date" id="act_start" name="act_start" value ="${B.act_start}">
                    </div>
                </div>

                <div class="fields">
                    <span class="title">Actual End Date</span>
                    <div class="input-field">
                        <input type="date" id="act_end" name="act_end" value ="${B.act_end}">
                    </div>
                </div>

                <div class="fields">
                    <span class="title">Cost</span>
                    <div class="input-field">
                        <input type="text" id="cost" name="cost" value ="${B.cost}">
                    </div>
                </div>    

                <div class="fields">
                    <span class="title">Status</span>
                    <div class="input-field">
                        <select name="status" id="type" class="select_class">
                            <option value="S" ${B.status eq 'S' ? 'selected' : ''}>Scheduled</option>
                            <option value="O" ${B.status eq 'O' ? 'selected' : ''}>Ongoing</option>
                            <option value="C" ${B.status eq 'C' ? 'selected' : ''}>Completed</option>
                        </select>
                    </div>
                </div>
                <input type="submit" value="Submit" class="btn-submit"/>
                </div>
            </div>
            
            
            
            </form>
        </div>
        
        </form>
    </body>
</html>