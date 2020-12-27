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
				<label class="layui-form-label">名称</label>
				<div class="layui-input-inline">
					<input type="text" name="name" lay-verify="required" placeholder="请输入名称" value="" class="layui-input">
				</div>
			</div>
			
			<div class="layui-form-item">
				<label class="layui-form-label">图片</label>
				<div class="layui-input-inline">
					<button type="button" class="layui-btn layui-btn-normal" id="image-upload-show">
						<i class="layui-icon layui-icon-upload"></i>上传图片
					</button>
					<div class="image-upload-show"></div>
				</div>
			</div>
			
			<div class="layui-form-item">
				<label class="layui-form-label">热量</label>
				<div class="layui-input-inline">
					<input type="text" name="heat" lay-verify="required|number" placeholder="请输入热量" value="" class="layui-input">
				</div>
			</div>
						
			<div class="layui-form-item">
				<label class="layui-form-label">简介</label>
				<div class="layui-input-inline">
					<input type="text" name="des" lay-verify="required" placeholder="请输入简介" value="" class="layui-input">
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
var modleName = "${ctxPath}/sport";
//layui加载完成操作
function initData(){
	bindUpload("image-upload-show", "avatarUrl",currentItemData.avatarUrl);
	bindSubmit(modleName, 'update', 'btn_form_submit', 'form_submit');
}
</script>
</html>





























