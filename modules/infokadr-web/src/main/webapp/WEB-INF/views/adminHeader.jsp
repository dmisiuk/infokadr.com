<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page isELIgnored="false" %>

<c:set var="root" value="/infokadr" scope="request"/>
<c:set var="img" value="${root}/static/images" scope="request"/>
<c:set var="css" value="${root}/static/css" scope="request"/>
<c:set var="js" value="${root}/static/js" scope="request"/>
<c:set var="bs" value="${root}/static/bootstrap" scope="request"/>


<script>
    $(document).ready(
            function () {
                $('.dropdown-toggle').dropdown();
            }
    );
    $(function () {
        $("#films").autocomplete({
            source: function (request, response) {
                $.ajax({
                    url: "${root}/film/adminSearch",
                    dataType: 'json',
                    data: {
                        term: request.term
                    },
                    success: function (data) {
                        response(data);
                    }
                });
            },
            minLength: 1,
            select: function (event, ui) {
                window.location.href = "${root}/admin/film/" + ui.item.id;
            }
        });
    });
</script>


<br/>

<div class="row">
    <div class="span6">
        <ul class="nav nav-pills">
            <li><a href="${root}" style="font-weight: bold; font-size: 24px">infokadr</a></li>
        </ul>
    </div>

    <div style="text-align: right" class="span6">
        <div class="control-group">
            <div class="controls">
                <div class="input-prepend">
                    <span class="add-on">
                        <i class="icon-search"></i>
                    </span>
                    <input type="search" class="span3" placeholder="поиск по названию фильма"
                           id="films">
                </div>
            </div>
        </div>

    </div>
</div>