<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<t:main_layout>

  <jsp:attribute name="head_area">
    <title>Buy Item</title>
  </jsp:attribute>

  <jsp:attribute name="content">

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
        <%--<input class="btn btn-default" type="submit" name="correctcomment" value="Update">--%>
    </form>

  </jsp:attribute>

  <jsp:attribute name="bottom_area">

       <a class="btn btn-default" href="<c:url value="/buys"/>">Return to buys list</a>
       <c:if test="${buy.id eq null}">
           <a class="btn btn-default" onclick="saveBuy()">Save</a>
       </c:if>
       <c:if test="${buy.id ne null}">
           <a class="btn btn-default" onclick="updateBuy()">Update</a>
       </c:if>
       <a class="btn btn-default" onclick="delBuy()">Delete</a>
       <a class="btn btn-default" onclick="getBuy()">Get</a>

       <script type="text/javascript">

           function updateBuy() {
               var form = $("#form_buy");
               form.find('input[name="_method"]').val('PUT');
               form.submit();
           }

           function delBuy() {
               var form = $("#form_buy");
               form.find('input[name="_method"]').val('DELETE');
               form.submit();
           }

           function saveBuy() {
               var form = $("#form_buy");
               form.find('input[name="_method"]').val('POST');
               form.submit();
           }

           function getBuy() {
               var form = $("#form_buy");
               form.find('input[name="_method"]').val('GET');
               form.submit();
           }

           $(document).ready(function() {
               $('#update_btn').on('click',function(){
                   var form = $("#form_buy");
                   var url = form.attr("action");
                   $.ajax({
                           url: url,
                           type: 'POST',
                           data: form.serialize(),
                           success: function(result) {
                               window.location = "/buys";
                           }
                   });
               });
           });

           $(document).ajaxStart(function(){
               $('#loading').show();
           }).ajaxStop(function(){
               setTimeout( function(){
                   $('#loading').hide();
               }, 300);
           });
       </script>
  </jsp:attribute>
</t:main_layout>



