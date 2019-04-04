/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.examination.service;

import java.util.List;

import com.jeesite.modules.multiple.entity.MultipleSelection;
import com.jeesite.modules.single.entity.SingleSelection;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.examination.entity.ExaminationPaper;
import com.jeesite.modules.examination.dao.ExaminationPaperDao;
import com.jeesite.modules.file.utils.FileUploadUtils;

/**
 * examination_paperService
 * @author xt
 * @version 2019-03-18
 */
@Service
@Transactional(readOnly=true)
public class ExaminationPaperService extends CrudService<ExaminationPaperDao, ExaminationPaper> {
	
	/**
	 * 获取单条数据
	 * @param examinationPaper
	 * @return
	 */
	@Override
	public ExaminationPaper get(ExaminationPaper examinationPaper) {
		return super.get(examinationPaper);
	}
	
	/**
	 * 查询分页数据
	 * @param examinationPaper 查询条件
	 * @param examinationPaper.page 分页对象
	 * @return
	 */
	@Override
	public Page<ExaminationPaper> findPage(ExaminationPaper examinationPaper) {
		return super.findPage(examinationPaper);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param examinationPaper
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(ExaminationPaper examinationPaper) {
		super.save(examinationPaper);
		// 保存上传图片
		FileUploadUtils.saveFileUpload(examinationPaper.getId(), "examinationPaper_image");
	}
	
	/**
	 * 更新状态
	 * @param examinationPaper
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(ExaminationPaper examinationPaper) {
		super.updateStatus(examinationPaper);
	}
	
	/**
	 * 删除数据
	 * @param examinationPaper
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(ExaminationPaper examinationPaper) {
		super.delete(examinationPaper);
	}

    public int saveid(String[] ids, String examName) {
	    return dao.saveid(ids,examName);
    }

    public List<SingleSelection> listpapersin(String sinquestionId) {
		return dao.listpapersin(sinquestionId);
    }
	public List<MultipleSelection> listpapermul(String mulquestionId) {
		return dao.listpapermul(mulquestionId);
	}
}