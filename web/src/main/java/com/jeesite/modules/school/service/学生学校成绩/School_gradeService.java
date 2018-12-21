/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.school.service.学生学校成绩;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.school.entity.学生学校成绩.School_grade;
import com.jeesite.modules.school.dao.学生学校成绩.School_gradeDao;

/**
 * 测试数据Service
 * @author ThinkGem
 * @version 2018-12-20
 */
@Service
@Transactional(readOnly=true)
public class School_gradeService extends CrudService<School_gradeDao, School_grade> {
	
	/**
	 * 获取单条数据
	 * @param school_grade
	 * @return
	 */
	@Override
	public School_grade get(School_grade school_grade) {
		return super.get(school_grade);
	}
	
	/**
	 * 查询分页数据
	 * @param school_grade 查询条件
	 * @param school_grade.page 分页对象
	 * @return
	 */
	@Override
	public Page<School_grade> findPage(School_grade school_grade) {
		return super.findPage(school_grade);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param school_grade
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(School_grade school_grade) {
		super.save(school_grade);
	}
	
	/**
	 * 更新状态
	 * @param school_grade
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(School_grade school_grade) {
		super.updateStatus(school_grade);
	}
	
	/**
	 * 删除数据
	 * @param school_grade
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(School_grade school_grade) {
		super.delete(school_grade);
	}
	
}