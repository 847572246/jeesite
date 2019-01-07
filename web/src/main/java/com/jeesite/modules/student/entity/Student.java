/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.student.entity;

import org.hibernate.validator.constraints.Length;

import com.jeesite.common.entity.DataEntity;
import com.jeesite.common.mybatis.annotation.Column;
import com.jeesite.common.mybatis.annotation.Table;
import com.jeesite.common.mybatis.mapper.query.QueryType;

/**
 * studentEntity
 * @author xt
 * @version 2018-12-21
 */
@Table(name="student", alias="a", columns={
		@Column(name="id", attrName="id", label="id", isPK=true),
		@Column(name="school", attrName="school", label="school"),
		@Column(name="name", attrName="name", label="name", queryType=QueryType.LIKE),
		@Column(name="sex", attrName="sex", label="sex"),
		@Column(name="birth", attrName="birth", label="birth"),
		@Column(name="grade", attrName="grade", label="grade"),
		@Column(name="artsci", attrName="artsci", label="文科or理科"),
		@Column(name="phone", attrName="phone", label="phone"),
	}, orderBy="a.id DESC"
)
public class Student extends DataEntity<Student> {
	
	private static final long serialVersionUID = 1L;
	private String school;		// school
	private String name;		// name
	private String sex;		// sex
	private String birth;		// birth
	private String grade;		// grade
	private String artsci;		// 文科or理科
	private Long phone;		// phone
	
	public Student() {
		this(null);
	}

	public Student(String id){
		super(id);
	}
	
	@Length(min=0, max=255, message="school长度不能超过 255 个字符")
	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}
	
	@Length(min=0, max=255, message="name长度不能超过 255 个字符")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Length(min=0, max=255, message="sex长度不能超过 255 个字符")
	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}
	
	@Length(min=0, max=255, message="birth长度不能超过 255 个字符")
	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}
	
	@Length(min=0, max=255, message="grade长度不能超过 255 个字符")
	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}
	
	@Length(min=0, max=255, message="文科or理科长度不能超过 255 个字符")
	public String getArtsci() {
		return artsci;
	}

	public void setArtsci(String artsci) {
		this.artsci = artsci;
	}
	
	public Long getPhone() {
		return phone;
	}

	public void setPhone(Long phone) {
		this.phone = phone;
	}
	
}