/**
 * My library for jQuery 
 */
$(document).ready(function() {

		event.preventDefault();
		var href = $(this).attr('href');
		var text = $(this).text();
		if(text=='Edit'){
			$.get(href, function(ship, status){
				$('.myForm #id').val(ship.shipid);
				$('.myForm #source').val(ship.source);
				$('.myForm #destination').val(ship.destination);
			});
			$('.myForm #exampleModal').modal();
			
		}else {
			$('.myForm #id').val('');
			$('.myForm #source').val('');
			$('.myForm #destination').val('');
			$('.myForm #exampleModal').modal();
			$('#myModal #delRef').attr('href', href);
		}
	});

	$('.table .delBtn').on('click', function(event){
		event.preventDefault();

		var href = $(this).attr('href');
		$('#myModal').modal();
			$("#delRef").on('click', function(event){
				$.ajax({
			 		type : "GET",
			 		url : href,
			 		success: function(result){
			 			alert(result);
			 			$("#divContainer").html(result);
			 			$(".modal-backdrop").remove();
			 		},
			 		error : function(e){
			 			alert("blad" + e);
			 		}
				});
			});

		});

	
});


/*
$("#shipForm").submit(function(event){
	event.preventDefault();
	var action = $(this).attr('action');
	var formData = {
		source : $("#source").val()
	}
	// DO POST
	$.ajax({
		type : "POST",
		url : action,
		contentType : "application/json",
		data : JSON.stringify(formData),
		dataType : 'json',
		success : function(result){
			alert("dziala");
		},
		error : function(e){
			alert( e);
			console.log("Error", e);
		}
	});
});
*/