<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <%@include file="/resources/commons/basejs.jsp" %>
    <style>
    	.btn-little{
    		padding 10px 10px;
    		background-color: #0c0c0c;
    		color: #fff;
    		text-align: center;
    		cursor: pointer;
    		font-size: 12px;
    	}
    </style>
</head>
<body>
	<table id="id_table" lay-filter="lineToolFilter"></table>
</body>
<script type="text/javascript">
	var modleName = "${ctxPath}/sport";
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
				{field: 'id',title: 'ID',align: 'center'},
				{field: 'name',title: '名称',align: 'center'},
				{field: 'avatarUrl',title: '图片',align: 'center',templet:function(d){
					return '<img src="${ctxPath}/'+d.avatarUrl+'"/>';
				}},
				{field: 'heat',title: '热量',align: 'center'},
				{field: 'createTime',title: '入库时间',align: 'center',templet:function(d){
					return layui.util.toDateString(d.createTime);
				}},
				{field: 'state',title: '用户申请',align: 'center',templet:function(d){
					if(d.state == 3){
						return '<span class="btn-little" onclick="changeState1('+d.id+')">通过申请</span>';
					}
					return '';
				}},
				{title: "操作",align: "center",toolbar:"#bar"}
			]]
		});
		//使用父类的行工具栏
		useParentToolEvent(modleName);
	}
	
	//申请通过
	function changeState1(id){
		$.ajax({
			url: modleName + "/updateState",
			type: 'post',
			data: {
				id: id,
				state: 1
			},
			dataType: 'json',
			success: function(res){
				if(res.code==200){
					onSearch();
				}else{
					layer.msg(res.msg,{icon:5, shade:0.4,time:1000});
				}
			}
		})
	}
</script>
</html>





























