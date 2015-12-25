<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: hirs
  Date: 10.11.2015
  Time: 12:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Page</title>
  </head>
  <body>
  <h1>Page</h1>
  <table class="tskmg-table">
    <thead>
    <th class="control-col"></th>
    <th>ID</th>
    <th>NAME</th>
    <th>PRISE</th>
    <th class="control-col"></th>
    </thead>

    <tbody>
    <c:forEach items="${buys}" var="buy">
      <tr>
        <td><a href="<c:url value="/buys/${buy.id}" />">${buy.id}</a></td>
        <td><a href="<c:url value="/buys/${buy.id}" />">${buy.name}</a></td>
        <td>${buy.prise}</td>
      </tr>
    </c:forEach>
    </tbody>
  </table>

  <div>
    <a href="<c:url value="/"/>">
      <button>Return to add page</button>
    </a>
  </div>


  <h3>${greeting.id}</h3>
  <h3>${greeting.content}</h3>

  </body>
</html>
