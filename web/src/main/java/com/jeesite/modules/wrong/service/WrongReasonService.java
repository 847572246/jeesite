/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.wrong.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.wrong.entity.WrongReason;
import com.jeesite.modules.wrong.dao.WrongReasonDao;
import com.jeesite.modules.exam.entity.Single;

/**
 * wrong_reasonService
 * @author xt
 * @version 2019-01-08
 */
@Service
@Transactional(readOnly=true)
public class WrongReasonService extends CrudService<WrongReasonDao, WrongReason> {
	public String getwrongid(String user) {
		return dao.getwrongid(user);
	}
	public List<Single> getwrong(String wrong){
		return dao.getwrong(wrong);
	}
	/**
	 * 获取单条数据
	 * @param wrongReason
	 * @return
	 */
	@Override
	public WrongReason get(WrongReason wrongReason) {
		return super.get(wrongReason);
	}
	
	/**
	 * 查询分页数据
	 * @param wrongReason 查询条件
	 * @param wrongReason.page 分页对象
	 * @return
	 */
	@Override
	public Page<WrongReason> findPage(WrongReason wrongReason) {
		return super.findPage(wrongReason);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param wrongReason
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(WrongReason wrongReason) {
		super.save(wrongReason);
	}
	
	/**
	 * 更新状态
	 * @param wrongReason
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(WrongReason wrongReason) {
		super.updateStatus(wrongReason);
	}
	
	/**
	 * 删除数据
	 * @param wrongReason
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(WrongReason wrongReason) {
		super.delete(wrongReason);
	}
	
}