<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ page isELIgnored="false" %>

<tiles:insertTemplate template="/WEB-INF/views/breadcrumb.jsp">
    <tiles:putAttribute name="lisBreadcrumb">
        <li><a href="/admin">Все фильмы</a> <span class="divider">/</span></li>
        <li class="active">${film.rusName}</li>
    </tiles:putAttribute>
</tiles:insertTemplate>

<div class="row">
    <div class="span12">
        <h2>${film.rusName}</h2>
    </div>

    <div class="span4">
        <form>
            <fieldset>
                <%@include file="/WEB-INF/views/filmFieldset.jsp" %>
                <button type="submit" class="btn"><i class="icon-ok"></i> Сохранить изменения в фильме</button>
            </fieldset>
        </form>
    </div>
    <div class="span8 ">
        <legend>Трейлеры</legend>

        <c:choose>
            <c:when test="${fn:length(film.trailers) > 0}">
                <table class="table table-hover">
                    <thead>
                    <tr>
                        <th>полное название</th>
                        <th>Короткое название</th>
                        <th></th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="trailer" items="${film.trailers}">
                        <c:set var="trailerUrl" value="/admin/film/${film.id}/video/${trailer.id}"/>
                        <tr>
                            <td>
                                <a href="${trailerUrl}">${trailer.name} </a>
                            </td>
                            <td>
                                <a href="${trailerUrl}">${trailer.shortName} </a>
                            </td>
                            <td>
                                <a class="btn btn-mini" href="#"><i class="icon-remove"></i> удалить</a>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </c:when>
            <c:otherwise>
                <p>Этот фильм не имеет трейлеров</p>
            </c:otherwise>
        </c:choose>
        <p>
            <a class="btn" href="/admin/film/${film.id}/video/new"><i class="icon-plus"></i> Добавить новый трейлер</a>
        </p>
    </div>
</div>
