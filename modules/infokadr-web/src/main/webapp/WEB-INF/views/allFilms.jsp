<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ page isELIgnored="false" %>


<c:set var="root" value="/infokadr" scope="request"/>
<c:set var="img" value="${root}/static/images" scope="request"/>
<c:set var="css" value="${root}/static/css" scope="request"/>
<c:set var="js" value="${root}/static/js" scope="request"/>
<c:set var="bs" value="${root}/static/bootstrap" scope="request"/>

<tiles:insertTemplate template="/WEB-INF/views/breadcrumb.jsp">
    <tiles:putAttribute name="lisBreadcrumb" >
        <li class="active">Все фильмы</li>
    </tiles:putAttribute>
</tiles:insertTemplate>

<div class="row">
    <div class="span12">
        <h2>Все фильмы</h2>

        <p>
            <a class="btn" type="button" href="${root}/admin/film/new"><i class="icon-plus"></i> Добавить фильм</a>
        </p>
    </div>

    <div class="span8">
        <table class="table table-hover">
            <thead>
            <tr>
                <th>название фильма</th>
                <th>видео</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="film" items="${films}">
                <tr>
                    <td>
                        <a href="${root}/admin/film/${film.id}"> ${film.rusName}</a>
                    </td>
                    <td>
                            ${fn:length(film.trailers)}
                        <a class="btn btn-mini" href="${root}/admin/film/${film.id}/video/new"><i class="icon-plus"></i> добавить</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
