/**
 * 리스트
 */


var currPage = 1;
//listCall(currPage);

 //search-line의 값 가져오기
 $(document).ready(function(){
	 
		
	 listCall(currPage);
	 $.ajax({
		type:'get',
		url:"notice/selectList.ajax",
		data:{},
		dataType: 'JSON',
		success: function(data){
			//console.log(data.site);
			//console.log(data.company);
				
			/*현장명 select box에 넣기*/
			//$('#site_code').find('option').eq(0).nextAll().empty(); // 안하면 계속 밑에 붙음
			for (var i in data.site){
				$('#site_code').append(
				'<option value="'+data.site[i].SITE_CODE+'">'+data.site[i].SITE_NAME+'</option>'
				)
			}
			
			/*업체명 select box에 넣기*/
			//$('#cp_code').empty(); 
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
 
 
 
 
 
 
$('#sorting, #site_code, #company_code').on("change", function(){
	$('#pagination').twbsPagination('destroy');
	var currPage = 1;
	listCall(currPage);
});


$('#btn_search').on("click",function(){
	if($('#search_keyword').val() != ""){
		$('#pagination').twbsPagination('destroy');
		listCall(currPage);
	}else{
		alert("검색어를 입력해주세요.");
	}
});
 
 
 
function listCall(page){
	 var sorting = $('#sorting').val();
	 var site_code= $('#site_code').val();
	 var company_code = $('#company_code').val();
	 var search_option = $('#search_option').val();
	 var search_keyword = $('#search_keyword').val();
	 //console.log("sorting :"+ sorting);
	 //console.log("site_code : " + site_code);
	 //console.log("select_cp_code : " + select_cp_code);
	 //console.log("search_option : " + search_option);
	 //console.log("search_keyword : " + search_keyword);
	 //console.log("page :" + page );
	
	 
	$.ajax({
		type:'get',
		url:"notice/list.ajax",
		data:{
			'sorting' : sorting,
			'site_code' : site_code,
			'company_code' : company_code,
			'search_option' : search_option,
			'search_keyword' : search_keyword,
			'page' : page
		},
		dataType: 'JSON',
		success: function(data){
			//drawList(data.noticeList);
			
			//플러그인 이용해 페이징 처리
			currPage = data.currPage;
			if(data.noticeList.length>0){
			$("#pagination").twbsPagination({
				startPage : 1, //시작페이지
				totalPages : data.pages, //총 페이지(전체게시물 수 / 한페이지에 보여줄 게시물 수)
				visiblePages : data.pages, // 한번에 보여줄 페이지 수 [1][2][3][4][5]
				onPageClick: function(e,page){
					//console.log(e); 클릭한 페이지와 관련된 이벤트 객체
					//console.log(page); // 사용자가 클릭한 페이지
					currPage = page;
					listCall(page);
				}
			});
			}else{
				$("#pagination").twbsPagination({
					startPage : 1, //시작페이지
					totalPages : 1, //총 페이지(전체게시물 수 / 한페이지에 보여줄 게시물 수)
					visiblePages : 1
				});
			}
		},
		error:function(e){
			console.log(e);
		}
	});
}

 
 
function drawList(list){
	var theadContent = "";
	var content = "";
	//console.log(list);
	//console.log(list[0].athGb);
	
	if(list.length > 0){
		
		list.forEach(function(item,idx){
			var date = new Date(item.notiDate);
			var noti_date = date.toLocaleString("ko-KR");
			
			content += '<tr>';
			content += '<td>'+item.noticeNo+'</td>';
			content += '<td>'+item.siteName+'</td>';
			content += '<td>'+item.companyName+'</td>';
			content += '<td><a href="noticeOne.html?notice_no='+item.noticeNo+'">';
			content += item.noticeTitle+'</a></td>';
			content += '<td>'+item.memberName+'</td>';
			content += '</tr>';	
		});
	}else{
		content += '<td colspan="6" style="text-align:center">작성된 공지가 없습니다. </td>';
	}
	
	$("#noticeList").empty();
	$("#noticeList").append(content);
	/*
	//listCall()할때마다 '공개여부' 컬럼이 추가되는걸 막기위해서
	if($("#thead").find("th").eq(4).text() == '공개여부'){
		$("#thead").find("th").eq(4).remove();
	}
	$("#thead").find("th").eq(3).after(theadContent);*/
};

	