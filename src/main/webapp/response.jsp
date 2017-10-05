<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hello Page</title>
</head>
<body>
<h2>${greeting}</h2>

<p>
    <a href="index.html">&lt;&dash; Back to first page!</a>
</p>

<h3>Previous guests</h3>
<p>
<ul>
    <c:forEach items="${guests}" var="guest">
        <li>
            <c:out value="${guest}"/>
        </li>
    </c:forEach>
</ul>
</p>
</body>
</html>
