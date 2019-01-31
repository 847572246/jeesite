/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.wrongselect.web;

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
import com.jeesite.modules.wrongselect.entity.WrongSelection;
import com.jeesite.modules.wrongselect.service.WrongSelectionService;

/**
 * wrong_selectionController
 * @author xt
 * @version 2019-01-31
 */
@Controller
@RequestMapping(value = "${adminPath}/wrongselect/wrongSelection")
public class WrongSelectionController extends BaseController {

	@Autowired
	private WrongSelectionService wrongSelectionService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public WrongSelection get(String id, boolean isNewRecord) {
		return wrongSelectionService.get(id, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequiresPermissions("wrongselect:wrongSelection:view")
	@RequestMapping(value = {"list", ""})
	public String list(WrongSelection wrongSelection, Model model) {
		model.addAttribute("wrongSelection", wrongSelection);
		return "modules/wrongselect/wrongSelectionList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("wrongselect:wrongSelection:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<WrongSelection> listData(WrongSelection wrongSelection, HttpServletRequest request, HttpServletResponse response) {
		wrongSelection.setPage(new Page<>(request, response));
		Page<WrongSelection> page = wrongSelectionService.findPage(wrongSelection); 
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("wrongselect:wrongSelection:view")
	@RequestMapping(value = "form")
	public String form(WrongSelection wrongSelection, Model model) {
		model.addAttribute("wrongSelection", wrongSelection);
		return "modules/wrongselect/wrongSelectionForm";
	}

	/**
	 * 保存错题库
	 */
	@RequiresPermissions("wrongselect:wrongSelection:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated WrongSelection wrongSelection) {
		wrongSelectionService.save(wrongSelection);
		return renderResult(Global.TRUE, text("保存错题库成功！"));
	}
	
	/**
	 * 删除错题库
	 */
	@RequiresPermissions("wrongselect:wrongSelection:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(WrongSelection wrongSelection) {
		wrongSelectionService.delete(wrongSelection);
		return renderResult(Global.TRUE, text("删除错题库成功！"));
	}
	
}