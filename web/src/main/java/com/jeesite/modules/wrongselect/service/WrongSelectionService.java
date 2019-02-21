/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.wrongselect.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.wrongselect.entity.WrongSelection;
import com.jeesite.modules.single.entity.SingleSelection;
import com.jeesite.modules.wrongselect.dao.WrongSelectionDao;

/**
 * wrong_selectionService
 * @author xt
 * @version 2019-01-31
 */
@Service
@Transactional(readOnly=true)
public class WrongSelectionService extends CrudService<WrongSelectionDao, WrongSelection> {
	
	
	
	
	/**
	 * 获取单条数据
	 * @param wrongSelection
	 * @return
	 */
	@Override
	public WrongSelection get(WrongSelection wrongSelection) {
		return super.get(wrongSelection);
	}
	
	/**
	 * 查询分页数据
	 * @param wrongSelection 查询条件
	 * @param wrongSelection.page 分页对象
	 * @return
	 */
	@Override
	public Page<WrongSelection> findPage(WrongSelection wrongSelection) {
		return super.findPage(wrongSelection);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param wrongSelection
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(WrongSelection wrongSelection) {
		super.save(wrongSelection);
	}
	
	/**
	 * 更新状态
	 * @param wrongSelection
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(WrongSelection wrongSelection) {
		super.updateStatus(wrongSelection);
	}
	
	/**
	 * 删除数据
	 * @param wrongSelection
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(WrongSelection wrongSelection) {
		super.delete(wrongSelection);
	}
	public List<WrongSelection> findwrong(String usercode) {
		// TODO Auto-generated method stub
		return dao.findwrong(usercode);
	}
	public List<String> finduserwrongid(String usercode) {
		// TODO Auto-generated method stub
		return dao.finduserwrongid(usercode);
	}
	public List<String> finduserwrongflag(String usercode) {
		// TODO Auto-generated method stub
		return dao.finduserwrongflag(usercode);
	}

	public String selectionmultiple(String wrongreasonid) {
		// TODO Auto-generated method stub
		return dao.selectionmultiple(wrongreasonid);
	}

	public String selectionsingle(String wrongreasonid) {
		// TODO Auto-generated method stub
		return dao.selectionsingle(wrongreasonid);
	}
	
}