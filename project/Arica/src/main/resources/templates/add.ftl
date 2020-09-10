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

	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="layui.all.js"></script>
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
			</a> <a href="" class="download1"> <span
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
		<h2>添加Item</h2>

		<p class="info">
			
<form action="add" method="post">

<div class="layui-form-item">
    <label class="layui-form-label">名称</label>
    <div class="layui-input-block">
      <input type="text" name="title" required  lay-verify="required" placeholder="请输入商品名称" autocomplete="off" class="layui-input">
    </div>
  </div>
			
 <br />
	
		<div style="text-align: -webkit-center;">
		<!-- 富文本 action -->
		
			<textarea name="content" id="demo" style="display: none;"></textarea>
			
			
			<script>
			layui.use('layedit', function(){
			  var layedit = layui.layedit;
			  layedit.build('demo'); //建立编辑器
			});
			</script>
			
		<!-- 富文本 end -->
<div class="layui-form-item">
          <div class="layui-input-block">
            <button class="layui-btn" >保存</button>
            <a href="javascript:history.go(-1);" class="layui-btn layui-btn-primary">返回</a>
          </div>
        </div>			
		</div>
</form>

		<div class="intro-wrap" id="introWrap">
			<p>Copyright © 2019 cleverDZ All Rights Reserved.</p>
		</div>
	</div>



</body>

</html>