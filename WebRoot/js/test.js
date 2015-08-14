//获取数据列表
function MyAutoRun() {
	$.ajax({
		url : 'selectProductTypeWeb.action',
		type : 'post',
		data : {
			'fatherId' : 0
		},
		dataType : 'json',
		error : function() {
		},
		success : function(backValue) {
			$.each(backValue.dataList, function(idx, item) {
				/*
				 * if(idx==0){ return true;//同countinue，返回false同break }
				 */
				$("#ul_list").append(
						'<li><dl class="fenleiLeft"><dt>' + item.typeName
								+ '</dt><div class="fenleiright" id="id'
								+ item.typeId + '"></div></dl></li>');
				alert("1");
				id = "#id" + item.typeId;
				fatherId = item.typeId;

				$.ajax({
					url : "selectProductTypeWeb.action",
					type : "post",
					data : {
						"fatherId" : fatherId
					},
					dataType : "json",
					error : function() {
					},
					success : function(backValue) {
						$.each(backValue.dataList, function(idx, item) {
							$(id).append(
									'<dl class="flright"><dt>' + item.typeName
											+ '</dt></dl>');
							alert("2");
						});
					}
				});

				// alert("3");
				// $("#ul_list").append('</div></dl></li>');
			});
		}
	});
}

$('#mySelect').change(function() {

	var para = $(this).children('option:selected').val();// 这就是selected的值

	$.ajax({
		url : 'selectProductTypeWeb.action',
		type : 'post',
		data : {
			'fatherId' : 0
		},
		dataType : 'json',
		error : function() {
		},
		success : function(backValue) {

		}
	});
})