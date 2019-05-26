/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.school.entity;

import org.hibernate.validator.constraints.Length;

import com.jeesite.common.entity.DataEntity;
import com.jeesite.common.mybatis.annotation.Column;
import com.jeesite.common.mybatis.annotation.Table;
import com.jeesite.common.mybatis.mapper.query.QueryType;

/**
 * school_dateEntity
 * @author xt
 * @version 2019-05-23
 */
@Table(name="school_date", alias="a", columns={
		@Column(name="id", attrName="id", label="id", isPK=true),
		@Column(name="user_code", attrName="userCode", label="user_code"),
		@Column(name="school_year", attrName="schoolYear", label="学年"),
		@Column(name="exam_name", attrName="examName", label="考试名称", queryType=QueryType.LIKE),
		@Column(includeEntity=DataEntity.class),
		@Column(name="chinese_score", attrName="chineseScore", label="语文"),
		@Column(name="math_score", attrName="mathScore", label="数学"),
		@Column(name="english_score", attrName="englishScore", label="英语"),
		@Column(name="chemical_score", attrName="chemicalScore", label="化学"),
		@Column(name="physical_score", attrName="physicalScore", label="物理"),
		@Column(name="biological_score", attrName="biologicalScore", label="生物"),
		@Column(name="history_score", attrName="historyScore", label="历史"),
		@Column(name="geographic_score", attrName="geographicScore", label="地理"),
		@Column(name="political_score", attrName="politicalScore", label="政治"),
		@Column(name="order_flag", attrName="orderFlag", label="order_flag"),
	}, orderBy="a.update_date DESC"
)
public class SchoolDate extends DataEntity<SchoolDate> {
	
	private static final long serialVersionUID = 1L;
	private String userCode;		// user_code
	private String schoolYear;		// 学年
	private String examName;		// 考试名称
	private String chineseScore;		// 语文
	private String mathScore;		// 数学
	private String englishScore;		// 英语
	private String chemicalScore;		// 化学
	private String physicalScore;		// 物理
	private String biologicalScore;		// 生物
	private String historyScore;		// 历史
	private String geographicScore;		// 地理
	private String politicalScore;		// 政治
	private String orderFlag;		// order_flag
	
	public SchoolDate() {
		this(null);
	}

	public SchoolDate(String id){
		super(id);
	}
	
	@Length(min=0, max=255, message="user_code长度不能超过 255 个字符")
	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
	
	@Length(min=0, max=255, message="学年长度不能超过 255 个字符")
	public String getSchoolYear() {
		return schoolYear;
	}

	public void setSchoolYear(String schoolYear) {
		this.schoolYear = schoolYear;
	}
	
	@Length(min=0, max=255, message="考试名称长度不能超过 255 个字符")
	public String getExamName() {
		return examName;
	}

	public void setExamName(String examName) {
		this.examName = examName;
	}
	
	public String getChineseScore() {
		return chineseScore;
	}

	public void setChineseScore(String chineseScore) {
		this.chineseScore = chineseScore;
	}
	
	public String getMathScore() {
		return mathScore;
	}

	public void setMathScore(String mathScore) {
		this.mathScore = mathScore;
	}
	
	public String getEnglishScore() {
		return englishScore;
	}

	public void setEnglishScore(String englishScore) {
		this.englishScore = englishScore;
	}
	
	public String getChemicalScore() {
		return chemicalScore;
	}

	public void setChemicalScore(String chemicalScore) {
		this.chemicalScore = chemicalScore;
	}
	
	public String getPhysicalScore() {
		return physicalScore;
	}

	public void setPhysicalScore(String physicalScore) {
		this.physicalScore = physicalScore;
	}
	
	public String getBiologicalScore() {
		return biologicalScore;
	}

	public void setBiologicalScore(String biologicalScore) {
		this.biologicalScore = biologicalScore;
	}
	
	public String getHistoryScore() {
		return historyScore;
	}

	public void setHistoryScore(String historyScore) {
		this.historyScore = historyScore;
	}
	
	public String getGeographicScore() {
		return geographicScore;
	}

	public void setGeographicScore(String geographicScore) {
		this.geographicScore = geographicScore;
	}
	
	public String getPoliticalScore() {
		return politicalScore;
	}

	public void setPoliticalScore(String politicalScore) {
		this.politicalScore = politicalScore;
	}
	
	public String getOrderFlag() {
		return orderFlag;
	}

	public void setOrderFlag(String orderFlag) {
		this.orderFlag = orderFlag;
	}
	
}