<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="mvc"%>
<%@ taglib prefix="petclinic" tagdir="/WEB-INF/tags" %>

<petclinic:layout pageName="products">
<title>Product</title>
</head>
<body>
	<h2>Product</h2>
	<mvc:form modelAttribute="product">
		<table>
			<tr>
				<td><mvc:label path="name">Name:</mvc:label></td>
				<td><mvc:input path="name"/></td>
			</tr>
			<tr>
				<td><mvc:label path="price">Price:</mvc:label></td>
				<td><mvc:input path="price" /></td>
			</tr>
			<tr>
				<td><mvc:label path="productType">Select product type:</mvc:label></td>
        <mvc:select path="productType">
          <mvc:option value="Accesories"/>
          <mvc:option value="Food"/>
        </mvc:select>
        </td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Save" /></td>
			</tr>
		</table>
	</mvc:form>

</body>
</petclinic:layout>