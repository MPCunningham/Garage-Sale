<%-- 
    Document   : CreateSale
    Created on : Oct 18, 2018, 10:20:15 AM
    Author     : sabaaslam
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create Garage Sale Page</title>
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">  
        <style>
            input[type=text], select, textarea {
                width: 100%;
                padding: 12px;
                border: 1px solid #ccc;
                border-radius: 4px;
                resize: vertical;
            }

        </style>
    </head>
    <body>
        <div class="container">
            <h1>Create New Garage Sale!</h1>
            <form action="CreateSale" method="POST">
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                Enter Your Address: <input type="text" name="address"><br>

                City:
                <input type="text" name="City"><br>
                State:
                <select name="state">
                    <option value="Minnesota">Minnesota</option>
                    <option value="NorthDakota">North Dakota</option>
                    <option value="SouthDakota">South Dakota</option>
                </select>

                Zip:<input type="text" name="Zip"><br>
            <div class="row col-md-12" style=" padding-top: 20px;"> 
                <div class="col-md-2">
                    <button type="submit" class="btn btn-default">Create Sale</button>
                </div>
                <div class="col-md-offset-2 col-md-2">
                        <a href="${pageContext.request.contextPath}/Home" class="btn btn-default">Cancel</a>
                </div>
            </div>


            </form>
        </div>
    </body>
</html>
