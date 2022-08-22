package com.springbook.biz.board;

import java.sql.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlTransient;

import org.springframework.web.multipart.MultipartFile;
@XmlAccessorType(XmlAccessType.FIELD)
// VO(Value object)

public class BoardVO {
	
	@XmlAttribute
	private int seq;
	private String title;
	private String writer;
	private String content;
	private Date regDate;
	private int cnt;
	@XmlTransient	//XML 변환에서 제외
	private String searchCondition;
	@XmlTransient
	private String searchKeyword;
	@XmlTransient
	private MultipartFile uploadFile;
	
	
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
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
	
	
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	
	
				//자바객체를 JSON으로 변환할 때, 특정 변수를 변환에서 제외시킴
//	@JsonIgnore	//일반적인 어노테이션과 다르게 변수 위에 설정하지 않고 Getter 메소드 위에 설정해야 함
	public String getSearchCondition() {
		return searchCondition;
	}
	public void setSearchCondition(String searchCondition) {
		this.searchCondition = searchCondition;
	}
	
	
//	@JsonIgnore
	public String getSearchKeyword() {
		return searchKeyword;
	}
	public void setSearchKeyword(String searchKeyword) {
		this.searchKeyword = searchKeyword;
	}
	
	
//	@JsonIgnore
	public MultipartFile getUploadFile() {
		return uploadFile;
	}
	public void setUploadFile(MultipartFile uploadFile) {
		this.uploadFile = uploadFile;
	}
	
	
	@Override
	public String toString() {
		return String.format("BoardVO [seq = %d, title = %s, writer = %s, content = %s, regDate = %tF, cnt = %d]", seq, title, writer, content, regDate, cnt);
	}
}
