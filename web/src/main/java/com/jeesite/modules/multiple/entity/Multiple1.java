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
 * @version 2019-01-07
 */
@Table(name="multiple_selection", alias="a", columns={
		@Column(name="id", attrName="id", label="id", isPK=true),
		@Column(name="title", attrName="title", label="title", queryType=QueryType.LIKE),
		@Column(name="a", attrName="a", label="a"),
		@Column(name="b", attrName="b", label="b"),
		@Column(name="c", attrName="c", label="c"),
		@Column(name="d", attrName="d", label="d"),
		@Column(name="answer", attrName="answer", label="answer"),
		@Column(includeEntity=DataEntity.class),
		@Column(name="reason", attrName="reason", label="reason"),
	}, orderBy="a.update_date DESC"
)
public class Multiple1 extends DataEntity<Multiple1> {
	
	private static final long serialVersionUID = 1L;
	private String title;		// title
	private String a;		// a
	private String b;		// b
	private String c;		// c
	private String d;		// d
	private String answer;		// answer
	private String reason;		// reason
	
	public Multiple1() {
		this(null);
	}

	public Multiple1(String id){
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
	
	@Length(min=0, max=255, message="reason长度不能超过 255 个字符")
	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}
	
}