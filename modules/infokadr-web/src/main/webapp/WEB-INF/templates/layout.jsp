<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>

<html>

<head>
    <meta charset="UTF-8">

    <title>
        <tiles:insertAttribute name="title"/>

    </title>
    <meta name="description" content="Трейлеры и кадросюжеты фильмов (кадры из фильмов и сюжеты к ним)."/>
    <meta name="keywords"
          content="инфокадр, трейлеры, трейлеры фильмов, новые трейлеры, трейлеры онлайн, кадросюжеты, кадры из фильмов, сюжеты фильмов"/>

    <link href="/resources/bootstrap/css/bootstrap.css" rel="stylesheet">
    <link href="/resources/bootstrap/css/bootstrap-responsive.css" rel="stylesheet">
    <link href="/resources/css/responsive-video.css" rel="stylesheet">
    <script src="/resources/js/jquery.js" type="text/javascript"></script>
    <%--<script src="/resources/bootstrap/js/bootstrap.js" type="text/javascript"></script>--%>
    <script type="text/javascript" src="/resources/bootstrap/js/bootstrap.js"></script>
    <link href="/resources/css/infokadr.css" rel="stylesheet">

</head>
<body style="background-color: whiteSmoke">

<script>
    $(document).ready(
            function () {
                $('.dropdown-toggle').dropdown();
                $("#search").typeahead({
                    source: function (text, process) {
                        $.ajax({
                            url: "/film/search",
                            type: "POST",
                            data: "text=" + text,
                            dataType: "JSON",
                            async: true,
                            success: function (data) {
                                process(data);
                            }
                        })
                    }
                });
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
                        <input type="text"
                               id="search"
                               class="span3"
                               name="text"
                               style="margin: 0 auto;"
                               data-provide="typeahead"
                               placeholder="поиск фильма по названию"
                               autocomplete="off"
                               data-items="4">
                    </div>
                </div>
            </div>
        </div>
    </div>


    <tiles:insertAttribute name="body"/>


</div>

</body>
</html>