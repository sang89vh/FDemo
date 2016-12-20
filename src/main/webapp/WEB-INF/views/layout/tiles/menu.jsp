<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layout/taglib.jsp"%>
<nav class="navbar navbar-inverse navbar-embossed" role="navigation">
	<div class="navbar-header">
		<button type="button" class="navbar-toggle" data-toggle="collapse"
			data-target="#navbar-collapse-01">
			<span class="sr-only">FDemo</span>
		</button>
		<a class="navbar-brand" href="">FDemo</a>
	</div>
	<div class="collapse navbar-collapse" id="navbar-collapse-01">
		<ul class="nav navbar-nav navbar-left FDemo-nav-left">
			<li><a href="../ff0000/index">Right Event</a></li>
			<li ><a class="fffancybox fancybox.iframe"  href="https://docs.google.com/spreadsheets/d/1_W7FfZodVA1ybFBcKKOsPovXxXqt3y-RLRVIZVrbSrQ/edit#gid=1514860199">Investment</a></li>
			<li ><a class="fffancybox fancybox.iframe"  href="https://docs.google.com/spreadsheets/d/1aQ5j1Ol0t17-wGQd0G21JZDXNfzAf7GaAaZgBIWV9Yw/edit#gid=0">Company ranking</a></li>
			<li><a href="../ff0002/index">Historical Price</a></li>
			<li><a href="../ff0003/index">Knowledge</a></li>
			<li><a class="fffancybox fancybox.iframe"  href="https://banggia.vndirect.com.vn/chung-khoan/#khop-lenh/hose">Trading board</a></li>
			
		</ul>
		<ul class="nav navbar-nav navbar-right">
			<li class="dropdown">
				<a href="#" class="dropdown-toggle" data-toggle="dropdown">Account<b class="caret"></b></a> 
					<span class="dropdown-arrow"></span>
				<ul class="dropdown-menu">
					<li><a href="<c:url value='/ff0001/logout' />">Logout</a></li>
				</ul></li>
		</ul>
	</div>
	<!-- /.navbar-collapse -->
</nav>