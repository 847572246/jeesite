/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.school.entity;

import java.util.List;

import org.hibernate.validator.constraints.Length;

import com.jeesite.common.entity.DataEntity;
import com.jeesite.common.mybatis.annotation.Column;
import com.jeesite.common.mybatis.annotation.Table;
import com.jeesite.common.mybatis.mapper.query.QueryType;

/**
 * school_dateEntity
 * @author xt
 * @version 2018-12-21
 */
@Table(name="school_date", alias="a", columns={
		@Column(name="id", attrName="id", label="id", isPK=true),
		@Column(includeEntity=DataEntity.class),
		@Column(name="math_grade", attrName="mathGrade", label="math_grade"),
		@Column(name="english_grade", attrName="englishGrade", label="english_grade"),
		@Column(name="chemical_grade", attrName="chemicalGrade", label="chemical_grade"),
		@Column(name="physical_grade", attrName="physicalGrade", label="physical_grade"),
		@Column(name="biological_grade", attrName="biologicalGrade", label="biological_grade"),
		@Column(name="history_grade", attrName="historyGrade", label="history_grade"),
		@Column(name="geographic_grade", attrName="geographicGrade", label="geographic_grade"),
		@Column(name="political_grade", attrName="politicalGrade", label="political_grade"),
		@Column(name="stuid", attrName="stuid", label="stuid"),
		@Column(name="chinese_grade", attrName="chineseGrade", label="chinese_grade"),
		@Column(name="chemical_grade", attrName="chemicalGrade", label="chemical_grade"),
		@Column(name="physical_grade", attrName="physicalGrade", label="physical_grade"),
		@Column(name="biological_grade", attrName="biologicalGrade", label="biological_grade"),
		@Column(name="history_grade", attrName="historyGrade", label="history_grade"),
		@Column(name="geographic_grade", attrName="geographicGrade", label="geographic_grade"),
		@Column(name="political_grade", attrName="politicalGrade", label="political_grade"),
	}, orderBy="a.update_date DESC"
)
public class SchoolDate extends DataEntity<SchoolDate> {
	
	private static final double serialVersionUID = 1L;
	private String stuid;		// stuid
	private String examname;
	private double mathGrade;		// math_grade
	private double englishGrade;		// english_grade
	private double chineseGrade;		// chinese_grade
	private double chemicalGrade;		// chemical_grade
	private double physicalGrade;		// physical_grade
	private double biologicalGrade;		// biological_grade
	private double historyGrade;		// history_grade
	private double geographicGrade;		// geographic_grade
	private double politicalGrade;		// political_grade
	/*private List<String> math;
	private List<String> math;*/
	
	
	public SchoolDate() {
		this(null);
	}

	public SchoolDate(String id){
		super(id);
	}
	
	public double getMathGrade() {
		return mathGrade;
	}

	public void setMathGrade(double mathGrade) {
		this.mathGrade = mathGrade;
	}
	
	public double getEnglishGrade() {
		return englishGrade;
	}

	public void setEnglishGrade(double englishGrade) {
		this.englishGrade = englishGrade;
	}
	
	public double getChemicalGrade1() {
		return chemicalGrade;
	}

	public void setChemicalGrade1(double chemicalGrade) {
		this.chemicalGrade = chemicalGrade;
	}
	
	public double getPhysicalGrade1() {
		return physicalGrade;
	}

	public void setPhysicalGrade(double physicalGrade) {
		this.physicalGrade = physicalGrade;
	}
	
	public double getBiologicalGrade() {
		return biologicalGrade;
	}

	public void setBiologicalGrade(double biologicalGrade) {
		this.biologicalGrade = biologicalGrade;
	}
	
	public double getHistoryGrade() {
		return historyGrade;
	}

	public void setHistoryGrade(double historyGrade) {
		this.historyGrade = historyGrade;
	}
	
	public double getGeographicGrade() {
		return geographicGrade;
	}

	public void setGeographicGrade(double geographicGrade) {
		this.geographicGrade = geographicGrade;
	}
	
	public double getPoliticalGrade() {
		return politicalGrade;
	}

	public void setPoliticalGrade(double politicalGrade) {
		this.politicalGrade = politicalGrade;
	}
	
	@Length(min=0, max=255, message="stuid长度不能超过 255 个字符")
	public String getStuid() {
		return stuid;
	}

	public void setStuid(String stuid) {
		this.stuid = stuid;
	}
	
	public double getChineseGrade() {
		return chineseGrade;
	}

	public void setChineseGrade(double chineseGrade) {
		this.chineseGrade = chineseGrade;
	}
	
	public double getChemicalGrade() {
		return chemicalGrade;
	}

	public void setChemicalGrade(double chemicalGrade) {
		this.chemicalGrade = chemicalGrade;
	}
	
	public double getPhysicalGrade() {
		return physicalGrade;
	}

	public void setPhysicalGrade1(double physicalGrade) {
		this.physicalGrade = physicalGrade;
	}
	
	public double getBiologicalGrade1() {
		return biologicalGrade;
	}

	public void setBiologicalGrade1(double biologicalGrade) {
		this.biologicalGrade = biologicalGrade;
	}
	
	public double getHistoryGrade1() {
		return historyGrade;
	}

	public void setHistoryGrade1(double historyGrade) {
		this.historyGrade = historyGrade;
	}
	
	public double getGeographicGrade1() {
		return geographicGrade;
	}

	public void setGeographicGrade1(double geographicGrade) {
		this.geographicGrade = geographicGrade;
	}
	
	public double getPoliticalGrade1() {
		return politicalGrade;
	}

	public void setPoliticalGrade1(double politicalGrade) {
		this.politicalGrade = politicalGrade;
	}

	public String getExamname() {
		return examname;
	}

	public void setExamname(String examname) {
		this.examname = examname;
	}
	
}