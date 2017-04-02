<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layout/taglib.jsp"%>
<h1>${msg}</h1>
<form:form action="../ff0002/data02" method="post">
	<input type="submit" value="run Job">
</form:form>