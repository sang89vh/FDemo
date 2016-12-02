<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/layout/taglib.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Script-Type" content="text/javascript" />
<meta http-equiv="Content-Style-Type" content="text/css" />
 <meta name="viewport" content="width=1000, initial-scale=1.0, maximum-scale=1.0">
<title>FDemo</title>
<script type="text/javascript"> 
	var ctx = "<%=request.getContextPath()%>";
</script>
<link media="screen" href="${ctxPath}/resources/css/fdemo.css" rel="stylesheet" type="text/css" />
<link media="screen" href="${ctxPath}/resources/css/sweetalert.css" rel="stylesheet" type="text/css" />
<link media="screen" href="${ctxPath}/resources/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<link media="screen" href="${ctxPath}/resources/css/pace.css" rel="stylesheet" type="text/css" />
<link media="screen" href="${ctxPath}/resources/css/sweetalert.css" rel="stylesheet" type="text/css" />
<link media="screen" href="${ctxPath}/resources/css/flat-ui.min.css" rel="stylesheet" type="text/css" />


<link media="screen" href="${ctxPath}/resources/css/fdemo.css" rel="stylesheet" type="text/css" />

<script type="text/javascript" src="${ctxPath}/resources/js/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="${ctxPath}/resources/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${ctxPath}/resources/js/pace.min.js"></script>
<script type="text/javascript" src="${ctxPath}/resources/js/flat-ui.min.js"></script>
<script type="text/javascript" src="${ctxPath}/resources/js/sweetalert.min.js"></script>

<script type="text/javascript" src="${ctxPath}/resources/js/fdemo.js"></script>

</head>
<body>
	<div class="container">
		<div class="row">
			<tiles:insertAttribute name="body" />
		</div>
	</div>
</body>
