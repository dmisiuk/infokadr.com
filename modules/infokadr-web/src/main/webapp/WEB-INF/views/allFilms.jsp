<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ page isELIgnored="false" %>

<tiles:putAttribute name="title">
    Мой мега список аттрибутов
</tiles:putAttribute>

<div class="row">
    <div class="span12">
        <ul class="breadcrumb">
            <li class="active">Все фильмы</li>
            <a href="#" style="float: right"> <i class="icon-off"></i> выйти</a>
        </ul>

    </div>
</div>

<div class="row">
    <div class="span12">
        <h2>Все фильмы</h2>

        <p>
            <a class="btn" type="button" href="/admin/film/new"><i class="icon-plus"></i> Добавить фильм</a>
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
                        <a href="/admin/film/${film.id}"> ${film.rusName}</a>
                    </td>
                    <td>
                            ${fn:length(film.trailers)}
                        <a class="btn btn-mini" href="#"><i class="icon-plus"></i> добавить</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
