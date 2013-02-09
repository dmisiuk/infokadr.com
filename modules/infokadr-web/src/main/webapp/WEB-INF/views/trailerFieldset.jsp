<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ page isELIgnored="false" %>

<legend>Общая информация</legend>

<label>Короткое название(уникальное)</label>
<input type="text" style="width: 70%" value="${trailer.shortName}"/>

<label>YouTube url(формат http://www.youtube.com/embed/-O-_R5Y2DZA)</label>
<input type="text" style="width: 70%" value="${trailer.url}"/>

<label>Название трейлера:</label>
<textarea rows="3" style="width: 90%">${trailer.name}</textarea>

<label>Описание трейлера:</label>
<textarea rows="5" style="width: 90%">${trailer.description}</textarea>