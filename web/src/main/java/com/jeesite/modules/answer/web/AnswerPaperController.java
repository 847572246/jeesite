/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.answer.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jeesite.modules.single.entity.SingleSelection;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jeesite.common.config.Global;
import com.jeesite.common.entity.Page;
import com.jeesite.common.web.BaseController;
import com.jeesite.modules.answer.entity.AnswerPaper;
import com.jeesite.modules.answer.service.AnswerPaperService;

import java.util.ArrayList;
import java.util.List;

/**
 * answer_paperController
 * @author xt
 * @version 2019-03-20
 */
@Controller
@RequestMapping(value = "${adminPath}/answer/answerPaper")
public class AnswerPaperController extends BaseController {

	@Autowired
	private AnswerPaperService answerPaperService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public AnswerPaper get(String id, boolean isNewRecord) {
		return answerPaperService.get(id, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequiresPermissions("answer:answerPaper:view")
	@RequestMapping(value = {"list", ""})
	public String list(AnswerPaper answerPaper, Model model) {
		model.addAttribute("answerPaper", answerPaper);
		return "modules/answer/answerPaperList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("answer:answerPaper:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<AnswerPaper> listData(AnswerPaper answerPaper, HttpServletRequest request, HttpServletResponse response) {
		answerPaper.setPage(new Page<>(request, response));
		Page<AnswerPaper> page = answerPaperService.findPage(answerPaper); 
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("answer:answerPaper:view")
	@RequestMapping(value = "form")
	public String form(AnswerPaper answerPaper, Model model) {
		model.addAttribute("answerPaper", answerPaper);
		return "modules/answer/answerPaperForm";
	}
	/**
	 * 跳转答题页面
	 */
	@RequiresPermissions("answer:answerPaper:view")
	@RequestMapping(value = "exam")
	public String exam( Model model,String examid) {
		String ids=answerPaperService.findexamsingleid(examid);
		List<SingleSelection> singleSelection=answerPaperService.findexamsingle(ids);
		model.addAttribute("single", singleSelection);
		return "modules/exam/newexam";
	}
	/**
	 * 保存试卷
	 */
	@RequiresPermissions("answer:answerPaper:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated AnswerPaper answerPaper) {
		answerPaperService.save(answerPaper);
		return renderResult(Global.TRUE, text("保存试卷成功！"));
	}
	/**
	 * 保存试卷
	 */
	@RequiresPermissions("answer:answerPaper:edit")
	@PostMapping(value = "answer")
	@ResponseBody
	public String answer(@Validated AnswerPaper answerPaper) {
		answerPaperService.save(answerPaper);
		return renderResult(Global.TRUE, text("保存试卷成功！"));
	}
	/**
	 * 删除试卷
	 */
	@RequiresPermissions("answer:answerPaper:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(AnswerPaper answerPaper) {
		answerPaperService.delete(answerPaper);
		return renderResult(Global.TRUE, text("删除试卷成功！"));
	}
}