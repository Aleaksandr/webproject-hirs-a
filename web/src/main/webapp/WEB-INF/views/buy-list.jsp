<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<t:main_layout>

  <jsp:attribute name="head_area">
    <title>Buys List</title>
  </jsp:attribute>

  <jsp:attribute name="content">
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

    <script type="text/javascript">
      $(document).ready(function () {
        $('.fa-trash-o').on('click', function(event) {
          event.preventDefault();
          var targA = $(event.target);
          var link = targA.attr("href");
          if (link) {
            $.ajax({
              url : link,
              type: 'DELETE',
              contentType: 'text/html',
              mimeType: 'text/html',
              data : null,
              success: function (data) {
                targA.closest("tr").remove();
              }
            });
          }
        })
      })

      $(document).ajaxStart(function(){
        $('#loading').show();
      }).ajaxStop(function(){
        setTimeout( function(){
          $('#loading').hide();
        }, 300);
      });

    </script>


  </jsp:attribute>

  <jsp:attribute name="bottom_area">
     <a class="btn btn-default" href="<c:url value="/buys/new"/>">Add new buy</a>
  </jsp:attribute>
</t:main_layout>

