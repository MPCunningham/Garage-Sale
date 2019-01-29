<%-- 
    Document   : register
    Created on : Oct 18, 2018, 3:16:56 PM
    Author     : macam
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>Garage Sale User Registration Page</title>
        <!--Bootstrap core CSS-->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet"/>
    </head>
    <body>
        <div class="container" style=" margin-top: 3%; margin-left: 2%">
            <div class="input-group">
                <form class="form-horizontal" role="form" method="POST" id="userForm" action="createUser">
                    <div class="row col-md-12">
                        <label for="name" class="col-md-2 control-label">Your Name:</label>
                        <div class="col-md-4">
                            <input type="text" class="form-control" name="name" placeholder="Namey Namerson"/>
                        </div>
                    </div>
                    <div class="row col-md-12" style=" padding-top: 10px;">
                        <label for="phone" class="col-md-2 control-label">Phone:</label>
                        <div class="col-md-4">
                            <input type="tel" class="form-control" name="phone" placeholder="555-555-5555"/>
                        </div>
                    </div>
                    <div class="row col-md-12" style=" padding-top: 10px;">
                        <label for="email" class="col-md-2 control-label">Email:</label>
                        <div class="col-md-10">
                            <input type="email" class="form-control" name="email" placeholder="example123@email.com"/>
                        </div>
                    </div>
                    <div class="row col-md-12"  style=" padding-top: 30px;" >
                        <label for="username" class="col-md-2 control-label">Username:</label>
                        <div class="col-md-4">
                            <input type="text" class="form-control" name="username" placeholder="Username"/>
                        </div>
                    </div>
                    <div class="row col-md-12" style=" padding-top: 10px;">
                        <label for="password" class="col-md-2 control-label">Password:</label>
                        <div class="col-md-4">
                            <input type="password" class="form-control" name="password" placeholder="Password"/>
                        </div>
                        <label for="confirmPassword" class="col-md-2 control-label">Confirm Password:</label>
                        <div class="col-md-4">
                            <input type="password" class="form-control" name="confirmPassword"/>
                        </div>
                    </div>
                    <div class="row col-md-12" style=" padding-top: 20px;"> 
                        <div class="col-md-offset-2 col-md-2">
                            <a href="${pageContext.request.contextPath}/Home" class="btn btn-default">Cancel</a>
                        </div>
                        <div class="col-md-2">
                            <button type="submit" class="btn btn-default">Register</button>
                        </div>
                    </div>
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                </form>
            </div>
        </div>
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    </body>
</html>
