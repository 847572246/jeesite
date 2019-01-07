/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.multiple.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.multiple.entity.Multiple1;
import com.jeesite.modules.multiple.dao.Multiple1Dao;

/**
 * multiple_selectionService
 * @author xt
 * @version 2019-01-07
 */
@Service
@Transactional(readOnly=true)
public class Multiple1Service extends CrudService<Multiple1Dao, Multiple1> {
	
	/**
	 * 获取单条数据
	 * @param multiple1
	 * @return
	 */
	@Override
	public Multiple1 get(Multiple1 multiple1) {
		return super.get(multiple1);
	}
	
	/**
	 * 查询分页数据
	 * @param multiple1 查询条件
	 * @param multiple1.page 分页对象
	 * @return
	 */
	@Override
	public Page<Multiple1> findPage(Multiple1 multiple1) {
		return super.findPage(multiple1);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param multiple1
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(Multiple1 multiple1) {
		super.save(multiple1);
	}
	
	/**
	 * 更新状态
	 * @param multiple1
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(Multiple1 multiple1) {
		super.updateStatus(multiple1);
	}
	
	/**
	 * 删除数据
	 * @param multiple1
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(Multiple1 multiple1) {
		super.delete(multiple1);
	}
	
}