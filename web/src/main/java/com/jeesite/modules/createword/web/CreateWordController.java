/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.createword.web;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.jeesite.modules.exam.service.ExamService;
import com.jeesite.modules.exam.web.ExamController;
import com.jeesite.modules.multiple.entity.MultipleSelection;
import com.jeesite.modules.multiple.service.MultipleSelectionService;
import com.jeesite.modules.multiple.web.MultipleSelectionController;
import com.jeesite.modules.single.entity.SingleSelection;
import com.jeesite.modules.single.service.SingleSelectionService;
import com.jeesite.modules.single.web.SingleSelectionController;

/**
 * 代码生成表Controller
 * 
 * @author xt
 * @version 2019-01-02
 */
@Controller
@RequestMapping(value = "${adminPath}/createword/create")
public class CreateWordController extends BaseController {

	@Autowired
	private CreateWordService createwordService;
	@Autowired
	private SingleSelectionController singleselectioncontroller;
	@Autowired
	private MultipleSelectionController multipleSelectionController;

	
	/**
	 * 查询列表
	 */
	@RequiresPermissions("createword:create:view")
	@RequestMapping(value = {"single", ""})
	public String listsingle(SingleSelection singleSelection, Model model) {
		model.addAttribute("singleSelection", singleSelection);
		return "modules/createword/createWordList2";
	}
	/**
	 * 查询列表
	 */
	@RequiresPermissions("createword:create:view")
	@RequestMapping(value = {"multiple", ""})
	public String listmultiple(MultipleSelection multipleSelection, Model model) {
		model.addAttribute("multipleSelection", multipleSelection);
		return "modules/createword/createWordList3";
	}
	
	@RequestMapping(value = "create")
	@ResponseBody
	public void exportSimpleWord() {
		String[] id = { "1085352781168775168", "1085353136787034112", "1085353276662878208", "1082173345942388736",
				"1085352629917978624", "1085354419958845440", "1085354551022456832" };
		List<SingleSelection> list = singleselectioncontroller.findsingle(id);
		List<MultipleSelection> list1 = multipleSelectionController.findmultiple(id);
		list.removeAll(Collections.singleton(null));
		list1.removeAll(Collections.singleton(null));
		Map<String, Object> root = new HashMap<String, Object>();
		root.put("single", list);
		root.put("multiple", list1);
		FreeMarkertUtil.analysisTemplate("C:/create/", "exam.ftl", "C:/create/use.doc" + Math.random() * 10000 + ".doc",
				root);
	}

	public List<MultipleSelection> inUserList(String[] id) {
		return multipleSelectionController.findmultiple(id);
	}
	/**
	 * 
	 * @param multiple
	 * @param model
	 * @return
	 */
	@RequiresPermissions("createword:create:view")
	@RequestMapping(value = { "createword", "" })
	public String listmultiple(MultipleSelection multiple, Model model,SingleSelection single) {
		model.addAttribute("multiple", multiple);
		model.addAttribute("single", single);
		return "modules/createword/createWordList";
	}

	/**
	 * 单选题列表
	 * 
	 * @param single
	 * @param model
	 * @return
	 *//*
	@RequiresPermissions("createword:create:view")
	@RequestMapping(value = { "list", "" })
	public String list(SingleSelection single, Model model) {
		model.addAttribute("single", single);
		return "modules/single/singleSelectionList";
	}

	*//**
	 * 多选题列表
	 * 
	 * @param multiple
	 * @param model
	 * @return
	 *//*

	@RequiresPermissions("createword:create:view") 
	@RequestMapping(value = { "start", "" })
	public String start(MultipleSelection multiple, Model model) {
		model.addAttribute("multiple", multiple);
		return "modules/multiple/multipleSelectionList";
	}
*/
	/**
	 * 查询列表数据
	 */
	/*
	 * @RequiresPermissions("createword:create:view")
	 * 
	 * @RequestMapping(value = "listData")
	 * 
	 * @ResponseBody public Page<Single> listData(Single single, HttpServletRequest
	 * request, HttpServletResponse response) { single.setPage(new Page<>(request,
	 * response)); Page<Single> page = examService.findPage(single); return page; }
	 */

	/**
	 * 查看编辑表单
	 */
	/* @RequiresPermissions("exam:single:view") */
	@RequestMapping(value = "form")
	public String form(SingleSelection single, Model model) {
		model.addAttribute("single", single);
		return "modules/exam/singleForm";
	}

}