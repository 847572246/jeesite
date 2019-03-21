/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.answer.service;

import java.util.List;

import com.jeesite.modules.examination.entity.ExaminationPaper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.answer.entity.AnswerPaper;
import com.jeesite.modules.answer.dao.AnswerPaperDao;

/**
 * answer_paperService
 * @author xt
 * @version 2019-03-20
 */
@Service
@Transactional(readOnly=true)
public class AnswerPaperService extends CrudService<AnswerPaperDao, AnswerPaper> {
	
	/**
	 * 获取单条数据
	 * @param answerPaper
	 * @return
	 */
	@Override
	public AnswerPaper get(AnswerPaper answerPaper) {
		return super.get(answerPaper);
	}
	
	/**
	 * 查询分页数据
	 * @param answerPaper 查询条件
	 * @param answerPaper.page 分页对象
	 * @return
	 */
	@Override
	public Page<AnswerPaper> findPage(AnswerPaper answerPaper) {
		return super.findPage(answerPaper);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param answerPaper
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(AnswerPaper answerPaper) {
		super.save(answerPaper);
	}
	/**
	 * 发送数据（插入或更新）
	 * @param answerPaper
	 */
	/*@Override*/
	@Transactional(readOnly=false)
	public void send(ExaminationPaper examinationPaper, String usercode, String username) {
		AnswerPaper answerPaper=new AnswerPaper();
		answerPaper.setExamId(examinationPaper.getId());
		answerPaper.setExamName(examinationPaper.getExamName());
		answerPaper.setUserCode(usercode);
		answerPaper.setUserName(username);
		answerPaper.setQuestionId(examinationPaper.getQuestionId());
		super.save(answerPaper);
	}
	/**
	 * 更新状态
	 * @param answerPaper
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(AnswerPaper answerPaper) {
		super.updateStatus(answerPaper);
	}
	
	/**
	 * 删除数据
	 * @param answerPaper
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(AnswerPaper answerPaper) {
		super.delete(answerPaper);
	}


}