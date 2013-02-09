<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ page isELIgnored="false" %>


<div class="row">
    <div class="span12">
        <ul class="breadcrumb">
            <li><a href="/admin">Все фильмы</a> <span class="divider">/</span></li>

            <li class="active">Новый фильм</li>
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

                <button type="submit" class="btn"><i class="icon-ok"></i> Добавить новый фильм в базу</button>
            </fieldset>
        </form>
    </div>

</div>

