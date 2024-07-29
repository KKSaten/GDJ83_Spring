

const commentButton = document.getElementById("commentButton");
const commentContents = document.getElementById("commentContents");
const commentClose = document.getElementById("commentClose");
const commentList = document.getElementById("commentList");


getList(1);

function getList(page) {
	fetch("commentList?item_id=" + commentButton.getAttribute("data-id") + "&page=" + page , {
		method:"GET"
	})
	.then(r=>r.text())
	.then(r=>commentList.innerHTML=r)

}

commentList.addEventListener("click", (e)=> {
	// e.preventDefault();
	if(e.target.classList.contains("pn")) {
		let p = e.target.getAttribute("data-page-num");
		getList(p);
	}

})



//삭제버튼을 포함한 commentList.jsp는 처음부터가 아닌 이후에 생성되므로 버튼에 직접적으로 이벤트를 걸 수 없다
commentList.addEventListener("click", (d)=> {
	if(d.target.classList.contains("delBtn")) {
		let id = d.target.getAttribute("data-del-id");
		fetch("commentDelete", {
			method:"POST",
			headers:{
				"Content-type":"application/x-www-form-urlencoded"
			},
			body:"boardNum=" + id
		})
		.then(r=>r.text())
		.then(r=>{
			r=r.trim();
			if(r>0){
				alert("삭제 성공")
				getList(1)
			}else {
				alert("삭제 실패")
			}
		})
	}
})

commentButton.addEventListener("click", ()=> {
	commentClose.click();
	let contents = commentContents.value;
	
	//ajax 파라미터
	fetch("commentAdd", {
		method:"POST",
		headers:{
			"Content-type":"application/x-www-form-urlencoded"
		},
		body:"boardContents=" + contents + "&item_id=" + commentButton.getAttribute("data-id")
	})
    .then(r=>r.text())
    .then(r=>{
        r=r.trim();
        if(r>0){
            alert('댓글추가')
            getList(1);
        }
    })
	
	commentContents.value="";
})