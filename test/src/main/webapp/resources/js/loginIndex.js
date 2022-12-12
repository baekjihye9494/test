/**
 * 
 */


function loginChk(){
    
    
    var member_id = $('#member_id').val();
    var member_pw = $('#member_pw').val();
    console.log(member_id);
    console.log(member_pw);
    
    
    if(member_id == "" || member_pw == ""){
        alert("아이디 또는 비밀번호를 입력해주세요");
    }else{
        
        $.ajax({
                type:'post',
                url:"notice/login.ajax",
                data:{
                    'member_id' : member_id,
                    'member_pw' : member_pw
                },
                dataType: 'JSON',
                success: function(data){
                    console.log('success!');
                    if(!data.loginSuccess){
                        alert("아이디 또는 비밀번호가 틀렸습니다.");
                        location.reload();
                    }else{
                        location.href='/noticeList.html';
                        console.log("성공!");
                    }
                },
                error:function(e){
                    console.log(e);    
                }
            });
    
    }
}