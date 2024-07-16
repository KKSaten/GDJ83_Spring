package com.lsw.app.boards.qna;

import com.lsw.app.boards.BoardDTO;

public class QnaDTO extends BoardDTO {
	
	private Integer del;
	
	
	//본래는 글번호 desc순으로 정렬을 했다 하지만 답글이 있다면 지금까지처럼 정렬시킬 수 없다
	

	private Long ref;	//글들을 그룹으로 묶는 용도 (원본글과 그 밑의 답글들을 묶을 것임)
						//원본글 : 자기 자신의 글 번호가 REF값으로 입력
						//답글 : 부모글의 REF값이 자기의 REF값으로 입력
	
	private Long step;	//그룹내에서 순서를 정하는 용도(1번글의 답글 1-1과 또 그의 답글 1-1-1일 경우 이 정렬 순서를 결정)
						//원본글 : 0
						//답글
						//	a) ref가 부모의 ref와 같고 step이 부모의 step보다 큰 것들을 
						//	   찾아서 step에 +1한 값으로 업데이트 (1, 1-1, 1-1-1이 존재하는 상태에서 이후 다시 1-2가 들어올 수 있으므로)
						//	b) 부모글의 step에 +1한 값을 자기의 step 값으로 입력
	
	
	private Long depth;	//jsp에 출력시 들여쓰기 횟수를 정할 것임(	원본글
						//									ㄴ답글		이렇게)
						//원본글 : 0
						//답글 : 부모글의 depth에 +1한 값을 자기의 depth 값으로 입력


//	최종적으로는 이런형태로 나오게끔	
	
//	SELECT * FROM QNA ORDER BY REF DESC, STEP ASC
	
//	글번호		제목						REF			STEP		DEPTH
//	2			2						2			0			0
//	4			 ㄴ2-1					2			1			1
//	1			1						1			0			0
//	7			 ㄴ1-2					1			1			1
//	8			  ㄴ1-2-1				1			2			2
//	3			 ㄴ1-1					1			3			1
//	5			  ㄴ1-1-1				1			4			2
//	6			   ㄴ1-1-1-1				1			5			3
	
	
	public Long getRef() {
		return ref;
	}
	public void setRef(Long ref) {
		this.ref = ref;
	}
	public Long getStep() {
		return step;
	}
	public void setStep(Long step) {
		this.step = step;
	}
	public Long getDepth() {
		return depth;
	}
	public void setDepth(Long depth) {
		this.depth = depth;
	}
	public Integer getDel() {
		return del;
	}
	public void setDel(Integer del) {
		this.del = del;
	}

}
