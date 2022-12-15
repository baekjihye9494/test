/**
 * 
 */


 $(document).ready(function(){
	 
		
	 $.ajax({
		type:'get',
		url:"notice/noticeOne.ajax",
		data:{},
		dataType: 'JSON',
		success: function(data){
			console.log(data.loginId);
			
			
			var content = "";
			
			if(noticeOne.length > 0){
				//리스트의 갯수?까지 계산 한 값이 > 0 보다 크면
				noticeOne.forEach(function(item,idx){
					console.log(item);
					//리스트 for문 돌려서 리스트를 호출
					console.log(item);
					content += '<tr>';
					content += '<td>'+item.noticeNo+'</td>';
					content += '<td>'+item.noticeTitle+'</td>';
					content += '<td>'+item.views+'</td>';
					content += '<td>'+item.memberName+'</td>';
					content += '</tr>';	
					content += '<tr>';
					content += '<td>'+item.noticeDate+'</td>';
					content += '<td>'+item.siteName+'</td>';
					content += '<td>'+item.companyName+'</td>';
					content += '</tr>';	
					content += '<tr>';
					content += '<td><<textarea>'+item.noticeContent+'</textarea></td>';
					content += '</tr>';						
				});
			}else{
				content += '<td colspan="6" style="text-align:center">작성된 공지가 없습니다. </td>';
			}
			
			$("#noticeOne").empty();
			$("#noticeOne").append(content);

		
		},
		error:function(e){
			console.log(e);
		}
	});	 
 });