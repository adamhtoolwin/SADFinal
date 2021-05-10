<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
  <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
  <meta charset="ISO-8859-1">
  <title>Buy Products</title>
</head>
    <div class="container">
    <br>
    <h1>Products</h1>
    <hr>
    <table class="table">
        <thead class="thead-dark">
            <tr>
                <th>ID #</th>
                <th>Name</th>
                <th>Company</th>
                <th>Categories</th>
                <th>Price</th>
                <th>Stock</th>
                <th>Buy</th>
            </tr>
        </thead>
        
        <tbody>
            <c:forEach items="${products}" var="product">
                <tr>
                    <th scope="row"><c:out value="${product.id}"/></th></th>
                    <td><c:out value="${product.name}"/></td>
                    <td><c:out value="${product.company.name}"/></td>
                    <td>
                        <c:forEach items="${product.categories}" var="category">
                            <p><c:out value="${category.name}"/></p>
                        </c:forEach>
                    </td>
                    <td><c:out value="${product.price_}"/></td>
                    <td><c:out value="${product.stock}"/></td>

                    <td>
                        <form action="/product/${product.id}/buy" method="POST">
                            Amount: <select name="amount">
                                <c:forEach begin="0" end="${product.stock}" varStatus="stock">
                                    <option value="${stock.index}"><c:out value="${stock.index}"/></option>
                                </c:forEach>
                              </select>
                            <input type="submit" value="Buy">
                        </form>
                    </td>                    
                </tr>
            </c:forEach>
        </tbody>
    </table>

    <!-- <a href="/addCourse"><h1>Add Course</h1></a>
    <hr>

	<a href="/logout">Logout</a>
    </div> -->
</html>