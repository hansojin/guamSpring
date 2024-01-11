package com.guam.biz.board;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

public class BoardVO {
	private int seq;
	private String cate;
	private String writerid;
	private String content;
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
		return "BoardVO [seq=" + seq + ", cate=" + cate + ", writerid=" + writerid + ", "
				+ "content=" + content + ", regDate=" + regDate + "]";
	}
}