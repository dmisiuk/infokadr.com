<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ page isELIgnored="false" %>

<legend>Общая информация</legend>

<label>Название фильма на руском:</label>
<textarea rows="3" style="width: 90%">${film.rusName}</textarea>

<label>Название фильма на английском:</label>
<textarea rows="3" style="width: 90%">${film.engName}</textarea>
