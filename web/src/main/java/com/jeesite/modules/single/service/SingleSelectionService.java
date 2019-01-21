/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.single.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.single.entity.SingleSelection;
import com.jeesite.modules.single.dao.SingleSelectionDao;
import com.jeesite.modules.file.utils.FileUploadUtils;

/**
 * single_selectionService
 * @author xt
 * @version 2019-01-18
 */
@Service
@Transactional(readOnly=true)
public class SingleSelectionService extends CrudService<SingleSelectionDao, SingleSelection> {
	
	/**
	 * 获取单条数据
	 * @param singleSelection
	 * @return
	 */
	@Override
	public SingleSelection get(SingleSelection singleSelection) {
		return super.get(singleSelection);
	}
	/**
	 * 
	 * @param id
	 * @return
	 */
	
	@Transactional(readOnly=false)
	public List<SingleSelection> getsingle() {
		return dao.getsingle();
	}
	
	/**
	 * 查询分页数据
	 * @param singleSelection 查询条件
	 * @param singleSelection.page 分页对象
	 * @return
	 */
	@Override
	public Page<SingleSelection> findPage(SingleSelection singleSelection) {
		return super.findPage(singleSelection);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param singleSelection
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(SingleSelection singleSelection) {
		super.save(singleSelection);
		// 保存上传图片
		FileUploadUtils.saveFileUpload(singleSelection.getId(), "singleSelection_image");
	}
	
	/**
	 * 更新状态
	 * @param singleSelection
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(SingleSelection singleSelection) {
		super.updateStatus(singleSelection);
	}
	
	/**
	 * 删除数据
	 * @param singleSelection
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(SingleSelection singleSelection) {
		super.delete(singleSelection);
	}
	public SingleSelection findsingle(String id) {
		System.out.println(id+"哒哒哒哒哒哒多");
		return dao.findsingle(id);
	}
	
}