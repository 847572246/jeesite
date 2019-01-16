/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.wrong.entity;

import org.hibernate.validator.constraints.Length;

import com.jeesite.common.entity.DataEntity;
import com.jeesite.common.mybatis.annotation.Column;
import com.jeesite.common.mybatis.annotation.Table;
import com.jeesite.common.mybatis.mapper.query.QueryType;

/**
 * wrong_reasonEntity
 * @author xt
 * @version 2019-01-08
 */
@Table(name="wrong_reason", alias="a", columns={
		@Column(name="id", attrName="id", label="id", isPK=true),
		@Column(name="wrong_title", attrName="wrongTitle", label="wrong_title", queryType=QueryType.LIKE),
		@Column(name="wrong_reason", attrName="wrongReason", label="wrong_reason"),
		@Column(includeEntity=DataEntity.class),
	}, orderBy="a.update_date DESC"
)
public class WrongReason extends DataEntity<WrongReason> {
	
	private static final long serialVersionUID = 1L;
	private String wrongTitle;		// wrong_title
	private String wrongReason;		// wrong_reason
	
	public WrongReason() {
		this(null);
	}

	public WrongReason(String id){
		super(id);
	}
	
	@Length(min=0, max=255, message="wrong_title长度不能超过 255 个字符")
	public String getWrongTitle() {
		return wrongTitle;
	}

	public void setWrongTitle(String wrongTitle) {
		this.wrongTitle = wrongTitle;
	}
	
	@Length(min=0, max=255, message="wrong_reason长度不能超过 255 个字符")
	public String getWrongReason() {
		return wrongReason;
	}

	public void setWrongReason(String wrongReason) {
		this.wrongReason = wrongReason;
	}
	
}