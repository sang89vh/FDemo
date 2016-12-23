<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layout/taglib.jsp"%>
<%@page session="true"%>
<!DOCTYPE html>
<html lang="en">
<head>
<jsp:include page="tiles/header.jsp"></jsp:include>
</head>
<body>
	<div class="container">
		<div class="row">
			<tiles:insertAttribute name="body" />
		</div>
	</div>
</body>
