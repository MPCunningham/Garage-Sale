<%-- 
    Document   : ViewItem
    Created on : Oct 25, 2018, 10:21:06 AM
    Author     : 4oaks
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="windows-1252"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>View Featured Item</title>
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet"/>
        
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
            <div class="col-md-6">
            <table class="table-striped">
                <th width="25%">Item Name</th>
                <th width="25%"> Description</th>
                <th width="25%">Category</th>

                <c:forEach var="currentItem" items="${itemList}">
                    <tr>

                        <td>  <a href="createItem?GarageSaleId=${currentItem.garageSaleId}"></a>
                            
                            
                            <a href="displayItemDetails?GarageSaleId=${currentItem.getItemId()}">
                                <c:out value="${currentItem.getItemName()}"/>
                            </a>
                        </td>
                        <td>
                            <c:out value="${currentItem.getItemDescription()}"/>
                        </td>
                        <td>
                            <c:out value="${currentItem.getItemCategory()}"/>
                        </td>
                        <td>   <a href="displayEditItem?itemId=${currentItem.itemId}">
                                Edit
                            </a>
                        </td>
                        <td>
                            <a href="deleteItem?itemId=${currentItem.itemId}">
                                Delete
                            </a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
                </div>
            <div class="col-md-6">
            <h1>Create New Item !</h1>
            <form action="CreateItem" method="POST">
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
<input type="hidden" name="garageSaleId" value="${currentItem.garageSaleId}"/>

                Item Category:
                <select name="Category">
                    <option value="Clothing">Clothing</option>
                    <option value="Toys">Toys</option>
                    <option value="Furniture">Furniture</option>
                </select><br />
                <br />
                Item Name:<input  type="text" name="itemName"><br>
                Item Description:<input type="text" name="itemDescription"><br>
                <!--              <select>
                                <option value="Small">Small</option>
                                <option value="Medium">Medium</option>
                                <option value="Large">Large</option>
                              </select><br>-->
                <input type="submit" value="Create Item">




            </form>

                </div>
        </div>
    </body>
</html>
