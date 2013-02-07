<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page isELIgnored="false" %>


<div class="row">
    <div class="span12">
        <ul class="breadcrumb">
            <li><a href="/admin">Все фильмы</a> <span class="divider">/</span></li>

            <li class="active">${film.rusName}</li>
            <a href="#" style="float: right"> <i class="icon-off"></i> выйти</a>
        </ul>

    </div>
</div>

<div class="row">
    <div class="span12">
        <h2>${film.rusName}</h2>
    </div>

    <div class="span4">
        <form>
            <fieldset>
                <legend>Общая информация</legend>

                <label>Название фильма на руском:</label>
                <textarea rows="3" style="width: 90%">${film.rusName}</textarea>

                <label>Название фильма на английском:</label>
                <textarea rows="3" style="width: 90%">${film.engName}</textarea>

                <button type="submit" class="btn">Сохранить изменения в фильме</button>
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
                        <tr>
                            <td>
                                <a href="#">${trailer.name} </a>
                            </td>
                            <td>
                                <a href="#">${trailer.shortName} </a>
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
            <button class="btn" type="button"><i class="icon-plus"></i> Добавить новый трейлер</button>
        </p>
    </div>
</div>

