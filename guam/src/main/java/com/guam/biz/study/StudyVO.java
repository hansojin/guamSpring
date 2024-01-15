package com.guam.biz.study;

import java.util.Date;

public class StudyVO {
	private int seq;
	private String cate;
	private String title;
	private String goal;
	private String content;
	private String writerid;
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

	public String getGoal() {
		return goal;
	}

	public void setGoal(String goal) {
		this.goal = goal;
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
		return "StudyVO [seq=" + seq + ", cate=" + cate + ", title=" + title + ", goal=" + goal + ", content=" + content + ", "
				+ "writerid=" + writerid + ", regDate=" + regDate + "]";
	}
}
