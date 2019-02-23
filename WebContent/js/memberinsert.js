$(function() {
	$("#chk").click(function() {
		$.ajax({
			url : "idchkCon",
			type : "post",
			data : "id=" + $("#_id").val(),
			success : function(data) {
				alert(data);
			},
			error : function() {
				alert("에러가 발생되었습니다.");
			}
		});
	});
});