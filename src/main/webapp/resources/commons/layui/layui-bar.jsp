<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<script type="text/html" id="toolBar">
    <div>
        <div class="layui-inline">名称:</div>
        <input type="text" class="layui-input" style="display: inline-block;width: 220px"
               id="name_search" name="name" placeholder="请输入名称" autocomplete="off">

        <div class="layui-inline">
            <select name="state" id="state_search" class="layui-inline">
                <option value="-1" selected>全部</option>
                <option value="1">正常</option>
                <option value="2">删除</option>
            </select>
        </div>

        <a class="layui-btn" lay-event="search" id="toolBar_btn_search">
            <i class="layui-icon layui-icon-search"></i>搜索
        </a>

        <a class="layui-btn " lay-event="add">
            <i class="layui-icon layui-icon-add-1 layui-bg-cyan"></i>添加
        </a>
    </div>
</script>


<script type="text/html" id="toolBar_search_only">
    <div>
        <div class="layui-inline">内容:</div>
        <input type="text" class="layui-input" style="display: inline-block;width: 220px"
               id="name_search" name="name" placeholder="请输入搜索内容" autocomplete="off">

        <div class="layui-inline">
            <select name="state" id="state_search" class="layui-inline">
                <option value="-1" selected>全部</option>
                <option value="1">正常</option>
                <option value="2">删除</option>
            </select>
        </div>

        <a class="layui-btn" lay-event="search" id="toolBar_btn_search">
            <i class="layui-icon layui-icon-search"></i>搜索
        </a>
    </div>
</script>

<script type="text/html" id="toolBar_search_only2">
    <div>
        <div class="layui-inline">内容:</div>
        <input type="text" class="layui-input" style="display: inline-block;width: 220px"
               id="name_search" name="name" placeholder="请输入搜索内容" autocomplete="off">

        <a class="layui-btn" lay-event="search" id="toolBar_btn_search">
            <i class="layui-icon layui-icon-search"></i>搜索
        </a>
    </div>
</script>

<script type="text/html" id="toolBar_search_only3">
    <div>
        <div class="layui-inline">内容:</div>
        <input type="text" class="layui-input" style="display: inline-block;width: 220px"
               id="name_search" name="name" placeholder="请输入搜索内容" autocomplete="off">

        <a class="layui-btn" lay-event="search" id="toolBar_btn_search">
            <i class="layui-icon layui-icon-search"></i>搜索
        </a>
        <a class="layui-btn " lay-event="add">
            <i class="layui-icon layui-icon-add-1 layui-bg-cyan"></i>添加
        </a>
    </div>
</script>



<script type="text/html" id="bar">
    <a class="layui-btn layui-btn-xs layui-bg-orange" lay-event="edit">编辑</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>

<script type="text/html" id="bar2">
    <a class="layui-btn layui-btn-xs layui-bg-orange" lay-event="edit">编辑</a>
</script>

<script type="text/html" id="bar_detail">
    <a class="layui-btn layui-btn-xs layui-bg-black" lay-event="detail">详情</a>
</script>
