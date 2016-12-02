<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/layout/taglib.jsp"%>
<nav class="navbar navbar-inverse navbar-embossed" role="navigation">
	<div class="navbar-header">
		<button type="button" class="navbar-toggle" data-toggle="collapse"
			data-target="#navbar-collapse-01">
			<span class="sr-only">Toggle navigation</span>
		</button>
		<a class="navbar-brand" href="#">Flat UI</a>
	</div>
	<div class="collapse navbar-collapse" id="navbar-collapse-01">
		<ul class="nav navbar-nav navbar-left">
			<li><a href="#fakelink">Menu Item<span class="navbar-unread">1</span></a></li>
			<li class="dropdown"><a href="#" class="dropdown-toggle"
				data-toggle="dropdown">Messages <b class="caret"></b></a> <span
				class="dropdown-arrow"></span>
				<ul class="dropdown-menu">
					<li><a href="#">Action</a></li>
					<li><a href="#">Another action</a></li>
					<li><a href="#">Something else here</a></li>
					<li class="divider"></li>
					<li><a href="#">Separated link</a></li>
				</ul></li>
			<li><a href="#fakelink">About Us</a></li>
		</ul>
		<form class="navbar-form navbar-right" action="#" role="search">
			<div class="form-group">
				<div class="input-group">
					<input class="form-control" id="navbarInput-01" type="search"
						placeholder="Search"> <span class="input-group-btn">
						<button type="submit" class="btn">
							<span class="fui-search"></span>
						</button>
					</span>
				</div>
			</div>
		</form>
	</div>
	<!-- /.navbar-collapse -->
</nav>