<html>
<body>
<h3>Spring REST Demo </h3>
<hr>
<a href="test/hello">Test API-endpoint with relative path</a>
<br>
<%--The pageContext is an implicit object available in JSPs.--%>
<%--The context for the JSP page. Provides access to various objects including:--%>
<%--servletContext, session, request, response etc.--%>
<a href="${pageContext.request.contextPath}/test/hello">Test API-endpoint with absolute path</a>
<hr>
<a href="${pageContext.request.contextPath}/api/students">API-endpoint for all students</a>
<br>
<a href="${pageContext.request.contextPath}/api/students/0">API-endpoint for specific student</a>

</body>
</html>