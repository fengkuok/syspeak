$(function() {
	$('#submit')[0].disabled = 'disabled';
	$("#username").blur(function() {
		$('#username').val($.trim($('#username').val()));
		if ($('#username').val() == '') {
			$('#userExisted').html('');
			$('#submit')[0].disabled = 'disabled';
			return;
		}
		$.ajax({
			type : 'post',
			url : 'user/userExisted',
			data : {
				username : $("#username").val()
			},
			success : function(responseData, textStatus) {
				if (responseData == true) {
					$('#userExisted').html('<font color="red">该帐号已存在！</font>');
					$("#username").focus();
					$('#submit')[0].disabled = 'disabled';
				} else {
					$('#userExisted').html('<font color="green">可用</font>');
					$('#submit')[0].disabled = false;
				}
			}
		});
	});

	$('#submit').click(function() {
		$.ajax({
			type : 'post',
			url : 'user/userExisted',
			data : {
				username : $("#username").val()
			},
			success : function(responseData, textStatus) {
				if (textStatus == 'success') {
					if (responseData == true) {
						$('#userExisted').html('<font color="red">该帐号已存在！</font>');
						$("#username").focus();
						$('#submit')[0].disabled = 'disabled';
					} else {
						$('#userExisted').html('<font color="green">可用</font>');
						$('#submit')[0].disabled = false;
						$.ajax({
							type : 'post',
							url : 'user/doAdd',
							data : {
								username : $('#username').val(),
								enabled : $('#enabled').val()
							},
							success : function(responseData, textStatus) {
								if (textStatus == 'success') {
									if (responseData.success == true) {
										alert('添加成功');
									} else {
										alert('添加失败');
									}
								} else {
									alert('未知原因导致添加失败，请检查网络或者与系统管理员联系');
								}
							}
						});
					}
				} else {
					alert('未知原因导致添加失败，请检查网络或者与系统管理员联系');
				}
			}
		});

	});
});