<%-- 
    Document   : record_transaction
    Created on : 04 15, 23, 1:39:38 AM
    Author     : ccslearner
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <title>Record Transaction</title>
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
      <form action="record_transaction_processing.jsp" class="form_class">
        <jsp:useBean
          id="C"
          class="assetmanagement.transaction"
          scope="session"
        />
        <div class="col1">
          <h2 class="titleLabel">Record Transaction</h2>
          <div class="fields">
            <span class="title">Asset</span>

            <div class="input-field">
              <select id="assetid" name="assetid" class="select_class">
                <% C.asset_id_dropdown(); 
                for(int i = 0; i < C.asset_idList.size(); i++){ %>
                <option value="<%=C.asset_idList.get(i)%>">
                  <%=C.asset_idList.get(i)%>
                </option>
                <% } %>
              </select>
            </div>
          </div>
              
          <div class="fields">
            <span class="title">Transaction_date</span>
            <div class="input-field">
              <input type="date" id="transaction_date" name="transaction_date" />
            </div>
          </div>
              
          <div class="fields">
            <span class="title">Transaction Election Date</span>

            <div class="input-field">
              <select id="trans_electiondate" name="trans_electiondate" class="select_class">
                  <%  C.trans_position = request.getParameter("trans_position");
                      C.electiondate_dropdown(); 
                for(int i = 0; i < C.electionList.size(); i++){ %>
                <option value="<%=C.electionList.get(i)%>">
                  <%=C.electionList.get(i)%>
                </option>
                <% } %>
              </select>
            </div>
          </div>
              
          <span class="title">Is Deleted?</span>
            <div class="fields">
              <div class="input-field">
                    <div id="choice">
                        <div id="choice1">
                            <input type="radio" id="Yes" name="isdeleted" value=1 checked>
                            <label for="Yes">Yes</label>    
                        </div>
                                        
                        <div id="choice2">
                            <input type="radio" id="No" name="isdeleted" value=0>
                            <label for="No">No</label>    
                        </div>
                    </div>
                </div>
            </div>
              
          <div class="fields">
            <span class="title">Approval Homeowner ID</span>
            <div class="input-field">
              <input type="number" id="approval_hoid" name="approval_hoid" value=""/>
            </div>
          </div>  
          </div>
              <div class="col1"> 
          <div class="fields">
            <span class="title">Approval Position</span>
            <div class="input-field">
              <input type="text" id="approval_position" name="approval_position" value=""/>
            </div>
          </div>
              
          <div class="fields">
            <span class="title">Approval Election Date</span>
            <div class="input-field">
              <input type="date" id="approval_electiondate" name="approval_electiondate" value="2000-01-01"/>
            </div>
          </div>
              
          <div class="fields">
            <span class="title">OR Number</span>
            <div class="input-field">
              <input type="number" id="ornum" name="ornum" value=""/>
            </div>
          </div>
              
          <div class="fields">
            <span class="title">Transaction Type</span>
            <div class="input-field">
              <select name="transaction_type" class="select_class" id="transaction_type">
                <option value="R">Rental</option>
                <option value="T">Transfer</option>
                <option value="A">Activity</option>
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
            var inputs = document.querySelectorAll('.input-field input, .input-field select');
            var hasEmpty = false;
            inputs.forEach(function(input) {
               if (!input.value && !['approval_hoid', 'approval_position', 'approval_electiondate', 'ornum'].includes(input.id)) {
                    hasEmpty = true;
              }
            });
            document.querySelector('.btn-submit').disabled = hasEmpty;
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

        