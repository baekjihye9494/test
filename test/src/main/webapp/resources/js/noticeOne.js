/**
 * 
 */

 $(document).ready(function(){

 	 var notice_no = $('#notice_no').val();
 	 
 	 detailCall(notice_no);
	 $.ajax({
	 		type:'get',
	 		url:"notice/detail.ajax",
	 		data:{
	 			'notice_no' : notice_no,
	 			'noticeOne' : noticeOne
	 		},
	 		dataType: 'JSON',
	 		success: function(data){

				 consol.log(data.noticeNo);
	 			 consol.log(data.noticeOne);
	 			//drawList(data.noticeNo);
	 		}
	 })
 });
 
 function detailCall(detail){ //map.put("detail",detail);에 담은 이름 불러주기
 	 
	 var content = "";

		
		if(noticeOne.length > 0){ //맵퍼noticeOne 이름 부르기
			//리스트의 갯수?까지 계산 한 값이 > 0 보다 크면
			noticeOne.forEach(function(item,idx){
				//리스트 for문 돌려서 리스트를 호출
				var createDate = new Date(item.createDate);//오라클에서 타입을 date로 했으면 sql데이트타입을 선언해서 가져와야함
				console.log(item);
				content += '<tr>';
				content += '<td>'+item.noticeNo+'</td>';
				content += '<td>'+item.siteName+'</td>';
				content += '<td>'+item.companyName+'</td>';
				content += '<td><a href="noticeOne.html?notice_no='+item.noticeNo+'">';
				content += item.noticeTitle+'</a></td>';
				content += '<td>'+item.memberName+'</td>';
				content += '<td>'+createDate.toLocaleDateString("ko-KR")+'</td>';
				//데이트타입으로 선언된 변수명+toLocaleDateString("ko-KR") 써줘야 한글로? 인식하고 변환돼서 나옴
				content += '<td>'+item.views+'</td>';
				content += '</tr>';	
			});
		}else{
			content += '<td colspan="6" style="text-align:center">작성된 공지가 없습니다. </td>';
		}
		
		$("#noticeOne").empty();
		$("#noticeOne").append(content);
	};



 function logOut(){
	 $.ajax({
			type:'get',
			url:"notice/logout",
			data:{},
			dataType: 'JSON',
			success: function(data){
			alert("로그아웃 되었습니다.");
			location.href="/loginIndex.html";
				
			},
			error:function(e){
				console.log(e);
			}
		});
 }



$('#modify').on("click",function(){
	if($('#notice_no').val() != ""){
		location.href="/updateNotice.html?=notice_no"+$('#notice_no').val();
	}else{
		alert("수정 할 수 없습니다.");
	}
});
 


 /**
 function modify(noticeNo) {
 	
 	
 	 $.ajax({
 			type:'get',
 			url:"notice/update.ajax",
 			data:{},
 			dataType: 'JSON',
 			success: function(data){
 				console.log(data.noticeOne);
 				
 				var chk = confirm("수정하시겠습니까?");
 				
 				if (chk) {
 					if(noticeOne.length > 0){
 						//리스트의 갯수?까지 계산 한 값이 > 0 보다 크면
 						noticeOne.forEach(function(item,idx){
 					
							location.href='updateNotice.html?=noticeNo'+item.noticeNo;
 						});
 					}
 				}else {
 					location.href='noticeList.html';
 				}
 			},
 			error:function(e){
		 		console.log(e);
			}
 	});	
 };

function remove(noticeNo) {
	
	
	 $.ajax({
			type:'post',
			url:"notice/delete.ajax",
			data:{},
			dataType: 'JSON',
			success: function(data){
				console.log(data.loginId);
				
				var chk = confirm("정말 삭제하시겠습니까?");
				
				if (chk) {
					location.href='deleteNotice.html?noticeNo='+noticeNo;
				}	
			},
			error:function(e){
				console.log(e);
			}
	});	
};
**/