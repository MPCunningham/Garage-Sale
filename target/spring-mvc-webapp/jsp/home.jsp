<%-- 
    Document   : Home
    Created on : Oct 17, 2018, 10:41:31 AM
    Author     : sabaaslam
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
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
        <div class="container" style=" margin-top: 3%; margin-left: 2%;">
            <div class="row">
                <div class="col-md-12">
                    <div class="col-md-8">
                        <div class="input-group">
                            <input type="hidden" name="searchParam" id="searchParam">
                            <input type="text" class="form-control" name="x" placeholder="Search by Address, City, Zip...">
                            <span class="input-group-btn">
                                <button class="btn btn-default" type="button"><span class="glyphicon glyphicon-search"></span></button>
                            </span>
                        </div>
                    </div>
                    <sec:authorize access="!isAuthenticated()">
                        <a href="${pageContext.request.contextPath}/Login" class="btn btn-default">Login</a>
                        <a href="${pageContext.request.contextPath}/Register" class="btn btn-default">Register</a>
                    </sec:authorize>
                    <sec:authorize access="isAuthenticated()">
                        <form class="form-inline" method="POST" action="${pageContext.request.contextPath}/logout">
                            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

                            <button type="submit" class="btn btn-default" id="submit">Logout</button>
                            <a href="Garagesale" class="btn btn-default">View Garage Sale</a>
                            <a href="${pageContext.request.contextPath}/CreateSale" class="btn btn-default">Create New Garage Sale</a>
                        </form>
                    </sec:authorize>
                    <sec:authorize access="hasAnyAuthority('admin', 'moderator')">
                        <a href="${pageContext.request.contextPath}/moderationpage" class="btn btn-default">Moderate Site</a>
                    </sec:authorize>
                </div>
            </div>
        </div>
        <div class="container col-md-6" id="googleMap" style=" margin-top: 1.5%; margin-left: 7%; width: 500px; height: 480px;">
            <script>
                function myMap() {
                    var mapOptions = {
                        center: new google.maps.LatLng(44.9, -93.2),
                        zoom: 10,
                        mapTypeId: google.maps.MapTypeId.ROADMAP
                    };
                    var map = new google.maps.Map(document.getElementById("googleMap"), mapOptions);
                    google.maps.event.addDomListener(window, "load", myMap);
                }
            </script>
        </div>
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
        <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyA0yXc5c0-x83I0vGOxPtBeseRqh_KBoP0&callback=myMap"></script>
    </body>
</html>
