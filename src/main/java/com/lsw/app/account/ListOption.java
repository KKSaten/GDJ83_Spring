package com.lsw.app.account;

public class ListOption {
	
	private String bank_id;
	
	private Integer order;// 0 desc, 1 asc
	
	private Integer io; // 1 출금 0 입금

	public Integer getIo() {
		return io;
	}

	public void setIo(Integer io) {
		this.io = io;
	}

	public String getBank_id() {
		return bank_id;
	}

	public void setBank_id(String bank_id) {
		this.bank_id = bank_id;
	}

	public Integer getOrder() {
		return order;
	}

	public void setOrder(Integer order) {
		this.order = order;
	}
	
	
	
}
