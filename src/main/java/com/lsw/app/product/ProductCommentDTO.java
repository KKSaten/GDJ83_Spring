package com.lsw.app.product;

import com.lsw.app.boards.CommentDTO;

public class ProductCommentDTO extends CommentDTO {
	
	private Long item_id;

	public Long getItem_id() {
		return item_id;
	}

	public void setItem_id(Long item_id) {
		this.item_id = item_id;
	}

}
