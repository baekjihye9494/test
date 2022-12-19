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
				'<option value="'+data.site[i].siteCode+'">'+data.site[i].siteName+'</option>'
				)
			}
			
			/*업체명 select box에 넣기*/
			//$('#cp_code').empty(); 
			for (var i in data.company){
				$('#select_cp_code').append(
				'<option value="'+data.company[i].cpCode+'">'+data.company[i].cpName+'</option>'
				)
			}
			
			$('#loginId').text(data.loginId + "님");
			
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
			location.href="/login.html";
				
			},
			error:function(e){
				console.log(e);
			}
		});
 }
 
 
 
 
 
 
$('#sorting, #site_code, #select_cp_code').on("change", function(){
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
	 var select_cp_code = $('#select_cp_code').val();
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
			'select_cp_code' : select_cp_code,
			'search_option' : search_option,
			'search_keyword' : search_keyword,
			'page' : page
		},
		dataType: 'JSON',
		success: function(data){
			drawList(data.noticeList);
			
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
	var today_date = new Date(); //이거 왜 12월 1일에 머물러있지? 12월 2일부터 에약글이던데. 됐다가 안되는 이유가 뭐야 ? 그래서 today_date와 noti_date로 만 비교함 
	//var today = today_date.toLocaleString("ko-KR");
	console.log("현재날짜 :"+ today_date);
	//console.log(list);
	//console.log(list[0].athGb);
	
	if(list.length > 0){
		
	//관리자만 공개여부 컬럼 보일 수 있도록
	if(list[0].athGb == 'Y'){
		theadContent += '<th>공개여부</th>';
	}
		list.forEach(function(item,idx){
			var noti_date = new Date(item.notiDate);
			//var noti_date = date.toLocaleString("ko-KR");
			//console.log("게시날짜 : " + noti_date);
			
			content += '<tr>';
			content += '<td>'+item.notiCode+'</td>';
			content += '<td>'+item.siteName+'</td>';
			content += '<td>'+item.cpName+'</td>';
			content += '<td><a href="detail.html?noti_code='+item.notiCode+'">';
			if(today_date < noti_date){
				content += "[예약] ";
			}
			content += item.notiSubject+'</a></td>';
			if(item.athGb == 'Y'){
				content += '<td>'+item.notiOpentype+'</td>';
			}
			content += '<td>'+item.mbName+'</td>';
			content += '<td>'+noti_date.toLocaleDateString("ko-KR")+'</td>';
			content += '</tr>';	
		});
	}else{
		content += '<td colspan="6" style="text-align:center">작성된 공지가 없습니다. </td>';
	}
	
	$("#noticeList").empty();
	$("#noticeList").append(content);
	
	//listCall()할때마다 '공개여부' 컬럼이 추가되는걸 막기위해서
	if($("#thead").find("th").eq(4).text() == '공개여부'){
		$("#thead").find("th").eq(4).remove();
	}
	$("#thead").find("th").eq(3).after(theadContent);
};

	