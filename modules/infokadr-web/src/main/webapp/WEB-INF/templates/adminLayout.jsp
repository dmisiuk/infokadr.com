<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>

<head>
    <meta charset="UTF-8">

    <title>Admin</title>
    <meta name="description" content="Трейлеры и кадросюжеты фильмов (кадры из фильмов и сюжеты к ним)."/>
    <meta name="keywords"
          content="инфокадр, трейлеры, трейлеры фильмов, новые трейлеры, трейлеры онлайн, кадросюжеты, кадры из фильмов, сюжеты фильмов"/>

    <link href="/resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="/resources/bootstrap/css/bootstrap-responsive.min.css" rel="stylesheet">
    <link href="/resources/css/responsive-video.css" rel="stylesheet">
    <script src="/resources/js/jquery.min.js" type="text/javascript"></script>
    <script src="/resources/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
    <link href="../../resources/css/infokadr.css" rel="stylesheet">

</head>
<body style="background-color: #fffafa">

<div class="container">

    <tiles:insertAttribute name="header"/>

    <tiles:insertAttribute name="content"/>

</div>
</body>
</html>