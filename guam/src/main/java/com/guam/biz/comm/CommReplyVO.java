package com.guam.biz.comm;

import java.util.Date;

public class CommReplyVO {
	private int seq;
	private int commseq;
	private String writerid;
	private String content;
	private Date regDate;
	
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public int getCommseq() {
		return commseq;
	}
	public void setCommseq(int commseq) {
		this.commseq = commseq;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriterid() {
		return writerid;
	}
	public void setWriterid(String writerid) {
		this.writerid = writerid;
	}
	
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	
	@Override
	public String toString() {
		return "CommReplyVO [seq=" + seq + ", commseq=" + commseq + ",writerid=" + writerid + ", "
				+ "content=" + content + ", regDate=" + regDate + "]";
	}
	
}
