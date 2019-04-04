/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.multiple.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.multiple.entity.MultipleSelection;
import com.jeesite.modules.multiple.dao.MultipleSelectionDao;
import com.jeesite.modules.file.utils.FileUploadUtils;

/**
 * multiple_selectionService
 * @author xt
 * @version 2019-01-17
 */
@Service
@Transactional(readOnly=true)
public class MultipleSelectionService extends CrudService<MultipleSelectionDao, MultipleSelection> {
	@Transactional(readOnly=false)
	public List<MultipleSelection> getmultiple() {
		return dao.getmultiple();
	}
	public MultipleSelection findmultiple(String mulids) {
		return dao.findmultiple(mulids);
	}
	/**
	 * 获取单条数据
	 * @param multipleSelection
	 * @return
	 */
	@Override
	public MultipleSelection get(MultipleSelection multipleSelection) {
		return super.get(multipleSelection);
	}
	
	/**
	 * 查询分页数据
	 * @param multipleSelection 查询条件
	 * @param multipleSelection.page 分页对象
	 * @return
	 */
	@Override
	public Page<MultipleSelection> findPage(MultipleSelection multipleSelection) {
		return super.findPage(multipleSelection);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param multipleSelection
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(MultipleSelection multipleSelection) {
		super.save(multipleSelection);
		// 保存上传图片
		FileUploadUtils.saveFileUpload(multipleSelection.getId(), "multipleSelection_image");
	}
	
	/**
	 * 更新状态
	 * @param multipleSelection
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(MultipleSelection multipleSelection) {
		super.updateStatus(multipleSelection);
	}
	
	/**
	 * 删除数据
	 * @param multipleSelection
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(MultipleSelection multipleSelection) {
		super.delete(multipleSelection);
	}

    public String  getmultipleanswer(String mulQuestionId) {
		return dao.getmultipleanswer(mulQuestionId);
    }
}