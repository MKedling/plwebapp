<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
	<link href="<c:url value="/resources/css/product.css" />" rel="stylesheet">

</head>
<body>

<h2>Produkter </h2>


<c:forEach items="${products}" var="product">

<table>
<tr onClick="document.location='product/details?q=${product.id}'">

	<td> ${product.name} </td> 
	<td>${product.description} </td>
	<td>${product.price} </td>
	<td><img src="<c:url value="/images/${product.image}"/>"/></td>
	
	<form action="cart" method="post">
		<input name="p_name" value=${product.name} type="hidden">
		<input name="id" value=${product.id} type="hidden">
		<input name="price" value=${product.price} type="hidden">
		<input type="submit">
	</form>
	
</tr>
</table>

</c:forEach>

</body>
</html>