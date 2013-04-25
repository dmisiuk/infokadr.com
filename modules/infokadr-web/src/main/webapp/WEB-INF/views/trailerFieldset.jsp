<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>

<style>
    .spoiler_body {
        display: none;
        cursor: pointer;
    }
</style>


<script>
    $(document).ready(
            function () {
                var saveButton = $("#save");
                saveButton.attr("disabled", "disabled");
                var urlInput = $("#url");
                if (urlInput.val()) {
                    saveButton.removeAttr("disabled");
                }

                $('.spoiler_links').click(function () {
                    $(this).parent().children('div.spoiler_body').toggle('normal');
                    return false;
                });

            }
    );

    var parseUrl = function () {

        var prefix = "http://www.youtube.com/embed/";
        var urlInput = $("#url");
        var customUrlInput = $("#customUrl");
        var filmUrlFrame = $("#film_url");
        var urlLabel = $("#url-label");
        var customUrl = customUrlInput.val();
        var completeURL = prefix+ getYouTubeCode(customUrl);
        filmUrlFrame.attr("src", completeURL);
        urlLabel.text(completeURL);
        urlInput.val(completeURL);

        var saveButton = $("#save");
        saveButton.removeAttr("disabled");
    }

    var getYouTubeCode = function(str) {
        //http://www.youtube.com/watch?v=_T0002AcY-k
        var regFromBrowser = /^((https|http)\:\/\/)?(www.)?youtube.com\/watch\?v=.*$/
        //http://youtu.be/_T0002AcY-k
        var regFromShare = /^http\:\/\/youtu.be\/.*$/
        //_T0002AcY-k

        if(regFromBrowser.test(str)){
            var startParameter = str.indexOf("?v=");
            return str.slice(startParameter +3);
        }
        if(regFromShare.test(str)){
            return str.slice(16);
        }
        return str;
    }

</script>

<legend>Общая информация</legend>


<label>Название трейлера:</label>
<form:errors path="name" cssClass="help-block"/>
<form:textarea path="name" rows="3" style="width: 80%" required="true"/>


<label>Короткое название(уникальное)</label>
<form:errors path="shortName" cssClass="help-block"/>
<form:input path="shortName" cssStyle="width: 80%" required="true"/>


<label>Описание трейлера:</label>
<form:errors path="description" cssClass="help-block"/>
<form:textarea path="description" rows="5" style="width: 80%" required="true"/>

<label>YouTube URL:</label>

<div>
    <a href="" class="spoiler_links">нажмите, чтобы узнать возможные варианты</a>

    <div class="spoiler_body">
        <div style="border: solid">
            Из адресной строки<br>
            <img src="${img}/examples/screen_01.png" class="img-polaroid">
            <hr>
            Из поля "Share"<br>
            <img src="${img}/examples/screen_02.png" class="img-polaroid">
            <hr>
            Непосредственно YouTube идентификатор<br>
            <img src="${img}/examples/screen_03.png" class="img-polaroid"><br>
        </div>
    </div>
</div>


<input type="text" id="customUrl" style="width: 60%" required="true"/>
<button type="button" onclick="parseUrl();" class="btn"><i class="icon-check"></i> проверить</button>

<label class="label-info" style="width: 80%;">
    (после вставки нажмите "проверить", чтобы убедится. Видео должно появится справа)
</label>
<form:errors path="url" cssClass="help-block"/>
<form:input type="hidden" path="url" style="width: 80%" required="true"/>
<span style="font-weight: bold" id="url-label">${trailer.url}</span>
<br>
