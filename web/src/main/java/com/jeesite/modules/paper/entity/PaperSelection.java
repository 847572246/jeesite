/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.paper.entity;

import javax.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

import com.jeesite.common.entity.DataEntity;
import com.jeesite.common.mybatis.annotation.Column;
import com.jeesite.common.mybatis.annotation.Table;
import com.jeesite.common.mybatis.mapper.query.QueryType;

/**
 * paper_selectionEntity
 * @author xt
 * @version 2019-03-26
 */
@Table(name="paper_selection", alias="a", columns={
		@Column(name="id", attrName="id", label="id", isPK=true),
		@Column(name="paper_id", attrName="paperId", label="试卷id"),
		@Column(name="sin_question_id", attrName="sinQuestionId", label="单选题目id"),
		@Column(name="mul_question_id", attrName="mulQuestionId", label="多选题目id"),
		@Column(name="user_code", attrName="userCode", label="用户编码"),
		@Column(name="answer", attrName="answer", label="回答"),
		@Column(name="model_answers", attrName="modelAnswers", label="标准答案"),
		@Column(includeEntity=DataEntity.class),
		@Column(name="correct", attrName="correct", label="是否正确"),
	}, orderBy="a.update_date DESC"
)
public class PaperSelection extends DataEntity<PaperSelection> {
	
	private static final long serialVersionUID = 1L;
	private String paperId;		// 试卷id
	private String sinQuestionId;		// 单选题目id
	private String mulQuestionId;		// 多选题目id
	private String userCode;		// 用户编码
	private String answer;		// 回答
	private String modelAnswers;		// 标准答案
	private String correct;		// 是否正确
	
	public PaperSelection() {
		this(null);
	}

	public PaperSelection(String id){
		super(id);
	}
	
	@NotBlank(message="试卷id不能为空")
	@Length(min=0, max=255, message="试卷id长度不能超过 255 个字符")
	public String getPaperId() {
		return paperId;
	}

	public void setPaperId(String paperId) {
		this.paperId = paperId;
	}
	
	@Length(min=0, max=255, message="单选题目id长度不能超过 255 个字符")
	public String getSinQuestionId() {
		return sinQuestionId;
	}

	public void setSinQuestionId(String sinQuestionId) {
		this.sinQuestionId = sinQuestionId;
	}
	
	@Length(min=0, max=255, message="多选题目id长度不能超过 255 个字符")
	public String getMulQuestionId() {
		return mulQuestionId;
	}

	public void setMulQuestionId(String mulQuestionId) {
		this.mulQuestionId = mulQuestionId;
	}
	
	@NotBlank(message="用户编码不能为空")
	@Length(min=0, max=100, message="用户编码长度不能超过 100 个字符")
	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
	
	@Length(min=0, max=4, message="回答长度不能超过 4 个字符")
	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
	@Length(min=0, max=4, message="标准答案长度不能超过 4 个字符")
	public String getModelAnswers() {
		return modelAnswers;
	}

	public void setModelAnswers(String modelAnswers) {
		this.modelAnswers = modelAnswers;
	}
	
	@Length(min=0, max=1, message="是否正确长度不能超过 1 个字符")
	public String getCorrect() {
		return correct;
	}

	public void setCorrect(String correct) {
		this.correct = correct;
	}
	
}