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
	var modleName = "${ctxPath}/swiperFoods";
	//layui加载完成操作
	function onLayuiInit(){
		//渲染表格
		renderTable({
			elem: "#id_table",
			id: "id_table",
			toolbar: "#toolBar_search_only3",
			url: modleName+"/getList",
			cols:[[
				{type: 'checkbox',LAY_CHECKED: false},
				{field: 'name',title: '推荐标题',align: 'center'},
				{field: 'avatarUrl',title: '推荐图片',align: 'center',templet:function(d){
					return '<img src="${ctxPath}/'+d.avatarUrl+'"/>';
				}},
				{field: 'foodsName',title: '食物名称',align: 'center'},
				{field: 'foodsHeat',title: '食物热量',align: 'center'},
				{field: 'createTime',title: '添加时间',align: 'center',templet:function(d){
					return layui.util.toDateString(d.createTime);
				}},
				{title: "操作",align: "center",toolbar:"#bar"}
			]]
		});
		//使用父类的行工具栏
		useParentToolEvent(modleName);
	}
</script>
</html>





























