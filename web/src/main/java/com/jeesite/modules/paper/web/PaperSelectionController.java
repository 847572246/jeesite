/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.paper.web;

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
import com.jeesite.modules.paper.entity.PaperSelection;
import com.jeesite.modules.paper.service.PaperSelectionService;

/**
 * paper_selectionController
 * @author xt
 * @version 2019-03-26
 */
@Controller
@RequestMapping(value = "${adminPath}/paper/paperSelection")
public class PaperSelectionController extends BaseController {

	@Autowired
	private PaperSelectionService paperSelectionService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public PaperSelection get(String id, boolean isNewRecord) {
		return paperSelectionService.get(id, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequiresPermissions("paper:paperSelection:view")
	@RequestMapping(value = {"list", ""})
	public String list(PaperSelection paperSelection, Model model) {
		model.addAttribute("paperSelection", paperSelection);
		return "modules/paper/paperSelectionList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("paper:paperSelection:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<PaperSelection> listData(PaperSelection paperSelection, HttpServletRequest request, HttpServletResponse response) {
		paperSelection.setPage(new Page<>(request, response));
		Page<PaperSelection> page = paperSelectionService.findPage(paperSelection); 
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("paper:paperSelection:view")
	@RequestMapping(value = "form")
	public String form(PaperSelection paperSelection, Model model) {
		model.addAttribute("paperSelection", paperSelection);
		return "modules/paper/paperSelectionForm";
	}

	/**
	 * 保存答题表
	 */
	@RequiresPermissions("paper:paperSelection:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated PaperSelection paperSelection) {
		paperSelectionService.save(paperSelection);
		return renderResult(Global.TRUE, text("保存答题表成功！"));
	}
	
	/**
	 * 删除答题表
	 */
	@RequiresPermissions("paper:paperSelection:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(PaperSelection paperSelection) {
		paperSelectionService.delete(paperSelection);
		return renderResult(Global.TRUE, text("删除答题表成功！"));
	}
	
}