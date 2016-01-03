<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<t:main_layout>

  <jsp:attribute name="head_area">
    <link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
    <script src="//code.jquery.com/jquery-1.10.2.js"></script>
    <script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
    <script type="text/javascript" src="<c:url value="/static/js/buy-list.js" />"></script>
    <title>Buys List</title>
  </jsp:attribute>

  <jsp:attribute name="content">

    <label for="autocomplete">Select buy: </label>
    <input id="autocomplete">

    <table class="table table-hover">

      <thead>
      <th class="control-col"></th>
      <th>ID</th>
      <th>NAME</th>
      <th>PRISE</th>
      <th>DEL</th>
      </thead>

      <tbody>
      <c:forEach items="${buys}" var="buy">
        <tr>
          <td></td>
          <td><a href="<c:url value="/buys/${buy.id}" />">${buy.id}</a></td>
          <td><a href="<c:url value="/buys/${buy.id}" />">${buy.name}</a></td>
          <td>${buy.prise}</td>
          <td><a href="<c:url value="/buys/${buy.id}" />" class="fa fa-trash-o fa-fw"></a></td>
        </tr>
      </c:forEach>
      </tbody>
    </table>

  </jsp:attribute>

  <jsp:attribute name="bottom_area">
     <a class="btn btn-default" href="<c:url value="/buys/new"/>">Add new buy</a>
  </jsp:attribute>
</t:main_layout>

