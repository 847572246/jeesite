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
	private SingleSelectionController singleselectioncontroller;
	private MultipleSelectionController multipleSelectionController;

@RequestMapping(value = "create")
@ResponseBody
	public void exportSimpleWord() {
		String[] qid= {"1085352781168775168","1085353136787034112","1085353276662878208","1082173345942388736","1085352629917978624","1085354419958845440","1085354551022456832"};
		//SingleSelectionController singleController=new SingleSelectionController();
		//MultipleSelectionController multipleController=new MultipleSelectionController();
		List<SingleSelection> list = singleselectioncontroller.findsingle(qid);
		List<MultipleSelection> list1 = multipleSelectionController.findmultiple(qid);
		Map<String, Object> root = new HashMap<String, Object>();
		root.put("single", list);
		root.put("multiple", list1);
		FreeMarkertUtil.analysisTemplate("C:/create/", "test.ftl", "C:/create/use.doc" + Math.random() * 10000 + ".doc",
				root);
	} 
	
	/*public static  List<SingleSelection> initUserList(String[] id) {
		SingleSelectionController singleController=new SingleSelectionController();
		return singleController.findsingle(id);
	}*/
/*	public static  List<MultipleSelection> inUserList(String[] id) {
		MultipleSelectionController multipleController=new MultipleSelectionController();
		return multipleController.findmultiple(id);
	}*/
	

	
	/**
	 * 单选题列表
	 * 
	 * @param single
	 * @param model
	 * @return
	 */
	@RequiresPermissions("createword:create:view")
	@RequestMapping(value = { "list", "" })
	public String list(SingleSelection single, Model model) {
		model.addAttribute("single", single);
		return "modules/exam/singleList";
	}

	/**
	 * 多选题列表
	 * 
	 * @param multiple
	 * @param model
	 * @return
	 */
	@RequiresPermissions("createword:create:view")
	@RequestMapping(value = { "listmultiple", "" })
	public String listmultiple(SingleSelection multiple, Model model) {
		model.addAttribute("multiple", multiple);
		return "modules/exam/multipleList";
	}

	/* @RequiresPermissions("exam:single:view") */
	@RequestMapping(value = { "start", "" })
	public String start(SingleSelection single, Model model) {
		model.addAttribute("single", single);
		return "modules/exam/ti";
	}
	
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