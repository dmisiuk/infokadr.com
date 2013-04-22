<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page isELIgnored="false" %>


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
                    url: "/film/adminSearch",
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
                window.location.href = "/admin/film/" + ui.item.id;
            }
        });
    });
</script>


<br/>

<div class="row">
    <div class="span6">
        <ul class="nav nav-pills">
            <li><a href="/" style="font-weight: bold; font-size: 24px">infokadr</a></li>
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