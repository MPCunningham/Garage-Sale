<%-- 
    Document   : edituser
    Created on : Oct 31, 2018, 3:28:04 PM
    Author     : macam
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Garage Sale Home Page</title>
        <!--Bootstrap core CSS-->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet"/>
    </head>
    <body>
               <div class="container" style=" margin-top: 3%; margin-left: 2%">
            <div class="input-group">
                <form class="form-horizontal" role="form" modelAttribute="user" method="POST" id="userForm" action="edituser">
                    <div class="row col-md-12"  style=" padding-top: 30px;" >
                        <label for="username" class="col-md-2 control-label">Username:</label>
                        <div class="col-md-4">
                            <sf:input type="text" class="form-control" path="userName" name="username"/>
                        </div>
                    </div>
                    <div class="row col-md-12" style=" padding-top: 10px;">
                        <label for="password" class="col-md-2 control-label">Password:</label>
                        <div class="col-md-4">
                            <sf:input type="password" class="form-control" path="password" name="password" placeholder="Password"/>
                        </div>
                    </div>
                    <div class="row col-md-12" style=" padding-top: 20px;"> 
                        <div class="col-md-offset-2 col-md-2">
                            <a href="${pageContext.request.contextPath}/moderationpage" class="btn btn-default">Cancel</a>
                        </div>
                        <div class="col-md-2">
                            <button type="submit" class="btn btn-default">Promote</button>
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
