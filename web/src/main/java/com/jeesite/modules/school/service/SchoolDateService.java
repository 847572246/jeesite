/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.school.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.school.entity.SchoolDate;
import com.jeesite.modules.school.dao.SchoolDateDao;

/**
 * school_dateService
 * @author xt
 * @version 2019-05-23
 */
@Service
@Transactional(readOnly=true)
public class SchoolDateService extends CrudService<SchoolDateDao, SchoolDate> {
	public List<String> chinese(String schyear, String usercode) {
		 return dao.chinese(schyear,usercode);
	}

	public List<SchoolDate> all(String schyear, String usercode) {
		return dao.all(schyear,usercode);
	}

	public List<String> math(String schyear, String usercode) {
		 return dao.math(schyear,usercode);
	}

	public List<String> english(String schyear, String usercode) {
		 return dao.english(schyear,usercode);
	}

	public List<String> chemical(String schyear, String usercode) {
		 return dao.chemical(schyear,usercode);
	}

	public List<String> physical(String schyear, String usercode) {
		 return dao.physical(schyear,usercode);
	}

	public List<String> biological(String schyear, String usercode) {
		 return dao.biological(schyear,usercode);
	}

	public List<String> history(String schyear, String usercode) {
		 return dao.history(schyear,usercode);
	}

	public List<String> geographic(String schyear, String usercode) {
		 return dao.geographic(schyear,usercode);
	}

	public List<String> political(String schyear, String usercode) {
		 return dao.political(schyear,usercode);
	}
	public List<String> examname(String schyear, String usercode) {
		 return dao.examname(schyear,usercode);
	}
	public List<String> schoolyear(String usercode) {
		 return dao.schoolyear(usercode);
	}
	/**
	 * 获取单条数据
	 * @param schoolDate
	 * @return
	 */
	@Override
	public SchoolDate get(SchoolDate schoolDate) {
		return super.get(schoolDate);
	}
	
	/**
	 * 查询分页数据
	 * @param schoolDate 查询条件
	 * @param schoolDate.page 分页对象
	 * @return
	 */
	@Override
	public Page<SchoolDate> findPage(SchoolDate schoolDate) {
		return super.findPage(schoolDate);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param schoolDate
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(SchoolDate schoolDate) {
		super.save(schoolDate);
	}
	
	/**
	 * 更新状态
	 * @param schoolDate
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(SchoolDate schoolDate) {
		super.updateStatus(schoolDate);
	}
	
	/**
	 * 删除数据
	 * @param schoolDate
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(SchoolDate schoolDate) {
		super.delete(schoolDate);
	}
	
}