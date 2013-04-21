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
    <script src="http://code.jquery.com/ui/1.10.2/jquery-ui.js"></script>
    <%--<script src="/resources/bootstrap/js/bootstrap.js" type="text/javascript"></script>--%>
    <script type="text/javascript" src="/resources/bootstrap/js/bootstrap.js"></script>
    <link href="/resources/css/infokadr.css" rel="stylesheet">

</head>
<body style="background-color: whiteSmoke">

<style>
    .ui-autocomplete {
        position: absolute;
        top: 100%;
        left: 0;
        z-index: 1000;
        float: left;
        display: none;
        min-width: 160px;
        _width: 160px;
        padding: 4px 0;
        margin: 2px 0 0 0;
        list-style: none;
        background-color: #ffffff;
        border-color: #ccc;
        border-color: rgba(0, 0, 0, 0.2);
        border-style: solid;
        border-width: 1px;
        -webkit-border-radius: 5px;
        -moz-border-radius: 5px;
        border-radius: 5px;
        -webkit-box-shadow: 0 5px 10px rgba(0, 0, 0, 0.2);
        -moz-box-shadow: 0 5px 10px rgba(0, 0, 0, 0.2);
        box-shadow: 0 5px 10px rgba(0, 0, 0, 0.2);
        -webkit-background-clip: padding-box;
        -moz-background-clip: padding;
        background-clip: padding-box;
        *border-right-width: 2px;
        *border-bottom-width: 2px;

    .ui-menu-item > a.ui-corner-all {
        display: block;
        padding: 3px 15px;
        clear: both;
        font-weight: normal;
        line-height: 18px;
        color: #555555;
        white-space: nowrap;

    &.ui-state-hover, &.ui-state-active {
        color: #ffffff;
        text-decoration: none;
        background-color: #0088cc;
        border-radius: 0px;
        -webkit-border-radius: 0px;
        -moz-border-radius: 0px;
        background-image: none;
    }

        }

        }

</style>

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
                    url: "/film/searh-jquery-ui",
                    dataType: 'json',
                    data: {
                        term: request.term
                    },
                    success: function (data) {
                        response(data);
                    }
                });
            },
            minLength: 1,
            select: function (event, ui) {
                window.location.href = "/video/" + ui.item.id;
            }
        });
    });
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
                               id="films"
                               class="span3">
                    </div>
                </div>
            </div>
        </div>
    </div>


    <tiles:insertAttribute name="body"/>


</div>

</body>
</html>