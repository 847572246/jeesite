/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.paper.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.paper.entity.PaperSelection;
import com.jeesite.modules.paper.dao.PaperSelectionDao;

/**
 * paper_selectionService
 * @author xt
 * @version 2019-03-26
 */
@Service
@Transactional(readOnly=true)
public class PaperSelectionService extends CrudService<PaperSelectionDao, PaperSelection> {
	
	/**
	 * 获取单条数据
	 * @param paperSelection
	 * @return
	 */
	@Override
	public PaperSelection get(PaperSelection paperSelection) {
		return super.get(paperSelection);
	}
	
	/**
	 * 查询分页数据
	 * @param paperSelection 查询条件
	 * @param paperSelection.page 分页对象
	 * @return
	 */
	@Override
	public Page<PaperSelection> findPage(PaperSelection paperSelection) {
		return super.findPage(paperSelection);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param paperSelection
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(PaperSelection paperSelection) {
		super.save(paperSelection);
	}

	/**
	 * 保存数据（插入或更新）
	 * @param paperSelection
	 */
	@Transactional(readOnly=false)
	public void savelist(List<PaperSelection> paperSelection) {
		for (int i=0;i<paperSelection.size();i++){
			super.save(paperSelection.get(i));
		}

	}
	/**
	 * 更新状态
	 * @param paperSelection
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(PaperSelection paperSelection) {
		super.updateStatus(paperSelection);
	}
	
	/**
	 * 删除数据
	 * @param paperSelection
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(PaperSelection paperSelection) {
		super.delete(paperSelection);
	}
	
}