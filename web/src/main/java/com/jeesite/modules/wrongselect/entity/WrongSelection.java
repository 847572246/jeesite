/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.wrongselect.entity;

import javax.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

import com.jeesite.common.entity.DataEntity;
import com.jeesite.common.mybatis.annotation.Column;
import com.jeesite.common.mybatis.annotation.Table;
import com.jeesite.common.mybatis.mapper.query.QueryType;

/**
 * wrong_selectionEntity
 * @author xt
 * @version 2019-01-31
 */
@Table(name="wrong_selection", alias="a", columns={
		@Column(name="id", attrName="id", label="id", isPK=true),
		@Column(name="user_name", attrName="userName", label="用户昵称", queryType=QueryType.LIKE),
		@Column(name="user_code", attrName="userCode", label="用户编码"),
		@Column(name="wrong_id_sin", attrName="wrongIdSin", label="单选题号"),
		@Column(name="wrong_id_mul", attrName="wrongIdMul", label="多选题号"),
		@Column(name="wrong_select", attrName="wrongSelect", label="错题题目"),
		@Column(name="wrong_reason_id", attrName="wrongReasonId", label="错误原因号"),
		@Column(name="wrong_reason", attrName="wrongReason", label="错误原因"),
		@Column(includeEntity=DataEntity.class),
		@Column(name="flag", attrName="flag", label="错误次数"),
	}, orderBy="a.update_date DESC"
)
public class WrongSelection extends DataEntity<WrongSelection> {
	
	private static final long serialVersionUID = 1L;
	private String userName;		// 用户昵称
	private String userCode;		// 用户编码
	private String wrongIdSin;		// 单选题号
	private String wrongIdMul;		// 多选题号
	private String wrongSelect;		// 错题题目
	private String wrongReasonId;		// 错误原因号
	private String wrongReason;		// 错误原因
	private Integer flag;		// 错误次数
	
	public WrongSelection() {
		this(null);
	}

	public WrongSelection(String id){
		super(id);
	}
	
	@NotBlank(message="用户昵称不能为空")
	@Length(min=0, max=100, message="用户昵称长度不能超过 100 个字符")
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	@Length(min=0, max=100, message="用户编码长度不能超过 100 个字符")
	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
	
	@Length(min=0, max=255, message="单选题号长度不能超过 255 个字符")
	public String getWrongIdSin() {
		return wrongIdSin;
	}

	public void setWrongIdSin(String wrongIdSin) {
		this.wrongIdSin = wrongIdSin;
	}
	
	@Length(min=0, max=255, message="多选题号长度不能超过 255 个字符")
	public String getWrongIdMul() {
		return wrongIdMul;
	}

	public void setWrongIdMul(String wrongIdMul) {
		this.wrongIdMul = wrongIdMul;
	}
	
	@Length(min=0, max=255, message="错题题目长度不能超过 255 个字符")
	public String getWrongSelect() {
		return wrongSelect;
	}

	public void setWrongSelect(String wrongSelect) {
		this.wrongSelect = wrongSelect;
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
	
	public Integer getFlag() {
		return flag;
	}

	public void setFlag(Integer flag) {
		this.flag = flag;
	}


	
}