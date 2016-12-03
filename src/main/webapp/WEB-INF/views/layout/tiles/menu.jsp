<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layout/taglib.jsp"%>
<nav class="navbar navbar-inverse navbar-embossed" role="navigation">
	<div class="navbar-header">
		<button type="button" class="navbar-toggle" data-toggle="collapse"
			data-target="#navbar-collapse-01">
			<span class="sr-only">MBackend</span>
		</button>
		<a class="navbar-brand" href="">MBackend</a>
	</div>
	<div class="collapse navbar-collapse" id="navbar-collapse-01">
		<ul class="nav navbar-nav navbar-left mbackend-nav-left">
			<li><a href="/">SẢN PHẨM</a></li>
			<li><a href="/application/my-application">ỨNG DỤNG</a></li>
			<li id="nav_likevideos" style="display: none;"><a
				href="/videos/manager">LIKE VIDEOS</a></li>
			<li><a target="_blank" href="http://doc.mbackend.com/">TÀI
					LIỆU</a></li>
			<li><a target="_blank"
				href="http://123hoidap.vn/subject/detail/question/556a6696027b87c55f8b4659/baas.html">HỖ
					TRỢ</a></li>
			<li><a target="_blank" href="http://project.mbackend.com/">OPEN
					PROJECT</a></li>
		</ul>
		<ul class="nav navbar-nav navbar-right">
			<li class="dropdown"><a href="#" class="dropdown-toggle"
				data-toggle="dropdown">Account <b class="caret"></b></a> <span
				class="dropdown-arrow"></span>
				<ul class="dropdown-menu">
					<li><a href="<c:url value='/ff0001/login?logout' />">Logout</a></li>
				</ul></li>
		</ul>
	</div>
	<!-- /.navbar-collapse -->
</nav>