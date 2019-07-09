package kr.or.ddit.batch.model;

import java.util.Date;

public class BatchVo {
	
	private int bid; //배치 번호(시퀀스)
	private String bcd; //배치코드(04")
	private String st;
	private Date st_dt;
	private Date et_dt;
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	@Override
	public String toString() {
		return "BatchVo [bid=" + bid + ", bcd=" + bcd + ", st=" + st + ", st_dt=" + st_dt + ", et_dt=" + et_dt + "]";
	}
	public String getBcd() {
		return bcd;
	}
	public void setBcd(String bcd) {
		this.bcd = bcd;
	}
	public String getSt() {
		return st;
	}
	public void setSt(String st) {
		this.st = st;
	}
	public Date getSt_dt() {
		return st_dt;
	}
	public void setSt_dt(Date st_dt) {
		this.st_dt = st_dt;
	}
	public Date getEt_dt() {
		return et_dt;
	}
	public void setEt_dt(Date et_dt) {
		this.et_dt = et_dt;
	}
	

}
