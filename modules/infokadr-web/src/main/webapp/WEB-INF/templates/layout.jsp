<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page isELIgnored="false" %>

<c:set var="root" value="/" scope="request"/>
<c:set var="img" value="${root}static/images" scope="request"/>
<c:set var="css" value="${root}static/css" scope="request"/>
<c:set var="js" value="${root}static/js" scope="request"/>
<c:set var="bs" value="${root}static/bootstrap" scope="request"/>


<html>

<head>
    <meta charset="UTF-8">

    <title>
        <tiles:insertAttribute name="title"/>

    </title>
    <meta name="description" content="Трейлеры и кадросюжеты фильмов (кадры из фильмов и сюжеты к ним)."/>
    <meta name="keywords"
          content="инфокадр, трейлеры, трейлеры фильмов, новые трейлеры, трейлеры онлайн, кадросюжеты, кадры из фильмов, сюжеты фильмов"/>

    <link href="${bs}/css/bootstrap.css" rel="stylesheet">
    <link href="${bs}/css/bootstrap-responsive.css" rel="stylesheet">
    <link href="${css}/responsive-video.css" rel="stylesheet">
    <script src="${js}/jquery.js" type="text/javascript"></script>
    <script src="http://code.jquery.com/ui/1.10.2/jquery-ui.js"></script>
    <%--<script src="/resources/bootstrap/js/bootstrap.js" type="text/javascript"></script>--%>
    <script src="${bs}/js/bootstrap.js"></script>
    <link href="${css}/infokadr.css" rel="stylesheet">

</head>
<body style="background-color: whiteSmoke">

<script>
    $(document).ready(
            function () {
                $('.dropdown-toggle').dropdown();
            }
    );

    $(function () {

        $("#films").autocomplete({
            source: function (request, response) {
                $.ajax({
                    url: "${root}film/searchForLastTrailer",
                    dataType: 'json',
                    data: {
                        term: request.term
                    },
                    success: function (data) {
                        response(data);

                    }
                });
                $(".ui-helper-hidden-accessible").hide();
            },
            minLength: 1,
            select: function (event, ui) {
                window.location.href = "${root}video/" + ui.item.id;
            }
        });
    });

</script>


<div class="container">
    <br>

    <div class="row">
        <div class="span6">
            <ul class="nav nav-pills">
                <li><a href="${root}" style="font-weight: bold;">infokadr</a></li>
                <sec:authorize access="hasRole('admin')">
                    <li>
                        <a href="${root}admin">панель администратора</a>
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
                        <input type="search" class="span3" placeholder="поиск по названию фильма"
                               id="films">
                    </div>
                </div>
            </div>
        </div>
    </div>


    <tiles:insertAttribute name="body"/>


</div>

</body>
</html>