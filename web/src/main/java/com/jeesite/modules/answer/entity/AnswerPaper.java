/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.answer.entity;

import javax.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

import com.jeesite.common.entity.DataEntity;
import com.jeesite.common.mybatis.annotation.Column;
import com.jeesite.common.mybatis.annotation.Table;
import com.jeesite.common.mybatis.mapper.query.QueryType;

/**
 * answer_paperEntity
 * @author xt
 * @version 2019-03-20
 */
@Table(name="answer_paper", alias="a", columns={
		@Column(name="id", attrName="id", label="id", isPK=true),
		@Column(name="exam_name", attrName="examName", label="试卷名称", queryType=QueryType.LIKE),
		@Column(name="exam_id", attrName="examId", label="试卷id"),
		@Column(name="user_name", attrName="userName", label="用户昵称", queryType=QueryType.LIKE),
		@Column(name="user_code", attrName="userCode", label="用户编码"),
		@Column(includeEntity=DataEntity.class),
		@Column(name="paper_status", attrName="paperStatus", label="试卷状态"),
	}, orderBy="a.update_date DESC"
)
public class AnswerPaper extends DataEntity<AnswerPaper> {
	
	private static final long serialVersionUID = 1L;
	private String examName;		// 试卷名称
	private String examId;		// 试卷id
	private String userName;		// 用户昵称
	private String userCode;		// 用户编码
	private String paperStatus;		// 试卷状态
	
	public AnswerPaper() {
		this(null);
	}

	public AnswerPaper(String id){
		super(id);
	}

	@NotBlank(message="试卷名称不能为空")
	@Length(min=0, max=255, message="试卷名称长度不能超过 255 个字符")
	public String getExamName() {
		return examName;
	}

	public void setExamName(String examName) {
		this.examName = examName;
	}
	
	@NotBlank(message="试卷id不能为空")
	@Length(min=0, max=255, message="试卷id长度不能超过 255 个字符")
	public String getExamId() {
		return examId;
	}

	public void setExamId(String examId) {
		this.examId = examId;
	}
	
	@NotBlank(message="用户昵称不能为空")
	@Length(min=0, max=100, message="用户昵称长度不能超过 100 个字符")
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	@NotBlank(message="用户编码不能为空")
	@Length(min=0, max=100, message="用户编码长度不能超过 100 个字符")
	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}


	@Length(min=0, max=1, message="试卷状态长度不能超过 1 个字符")
	public String getPaperStatus() {
		return paperStatus;
	}

	public void setPaperStatus(String paperStatus) {
		this.paperStatus = paperStatus;
	}
	
}