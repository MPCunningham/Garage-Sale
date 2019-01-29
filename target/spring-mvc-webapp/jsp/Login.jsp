<%-- 
    Document   : Login
    Created on : Oct 17, 2018, 10:57:46 AM
    Author     : sabaaslam
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login page</title>
        <!-- Bootstrap core CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">  
    </head>
    <body>
        <div class="container" style=" margin-top: 20px;">
            <h2 style="text-align:center;">Login</h2><br /><br />
            <form class="form-horizontal" role="form" method="post" action="login">
                <div class ="form-group">
                    <label for ="username" class="control-label">Username</label>
                    <div class="col-md-12">
                        <input type="text" class="form-control" id="username" name="username" placeholder="Username"/>
                    </div>
                </div>
                <div class="form-group">
                    <label for ="password" class="control-label">Password</label>
                    <div class="col-md-12"><input type="password" class="form-control" id="password" name="password" placeholder="Password"/>
                    </div>
                </div>
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                <div class="form-group">
                        <a href="${pageContext.request.contextPath}/Home" class="btn btn-default">Cancel</a>
                        <input type="submit" class="btn btn-default" id="signIn" style=" float: right;" class="btn btn-default" value="Sign In"/>
                </div>
            </form>
        </div>        
        <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>


    </body>
</html>
