/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.paper.entity;

/**
 * paper_selectionEntity
 * @author xt
 * @version 2019-03-26
 */

public class middlePaperSelection {

	private static final long serialVersionUID = 1L;
	private String sinQuestionId;		// 单选题目id
	private String mulQuestionId;		// 多选题目id
	private String answer;		// 回答
	private String modelAnswers;		// 标准答案
	private String correct;		// 是否正确

	public String getSinQuestionId() {
		return sinQuestionId;
	}

	public void setSinQuestionId(String sinQuestionId) {
		this.sinQuestionId = sinQuestionId;
	}

	public String getMulQuestionId() {
		return mulQuestionId;
	}

	public void setMulQuestionId(String mulQuestionId) {
		this.mulQuestionId = mulQuestionId;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
	public String getModelAnswers() {
		return modelAnswers;
	}

	public void setModelAnswers(String modelAnswers) {
		this.modelAnswers = modelAnswers;
	}
	
	public String getCorrect() {
		return correct;
	}

	public void setCorrect(String correct) {
		this.correct = correct;
	}
}