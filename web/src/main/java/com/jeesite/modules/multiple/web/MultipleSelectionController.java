/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.multiple.web;

import java.util.ArrayList;
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
import com.jeesite.modules.multiple.entity.MultipleSelection;
import com.jeesite.modules.multiple.service.MultipleSelectionService;
import com.jeesite.modules.single.entity.SingleSelection;
import com.jeesite.modules.wrong.entity.WrongReason;

/**
 * multiple_selectionController
 * @author xt
 * @version 2019-01-17
 */
@Controller
@RequestMapping(value = "${adminPath}/multiple/multipleSelection")
public class MultipleSelectionController extends BaseController {

	@Autowired
	private MultipleSelectionService multipleSelectionService;
	
	/**
	 * 
	 * @param mulids
	 * @return
	 */
	@RequestMapping(value = "findmultiple")
	@ResponseBody
	public List<MultipleSelection> findmultiple(String[] mulids) {
		List<MultipleSelection> list=new ArrayList<MultipleSelection>(); 
		for (int i = 0; i < mulids.length; i++) {
			list.add(multipleSelectionService.findmultiple(mulids[i]));
		}
		return list;
	}
	/**
	 * 
	 * @return
	 */
	@RequestMapping(value = "getmultiple")
	@ResponseBody
	public List<MultipleSelection> getmultiple() {
		List<MultipleSelection> multiple=multipleSelectionService.getmultiple();
		return multiple;
	}
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public MultipleSelection get(String id, boolean isNewRecord) {
		return multipleSelectionService.get(id, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequiresPermissions("multiple:multipleSelection:view")
	@RequestMapping(value = {"list", ""})
	public String list(MultipleSelection multipleSelection, Model model) {
		model.addAttribute("multipleSelection", multipleSelection);
		return "modules/multiple/multipleSelectionList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("multiple:multipleSelection:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<MultipleSelection> listData(MultipleSelection multipleSelection, HttpServletRequest request, HttpServletResponse response) {
		multipleSelection.setPage(new Page<>(request, response));
		Page<MultipleSelection> page = multipleSelectionService.findPage(multipleSelection); 
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("multiple:multipleSelection:view")
	@RequestMapping(value = "form")
	public String form(MultipleSelection multipleSelection, Model model) {
		model.addAttribute("multipleSelection", multipleSelection);
		return "modules/multiple/multipleSelectionForm";
	}
	
	/**
	 * 查询错误原因列表
	 */
	@RequiresPermissions("multiple:multipleSelection:edit")
	@RequestMapping(value = {"wrongreason", ""})
	public String list(WrongReason wrongReason, Model model) {
		model.addAttribute("wrongReason", wrongReason);
		return "modules/multiple/wrongReasonList";
	}
	
	/**
	 * 保存多项选择题
	 */
	@RequiresPermissions("multiple:multipleSelection:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated MultipleSelection multipleSelection) {
		multipleSelectionService.save(multipleSelection);
		return renderResult(Global.TRUE, text("保存多项选择题成功！"));
	}
	
	/**
	 * 删除多项选择题
	 */
	@RequiresPermissions("multiple:multipleSelection:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(MultipleSelection multipleSelection) {
		multipleSelectionService.delete(multipleSelection);
		return renderResult(Global.TRUE, text("删除多项选择题成功！"));
	}

	
}