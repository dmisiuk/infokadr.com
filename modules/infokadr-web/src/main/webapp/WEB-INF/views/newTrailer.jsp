<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>

<tiles:insertTemplate template="/WEB-INF/views/breadcrumb.jsp">
    <tiles:putAttribute name="lisBreadcrumb">
        <li><a href="${root}admin">Все фильмы</a> <span class="divider">/</span></li>
        <li><a href="${root}admin/film/${film.id}">${film.rusName}</a> <span class="divider">/</span></li>
        <li class="active">Добавить новый трейлер</li>
    </tiles:putAttribute>
</tiles:insertTemplate>



<div class="row">
    <div class="span12">
        <h2>Добавление нового трейлера</h2>
    </div>

    <div class="span6">
        <form:form commandName="trailer" method="POST">
            <fieldset>
                <%@include file="/WEB-INF/views/trailerFieldset.jsp" %>
                <button type="submit" id="save" class="btn"><i class="icon-ok"></i> Добавить новый трейлер в базу</button>
            </fieldset>
        </form:form>
    </div>

    <div class="span6">
        <div class="flex-video widescreen">
            <iframe id="film_url" src="${trailer.url}" frameborder="0"
                    allowfullscreen=""></iframe>
        </div>
    </div>

</div>
