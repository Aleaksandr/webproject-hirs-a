<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<form id="form_buy" class="form-horizontal" action="<c:url value='/buys/${buy.id}'/>" method="post">
  <input type="hidden" name="_method" value=""/>
  <input type="hidden" name="id" id="id" value="${buy.id}">
  <div class="form-group">
    <label class="col-sm-1 control-label">Name</label>
    <div class="col-sm-10">
      <input type="text" name="name" class="form-control" value="${buy.name}" required placeholder="Name">
    </div>
  </div>
  <div class="form-group">
    <label class="col-sm-1 control-label">Prise</label>
    <div class="col-sm-10">
      <input type="text" name="prise" class="form-control" value="${buy.prise}" required placeholder="Prise">
    </div>
  </div>
</form>