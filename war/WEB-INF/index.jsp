<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
  <head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <title>gogogo</title>
	<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
	<script type="text/javascript">
	<!--
		var data = ${name};
	
		$(function(){
			// HTML���[�h��Ɏ��s����������R�[�h
//			alert("hoge");
//			alert("hoge");
//			data = ${name};
			
//			alert(data.max_id);
			$("#maxid").text(data.max_id);
			
	
			// result �̕\��
			var i=0;
//			alert(data.results.length);
			for (i; i<data.results.length; ++i){
				var html = '<table border="3">';
				html = html + '<tr><th>０</th><th>１</th><th>２</th><th>３</th></tr>';
				
			}
//			alert(html);
//			alert("hoge4");
			$("#res").html(html);
		}); 
	-->
	</script>
  </head>

  <body>
    <h1>My hoge!</h1>
    <p id="maxid"></p>
    <div id="res"></div>
  </body>
</html>
