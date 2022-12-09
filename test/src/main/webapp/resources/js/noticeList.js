//페이지가 열리면 셀렉트 박스와 기본 리스트를 호출한다


var currentPage = 1;
//listCall을 부를때마다 보여질 페이지의 첫번재 숫자?

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

//셀렉트 박스 호출 이벤트
$(document).ready(function(){
    
	pageList(currentPage); //리스트호출
	
    $.ajax({
       type:'get',
       url:"notice/selectList.ajax",
       data:{},
       dataType: 'JSON',
       success: function(data){
           console.log(data.stList);
           console.log(data.cpList);
           console.log(data.ahType);
            
        	  
         //현장명 for문으로 넣기
		  for (var i in data.stList){
		   $('#stName').append(//셀렉트 박스에 들어가있는 id
		   '<option value="'+data.stList[i].SITE_CODE+'">'+data.stList[i].SITE_NAME+'</option>'
		   		)
    		  
		  }
    	  //업체명 for문으로 넣기
    	  for (var i in data.cpList){
    		  $('#cpName').append(//셀렉트 박스에 들어가있는 id
    		  '<option value="'+data.cpList[i].COMPANY_CODE+'">'+data.cpList[i].COMPANY_NAME+'</option>'
	   		)
		  	
          }
    
         
       },
       error:function(e){
           console.log(e);
       }
   });
});


  /*
$(document).ready(function(){
    
	$.ajax({
		// url : '/ajax-test/list.json', // list.json 문자데이터
		// url : '/ajax-test/list.jsp', // list.jsp실행결과 json문자 데이터
		// 요청이 페이지가 아닌데 jsp를 굳이....
		// 서블릿을 요청
		
		url : '/notice/noticeList.ajax',
		type : 'post',
		success : function(json) { // 매개변수 : 응답된 문자열 -> jquery api에서 자바스크립트 객체 변경
			// alert(json);
			
			$('#insertList').empty();
			
			$(json).each(function(index, item){
				let html = '';
				html += '<tr>'
				html += 	'<td>'+item.NOTICE_NO+'</td>';
				html += 	'<td>'+item.SITE_NAME+'</td>';
				html += 	'<td>'+item.NOTICE_TITLE+'</td>';
				html += 	'<td>'+item.NOTICE_CONTENT+'</td>';
				html += 	'<td>'+item.WRITER+'</td>';
				html += 	'<td>'+item.COMPANY_NAME+'</td>';
				html += 	'<td>'+item.VIEWS+'</td>';
				html += 	'<td>'+item.CREATE_DATE+'</td>';
				html += 	'<td>'+item.UPDATE_DATE+'</td>';
				html += '</tr>'
				$('#insertList').append(html);
			}); 
		},
		error : function(err) {
			alert('실패!');
			console.log(err);
		}
	});
});
    */



//검색어입력 후 검색 버튼 눌렀을 때 발생하는 이벤트
$('#btn_search').on("click",function(){
    if($('#keyword').val() != ""){ //키워드가 빈칸이 아니라면
        $('#pagination').twbsPagination('destroy'); // 페이징 리스트 호출
        pageList(currentPage);
    }else{
        alert("검색어를 입력해주세요.");
    }
});



//페이징+검색값?에 대한 리스트 호출
function pageList(page){
     var currentPage = $('#sorting').val(); //구분값 최신순, 최신역순 셀렉트박스에 넣은 id
     var st_name= $('#st_name').val();//
     var cp_name = $('#cpName').val();
     var keyword = $('#keyword').val();
     var searchType = $('#searchType').val();
     console.log("sorting :"+ sorting);
     console.log("stName : " + stName);
     console.log("cpName : " + cpName);
     console.log("searchType : " + searchType);
     console.log("keyword : " + keyword);


    $.ajax({
        type:'get',
        url:"notice/list.ajax",
        data:{
            'sorting' : sorting,
            'stName' : stName,
            'cpName' : cpName,
            'keyword' : keyword,
            'searchType' : searchType,
        	'page' : page
        },
        dataType: 'JSON',
        success: function(data){
        	drawList(data.noticeList);

            //플러그인 이용해 페이징 처리
            currentPage = data.currentPage;
            if(data.noticeList.length>0){
            $("#pagination").twbsPagination({
                startPage : 1, //시작페이지
                totalPages : 1, //총 페이지(전체게시물 수 / 한페이지에 보여줄 게시물 수)
                visiblePages : 1, // 한번에 보여줄 페이지 수 [1][2][3][4][5]
                onPageClick: function(e,page){
                    //console.log(e); 클릭한 페이지와 관련된 이벤트 객체
                    //console.log(page); // 사용자가 클릭한 페이지
                	currentPage = page;
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





function drawList(list){
	
	$.ajax({
		// url : '/ajax-test/list.json', // list.json 문자데이터
		// url : '/ajax-test/list.jsp', // list.jsp실행결과 json문자 데이터
		// 요청이 페이지가 아닌데 jsp를 굳이....
		// 서블릿을 요청
		
		url : '/notice/noticeList.ajax',
		type : 'post',
		success : function(json) { // 매개변수 : 응답된 문자열 -> jquery api에서 자바스크립트 객체 변경
			// alert(json);
			
			$('#insertList').empty();
			
			$(json).each(function(index, item){
				let html = '';
				html += '<tr>'
				html += 	'<td>'+item.NOTICE_NO+'</td>';
				html += 	'<td>'+item.SITE_NAME+'</td>';
				html += 	'<td>'+item.NOTICE_TITLE+'</td>';
				html += 	'<td>'+item.NOTICE_CONTENT+'</td>';
				html += 	'<td>'+item.WRITER+'</td>';
				html += 	'<td>'+item.COMPANY_NAME+'</td>';
				html += 	'<td>'+item.VIEWS+'</td>';
				html += 	'<td>'+item.CREATE_DATE+'</td>';
				html += 	'<td>'+item.UPDATE_DATE+'</td>';
				html += '</tr>'
				$('#insertList').append(html);
			}); 
		},
		error : function(err) {
			alert('실패!');
			console.log(err);
		}
	});
});
	