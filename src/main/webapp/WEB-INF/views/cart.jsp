<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head></head>
<body>

<h2>Hello this is cart</h2>

<p> ${name}  ${id}  ${price}   </p>

<table>
	
	<c:forEach items="${cartList}" var="item">
	    
	   <tr> 
	   	<td>ID: ${item.id}</td>
	   	<td>Namn: ${item.name}</td>
	   	<td>Pris: ${item.price}</td> 
	   </tr>
	      
	</c:forEach>

</table>

<p>Totalpris: ${totalPrice}</p>

</body>
</html>