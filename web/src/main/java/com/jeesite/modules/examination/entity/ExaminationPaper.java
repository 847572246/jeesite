/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.examination.entity;

import javax.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

import com.jeesite.common.entity.DataEntity;
import com.jeesite.common.mybatis.annotation.Column;
import com.jeesite.common.mybatis.annotation.Table;
import com.jeesite.common.mybatis.mapper.query.QueryType;

/**
 * examination_paperEntity
 * @author xt
 * @version 2019-03-18
 */
@Table(name="examination_paper", alias="a", columns={
		@Column(name="id", attrName="id", label="主键id", isPK=true),
		@Column(name="exam_name", attrName="examName", label="试卷名称", queryType=QueryType.LIKE),
		@Column(name="sin_question_id", attrName="sinquestionId", label="单选题目id"),
		@Column(name="mul_question_id", attrName="mulquestionId", label="多选题目id"),
		@Column(name="answer", attrName="answer", label="答案"),
		@Column(includeEntity=DataEntity.class),
	}, orderBy="a.update_date DESC"
)
public class ExaminationPaper extends DataEntity<ExaminationPaper> {
	
	private static final long serialVersionUID = 1L;
	private String examName;		// 试卷名称
	private String sinquestionId;		// 单选题目id
	private String mulquestionId;		// 多选题目id
	private String answer;		// 答案
	
	public ExaminationPaper() {
		this(null);
	}

	public ExaminationPaper(String id){
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

	@NotBlank(message="题目id不能为空")
	@Length(min=0, max=255, message="题目id长度不能超过 255 个字符")
	public String getSinquestionId() {
		return sinquestionId;
	}

	public void setSinquestionId(String questionId) {
		this.sinquestionId = questionId;
	}

	@NotBlank(message="题目id不能为空")
	@Length(min=0, max=255, message="题目id长度不能超过 255 个字符")
	public String getMulquestionId() {
		return mulquestionId;
	}

	public void setMulquestionId(String questionId) {
		this.mulquestionId = questionId;
	}
	
	@Length(min=0, max=10, message="答案长度不能超过 10 个字符")
	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

}