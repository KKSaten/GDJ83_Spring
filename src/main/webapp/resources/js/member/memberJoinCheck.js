
/**
 *
 */
 
 //alert('member check');
 // let, const

 const join_btn = document.getElementById("join_btn");
 const member_id = document.getElementById("member_id");
 const member_pw = document.getElementById("member_pw");
 const member_pw_ck = document.getElementById("member_pw_ck");
 const member_name = document.getElementById("member_name");
 const member_phone = document.getElementById("member_phone");
 const member_email = document.getElementById("member_email");
 const join_info = document.getElementsByClassName("join_info");
 const frm = document.getElementById("frm");
 const password_error = document.getElementById("password_error")
 const password_eqError = document.getElementById("password_eqError")


member_pw.addEventListener("blur", function() {
	if(member_pw.value=="") {
		password_error.innerHTML="Password는 필수입니다";
		return;
	}
	
	if(member_pw.value.length<6) {
		password_error.innerHTML="Password는 6글자 이상이어야 합니다";
	}
})


member_pw_ck.addEventListener("blur",function(){
	if(member_pw.value==member_pw_ck.value){
		password_eqError.innerHTML="Password가 일치합니다";
	}else{
		password_eqError.innerHTML="Password가 일치하지 않습니다";
		member_pw_ck.value="";
	}
	
	if(member_pw.value.length<6) {
		password_error.innerHTML="Password는 6글자 이상이어야 합니다";
	}
})


member_pw.addEventListener("change",function(){
    if(member_pw.value==member_pw_ck.value){
        password_eqError.innerHTML="Password가 일치합니다";
    }else{
        password_eqError.innerHTML="Password가 일치하지 않습니다";
        member_pw_ck.value="";
        member_pw_ck.focus();
    }
    
    if(member_pw.value.length<6) {
		password_error.innerHTML="Password는 6글자 이상이어야 합니다";
	}else {
		password_error.innerHTML="";
	}

})


join_btn.addEventListener("click",function(){
	
	if(member_id.value=="" || member_pw.value=="" || member_name.value=="" || member_phone.value=="" || member_email.value==""){
    	alert("모든 항목을 입력해주시길 바랍니다");
    	id_error.innerHTML="ID는 필수입니다";
    	password_error.innerHTML="Password는 필수입니다";
    	password_eqError.innerHTML="";
    	member_id.focus();
	}else{
		frm.submit();
		return;
	}
	
	if(member_pw.value.length < 6){
		password_eqError.innerHTML="";
		password_error.innerHTML="Password는 6글자 이상이어야 합니다";
		member_pw.focus();
	}

})














