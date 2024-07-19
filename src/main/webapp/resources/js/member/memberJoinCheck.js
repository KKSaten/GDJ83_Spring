/**
 * 
 */
 
 //alert('member check');
 // let, const

 const joinBtn = document.getElementById("joinBtn");
 const member_id = document.getElementById("member_id");
 const member_pw = document.getElementById("member_pw");
 const member_pw_ck = document.getElementById("member_pw_ck");
 const member_name = document.getElementById("member_name");
 const member_phone = document.getElementById("member_phone");
 const member_email = document.getElementById("member_email");
 const ch = document.getElementsByClassName("ch");
 const frm = document.getElementById("frm");
 const password_error = document.getElementById("password_error")
 const password_eqError = document.getElementById("password_eqError")


//빈값 있을 시 
 joinBtn.addEventListener("click",function(){
  
   if(member_id.value==""|| member_pw.value =="" ||member_name.value =="" || member_phone.value =="" || member_email.value==""){
    alert("모든 항목을 입력해주세요!");
    
   }else{
    alert("모든 항목 입력 완료!");
        //frm.submit();
   }
   if(member_id.value=="" ){
    id_error.innerHTML="id를 입력해주세요.";
    member_id.focus();
    return;
   }
  //패스워드 없을 때 글씨 나오게
   if(member_pw.value=="" ){
    password_error.innerHTML="password를 입력해주세요.";
    member_pw.focus();
    return;
   }
   if(member_pw.value.length < 6){
    password_error.innerHTML="password는 6자 이상으로 입력하세요.";
    member_pw.focus();
    return;
   }

})
member_pw_ck.addEventListener("blur",function(){
if(member_pw.value==member_pw_ck.value){
    password_eqError.innerHTML="password가 일치합니다.";
    return;
}else{
    password_eqError.innerHTML="password가 일치하지않습니다.";
    member_pw_ck.value="";
    member_pw_ck.focus();
    return;
}
})

member_pw.addEventListener("change",function(){
    if(member_pw.value==member_pw_ck.value){
        password_eqError.innerHTML="password가 일치합니다.";
        return;
    }else{
        password_eqError.innerHTML="password가 일치하지않습니다.";
        member_pw_ck.value="";
        member_pw_ck.focus();
        return;
    }

})





