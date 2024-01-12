package com.guam.biz.comm;

import java.util.Date;

public class CommVO {
	private int seq;
	private String cate;
	private String title;
	private String content;
	private String writerid;
	private int view;
	private int reply;
	private Date regDate;
	
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getCate() {
		return cate;
	}
	public void setCate(String cate) {
		this.cate = cate;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
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
	public int getView() {
		return view;
	}
	public void setView(int view) {
		this.view = view;
	}
	public int getReply() {
		return reply;
	}
	public void setReply(int reply) {
		this.reply = reply;
	}
	
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	
	@Override
	public String toString() {
		return "CommVO [seq=" + seq + ", cate=" + cate + ", title=" + title + ",writerid=" + writerid + ", "
				+ "content=" + content + ", view=" + view + ",reply=" + reply + ",regDate=" + regDate + "]";
	}
	
}
