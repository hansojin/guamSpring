package com.guam.biz.study;

import java.util.Date;

public class ChatVO {
	private int idx;
	private int seq;
	private String writerid;
	private String content;
	private Date regDate;
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getWriterid() {
		return writerid;
	}
	public void setWriterid(String writerid) {
		this.writerid = writerid;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	
	@Override
	public String toString() {
		return "ChatVO [idx=" + idx + ", seq=" + seq + ", writerid=" + writerid + ", "
				+ "content=" + content + ", regDate=" + regDate + "]";
	}
}
