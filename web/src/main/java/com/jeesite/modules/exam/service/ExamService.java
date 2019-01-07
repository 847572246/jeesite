/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.exam.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.exam.entity.Multiple;
import com.jeesite.modules.exam.entity.Single;
import com.jeesite.modules.exam.dao.ExamDao;

/**
 * 代码生成表Service
 * @author xt
 * @version 2019-01-02
 */
@Service
@Transactional(readOnly=true)
public class ExamService extends CrudService<ExamDao, Single> {
	
	/**
	 * 获取单条数据
	 * @param single
	 * @return
	 */
	@Override
	public Single get(Single single) {
		return super.get(single);
	}
	
	/**
	 * 查询分页数据
	 * @param single 查询条件
	 * @param single.page 分页对象
	 * @return
	 */
	@Override
	public Page<Single> findPage(Single single) {
		return super.findPage(single);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param single
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(Single single) {
		super.save(single);
	}
	
	/**
	 * 更新状态
	 * @param single
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(Single single) {
		super.updateStatus(single);
	}
	
	/**
	 * 删除数据
	 * @param single
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(Single single) {
		super.delete(single);
	}

	@Transactional(readOnly=false)
	public List<Single> getsingle() {
		return dao.getsingle();
	}
	@Transactional(readOnly=false)
	public List<Multiple> getmultiple() {
		return dao.getmultiple();
	}
	
}