/**
 * 수정하기
 */

// 로그아웃 이벤트
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


//url 파라미터 값 가져오기
function getParameterByName(name) {
	  name = name.replace(/[\[]/, "\\[").replace(/[\]]/, "\\]");
	  var regex = new RegExp("[\\?&]" + name + "=([^&#]*)"),
	  results = regex.exec(location.search);
	  return results == null ? "" : decodeURIComponent(results[1].replace(/\+/g, " "));
}

var patId = getParameterByName('notice_no'); 
console.log(patId);


//search-line의 값 가져오기
$(document).ready(function(){
	
	 $.ajax({
		type:'get',
		url:"notice/detail.ajax",
		data:{
			'notice_no' : patId
		},
		dataType: 'JSON',
		success: function(data){
			console.log(data.site);
			console.log(data.company);
			console.log(data.detail);
			console.log(data.detail.siteCode);
			var detail = data.detail;
				
			/*현장명 select box에 넣기*/
			//$('#site_code').find('option').eq(0).nextAll().empty(); // 안하면 계속 밑에 붙음
			for (var i in data.site){
				$('#site_code').append(
				'<option value="'+data.site[i].siteCode+'">'+data.site[i].siteName+'</option>'
				)
				
				if(data.site[i].siteCode==detail.siteCode){
					$('#site_code').val(detail.siteCode).prop("selected",true);
				}
			}
			
			/*업체명 select box에 넣기*/
			//$('#cp_code').empty(); 
			for (var i in data.company){
				$('#company_code').append(
				'<option value="'+data.company[i].companyCode+'">'+data.company[i].companyName+'</option>'
				)
				if(data.company[i].companyCode==detail.companyCode){
					$('#company_code').val(detail.companyCode).prop("selected",true);
				}
			}
			
			
			detailModify(detail);
 			
		},
		error:function(e){
			console.log(e);
		}
	});	 
	 
	 
	 
});

function detailModify(detail){

	 var content = ""; 
	 var btnContent = "";	
	 	content += '<tr>';
		content += '<td>번호</td>';
		content += '<td>'+detail.noticeNo+'</td>';
		content += '<td>제목</td>';
		content += '<td colspan="2"><input type="text" id ="notice_title" value="'+detail.noticeTitle+'"style="border-style: none; outline: none 0px; width: 100% "/></td>';
		content += '<td>작성자</td>';
		content += '<td>'+detail.memberName+'</td>';
		content += '</tr>';
		content += '<tr>';
		content += '</tr>';
		content += '<tr>';
		content += '<td colspan="2">내용</td>';
		content += '<td colspan="8"><textarea id ="notice_content"style="height:200px" >'
			+detail.noticeContent+'</textarea></td>';
		content += '</tr>';
		
		btnContent+= '<button style=" display: inline-block;" class="btn success" onclick="modify()">완료</button>';
		btnContent+= '<button style=" display: inline-block;" class="btn info" onclick="location.href=\'noticeOne.html?notice_no='+patId+'\'">취소</button>';
				
		
		$("#detailModify").empty();
		$("#detailModify").append(content);
		
		$("#btn").empty();
		$("#btn").append(btnContent);

}


function modify(){	
	
	var site_code= $('#site_code').val();
	var company_code = $('#company_code').val();
	var notice_title = $('#notice_title').val();
	var notice_content = $('#notice_content').val();	
	console.log("현장 코드 : "+ site_code);
	console.log("업체 코드 : "+ company_code);
	console.log("제목 : " + notice_title);
	console.log("내용 : " + notice_content);
	
	//유효성 검사
	if(site_code == ""){
		alert("현장명을 선택해 주세요.");
		$('#site_code').focus();
	}else if(company_code == ""){
		alert("업체명을 선택해 주세요.");
		$('#company_code').focus();
	}else if(notice_title == ""){
		alert("제목을 입력해 주세요.");
		$('#notice_title').focus();
	}else if(notice_content == ""){
		alert("내용을 입력해 주세요.");
		$('#notice_content').focus();
	}else{
		

		$.ajax({
			type:'get',
			url:"notice/update.ajax",
			data:{
				'site_code' : site_code,
				'company_code' : company_code,
				'notice_title' : notice_title,
				'notice_content' : notice_content,
				'notice_no' : patId
				
			},
			dataType: 'JSON',
			success: function(data){
				console.log(data.modify);
				if(data.modify > 0){
					alert("정상적으로 수정됐습니다.");
					location.href="/noticeOne.html?notice_no="+patId;
				}else {
					alert("공지글 작성에 실패했습니다.");
				}
			},
			error:function(e){
				console.log(e);
			}
		});
	}
}
