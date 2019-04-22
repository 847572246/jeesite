/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.answer.service;

import java.util.List;

import com.jeesite.modules.examination.entity.ExaminationPaper;
import com.jeesite.modules.multiple.entity.MultipleSelection;
import com.jeesite.modules.paper.entity.PaperSelection;
import com.jeesite.modules.single.entity.SingleSelection;
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
	 * 查找单选题
	 */
	public List<SingleSelection> findexamsingle(String ids){
		return dao.findexamsingle(ids);
	}
	/**
	 * 查找多选题
	 */
	public List<MultipleSelection> findexammultiple(String ids){
		return dao.findexammultiple(ids);
	}
	/**
	 *按试卷id查找单选题
	 */
	public String findexamsingleid(String examid){
		return dao.findexamsingleid(examid);
	}
	/**
	 *按试卷id查找多选题
	 */
	public String findexammultipleid(String examid){
		return dao.findexammultipleid(examid);
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
	public void send(String examid,String examName,String usercode,String username) {
		AnswerPaper answerPaper=new AnswerPaper();
		answerPaper.setExamId(examid);
		answerPaper.setExamName(examName);
		answerPaper.setUserCode(usercode);
		answerPaper.setUserName(username);
		//answerPaper.setQuestionId(questionId);
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

	@Transactional(readOnly=false)
	public void changpaperstatus(String answerPaperid) {
		dao.changpaperstatus(answerPaperid);
	}

    public String findanswersingle(String paperid) {
		return dao.findanswersingle(paperid);
    }
    public String findanswermultiple(String paperid) {
		return dao.findanswermultiple(paperid);
    }

	public List<PaperSelection> findanswer(String paperid) {
		return dao.findanswer(paperid);
	}
}