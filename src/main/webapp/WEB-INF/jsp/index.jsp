<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <%@include file="/resources/commons/basejs.jsp" %>
    <script type="text/javascript" src="${ctxPath}/resources/js/index.js"></script>
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
    <!--顶部部分  -->
    <div class="layui-header">
    	<div class="layui-logo">健身爱好者饮食管理系统</div>
    	<ul class="layui-nav layui-layout-right">
    		<li class="layui-nav-item">
    			<img alt="" src="${ctxPath}/upload/headpic.jpg" class="layui-nav-img">
    			${sessionScope.userInfo.name}
    		</li>
    		<li class="layui-nav-item">
    			<a href="logout">退出</a>
    		</li>
    	</ul>
    </div>
    <!-- 左侧导航部分 -->
    <div class="layui-side layui-bg-black">
    	<div class="layui-side-scroll">
    		<ul class="layui-nav layui-nav-tree" lay-filter="test" id="nav_layui"></ul>
    	</div>
    </div>
    <!-- 主体部分 -->
    <div class="layui-body">
    	<iframe src="foods/listPage" name="myframe" frameborder="0" style="width:100%;height:100%;"></iframe>
    </div>
    <!-- 脚布局 -->
    <div class="layui-footer">
    	© 健身爱好者饮食管理系统
    </div>
</div>
</body>
</html>





























