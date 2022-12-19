/**
 * 
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

 
//페이지가 시작했을 때 현장과 업체를 선택할 셀렉트박스 불러오기(재활용함)
$(document).ready(function(){
		
				
	 $.ajax({
			type:'get',
			url:"notice/selectList.ajax",
			data:{},
			dataType: 'JSON',
			success: function(data){
				console.log(data.site);
				console.log(data.company);
				
						for (var i in data.site){
							$('#site_code').append(
							'<option value="'+data.site[i].siteCode+'">'+data.site[i].siteName+'</option>'
							)
						}
					 	for (var i in data.company){
							$('#company_code').append(
							'<option value="'+data.company[i].companyCode+'">'+data.company[i].companyName+'</option>'
							)
					 	}
				
			},
			error:function(e){
			console.log(e);
			}
					 
		 });
	});
				 
/*
function name(ahType){ //map.put("detail",detail);에 담은 이름 불러주기
 	 
	 var content = "";

			//리스트 for문 돌려서 리스트를 호출
			console.log(ahType);
			content += '<tr>';
			content += '<th>작성자</th>';
			content += '<input value="'+ahType.MEMBER_NAME+'" type="text">';
				
		$("#name").append(content);
		console.log(content);
	};

*/

//등록 버튼 눌렀을 때 이벤트
$('#noticeAdd').click(function() {
	
	 var notice_title = $('#notice_title').val();
	 var notice_content= $('#notice_content').val();
	 var site_code = $('#site_code').val();
	 var company_code = $('#company_code').val();
	  
	 
		//유효성검사 먼저
		if($('#notice_title').val() == ""){
	        alert("제목을 입력하세요");
	        $("#notice_title").focus();
	        return false;
	    }else if ($('#notice_content').val() == "") {
	        alert("내용을 입력하세요");
	        $("#notice_content").focus();
	        return false;
	    }else if ($('#company_code').val() == "") {
	        alert("업체를 선택하세요");
	        $("#company_code").focus();
	        return false;
	    }else if ($('#site_code').val() == "") {
	        alert("현장을 선택하세요");
	        $("#site_code").focus();
	        return false;
	    }
		
    	//ajax로 보냄
        $.ajax({
    		type:'get',
    		url:"notice/add.ajax",
    		data:{
    			'notice_title' : notice_title, 
                'notice_content' : notice_content, 
                'site_code' : site_code,
                'company_code' : company_code
    		},
    		dataType: 'JSON',
			success: function(data){
				console.log(data.notice);
				
				if(data.notice > 0) {
					location.href="/noticeList.html";
				}else{
					alert("공지를 등록 할 수 없습니다 관리자에게 문의하세요.");
					location.href="/addNotice.html";
				}
			},
			error:function(e){
				console.log(e);
			}
     });
});


	 