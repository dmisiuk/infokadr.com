<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>

<legend>Общая информация</legend>

<label>Короткое название(уникальное)</label>
<form:errors path="shortName" cssClass="help-block"/>
<form:input path="shortName" cssStyle="width: 70%"/>

<label>YouTube url(формат http://www.youtube.com/embed/-O-_R5Y2DZA)</label>
<form:errors path="url" cssClass="help-block"/>
<form:input path="url" style="width: 70%"/>

<label>Название трейлера:</label>
<form:errors path="name" cssClass="help-block"/>
<form:textarea path="name" rows="3" style="width: 90%"/>

<label>Описание трейлера:</label>
<form:errors path="description" cssClass="help-block"/>
<form:textarea path="description" rows="5" style="width: 90%"/>
