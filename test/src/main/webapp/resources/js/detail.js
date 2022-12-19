/**
 * 상세보기
 */

//console.log(location.search);
/*정규화 표현식을 이용한 URL파라미터 값 가져오기 함수*/
function getParameterByName(name) {
	  name = name.replace(/[\[]/, "\\[").replace(/[\]]/, "\\]");
	  var regex = new RegExp("[\\?&]" + name + "=([^&#]*)"),
	  results = regex.exec(location.search);
	  return results == null ? "" : decodeURIComponent(results[1].replace(/\+/g, " "));
}

var patId = getParameterByName('noti_code'); 
console.log(patId);
 
  

$(document).ready(function(){
	$.ajax({
		type:'get',
		url:"notice/detail.ajax",
		data:{
			'noti_code' : patId
		},
		dataType: 'JSON',
		success: function(data){
			console.log(data);
			drawDetail(data);
			if(data.ath_gb == 'Y'){
				drawCheckList(data.noticeCheckList);
			}
		},
		error:function(e){
			console.log(e);
		}
	});	 
	
});


function drawDetail(data){
	var content = "";
	var detailInfo = data.noticeDetail;
	var loginId = data.loginId;
	//console.log(detailInfo);
	console.log(data.loginId_cp_code);
	
	content += '<tr><td colspan="2" style="font-size:20px;">';
	content += detailInfo.notiSubject + '</td></tr>';
	content += '<tr><td>';
	content += detailInfo.mbName + '<span class="txt_bar"></span>';
	content += detailInfo.siteName + '<span class="txt_bar"></span>';
	content += detailInfo.cpName + '<span class="txt_bar"></span>';
	content += detailInfo.notiDateString + '</td>';
	if(loginId == detailInfo.mbId){
		content += '<td style="text-align : right;">';
		if(detailInfo.notiOpentype == 'Y'){
			content += '공개';
		}else{
			content += '비공개';
		}
		content += '<span class="txt_bar"></span>';
		content += '<span class="change" onclick="location.href=\'update.html?noti_code='+detailInfo.notiCode+'\'">수정</span><span class="txt_bar"></span>';
		content += '<span class="change" onclick="delNotice('+detailInfo.notiCode+')">삭제</span>';
		content += '</td>';
	}else if(loginId != detailInfo.mbId && data.loginId_cp_code == detailInfo.cpCode ){ //작성자는 아니지만 업체가 같을 때
		console.log("얍!!!!!!!!");
		content += '<td style="text-align : right;">';
		if(detailInfo.notiOpentype == 'Y'){
			content += '공개';
		}else{
			content += '비공개';
		}
		content += '<span class="txt_bar"></span>';
		content += '<span class="change" onclick="location.href=\'update.html?noti_code='+detailInfo.notiCode+'\'">수정</span>';
		content += '</td>';
	}
	content += '</tr>';
	content += '<tr>';
	content += '<td colspan="2" style="weight : 100px; height : 300px;">';
	content += detailInfo.notiContent;
	content += '</td>';
	content += '</tr>';
	
	$('#detailTable').empty();
	$('#detailTable').append(content);
}




//게시글 확인 리스트 
function drawCheckList(list){
	console.log(list);
	var content = "";
	//console.log(loginId);
	content += '<div id="noticeCheckList">';
	content += '<div><h4 id="checkListSubject">[게시글 조회 리스트]</h4></div>';
	content += '<div id="checkList">';
	if(list.length > 0){
		list.forEach(function(item,idx){
			console.log(item.MB_ID);
			content += '<ul>';
			content += '<li>'+item.MB_NAME+'</li>';
			content += '</ul>';
		});
	}else{
		content += '<p>게시글을 조회한 회원이 없습니다</p>';
	}
	content += '</div>';
	content += '</div>';
	
	$('#detailTable').before(content);
	
}





//삭제버튼
function delNotice(noti_code){
	if(confirm("공지글을 삭제하시겠습니까?")){
		$.ajax({
			type:'get',
			url:"notice/delete.ajax",
			data:{
				'noti_code' : noti_code
			},
			dataType: 'JSON',
			success: function(data){
				console.log(data.noticeDelete);
				if(data.noticeDelete){
					location.href="/noticeList.html";
				}
			},
			error:function(e){
				console.log(e);
			}
		});	 
	}
} 