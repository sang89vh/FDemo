<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layout/taglib.jsp"%>
<link  href="${ctx}/resources/css/ff0001/ff000101.css" rel="stylesheet" type="text/css" />

	<div class="div-login-container">

		

		<form name='loginForm' id="form-signup" class="form-signup"
			action="<c:url value='/ff0001/login' />" method='GET'>
			<div >
				<c:if test="${not empty error}">
					<div class="error" style="text-align: center;">${error}</div>
				</c:if>
				<c:if test="${not empty msg}">
					<div class="msg" style="text-align: center;">${msg}</div>
				</c:if>
			</div>
			<h5 class="form-signup-heading text-center">LOGIN TO F-SYSTEM</h5>
			<label for="inputEmail" class="sr-only">Your email</label> 
			<input type='text' 
				   name='USER_NAME' 
				   id='USER_NAME' 
				   class='form-control'
				   placeholder="Enter your email" 
				   required 
				   autofocus />
				
			<label for="inputPassword" class="sr-only">Your Password</label> 
			<input type='PASSWORD' 
				   name='PASSWORD'
				   id="inputPassword"
				   placeholder="Enter your password" 
				   required 
				   class="form-control"
				   />
			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />
			
			<button id="btn-signup-submit" 	data-loading-text="Loading..." class="btn btn-lg btn-primary btn-block" type="submit" >Login</button>

		</form>
	</div>
