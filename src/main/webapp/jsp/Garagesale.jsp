<%-- 
    Document   : Garagesale
    Created on : Oct 24, 2018, 1:58:17 PM
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
        <title>View a Garagesale</title>
        <!--Bootstrap core CSS-->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet"/>
    </head>
    <body>
        <div class="container">        
            <table id="listOfGarageSales" class="table table-hover">
                <tr>

                    <th width="30%">Address</th>
                    <th width="15%">City</th>
                    <th width="15%">State</th>
                    <th width="40%">Zip</th>
                </tr>
                <c:forEach var="currentGarageSale" items="${listOfGarageSales}">

                    <tr>
                        <td>
                            <a href="ViewGarageSale?GarageSaleId=${currentGarageSale.garageSaleId}">
                                <c:out value="${currentGarageSale.address}"/>
                            </a>
                        </td>
                        <td>
                            <c:out value="${currentGarageSale.city}"/>
                        </td>
                        <td>
                            <c:out value="${currentGarageSale.state}"/>
                        </td>
                        <td>
                            <c:out value="${currentGarageSale.zipCode}"/>
                        </td>
                        <td>
                            <a href="deleteGarageSale?garageSaleId=${currentGarageSale.garageSaleId}">
                                Delete
                            </a>
                        </td>
                        <td>
                            <a href="displayEditGarageSale?garageSaleId=${currentGarageSale.garageSaleId}">
                                Edit
                            </a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
            <div class="row col-md-12" style="padding-bottom: 2em;"> 
                <div class="col-md-offset-2 col-md-2">
                    <a href="${pageContext.request.contextPath}/Home" class="btn btn-default">Back to Home</a>
                </div>
            </div>    
        </div>

        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
        <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyA0yXc5c0-x83I0vGOxPtBeseRqh_KBoP0&callback=myMap"></script>
    </body>
</html>
