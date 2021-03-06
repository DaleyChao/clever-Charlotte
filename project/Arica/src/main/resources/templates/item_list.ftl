<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<meta name="viewport"
	content="user-scalable=no, width=device-width, minimum-scale=1, maximum-scale=1">

<title>静态文件管理</title>

<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/layui.css" rel="stylesheet">
<link href="css/home.css" rel="stylesheet">
<style type="text/css">
.wa {
	width: 100%;
}
</style>

</head>

<body>
	<header id="header">
		<div>
			<a href="addtor" class="download1"> <span
				class="glyphicon glyphicon-plus-sign"></span> <br>发布item
			</a> <a href="itemList" class="download1"> <span
				class="glyphicon glyphicon-folder-open"></span> <br>静态文件列表
			</a> <a href="#" class="about"> <span
				class="glyphicon glyphicon-paperclip"></span> <br>模板管理
			</a> <a href="https://mashibing.com/#" class="home"> </a> <a href="#"
				class="api"> <span class="glyphicon  glyphicon-ok-sign"></span>
				<br>文件检查
			</a> <a class="demo" href="#"> <span
				class="glyphicon glyphicon-floppy-disk"></span> <br>系统设置
			</a> <a class="demo" href="#"> <span
				class="glyphicon glyphicon glyphicon-tasks"></span> <br>系统状态
			</a>
		</div>
	</header>

	<div class="content why-hilo">
		<h2>Item 列表</h2>

		<p class="info">
			可以在这里维护item信息，和更新静态文件<br />
<a href="generateAll" target="_blank" class="layui-btn layui-btn-danger layui-btn-radius">批量生成</a>

<a href="generateMain" target="_blank" class="layui-btn layui-btn-danger layui-btn-radius">生成首页</a>

<a href="generateCategory" target="_blank" class="layui-btn layui-btn-danger layui-btn-radius">生成分类列表</a>

		</p>
		
		
<table class="layui-table">
  <colgroup>
    <col width="150">
    <col width="200">
    <col>
  </colgroup>
 
  
  <thead>
    <tr>
      <th>id</th>
      <th>title</th>
     
      <th>操作</th>
    </tr> 
  </thead>
  <tbody>
  
  
  
  <#list items as each>
  <tr>
    <td>${each.id}</td>
      <td>${each.title}</td>
      <td> 
      <a href="editor?id=${each.id}" target="_blank" class="layui-btn layui-btn-normal">编辑</a>
       <a href="view?id=${each.id}" target="_blank" class="layui-btn layui-btn-normal">查看动态预览</a>

     <a href="item${each.id}.html" target="_blank" class="layui-btn layui-btn-normal">查看静态文件 </a>
          
     <a href="generate?id=${each.id}" target="_blank" class="layui-btn layui-btn-normal">生成静态文件</a>
         
          
          </td>
  </tr>
</#list>

    
    
  </tbody>
</table>



		
		
		
		<div style="text-align: -webkit-center;">

			
		</div>


		<div class="intro-wrap" id="introWrap">



			<p>Copyright © 2019 Mashibing EDU All Rights Reserved.</p>



		</div>
	</div>


	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
<script src="layui.all.js"></script>
</body>

</html>