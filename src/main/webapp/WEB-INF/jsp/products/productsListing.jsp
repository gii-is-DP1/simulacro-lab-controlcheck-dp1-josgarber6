<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="petclinic" tagdir="/WEB-INF/tags" %>

<petclinic:layout pageName="products">
    <h2>Products</h2>

    <table id="productsTable" class="table table-striped">
        <thead>
        <tr>
            <th>Name</th>
            <th>Price</th>
            <th>Product Type</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${products}" var="p">
            <tr>
                <td>
                    <c:out value="${p.name}"/>
                </td>
                <td>
                    <c:out value="${p.price}"/>
                </td>
                <td>
                    <c:out value="${p.product_type}"/>
                </td>
                <td>
                    <c:out value="${ach.threshold}"/>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <a class="btn btn-default" href="/statistics/achievements/new">Create new achievement</a>

</petclinic:layout>
