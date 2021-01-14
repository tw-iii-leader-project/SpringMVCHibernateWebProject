<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<script src="https://code.jquery.com/jquery-3.5.1.min.js" integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0=" crossorigin="anonymous"></script>
	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.min.js" integrity="sha256-VazP97ZCwtekAsvgPBSUwPFKdrwD3unUfSGVYrahUqU=" crossorigin="anonymous"></script>
<meta charset="UTF-8">
<title>資料修改頁面</title>
<style type="text/css">
	#title{
		text-align: center;
	}
	#menu{
		padding-left:400px;
		padding-right:400px;
		margin:15px;
		font-size: 20px;	
	}
	#insertBox{
		text-align:center;
		display:none;
		padding-left:300px;
		padding-right:300px;
	}
	.insertTitle{
		padding:20px;
		font-size:30px;
	}
	#insertBox div{
		padding:5px;
		display: inline-block;
	}
	#deleteBox{
		text-align:center;
		display:none;
		padding-left:300px;
		padding-right:300px;
	}
	.deleteTitle{
		padding:20px;
		font-size:30px;
	}
	#deleteBox div{
		padding:5px;
		display: inline-block;
	}
	#updateBox{
		text-align:center;
		display:none;
		padding-left:300px;
		padding-right:300px;
	}
	.updateTitle{
		padding:20px;
		font-size:30px;
	}
	#updateBox div{
		padding:5px;
		display: inline-block;
	}
	
</style>
<script type="text/javascript">
	$(function(){
		$("#insert").click(function(){
			$("#insertBox").css("display","block");
		});
		
		$("#insertCancel").click(function(){
			$("#insertBox").css("display","none");
		});

		$("#insertForm").submit(function(){
			$("#insertMessage").text("資料已新增!!!").show(800).fadeOut(2500);
		});

		$("#delete").click(function(){
			$("#deleteBox").css("display","block");
		});
		
		$("#deleteCancel").click(function(){
			$("#deleteBox").css("display","none");
		});

		$("#deleteForm").submit(function(){
			$("#deleteMessage").text("資料已刪除!!!").show(800).fadeOut(2500);
		});

		$("#update").click(function(){
			$("#updateBox").css("display","block");
		});
		
		$("#updateCancel").click(function(){
			$("#updateBox").css("display","none");
		});

		$("#updateForm").submit(function(){
			$("#updateMessage").text("資料已更新!!!").show(800).fadeOut(2500);
		});
	
	});
</script>
</head>
<body>
	<div id="title" class="ui-grid-b">
		<div class="ui-block-a"></div>
		<div class="ui-block-b">
			<h1>歡		迎		光		臨</h1>
		</div>
		<div>使用者帳號 :${user}</div>
		<div>使用者ID :${id}</div>
		<div>電話 :${telephone}</div>
		<div>${msg}</div>
		
	</div>

	<div class="ui-grid-b">
		<div class="ui-block-a"></div>
		<div class="ui-block-b">
			<form action="selectAction" method="get"><button id="select" name="select" type="submit">查詢資料</button></form>
			<button id="update" name="update">修改商品</button>
			<button id="delete" name="delete">刪除商品</button>
			<button id="insert" name="insert">新增商品</button>
			<br/>
			<a id="update" href="<%=request.getContextPath()%>/userData.jsp">修改會員資料</a>
		</div>
		<div class="ui-block-c"></div>
	</div>




<div id="insertBox">
	<div class="insertTitle">您欲新增之商品資料</div>
	<form id="insertForm" method="post" action="insertAction">
		<div class="formgroup">
			商品名稱 :<input id="comname" name="comname"/>
		</div>
		<div class="formgroup">
			商品售價 :<input id="price" name="price"/>
		</div>
		<div class="formgroup">
			<button id="insertSubmit" type="submit">確定</button>
		</div>
	</form>
	<div id="insertMessage" style="font-size: 18px; color:red;"></div>
	<div>
		<button id="insertCancel">取消新增</button>
	</div>
</div>

<div id="deleteBox">
	<div class="deleteTitle">您欲刪除之商品資料</div>
	<form id="deleteForm" method="post" action="deleteAction">
		<div class="formgroup">
			商品名稱 :<input id="comname" name="comname"/>
		</div>
		<div class="formgroup">
			<button id="deleteSubmit" type="submit">確定</button>
		</div>
	</form>
	<div id="deleteMessage" style="font-size: 18px; color:red;"></div>
	<div>
		<button id="deleteCancel">取消刪除</button>
	</div>
</div>

<div id="updateBox">
	<div class="updateTitle">您欲修改之商品資料</div>
	<form id="updateForm" method="post" action="updateAction">
		<div class="formgroup">
			商品ID :<input id="comid" name="comid"/>
		</div>
		<div class="formgroup">
			商品名稱 :<input id="comname" name="comname"/>
		</div>
		<div class="formgroup">
			商品售價 :<input id="price" name="price"/>
		</div>
		<div class="formgroup">
			<button id="updatesubmit" type="submit">確定</button>
		</div>
	</form>
	<div id="updateMessage" style="font-size: 18px; color:red;"></div>
	<div>
		<button id="updateCancel">取消修改</button>
	</div>
</div>





</body>
</html>