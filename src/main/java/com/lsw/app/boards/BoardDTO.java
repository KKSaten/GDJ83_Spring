package com.lsw.app.boards;

import java.sql.Date;
import java.util.List;

public class BoardDTO extends CommentDTO{
	private String boardTitle;
	private Date updateDate;
	private String boardCategory;
	private Integer boardHit;
	private Integer del;
	private List<BoardFileDTO> boardFileDTOs;
	
	public List<BoardFileDTO> getBoardFileDTOs() {
		return boardFileDTOs;
	}
	public void setBoardFileDTOs(List<BoardFileDTO> boardFileDTOs) {
		this.boardFileDTOs = boardFileDTOs;
	}
	public Integer getDel() {
		if(this.del == null) {
			this.del = 0;
		}
		return del;
	}
	public void setDel(Integer del) {
		this.del = del;
	}
	
	public String getBoardTitle() {
		return boardTitle;
	}
	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	public String getBoardCategory() {
		return boardCategory;
	}
	public void setBoardCategory(String boardCategory) {
		this.boardCategory = boardCategory;
	}
	public Integer getBoardHit() {
		return boardHit;
	}
	public void setBoardHit(Integer boardHit) {
		this.boardHit = boardHit;
	}
	
	
	

}
