<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ page isELIgnored="false" %>

<div class="row">
    <div class="span12">
        <ul class="breadcrumb">
            <tiles:insertAttribute name="lisBreadcrumb"/>
            <a href="${root}/j_spring_security_logout" style="float: right"> <i class="icon-off"></i> выйти</a>
        </ul>
    </div>
</div>