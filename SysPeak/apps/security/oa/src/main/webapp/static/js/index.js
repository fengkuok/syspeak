tab = null;

$(function() {
	$("#index_layout").ligerLayout({
		topHeight : 70,
		bottomHeight : 40,
		leftWidth : 250
	});

	$.ajax({
		url : "listMenus",
		success : function(data) {
			var left = $('#left');
			$.each(data, function(index, value) {
				left.append('<div title="' + value.text + '" id="' + value.attribute['id'] + '"></div>');
				var item = $('#' + value.attribute['id']);
				item.append('<ul id="tree_' + value.attribute['id'] + '" style="margin-top: 5px;"></ul>');
				$('#tree_' + value.attribute['id']).ligerTree({
					data : value.children,
					checkbox : false,
					onClick : function(node) {
						var url = node.data.attribute['url'];
						if (!url)
							return;
						var tabid = $(node.target).attr("tabid");
						if (!tabid) {
							tabid = new Date().getTime();
							$(node.target).attr("tabid", tabid);
						}
						addTab(tabid, node.data.text, node.data.attribute['url']);
					}
				});
			});
			left.ligerAccordion();
		}
	});

	tab = $("#main").ligerTab();
});

function addTab(tabid, text, url) {
	tab.addTabItem({
		tabid : tabid,
		text : text,
		url : url
	});
}