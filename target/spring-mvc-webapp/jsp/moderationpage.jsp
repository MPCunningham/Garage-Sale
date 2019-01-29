<%-- 
    Document   : moderationpage
    Created on : Oct 30, 2018, 3:44:13 PM
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
        <title>Garage Sale and User Moderation Page</title>
        <!--Bootstrap core CSS-->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet"/>
    </head>
    <body>
        <div class="container-fluid" style=" margin-top: 3%; margin-left: 2%;">
            <div class="row">
                <a href="${pageContext.request.contextPath}/Home" class="btn btn-default">Back</a>
            </div>
            <div class="row">
                <div class="container col-md-6">
                    <h2>Garage Sales</h2>
                </div>
                <sec:authorize access="hasAuthority('admin')">
                    <div class="container col-md-6">
                        <h2>Users</h2>
                        <table id="userTable" style=" overflow: hidden; overflow-y: scroll;" class="table table-striped">
                            <tr>
                                <th width="50%">Username</th>
                                <th width="25%"></th>
                                <th></th>
                            </tr>
                            <c:forEach var="currentUser" items="${userList}">
                                <tr>
                                    <td><c:out value="${currentUser.userName}"/></td>
                                    <td>
                                        <a href="edituser?userID=${currentUser.userID}" class="btn btn-default">Edit</a>
                                    </td>
                                    <td>
                                        <a href="deleteuser?userID=${currentUser.userID}" class="btn btn-default">Delete</a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </table>
                    </div>
                </sec:authorize>
            </div>
        </div>
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    </body>
</html>
