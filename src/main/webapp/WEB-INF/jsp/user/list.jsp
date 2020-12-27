<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <%@include file="/resources/commons/basejs.jsp" %>
</head>
<body>
	<table id="id_table" lay-filter="lineToolFilter"></table>
</body>
<script type="text/javascript">
	var modleName = "${ctxPath}/user";
	//layui加载完成操作
	function onLayuiInit(){
		//渲染表格
		renderTable({
			elem: "#id_table",
			id: "id_table",
			toolbar: "#toolBar_search_only2",
			url: modleName+"/getList",
			cols:[[				
				{field: 'id',title: 'ID',align: 'center'},
				{field: 'username',title: '登录名',align: 'center'},				
				{field: 'name',title: '名称',align: 'center'},
				{field: 'gender',title: '性别',align: 'center'},
				{field: 'age',title: '年龄',align: 'center'},
				{field: 'avatarUrl',title: '头像',align: 'center',templet:function(d){
					return '<img src="${ctxPath}/'+d.avatarUrl+'"/>';
				}},
				{field: 'phone',title: '电话',align: 'center'},
				{field: 'height',title: '身高',align: 'center'},
				{field: 'weight',title: '体重',align: 'center'},
				{field: 'occupation',title: '职业',align: 'center'},
				{field: 'intake',title: '可摄入热量',align: 'center'},
				{field: 'target',title: '现阶段饮食目标',align: 'center'},
				{field: 'createTime',title: '注册时间',align: 'center',templet:function(d){
					return layui.util.toDateString(d.createTime);
				}}
			]]
		});
		//使用父类的行工具栏
		useParentToolEvent(modleName);
	}
</script>
</html>





























