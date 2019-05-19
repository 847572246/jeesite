/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.multiple.entity;

import org.hibernate.validator.constraints.Length;

import com.jeesite.common.entity.DataEntity;
import com.jeesite.common.mybatis.annotation.Column;
import com.jeesite.common.mybatis.annotation.Table;
import com.jeesite.common.mybatis.mapper.query.QueryType;

/**
 * multiple_selectionEntity
 * @author xt
 * @version 2019-01-17
 */
@Table(name="multiple_selection", alias="a", columns={
		@Column(name="id", attrName="id", label="id", isPK=true),
		@Column(name="title", attrName="title", label="title", queryType=QueryType.LIKE),
		@Column(name="a", attrName="a", label="a"),
		@Column(name="awrong_reason_id", attrName="awrongReasonId", label="a选项原因号"),
		@Column(name="awrong_reason", attrName="awrongReason", label="a选项原因"),
		@Column(name="b", attrName="b", label="b"),
		@Column(name="bwrong_reason_id", attrName="bwrongReasonId", label="b选项原因号"),
		@Column(name="bwrong_reason", attrName="bwrongReason", label="b选项原因"),
		@Column(name="c", attrName="c", label="c"),
		@Column(name="cwrong_reason_id", attrName="cwrongReasonId", label="c选项原因号"),
		@Column(name="cwrong_reason", attrName="cwrongReason", label="c选项原因"),
		@Column(name="d", attrName="d", label="d"),
		@Column(name="dwrong_reason_id", attrName="dwrongReasonId", label="d选项原因号"),
		@Column(name="dwrong_reason", attrName="dwrongReason", label="d选项原因"),
		@Column(name="answer", attrName="answer", label="answer"),
		@Column(includeEntity=DataEntity.class),
		@Column(name="wrong_reason_id", attrName="wrongReasonId", label="错误原因号"),
		@Column(name="wrong_reason", attrName="wrongReason", label="错误原因"),
	}, orderBy="a.update_date DESC"
)
public class MultipleSelection extends DataEntity<MultipleSelection> {
	
	private static final long serialVersionUID = 1L;
	private String title;		// title
	private String a;		// a
	private String awrongReasonId;		// a选项原因号
	private String awrongReason;		//a选项原因
	private String b;		// b
	private String bwrongReasonId;		// b选项原因号
	private String bwrongReason;		//b选项原因
	private String c;		// c
	private String cwrongReasonId;		//c选项原因号
	private String cwrongReason;		//c选项原因
	private String d;		// d
	private String dwrongReasonId;		// d选项原因号
	private String dwrongReason;		//d选项原因
	private String answer;		// answer
	private String wrongReasonId;		// 错误原因号
	private String wrongReason;		// 错误原因
	
	public MultipleSelection() {
		this(null);
	}

	public MultipleSelection(String id){
		super(id);
	}
	
	@Length(min=0, max=255, message="title长度不能超过 255 个字符")
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	@Length(min=0, max=255, message="a长度不能超过 255 个字符")
	public String getA() {
		return a;
	}

	public void setA(String a) {
		this.a = a;
	}
	
	@Length(min=0, max=255, message="b长度不能超过 255 个字符")
	public String getB() {
		return b;
	}

	public void setB(String b) {
		this.b = b;
	}
	
	@Length(min=0, max=255, message="c长度不能超过 255 个字符")
	public String getC() {
		return c;
	}

	public void setC(String c) {
		this.c = c;
	}
	
	@Length(min=0, max=255, message="d长度不能超过 255 个字符")
	public String getD() {
		return d;
	}

	public void setD(String d) {
		this.d = d;
	}
	
	@Length(min=0, max=4, message="answer长度不能超过 4 个字符")
	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	@Length(min=0, max=255, message="a选型原因号长度不能超过 255 个字符")
	public String getAwrongReasonId() {
		return awrongReasonId;
	}

	public void setAwrongReasonId(String awrongReasonId) {
		this.awrongReasonId = awrongReasonId;
	}


	@Length(min=0, max=255, message="a选型原因长度不能超过 255 个字符")
	public String getAwrongReason() {
		return awrongReason;
	}

	public void setAwrongReason(String awrongReason) {
		this.awrongReason = awrongReason;
	}

	/*bbbb*/
	@Length(min=0, max=255, message="b选型原因号长度不能超过 255 个字符")
	public String getBwrongReasonId() {
		return bwrongReasonId;
	}

	public void setBwrongReasonId(String bwrongReasonId) {
		this.bwrongReasonId = bwrongReasonId;
	}

	@Length(min=0, max=255, message="b选型原因长度不能超过 255 个字符")
	public String getBwrongReason() {
		return bwrongReason;
	}

	public void setBwrongReason(String bwrongReason) {
		this.bwrongReason = bwrongReason;
	}
	/*cccc*/
	@Length(min=0, max=255, message="c选型原因号长度不能超过 255 个字符")
	public String getCwrongReasonId() {
		return cwrongReasonId;
	}

	public void setCwrongReasonId(String cwrongReasonId) {
		this.cwrongReasonId = cwrongReasonId;
	}

	@Length(min=0, max=255, message="c选型原因长度不能超过 255 个字符")
	public String getCwrongReason() {
		return cwrongReason;
	}

	public void setCwrongReason(String cwrongReason) {
		this.cwrongReason = cwrongReason;
	}

	/*dddd*/
	@Length(min=0, max=255, message="d选型错误原因号长度不能超过 255 个字符")
	public String getDwrongReasonId() {
		return dwrongReasonId;
	}

	public void setDwrongReasonId(String dwrongReasonId) {
		this.dwrongReasonId = dwrongReasonId;
	}

	@Length(min=0, max=255, message="d选型错误原因长度不能超过 255 个字符")
	public String getDwrongReason() {
		return dwrongReason;
	}

	public void setDwrongReason(String dwrongReason) {
		this.dwrongReason = dwrongReason;
	}

	@Length(min=0, max=255, message="错误原因号长度不能超过 255 个字符")
	public String getWrongReasonId() {
		return wrongReasonId;
	}

	public void setWrongReasonId(String wrongReasonId) {
		this.wrongReasonId = wrongReasonId;
	}
	
	@Length(min=0, max=255, message="错误原因长度不能超过 255 个字符")
	public String getWrongReason() {
		return wrongReason;
	}

	public void setWrongReason(String wrongReason) {
		this.wrongReason = wrongReason;
	}
	
}