<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<a class="btn btn-default" href="<c:url value="/buys"/>">Return to buys list</a>
<c:if test="${buy.id eq null}">
  <a class="btn btn-default" onclick="saveBuy()">Save</a>
</c:if>
<c:if test="${buy.id ne null}">
  <a class="btn btn-default" onclick="updateBuy()">Update</a>
</c:if>
<a class="btn btn-default" onclick="delBuy()">Delete</a>
<a class="btn btn-default" onclick="getBuy()">Get</a>