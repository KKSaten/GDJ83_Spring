const add_btn = document.getElementById("add");
const result = document.getElementById("result");

//부모의 id값으로 사용
let idx =0;
//최대 첨부파일 갯수 조정
let max = 1;

//만든 횟수
let count = 0;

function setMax(m){
    max=m;

}


//파일 추가 누르면 파일이 생성됨
add_btn.addEventListener("click",function(){

    if(count>=max){
        alert("첨부파일은 최대 " + max + "개만 가능합니다.");
        return;
    }

    let parent = document.createElement("div"); //<div>
    parent.id="file"+idx;
    parent.classList.add("input-group","mb-3"); //<div class = "input-group mb-3">

   let input = document.createElement("input"); //<input>
   input.type="file";   //<input type = "file">
   input.name="files";
   
   input.classList.add("form-control"); //<input type = "file" class = "form-control">
   parent.append(input); //<div class = "input-group mb-3">  <input type = "file" class = "form-control">

   
  // let div = document.createElement("div");//<div>
   //div.classList.add("form-floating");//<div class = "form-floating">
  
   let span = document.createElement("span"); //<sapn>
   span.classList.add("input-group-text"); //<sapn class = "input-group-text">
   span.innerText="X";  //<sapn class = "input-group-text"> X
   span.id="spant";
   span.setAttribute("date-spant-id","file"+idx);//부모의 id명이 나옴


   parent.append(span); // <input type = "file" class = "form-control"> <sapn class = "input-group-text"> X
   result.append(parent);

   idx++;
   count++;
   });

//파일삭제
let spant = document.getElementsByClassName("input-group-text");
   
result.addEventListener("click",function(e){
    if(e.target.id=="spant"){//span태그 클릭
       //alert("spant");
      console.log(e.target.parentNode.parentNode);
      //e.target.parentNode.remove();
     let ids = e.target.getAttribute("date-spant-id");
     document.getElementById(ids).remove();
     count--;

    }

})