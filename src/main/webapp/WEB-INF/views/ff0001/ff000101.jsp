<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layout/taglib.jsp"%>
<link  href="${ctxPath}/resources/css/ff0001/ff000101.css" rel="stylesheet" type="text/css" />

	<div class="div-login-container">

		<c:if test="${not empty error}">
			<div class="error">${error}</div>
		</c:if>
		<c:if test="${not empty msg}">
			<div class="msg">${msg}</div>
		</c:if>

		<form name='loginForm' id="form-signup" class="form-signup"
			action="<c:url value='/login' />" method='POST'>

			<h5 class="form-signup-heading text-center">ĐĂNG NHẬP MBACKEND</h5>
			<label for="inputEmail" class="sr-only">Địa chỉ email</label> 
			<input type='text' 
				   name='USER_NAME' 
				   id='USER_NAME' 
				   class='form-control'
				   placeholder="Địa chỉ email" 
				   required 
				   autofocus />
				
			<label for="inputPassword" class="sr-only">Mật khẩu</label> 
			<input type='PASSWORD' 
				   name='PASSWORD'
				   id="inputPassword" 
				   class="form-control"
				   />
			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />
			
			<button id="btn-signup-submit" 	data-loading-text="Loading..." class="btn btn-lg btn-primary btn-block" type="submit" >Đăng nhập</button>
			<a class="btn btn-lg btn-warning btn-block" type="button" href="../user/signup">Chưa có tài khoản</a>

		</form>
	</div>
