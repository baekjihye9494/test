/**
 * 로그인 관련 내용
 */

function loginChk(){
	
	
	var mb_id = $('#mb_id').val();
	var mb_pw = $('#mb_pw').val();
	console.log(mb_id);
	console.log(mb_pw);
	
	if(mb_id == "" || mb_pw == ""){
		alert("아이디 또는 비밀번호를 입력해주세요");
	}else{
		
		$.ajax({
				type:'post',
				url:"notice/login.ajax",
				data:{
					'mb_id' : mb_id,
					'mb_pw' : mb_pw
				},
				dataType: 'JSON',
				success: function(data){
					console.log('success!');
					if(!data.loginSuccess){
						alert("아이디 또는 비밀번호가 틀렸습니다.");
						location.reload();
					}else{
						location.href='/noticeList.html';
					}
				},
				error:function(e){
					console.log(e);	
				}
			});
	
	}
}