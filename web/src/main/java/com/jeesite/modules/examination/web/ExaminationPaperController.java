/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.examination.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jeesite.modules.answer.entity.AnswerPaper;
import com.jeesite.modules.answer.service.AnswerPaperService;
import com.jeesite.modules.multiple.entity.MultipleSelection;
import com.jeesite.modules.multiple.service.MultipleSelectionService;
import com.jeesite.modules.single.entity.SingleSelection;
import com.jeesite.modules.single.service.SingleSelectionService;
import com.jeesite.modules.sys.entity.EmpUser;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.jeesite.common.config.Global;
import com.jeesite.common.entity.Page;
import com.jeesite.common.web.BaseController;
import com.jeesite.modules.examination.entity.ExaminationPaper;
import com.jeesite.modules.examination.service.ExaminationPaperService;

import java.util.ArrayList;
import java.util.List;

/**
 * examination_paperController
 * @author xt
 * @version 2019-03-18
 */
@Controller
@RequestMapping(value = "${adminPath}/examination/examinationPaper")
public class ExaminationPaperController extends BaseController {

	@Autowired
	private ExaminationPaperService examinationPaperService;
	@Autowired
	private AnswerPaperService answerPaperService;
	@Autowired
	private SingleSelectionService singleSelectionService;
	@Autowired
	private MultipleSelectionService multipleSelectionService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public ExaminationPaper get(String id, boolean isNewRecord) {
		return examinationPaperService.get(id, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequiresPermissions("examination:examinationPaper:view")
	@RequestMapping(value = {"list", ""})
	public String list(ExaminationPaper examinationPaper, Model model) {
		model.addAttribute("examinationPaper", examinationPaper);
		return "modules/examination/examinationPaperList";
	}
	/**
	 * 查询列表
	 */
	@RequiresPermissions("examination:examinationPaper:view")
	@RequestMapping(value = {"listpaper", ""})
	public String listpaper(SingleSelection singleSelection, MultipleSelection multipleSelection, Model model) {
		//model.addAttribute("singleSelection", singleSelection);
		model.addAttribute("multipleSelection", multipleSelection);
		return "modules/examination/singleSelectionList";
	}
	/**
	 * 查询列表试卷数据
	 */
	@RequiresPermissions("examination:examinationPaper:view")
	@RequestMapping(value = "listpaperData")
	public String listpaperData(@RequestParam(required  = false) String[] sinquestionId,@RequestParam(required  = false)  String[] mulquestionId,Model model) {
		List<SingleSelection> singleSelection=new ArrayList<SingleSelection>();
		singleSelection=examinationPaperService.listpapersin(sinquestionId);
		return "modules/examination/paperList";
	}
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("examination:examinationPaper:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<ExaminationPaper> listData(ExaminationPaper examinationPaper, HttpServletRequest request, HttpServletResponse response) {
		examinationPaper.setPage(new Page<>(request, response));
		Page<ExaminationPaper> page = examinationPaperService.findPage(examinationPaper);
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("examination:examinationPaper:view")
	@RequestMapping(value = "form")
	public String form(ExaminationPaper examinationPaper, Model model) {
		model.addAttribute("examinationPaper", examinationPaper);
		return "modules/examination/examinationPaperForm";
	}

	/**
	 * 保存试卷
	 */
	@RequiresPermissions("examination:examinationPaper:edit")
	@PostMapping(value = "saveid")
    @Transactional(readOnly = false)
	@ResponseBody
	public String saveid(String sinids,String mulids,String examName) {
        ExaminationPaper examinationPaper=new ExaminationPaper();
        examinationPaper.setSinquestionId(sinids);
		examinationPaper.setMulquestionId(mulids);
        examinationPaper.setExamName(examName);
        examinationPaperService.save(examinationPaper);
        return ("保存试卷成功！");
	}
	/**
	 * 发送试卷
	 */
	@RequiresPermissions("examination:examinationPaper:edit")
	@GetMapping(value = "send")
	@ResponseBody
	public String send(String examid,String  examName,String usercode,String username) {
		answerPaperService.send(examid,examName,usercode,username);
		return "发送试卷成功！";
	}
	/**
	 * 显示用户列表
	 */
	@RequiresPermissions("examination:examinationPaper:edit")
	@RequestMapping(value = "userlist")
	public String userlist(ExaminationPaper examinationPaper, EmpUser empUser, Model model) {
		model.addAttribute("examinationPaper", examinationPaper);
		return "modules/examination/empUserList";
	}

	@RequiresPermissions("examination:examinationPaper:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated ExaminationPaper examinationPaper) {
		examinationPaperService.save(examinationPaper);
		return renderResult(Global.TRUE, text("保存试卷成功！"));
	}
	
	/**
	 * 停用试卷
	 */
	@RequiresPermissions("examination:examinationPaper:edit")
	@RequestMapping(value = "disable")
	@ResponseBody
	public String disable(ExaminationPaper examinationPaper) {
		examinationPaper.setStatus(ExaminationPaper.STATUS_DISABLE);
		examinationPaperService.updateStatus(examinationPaper);
		return renderResult(Global.TRUE, text("停用试卷成功"));
	}
	
	/**
	 * 启用试卷
	 */
	@RequiresPermissions("examination:examinationPaper:edit")
	@RequestMapping(value = "enable")
	@ResponseBody
	public String enable(ExaminationPaper examinationPaper) {
		examinationPaper.setStatus(ExaminationPaper.STATUS_NORMAL);
		examinationPaperService.updateStatus(examinationPaper);
		return renderResult(Global.TRUE, text("启用试卷成功"));
	}
	
	/**
	 * 删除试卷
	 */
	@RequiresPermissions("examination:examinationPaper:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(ExaminationPaper examinationPaper) {
		examinationPaperService.delete(examinationPaper);
		return renderResult(Global.TRUE, text("删除试卷成功！"));
	}
	
}