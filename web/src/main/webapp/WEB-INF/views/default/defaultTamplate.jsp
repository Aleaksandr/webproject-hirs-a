<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
    <meta charset="utf-8">
    <link rel="shortcut icon" href='<c:url value="/static/img/faviconka_ru_1442.ico" />' type="image/x-icon">
    <link rel="icon" href='<c:url value="/static/img/faviconka_ru_1442.ico" />' type="image/x-icon">
    <link type="text/css" rel="stylesheet"
          href="<c:url value="/static/font-awesome-4.1.0/css/font-awesome.min.css" />"/>
    <link type="text/css" rel="stylesheet" href="<c:url value="/static/css/bootstrap.min.css" />"/>
    <link type="text/css" rel="stylesheet" href="<c:url value="/static/css/layout.css" />"/>
    <script type="text/javascript" src="<c:url value="/static/js/jquery-2.1.4.js" />"></script>

    <tiles:insertAttribute name="head_area"/>
</head>


<body>
<div class="wrapper">

    <div class="header">
        <tiles:insertAttribute name="header"/>
    </div>

    <div class="container">

        <div class="content">
            <div id="action_message" class="action_message">${action_message}</div>
            <tiles:insertAttribute name="body"/>
        </div>

        <div class="buttons">
            <tiles:insertAttribute name="button_area"/>
        </div>

    </div>

    <div class="push"></div>
</div>

<div id="loading">
    <p><img src="<c:url value="/static/img/FhHRx.gif" />"/></p>
</div>

<tiles:insertAttribute name="footer"/>

</body>
</html>