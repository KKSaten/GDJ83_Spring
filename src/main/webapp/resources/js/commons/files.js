

const add_btn = document.getElementById("add_btn");
const result = document.getElementById("result");


let idx = 0;		//부모의 id값으로 사용
let max = 1;		//최대 첨부파일 갯수 조정
let count = 0;		//만든 횟수


function setMax(m){
    max=m;
}


//파일 추가 누르면 파일이 생성됨
add_btn.addEventListener("click", function() {

    if(count >= max) {
        alert("첨부파일은 최대" + max + "개만 가능합니다");
        return;
    }

    let parent = document.createElement("div");         //<div>
    parent.id = "file" + idx;
    parent.classList.add("input-group", "mb-3");        //<div class="input-group mb-3">

    let input = document.createElement("input");        //<input>
    input.type = "file";                                //<input type="file">
    input.name = "files";                               //<input type="file" name="files">
    input.classList.add("form-control");  				//<input type="file" name="files" class="form-control">
    
    parent.append(input);                               //<div class="input-group mb-3">
                                                        //  <input type="file" class="form-control join_info">
                                                        //<div/>

    //let div = document.createElement("div");
    //div.classList.add("input-group-append");
    let span = document.createElement("span");
    span.classList.add("input-group-text");
    span.id="del";
    span.setAttribute("data-del-id", "file" + idx);
    span.innerText="X";

    //div.append(span);

    parent.append(span);

    result.append(parent);

    idx++;
    count++;

})

   
result.addEventListener("click", function(e) {
    if(e.target.id =="del") {
        // e.target.parentNode.parentNode.remove();
        let ids = e.target.getAttribute("data-del-id");
        document.getElementById(ids).remove();
        count--;
    }

})