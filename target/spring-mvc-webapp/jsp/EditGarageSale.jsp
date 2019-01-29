<%-- 
    Document   : EditGarageSale
    Created on : Oct 31, 2018, 2:17:16 PM
    Author     : LENOVO USER
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!-- Directive for Spring Form tag libraries -->
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>Edit Garage Sale</title>
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">  
    </head>
    <body>

        <h1>Edit Garage Sale</h1>

        <div class="container">
            <sf:form class="form-horizontal" role="form" modelAttribute="sale"
                     action="editGarage" method="POST">
                <div class="form-group">
                    <label for="address" class="col-md-4 control-label">Address: </label>
                    <div class="col-md-8">
                        <sf:input type="text" class="form-control" id="address"
                                  path="address" placeholder="address"/>
                        <sf:errors path="address" cssclass="error"></sf:errors>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="city" class="col-md-4 control-label">City:</label>
                        <div class="col-md-8">
                        <sf:input type="text" class="form-control" id="add-last-name"
                                  path="city" placeholder="city"/>
                        <sf:errors path="city" cssclass="error"></sf:errors>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="zipCode" class="col-md-4 control-label"> Zipcode: </label>
                        <div class="col-md-8">
                        <sf:input type="text" class="form-control" id="zipCode"
                                  path="zipCode" placeholder="zipCode"/>
                        <sf:errors path="zipCode" cssclass="error"></sf:errors>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="state" class="col-md-4 control-label"> State: </label>
                        <div class="col-md-8">
                        <sf:input type="text" class="form-control" id="state"
                                  path="state" placeholder="state"/>
                        <sf:errors path="state" cssclass="error"></sf:errors>
                        <sf:hidden path="garageSaleId"/>
                    </div>
                </div>
                <div class="row col-md-12" style=" padding-left: 27.8em;"> 
                    <div class="col-md-2">
                        <button type="submit" class="btn btn-default">Update Contact</button>
                    </div>
                    <div class="col-md-offset-2 col-md-2">
                        <a href="${pageContext.request.contextPath}/Home" class="btn btn-default">Cancel</a>
                    </div>
                </div>
            </sf:form>                
        </div>
        <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    </body>
</html>
