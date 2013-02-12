<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>

<head>
    <meta charset="UTF-8">

    <title>
        <tiles:insertAttribute name="title"/>

    </title>
    <meta name="description" content="Трейлеры и кадросюжеты фильмов (кадры из фильмов и сюжеты к ним)."/>
    <meta name="keywords"
          content="инфокадр, трейлеры, трейлеры фильмов, новые трейлеры, трейлеры онлайн, кадросюжеты, кадры из фильмов, сюжеты фильмов"/>

    <link href="/resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="/resources/bootstrap/css/bootstrap-responsive.min.css" rel="stylesheet">
    <link href="/resources/css/responsive-video.css" rel="stylesheet">
    <script src="/resources/js/jquery.min.js" type="text/javascript"></script>
    <script src="/resources/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
    <link href="/resources/css/infokadr.css" rel="stylesheet">

</head>
<body style="background-color: whiteSmoke">

<script>
    $(document).ready(
            function () {
                $('.dropdown-toggle').dropdown();
            }
    )
</script>

<div class="container">
    <br>

    <div class="row">
        <div class="span6">
            <ul class="nav nav-pills">
                <li><a href="/" style="font-weight: bold;">infokadr</a></li>
                <sec:authorize access="hasRole('admin')">
                    <li>
                        <a href="/admin">панель администратора</a>
                    </li>
                </sec:authorize>
            </ul>
        </div>
        <div style="text-align: right" class="span6">
            <div class="control-group">
                <div class="controls">
                    <div class="input-prepend">
                    <span class="add-on">
                        <i class="icon-search"></i>
                    </span>
                        <input type="search" class="span3" placeholder="поиск по названию фильма" name="search"
                               id="search">
                    </div>
                </div>
            </div>
        </div>
    </div>


    <tiles:insertAttribute name="body"/>


</div>

</body>
</html>