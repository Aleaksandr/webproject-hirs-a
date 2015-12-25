
	$(document).on('change', $("select"), function(el) {
		console.log($(el.target).attr("class"));
		if ($(el.target).attr("class") == "selectTaskStatus") {
			var idsel = $(el.target).attr("id");
			var inputText = $(el.target).val();
			$.ajax({
				url : '/changeTask',
				type: 'GET',
				dataType: 'json',
				contentType: 'application/json',
				mimeType: 'application/json',
				data : ({
					"id": idsel,
					"stat": inputText
				}),
				success: function (data) {
					var taskId = data.id;
					var taskStatus = data.stat;
					var taskType = data.type;
					//updateTask(taskId, taskStatus, taskType) {
					//
					//}
					alert("Id: "+taskId +", Status: "+ taskStatus + ", Type: "+ taskType);
					//var result = data.id + data.status;
				}
			});
		}
	})

	$(document).ajaxStart(function(){
		$('#loading').show();
	}).ajaxStop(function(){
		setTimeout( function(){
			$('#loading').hide();
		}, 500);
	});


