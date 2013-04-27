<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isELIgnored="false" %>

<tiles:insertTemplate template="/WEB-INF/views/breadcrumb.jsp">
    <tiles:putAttribute name="lisBreadcrumb">
        <li><a href="${root}admin">Все фильмы</a> <span class="divider">/</span></li>
        <li class="active">Новый фильм</li>
    </tiles:putAttribute>
</tiles:insertTemplate>

<div class="row">
    <div class="span12">
        <h2>Добавление нового фильма</h2>
    </div>

    <div class="span4">
        <form:form commandName="film" method="POST" >
            <fieldset>
                <%@include file="/WEB-INF/views/filmFieldset.jsp" %>
                <button type="submit" class="btn"><i class="icon-ok"></i> Добавить новый фильм в базу</button>
            </fieldset>
        </form:form>
    </div>

</div>

