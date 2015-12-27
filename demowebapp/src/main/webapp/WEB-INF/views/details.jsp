<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head></head>
<body>

<h2>Detaljer </h2>


<p> ${query}</p>


<%
	String str = "asdadad";

%>

<%=
 str

%>


<table>
<tr>
	<td>${products.description} </td>
	<td>${products.id} </td>
	<td><img src="<c:url value="/images/${products.image}"/>"/></td>
	
</tr>
</table>


</body>
</html>