<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page isELIgnored="false" %>

<div class="row">
    <div class="span2">

    </div>
    <div id="title" class="span6">
        ${trailer.name}
        <sec:authorize access="hasRole('admin')">
            <a href="${root}/admin/film/${trailer.film.id}/video/${trailer.id}">[редактировать]</a>
        </sec:authorize>
    </div>

    <%--<div class="span2" style="text-align: right">--%>
    <%--<button class="btn btn-mini btn-primary" style="font-size: 12px;font-weight: bold;">кадросюжет</button>--%>
    <%--</div>--%>
    <div class="span2">

        <c:if test="${fn:length(trailers) > 1}">
            <div class="btn-group" style="float: right;">
                <button class="btn  btn-primary btn-mini dropdown-toggle" style="font-size: 12px;font-weight: bold;">
                    ещё
                    <span class="caret"></span></button>
                <ul class="dropdown-menu">
                    <c:forEach var="tr" items="${trailers}">
                        <c:choose>
                            <c:when test="${tr.shortName == trailer.shortName}">
                                <li class="disabled"><a>${tr.shortName}</a></li>
                            </c:when>
                            <c:otherwise>
                                <li><a href="${root}video/${tr.id}">${tr.shortName}</a></li>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                </ul>
            </div>
        </c:if>
    </div>
</div>
<br>

<div class="row" style="font-size: 14px">
    <div class="span2">
        <ul id="previous" class="nav nav-list">
            <c:if test="${trailersBefore[0] != null}">
                <li><a href="${root}video/${trailersBefore[0].id}">
                    <img src="${img}/vlevo.png"></a>
                </li>
                <li class="nav-header">Предыдущие трейлеры:</li>
            </c:if>
            <c:forEach var="tr" items="${trailersBefore}">
                <li><a href="${root}video/${tr.id}">${tr.film.rusName}</a></li>
            </c:forEach>

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
            <c:if test="${trailersAfter[0] != null}">
                <li><a href="${root}video/${trailersAfter[0].id}">
                    <img src="${img}/vpravo.png"></a>
                </li>
                <li class="nav-header">Следующие трейлеры:</li>
            </c:if>

            <c:forEach var="tr" items="${trailersAfter}">
                <li><a href="${root}video/${tr.id}">${tr.film.rusName}</a></li>
            </c:forEach>
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



