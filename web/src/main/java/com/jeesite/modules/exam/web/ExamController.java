/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.exam.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
import com.jeesite.modules.createword.service.CreateWordService;
import com.jeesite.modules.exam.entity.Multiple;
import com.jeesite.modules.exam.entity.Single;
import com.jeesite.modules.exam.service.ExamService;

/**
 * 代码生成表Controller
 * @author xt
 * @version 2019-01-02
 */
@Controller
@RequestMapping(value = "${adminPath}/exam/examdata")
public class ExamController extends BaseController {

	@Autowired
	private ExamService examService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public Single get(String id, boolean isNewRecord) {
		return examService.get(id, isNewRecord);
	}
	
	/**
	 * 单选题列表
	 * @param single
	 * @param model
	 * @return
	 */
	@RequiresPermissions("exam:single:view")
	@RequestMapping(value = {"list", ""})
	public String list(Single single, Model model) {
		model.addAttribute("single", single);
		return "modules/exam/singleList";
	}
	/**
	 * 多选题列表
	 * @param multiple
	 * @param model
	 * @return
	 */
	@RequiresPermissions("exam:single:view")
	@RequestMapping(value = {"listmultiple", ""})
	public String listmultiple(Single multiple, Model model) {
		model.addAttribute("multiple", multiple);
		return "modules/exam/multipleList";
	}
	/*@RequiresPermissions("exam:single:view")*/
	@RequestMapping(value = {"start", ""})
	public String start(Single single, Model model) {
		model.addAttribute("single", single);
		return "modules/exam/ti";
	}
	/**
	 * 
	 * @return
	 */
	@RequestMapping(value = "getsingle")
	@ResponseBody
	public List<Single> getsingle() {
		List<Single> single=examService.getsingle();
		return single;
	}
	
	/**
	 * 
	 * @return
	 */
	@RequestMapping(value = "getmultiple")
	@ResponseBody
	public List<Multiple> getmultiple() {
		List<Multiple> multiple=examService.getmultiple();
		return multiple;
	}
	
	@RequestMapping(value = "findsingle")
	@ResponseBody
	public Single findsingle(String id) {
		Single single=examService.findsingle(id);
		return single;
	}
	@RequestMapping(value = "findmultiple")
	@ResponseBody
	public Multiple findmultiple(String id) {
		Multiple multiple=examService.findmultiple(id);
		return multiple;
	}
	
	
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("exam:single:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<Single> listData(Single single, HttpServletRequest request, HttpServletResponse response) {
		single.setPage(new Page<>(request, response));
		Page<Single> page = examService.findPage(single); 
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	/*@RequiresPermissions("exam:single:view")*/
	@RequestMapping(value = "form")
	public String form(Single single, Model model) {
		model.addAttribute("single", single);
		return "modules/exam/singleForm";
	}

	/**
	 * 保存代码生成表
	 */
	@RequiresPermissions("exam:single:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated Single single) {
		examService.save(single);
		return renderResult(Global.TRUE, text("保存代码生成表成功！"));
	}
	
	/**
	 * 删除代码生成表
	 */
	@RequiresPermissions("exam:single:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(Single single) {
		examService.delete(single);
		return renderResult(Global.TRUE, text("删除代码生成表成功！"));
	}
	
}