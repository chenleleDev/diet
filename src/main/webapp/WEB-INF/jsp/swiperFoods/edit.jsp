<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <%@include file="/resources/commons/basejs.jsp" %>
</head>
<body>
	<div style="width:700px;padding-top:10px;">
		<form id="form_submit" class="layui-form">
			<input type="hidden" name="id">
			<div class="layui-form-item">
				<label class="layui-form-label">轮播图</label>
				<div class="layui-input-inline">
					<select name="swiperid" id="swiperid" lay-verify="required"></select>
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">食物</label>
				<div class="layui-input-inline">
					<select name="foodsid" id="foodsid" lay-verify="required"></select>
				</div>
			</div>			
			
			<div class="layui-form-item" style="display:none">
				<button type="button" lay-submit lay-filter="btn_form_submit" id="btn_form_submit"
				 class="layui-btn layui-btn-lg"></button>
			</div>
			
		</form>
	</div>
</body>
<script type="text/javascript">
var modleName = "${ctxPath}/swiperFoods";
//layui加载完成操作
function initData(){
	loadOptionList({
		url:'${ctxPath}/swiper/getList',
		elementId:'swiperid',
		selectedValue:currentItemData.swiperid
	});
	
	loadOptionList({
		url:'${ctxPath}/foods/getList',
		elementId:'foodsid',
		selectedValue:currentItemData.foodsid
	});	
	
	bindSubmit(modleName, 'update', 'btn_form_submit', 'form_submit');
}
</script>
</html>
