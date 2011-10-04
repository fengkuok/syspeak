$(function() {
	$("#index_layout").ligerLayout({
		topHeight : 70,
		bottomHeight : 40,
		leftWidth : 250
	});

	$("#menu").ligerTree({
		 url : "listMenus",
		 checkbox : false
	});
});
