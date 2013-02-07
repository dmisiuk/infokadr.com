<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>

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

    <div class="row">
        <div class="span2">

        </div>
        <div id="title" class="span6">${trailer.name}
            <div class="btn-group">
                <button class="btn  btn-primary btn-mini dropdown-toggle" style="font-size: 12px;font-weight: bold;">ещё
                    <span class="caret"></span></button>
                <ul class="dropdown-menu">
                    <c:forEach var="tr" items="${trailer.film.trailers}">
                        <c:choose>
                            <c:when test="${tr.shortName == trailer.shortName}">
                                <li class="disabled"><a href="#">${tr.shortName}</a></li>
                            </c:when>
                            <c:otherwise>
                                <li><a href="#">${tr.shortName}</a></li>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                </ul>
            </div>
        </div>

        <%--<div class="span2" style="text-align: right">--%>
        <%--<button class="btn btn-mini btn-primary" style="font-size: 12px;font-weight: bold;">кадросюжет</button>--%>
        <%--</div>--%>
        <div class="span2">

        </div>
    </div>
    <br>

    <div class="row" style="font-size: 14px">
        <div class="span2">
            <ul id="previous" class="nav nav-list">
                <!--<li class="previous">-->
                <!--<a href="#">&larr;</a>-->
                <!--</li>-->
                <li class="disabled"><a href="#"><img src="../../resources/images/vlevo.png"></a></li>
                <li class="nav-header">Предыдущие трейлеры:</li>

            </ul>
        </div>
        <div class="span8">
            <div class="flex-video widescreen">
                <iframe id="film_url" src="${trailer.url}" frameborder="0"
                        allowfullscreen=""></iframe>
            </div>
        </div>
        <div class="span2">
            <ul id="next" class="nav nav-list">
                <!--<li class="previous">-->
                <!--<a href="#">&rarr;</a>-->
                <!--</li>-->
                <li class="disabled"><a href="#"><img src="../../resources/images/vpravo.png"></a></li>
                <li class="nav-header">Следующие трейлеры:</li>
            </ul>
        </div>
    </div>
    <div class="row">
        <div class="span2">
            <a style="color: #737373; ; text-decoration: no-underline;" href="mailto:kino@dol.by">kino@dol.by</a>
        </div>
        <div id="description" class="span8">${trailer.description}</div>
        <div class="span2">

        </div>
    </div>


</div>
