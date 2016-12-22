<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layout/taglib.jsp"%>
<div th:if="${message}">
	<h5 th:text="${message}" />
</div>
<form method="POST" enctype="multipart/form-data" action="${ctx}/ff0005/upload?${_csrf.parameterName}=${_csrf.token}">
	<table>
		<tr>
			<td></td>
			<td><input type="file" name="file" /></td>
		</tr>
		<tr>
			<td></td>
			<td>
				<input type="submit" value="Upload" />
			</td>
		</tr>
	</table>
</form>