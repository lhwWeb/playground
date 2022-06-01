$(function(){
	
	window.onload = function() {
		
		// 오늘날짜 계산
		var today = new Date();
		
		today = today.toISOString().slice(0, 10);
		
		var start = document.getElementById("start");
		var start2 = document.getElementById("start2");
		
		start.value = today;	
		start2.value = today;
		
		// 7일뒤 날짜 계산
		var last = new Date();
		
		var lastDay = new Date(last.setDate(last.getDate() + 7));
		
		lastDay = lastDay.toISOString().slice(0,10);
		
		var end = document.getElementById("end");
		var end2 = document.getElementById("end2");
		
		end.value = lastDay;
		end2.value = lastDay;
		
	};
	
	$(".1W").click(function(){
		// 7일뒤 날짜 계산
		var last = new Date();
		
		var lastDay = new Date(last.setDate(last.getDate() + 7));
		
		lastDay = lastDay.toISOString().slice(0,10);

		var start = document.getElementById("start");
		var start2 = document.getElementById("start2");
		var end = document.getElementById("end");
		var end2 = document.getElementById("end2");
		
		start.value = lastDay;
		start2.value = lastDay;
		end.value = lastDay;
		end2.value = lastDay;
	});
	
	$(".1M").click(function(){
		// 1달뒤 날짜 계산
		var last = new Date();
		
		var lastDay = new Date(last.setMonth(last.getMonth() + 1));
		
		lastDay = lastDay.toISOString().slice(0,10);

		var start = document.getElementById("start");
		var start2 = document.getElementById("start2");
		var end = document.getElementById("end");
		var end2 = document.getElementById("end2");
		
		start.value = lastDay;
		start2.value = lastDay;
		end.value = lastDay;
		end2.value = lastDay;
	});
	
	$(".3M").click(function(){
		// 3달뒤 날짜 계산
		var last = new Date();
		
		var lastDay = new Date(last.setMonth(last.getMonth() + 3));
		
		lastDay = lastDay.toISOString().slice(0,10);

		var start = document.getElementById("start");
		var start2 = document.getElementById("start2");
		var end = document.getElementById("end");
		var end2 = document.getElementById("end2");
		
		start.value = lastDay;
		start2.value = lastDay;
		end.value = lastDay;
		end2.value = lastDay;
	});
	
	$(".6M").click(function(){
		// 6달뒤 날짜 계산
		var last = new Date();
		
		var lastDay = new Date(last.setMonth(last.getMonth() + 6));
		
		lastDay = lastDay.toISOString().slice(0,10);

		var start = document.getElementById("start");
		var start2 = document.getElementById("start2");
		var end = document.getElementById("end");
		var end2 = document.getElementById("end2");
		
		start.value = lastDay;
		start2.value = lastDay;
		end.value = lastDay;
		end2.value = lastDay;
	});
	
	$(".search_button").click(function(){
		
		var date1 = $("#start").val();
		var date2 = $("#end").val();
		var date3 = $("#start2").val();
		var date4 = $("#end2").val();
		
		if(date1 != "" && date2 != "") {
			var startDate = date1.split('-');
			var endDate = date2.split('-');
			
			var startComp = new Date(startDate[0], parseInt(startDate[1])-1, startDate[2]);
			var endComp = new Date(endDate[0], parseInt(endDate[1])-1, endDate[2]);
			
			if(startComp.getTime() > endComp.getTime()) {
				alert("시작날짜와 종료날짜를 확인해 주세요.");
				
				return;
			}
			
			$(".search_button>button").submit();
			
		}
		
		if(date3 != "" && date4 != "") {
			var startDate = date3.split('-');
			var endDate = date4.split('-');
			
			var startComp = new Date(startDate[0], parseInt(startDate[1])-1, startDate[2]);
			var endComp = new Date(endDate[0], parseInt(endDate[1])-1, endDate[2]);
			
			if(startComp.getTime() > endComp.getTime()) {
				alert("시작날짜와 종료날짜를 확인해 주세요.");
				
				return;
			}
			
			$(".search_button>button").submit();
		}
		
	});
	
	
});