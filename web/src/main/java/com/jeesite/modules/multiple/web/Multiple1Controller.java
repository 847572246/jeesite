/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.multiple.web;

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
import com.jeesite.modules.multiple.entity.Multiple1;
import com.jeesite.modules.multiple.service.Multiple1Service;

/**
 * multiple_selectionController
 * @author xt
 * @version 2019-01-07
 */
@Controller
@RequestMapping(value = "${adminPath}/multiple/multiple1")
public class Multiple1Controller extends BaseController {

	@Autowired
	private Multiple1Service multiple1Service;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public Multiple1 get(String id, boolean isNewRecord) {
		return multiple1Service.get(id, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequiresPermissions("multiple:multiple1:view")
	@RequestMapping(value = {"list", ""})
	public String list(Multiple1 multiple1, Model model) {
		model.addAttribute("multiple1", multiple1);
		return "modules/multiple/multiple1List";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("multiple:multiple1:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<Multiple1> listData(Multiple1 multiple1, HttpServletRequest request, HttpServletResponse response) {
		multiple1.setPage(new Page<>(request, response));
		Page<Multiple1> page = multiple1Service.findPage(multiple1); 
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("multiple:multiple1:view")
	@RequestMapping(value = "form")
	public String form(Multiple1 multiple1, Model model) {
		model.addAttribute("multiple1", multiple1);
		return "modules/multiple/multiple1Form";
	}

	/**
	 * 保存multiple_selection
	 */
	@RequiresPermissions("multiple:multiple1:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated Multiple1 multiple1) {
		multiple1Service.save(multiple1);
		return renderResult(Global.TRUE, text("保存multiple_selection成功！"));
	}
	
	/**
	 * 删除multiple_selection
	 */
	@RequiresPermissions("multiple:multiple1:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(Multiple1 multiple1) {
		multiple1Service.delete(multiple1);
		return renderResult(Global.TRUE, text("删除multiple_selection成功！"));
	}
	
}