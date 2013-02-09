<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ page isELIgnored="false" %>

<c:set var="film" value="${trailer.film}"/>

<tiles:insertTemplate template="/WEB-INF/views/breadcrumb.jsp">
    <tiles:putAttribute name="lisBreadcrumb">
        <li><a href="/admin">Все фильмы</a> <span class="divider">/</span></li>
        <li><a href="/admin/film/${film.id}">${film.rusName}</a> <span class="divider">/</span></li>
        <li class="active">${trailer.shortName}</li>
    </tiles:putAttribute>
</tiles:insertTemplate>

<div class="row">
    <div class="span12">
        <h2>${trailer.name}</h2>
    </div>

    <div class="span6">
        <form>
            <fieldset>
                <%@include file="/WEB-INF/views/trailerFieldset.jsp" %>
                <button type="submit" class="btn"><i class="icon-ok"></i> Сохранить изменения в трейлере</button>
            </fieldset>
        </form>
    </div>
</div>

