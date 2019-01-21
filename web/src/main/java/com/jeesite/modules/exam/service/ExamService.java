/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.exam.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.multiple.entity.MultipleSelection;
import com.jeesite.modules.single.entity.SingleSelection;
import com.jeesite.modules.exam.dao.ExamDao;

/**
 * 代码生成表Service
 * @author xt
 * @version 2019-01-02
 */
@Service
@Transactional(readOnly=true)
public class ExamService extends CrudService<ExamDao, SingleSelection> {
	
	/**
	 * 获取单条数据
	 * @param id
	 * @return
	 */
	public SingleSelection get(SingleSelection id) {
		return super.get(id);
	}
	
	/**
	 * 查询分页数据
	 * @param single 查询条件
	 * @param single.page 分页对象
	 * @return
	 */
	@Override
	public Page<SingleSelection> findPage(SingleSelection single) {
		return super.findPage(single);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param single
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(SingleSelection single) {
		super.save(single);
	}
	
	/**
	 * 更新状态
	 * @param single
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(SingleSelection single) {
		super.updateStatus(single);
	}
	
	/**
	 * 删除数据
	 * @param single
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(SingleSelection single) {
		super.delete(single);
	}

	@Transactional(readOnly=false)
	public List<SingleSelection> getsingle() {
		return dao.getsingle();
	}
	@Transactional(readOnly=false)
	public List<MultipleSelection> getmultiple() {
		return dao.getmultiple();
	}
	
}