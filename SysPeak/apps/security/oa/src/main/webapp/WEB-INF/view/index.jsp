<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">
		<title>OA协同办公系统</title>

		<link rel="stylesheet" type="text/css" href="static/dwz-ria/themes/default/style.css">
		<link rel="stylesheet" type="text/css" href="static/dwz-ria/themes/css/core.css">

		<script type="text/javascript" src="static/dwz-ria/jquery.js"></script>
		<script type="text/javascript" src="static/dwz-ria/dwz.js"></script>
		<script type="text/javascript" src="static/js/index.js"></script>
	</head>

	<body>
	<body>
		<div id="layout">
			<div id="header">
				<div class="headerNav">
					<a class="logo" href="http://www.syspeak.com">标志</a>
					<ul class="nav">
						<li>
							<a href="changepwd.html" target="dialog">设置</a>
						</li>
						<li>
							<a href="http://bbs.dwzjs.com" target="_blank">论坛</a>
						</li>
						<li>
							<a href="logout">退出</a>
						</li>
					</ul>
					<ul class="themeList" id="themeList">
						<li theme="default">
							<div class="selected">
								蓝色
							</div>
						</li>
						<li theme="green">
							<div>
								绿色
							</div>
						</li>
						<li theme="purple">
							<div>
								紫色
							</div>
						</li>
						<li theme="silver">
							<div>
								银色
							</div>
						</li>
						<li theme="azure">
							<div>
								天蓝
							</div>
						</li>
					</ul>
				</div>

				<!-- navMenu -->

			</div>

			<div id="leftside">
				<div id="sidebar_s">
					<div class="collapse">
						<div class="toggleCollapse">
							<div></div>
						</div>
					</div>
				</div>
				<div id="sidebar">
					<div class="toggleCollapse">
						<h2>
							主菜单
						</h2>
						<div>
							收缩
						</div>
					</div>

					<div class="accordion" fillSpace="sidebar">
						<div class="accordionHeader">
							<h2>
								<span>Folder</span>界面组件
							</h2>
						</div>
						<div class="accordionContent">
							<ul class="tree treeFolder">
								<li>
									<a href="tabsPage.html" target="navTab">主框架面板</a>
									<ul>
										<li>
											<a href="main.html" target="navTab" rel="main">我的主页</a>
										</li>
										<li>
											<a href="http://www.baidu.com" target="navTab" rel="page1">页面一(外部页面)</a>
										</li>
										<li>
											<a href="demo_page2.html" target="navTab" rel="external" external="true">iframe navTab页面</a>
										</li>
										<li>
											<a href="demo_page1.html" target="navTab" rel="page1" fresh="false">替换页面一</a>
										</li>
										<li>
											<a href="demo_page2.html" target="navTab" rel="page2">页面二</a>
										</li>
										<li>
											<a href="demo_page4.html" target="navTab" rel="page3" title="页面三（自定义标签名）">页面三</a>
										</li>
										<li>
											<a href="demo_page4.html" target="navTab" rel="page4" fresh="false">测试页面（fresh="false"）</a>
										</li>
										<li>
											<a href="w_editor.html" target="navTab">表单提交会话超时</a>
										</li>
										<li>
											<a href="demo/common/ajaxTimeout.html" target="navTab">navTab会话超时</a>
										</li>
										<li>
											<a href="demo/common/ajaxTimeout.html" target="dialog">dialog会话超时</a>
										</li>
										<li>
											<a href="index_menu.html" target="_blank">横向导航条</a>
										</li>
									</ul>
								</li>

								<li>
									<a>常用组件</a>
									<ul>
										<li>
											<a href="w_panel.html" target="navTab" rel="w_panel">面板</a>
										</li>
										<li>
											<a href="w_tabs.html" target="navTab" rel="w_tabs">选项卡面板</a>
										</li>
										<li>
											<a href="w_dialog.html" target="navTab" rel="w_dialog">弹出窗口</a>
										</li>
										<li>
											<a href="w_alert.html" target="navTab" rel="w_alert">提示窗口</a>
										</li>
										<li>
											<a href="w_list.html" target="navTab" rel="w_list">CSS表格容器</a>
										</li>
										<li>
											<a href="demo_page1.html" target="navTab" rel="w_table">表格容器</a>
										</li>
										<li>
											<a href="w_removeSelected.html" target="navTab" rel="w_table">表格数据库排序+批量删除</a>
										</li>
										<li>
											<a href="w_tree.html" target="navTab" rel="w_tree">树形菜单</a>
										</li>
										<li>
											<a href="w_accordion.html" target="navTab" rel="w_accordion">滑动菜单</a>
										</li>
										<li>
											<a href="w_editor.html" target="navTab" rel="w_editor">编辑器</a>
										</li>
										<li>
											<a href="w_datepicker.html" target="navTab" rel="w_datepicker">日期控件</a>
										</li>
										<li>
											<a href="db_widget.html" target="navTab" rel="w_datepicker">dwz.database.js</a>
										</li>
									</ul>
								</li>

							</ul>
						</div>
						<div class="accordionHeader">
							<h2>
								<span>Folder</span>典型页面
							</h2>
						</div>
						<div class="accordionContent">
							<ul class="tree treeFolder treeCheck">
								<li>
									<a href="demo_page1.html" target="navTab" rel="demo_page1">查询我的客户</a>
								</li>
								<li>
									<a href="demo_page1.html" target="navTab" rel="demo_page2">表单查询页面</a>
								</li>
								<li>
									<a href="demo_page4.html" target="navTab" rel="demo_page4">表单录入页面</a>
								</li>
								<li>
									<a href="demo_page5.html" target="navTab" rel="demo_page5">有文本输入的表单</a>
								</li>
								<li>
									<a href="javascript:;">有提示的表单输入页面</a>
									<ul>
										<li>
											<a href="javascript:;">页面一</a>
										</li>
										<li>
											<a href="javascript:;">页面二</a>
										</li>
									</ul>
								</li>
								<li>
									<a href="javascript:;">选项卡和图形的页面</a>
									<ul>
										<li>
											<a href="javascript:;">页面一</a>
										</li>
										<li>
											<a href="javascript:;">页面二</a>
										</li>
									</ul>
								</li>
								<li>
									<a href="javascript:;">选项卡和图形切换的页面</a>
								</li>
								<li>
									<a href="javascript:;">左右两个互动的页面</a>
								</li>
								<li>
									<a href="javascript:;">列表输入的页面</a>
								</li>
								<li>
									<a href="javascript:;">双层栏目列表的页面</a>
								</li>
							</ul>
						</div>

					</div>

				</div>
			</div>
			<div id="container">
				<div id="navTab" class="tabsPage">
					<div class="tabsPageHeader">
						<div class="tabsPageHeaderContent">
							<!-- 显示左右控制时添加 class="tabsPageHeaderMargin" -->
							<ul class="navTab-tab">
								<li tabid="main" class="main">
									<a href="javascript:;"><span><span class="home_icon">我的主页</span> </span> </a>
								</li>
								<li tabid="main2" class="main">
									<a href="javascript:;"><span><span class="home_icon">我的主页</span> </span> </a>
								</li>
							</ul>
						</div>
						<div class="tabsLeft">
							left
						</div>
						<!-- 禁用只需要添加一个样式 class="tabsLeft tabsLeftDisabled" -->
						<div class="tabsRight">
							right
						</div>
						<!-- 禁用只需要添加一个样式 class="tabsRight tabsRightDisabled" -->
						<div class="tabsMore">
							more
						</div>
					</div>
					<div class="navTab-panel tabsPageContent">
						<div class="page">
							<div class="accountInfo">

							</div>
							<div class="pageFormContent" style="margin-right: 230px">
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

		<div id="footer">
			Copyright &copy; 2010
			<a href="http://www.syspeak.com" target="_blank">syspeak信息系统有限公司</a>
		</div>
	</body>
	</body>

</html>
