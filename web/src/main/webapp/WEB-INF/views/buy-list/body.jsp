<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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