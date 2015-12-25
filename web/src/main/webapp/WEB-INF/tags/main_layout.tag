<!DOCTYPE html>
<%@ tag language="java" pageEncoding="UTF-8"%>
<%@attribute name="head_area" fragment="true" %>
<%@attribute name="content" fragment="true" %>
<%@attribute name="bottom_area" fragment="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
    <meta http-equiv="Content-Type: text/html; charset=UTF-8">
    <link type="text/css" rel="stylesheet" href="<c:url value="/static/font-awesome-4.1.0/css/font-awesome.min.css" />"/>
    <link type="text/css" rel="stylesheet" href="<c:url value="/static/css/bootstrap.min.css" />"/>
    <link type="text/css" rel="stylesheet" href="<c:url value="/static/css/layout.css" />"/>
    <script type="text/javascript" src="<c:url value="/static/js/jquery-2.1.4.min.js" />"></script>

    <jsp:invoke fragment="head_area"/>

    <style>


    </style>
</head>
<body>
    <div class="wrapper">

        <div class="header">
            <h1><a href="<c:url value="/" />">Webportal</a></h1>
        </div>

        <div class="container">

            <div class="content">
	            <div id="action_message" class="action_message">${action_message}</div>
                <jsp:invoke fragment="content"/>
            </div>

            <div class="bottoms">
                <jsp:invoke fragment="bottom_area"/>
            </div>

            <%--<div class="sidebar">--%>
                <%--<jsp:invoke fragment="sidebar"/>--%>
            <%--</div>--%>

        </div>

        <div class="push"></div>
    </div>

    <div id="loading">
        <p><img src="<c:url value="/static/img/FhHRx.gif" />" /></p>
    </div>

    <div class="footer"><p>Hirs Aleksander, webportal, 2015</p></div>

</body>
</html>
