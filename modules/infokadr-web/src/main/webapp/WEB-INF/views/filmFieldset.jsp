<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>

<legend>Общая информация</legend>

<label>Название фильма на руском:</label>
<form:errors path="rusName" cssClass="help-block"/>
<form:textarea path="rusName" rows="3" style="width: 90%"/>


<label>Название фильма на английском:</label>
<form:errors path="engName" cssClass="help-block"/>
<form:textarea path="engName" rows="3" style="width: 90%"/>


