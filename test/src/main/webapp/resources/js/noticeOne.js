/**
 * 
 */

function getParameterByName(name) {
      name = name.replace(/[\[]/, "\\[").replace(/[\]]/, "\\]");
      var regex = new RegExp("[\\?&]" + name + "=([^&#]*)"),
      results = regex.exec(location.search);
      return results == null ? "" : decodeURIComponent(results[1].replace(/\+/g, " "));
}

 

var patId = getParameterByName('notice_no'); 
console.log(patId);

 $(document).ready(function(){

 	
	 $.ajax({
	 		type:'get',
	 		url:"notice/detail.ajax",
	 		data:{
	 			'notice_no' : patId
	 		},
	 		dataType: 'JSON',
	 		success: function(data){
	 			drawList(data.detail);
	 			//drawList(data.noticeNo);
	 		}
	 })
 });
 
 function logOut(){
	 $.ajax({
			type:'get',
			url:"notice/logout",
			data:{},
			dataType: 'JSON',
			success: function(data){
			confirm("로그아웃 하시겠습니까?");
			location.href="/loginIndex.html";
				
			},
			error:function(e){
				console.log(e);
			}
		});
 }
 
 function drawList(detail){ //map.put("detail",detail);에 담은 이름 불러주기
 	 
	 var content = ""; 
	 var btnContent = "";

			//리스트 for문 돌려서 리스트를 호출
				console.log(detail);
				//	var createDate = new Date(detail.createDate);//오라클에서 타입을 date로 했으면 sql데이트타입을 선언해서 가져와야함
				content += '<tr>';
				content += '<td>번호</td>';
				content += '<td>'+detail.noticeNo+'</td>';
				content += '<td>제목</td>';
				content += '<td colspan="2">'+detail.noticeTitle+'</td>';
				content += '<td>조회수</td>';
				content += '<td>'+detail.views+'</td>';
				content += '<td>작성자</td>';
				content += '<td>'+detail.memberName+'</td>';
				content += '</tr>';
				content += '<tr>';
				content += '<td>등록일</td>';
				content += '<td>'+detail.noticeDate+'</td>';
				//content += '<td>'+createDate.toLocaleDateString("ko-KR")+'</td>';
				content += '<td>현장명</td>';
				content += '<td colspan="4">'+detail.siteName+'</td>';
				content += '<td>업체명</td>';
				content += '<td>'+detail.companyName+'</td>';
				content += '</tr>';
				content += '<tr>';
				content += '<td colspan="2">내용</td>';
				content += '<td colspan="8"><textarea  style="height:200px" background-color: #fff;" class= "form-control" readonly="readonly">'
					+detail.noticeContent+'</textarea></td>';
				content += '</tr>';
				
				btnContent+= '<button style=" display: inline-block;" class="btn success" onclick="location.href=\'update.html?notice_no='+patId+'\'">수정</button>';
				btnContent+= '<button style=" display: inline-block;" class="btn danger" onclick="remove('+patId+')">삭제</button>';
				btnContent+= '<button style=" display: inline-block;" class="btn info" onclick="location.href=\'noticeList.html\'">목록</a>';				
				
		
		$("#noticeOne").empty();
		$("#noticeOne").append(content);
		
		$("#detail").empty();
		$("#detail").append(btnContent);
		
		
	};




 	 

function remove(notice_no) {
	
		if(confirm("정말 삭제하시겠습니까?")){
			$.ajax({
				type:'get',
				url:"notice/delete.ajax",
				data:{
					'notice_no' : notice_no
					},
				dataType: 'JSON',
				success: function(data){
					console.log(data.remove);
				
				if (data.remove > 0) {
					location.href='noticeList.html';
					alort("게시글이 삭제되었습니다!");
				}	
			},
			error:function(e){
				console.log(e);
			}
		});	
	};
}