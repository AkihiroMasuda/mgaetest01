<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
  <head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <title>Twitter API test</title>
	<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
	<script type="text/javascript">
	<!--
		var data = ${jsonres};
		var url = "${geturl}";
	
		$(function(){
			// HTML���[�h��Ɏ��s����������R�[�h
			$("#url").text("url : " + url);
			$("#maxid").text("maxid : " + data.max_id);
			$("#query").text("query : " + data.query);
			$("#nums").text("rpp  : " + data.results.length + "  (=The number of tweets to return per page)");
	//		$("#json").text(restxt);
	
			// results をテーブルに出力
			var html = '<table border="3">';
			html = html + '<tr><th>id</th><th>profile_image_url</th><th>text</th><th>created_at</th><th>source</th></tr>';
			for (var i=0; i<data.results.length; ++i){
				html = html + '<tr>';
				var r = data.results[i];
				html = html + '<td>' + r.id + '</td>';
				html = html + '<td><img src="' +r.profile_image_url+ '"/>' + '</td>';
				html = html + '<td>' + r.text + '</td>';
				html = html + '<td>' + r.created_at + '</td>';
				html = html + '<td>' + changeTokushu2HTML(r.source) + '</td>';
				html = html + '</tr>';
			}
			$("#res").html(html);
		}); 

		// 特殊文字を含む文字列をHTML形式に戻す。	
		function changeTokushu2HTML(str){
			var targetArray=['<','>','\"'];
			var changeArray=['&lt;','&gt;','&quot;'];
			
			for( i = 0; i < 3; i++){
				reg = new RegExp(changeArray[i], "g");
				str = str.replace(reg, targetArray[i]);
			}
			return str;
		}
		
	-->
	</script>
  </head>

  <body>
    <h1>Twitter API test.</h1>
    <p id="url"></p>
    <p id="maxid"></p>
    <p id="query"></p>
    <p id="nums"></p>
    <div id="res"></div>
    <div id="json"></div>
  </body>
</html>
