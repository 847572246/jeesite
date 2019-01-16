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
import com.jeesite.modules.exam.entity.Multiple;
import com.jeesite.modules.exam.entity.Single;
import com.jeesite.modules.exam.service.ExamService;
import com.jeesite.modules.exam.web.ExamController;
import freemarker.template.Configuration;
import freemarker.template.Template;

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

	@RequiresPermissions("createword:create:view")
	@RequestMapping(value = "create")
	public void exportSimpleWord(String[] qid) {
		List<Single> list = CreateWordController.initUserList(qid);
		List<Multiple> list1 = CreateWordController.inUserList(qid);
		Map<String, Object> root = new HashMap<String, Object>();
		root.put("single", list);
		root.put("multiple", list1);
		FreeMarkertUtil.analysisTemplate("C:/create/", "test.ftl", "C:/create/use.doc" + Math.random() * 10000 + ".doc",
				root);
	}
	
	public static List<Single> initUserList(String[] id) {
		ExamController examcontroller = new ExamController();
		
		List<Single> list = new ArrayList<Single>();
		for (int i = 0; i < id.length; i++) {
			list.add(examcontroller.findsingle(id[i]));
		}
		
		return list;
	}
	public static List<Multiple> inUserList(String[] id) {
		ExamController examcontroller = new ExamController();
		List<Multiple> list = new ArrayList<Multiple>();
		for (int i = 0; i < id.length; i++) {
			list.add(examcontroller.findmultiple(id[i]));
		}
		return list;
	}
	

	
	/**
	 * 单选题列表
	 * 
	 * @param single
	 * @param model
	 * @return
	 */
	@RequiresPermissions("createword:create:view")
	@RequestMapping(value = { "list", "" })
	public String list(Single single, Model model) {
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
	public String listmultiple(Single multiple, Model model) {
		model.addAttribute("multiple", multiple);
		return "modules/exam/multipleList";
	}

	/* @RequiresPermissions("exam:single:view") */
	@RequestMapping(value = { "start", "" })
	public String start(Single single, Model model) {
		model.addAttribute("single", single);
		return "modules/exam/ti";
	}
	/**
	 * 
	 * @return
	 */
	/*
	 * @RequestMapping(value = "getsingle")
	 * 
	 * @ResponseBody public List<Single> getsingle() { List<Single>
	 * single=examService.getsingle(); return single; }
	 */
	/**
	 * 
	 * @return
	 */
	/*
	 * @RequestMapping(value = "getmultiple")
	 * 
	 * @ResponseBody public List<Multiple> getmultiple() { List<Multiple>
	 * multiple=examService.getmultiple(); return multiple; }
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
	public String form(Single single, Model model) {
		model.addAttribute("single", single);
		return "modules/exam/singleForm";
	}

	
}