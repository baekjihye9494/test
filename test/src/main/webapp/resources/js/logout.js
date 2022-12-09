/**
 * 
 */
function logOut(){
	
	
	 $.ajax({
		 type:'post',
         url:"member/logOut.ajax",
         data:{},
         dataType: 'JSON',
         success: function(session){
        	 location.href='/loginIndex.html';
        }
	 });
}
	 



