<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. --> 
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!-- Formatting (dates) --> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Tacos</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/app.js"></script><!-- change to match your file/naming structure -->
</head>
<body>
  <h1>New Ninja</h1>
  <form:form action="/createninja" method="post" modelAttribute="ninja">
    <form:label path="dojo">Dojo</form:label>
    <form:select path="dojo">
      <c:forEach var="dojo" items="${dojos}">
        <form:option value="${dojo.id}">
          <c:out value="${dojo.name}"></c:out>
        </form:option>
      </c:forEach>
    </form:select>
    <br>
      <form:label path="firstName">First Name: </form:label>
      <form:errors path="firstName"></form:errors>
      <form:input path="firstName"></form:input>
    <br>
      <form:label path="lastName">Last Name: </form:label>
      <form:errors path="lastName"></form:errors>
      <form:input path="lastName"></form:input>
    <br>
      <form:label path="age">Age: </form:label>
      <form:errors path="age"></form:errors>
      <form:input path="age"></form:input>
    <br>
    <input type="submit" value="submit" class="btn btn-primary">  
  </form:form>
</body>
</html>

