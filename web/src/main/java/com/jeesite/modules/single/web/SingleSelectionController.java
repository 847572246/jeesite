/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.single.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jeesite.common.config.Global;
import com.jeesite.common.entity.Page;
import com.jeesite.common.web.BaseController;
import com.jeesite.modules.single.entity.SingleSelection;
import com.jeesite.modules.single.service.SingleSelectionService;

/**
 * single_selectionController
 * @author xt
 * @version 2019-01-18
 */
@Service
@Controller
@RequestMapping(value = "${adminPath}/single/singleSelection")
public class SingleSelectionController extends BaseController {

	@Autowired
	private SingleSelectionService singleSelectionService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public SingleSelection get(String id, boolean isNewRecord) {
		return singleSelectionService.get(id, isNewRecord);
	}
	
	 
	/**
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "findsingle")
	@ResponseBody
	public List<SingleSelection> findsingle(String[] id) {
		List<SingleSelection> list=new ArrayList<SingleSelection>();
		for (int i = 0; i < id.length; i++) {
			list.add(singleSelectionService.findsingle(id[i]));
		}
		return list;
	}
	/**
	 * 
	 * @return
	 */
	@RequestMapping(value = "getsingle")
	@ResponseBody
	public List<SingleSelection> getsingle() {
		List<SingleSelection> single=singleSelectionService.getsingle();
		for (int i = 0; i < single.size(); i++) {
			System.out.println(single.get(i));
		}
		
		return single;
	}
	
	/**
	 * 查询列表
	 */
	@RequiresPermissions("single:singleSelection:view")
	@RequestMapping(value = {"list", ""})
	public String list(SingleSelection singleSelection, Model model) {
		model.addAttribute("singleSelection", singleSelection);
		return "modules/single/singleSelectionList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("single:singleSelection:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<SingleSelection> listData(SingleSelection singleSelection, HttpServletRequest request, HttpServletResponse response) {
		singleSelection.setPage(new Page<>(request, response));
		Page<SingleSelection> page = singleSelectionService.findPage(singleSelection); 
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("single:singleSelection:view")
	@RequestMapping(value = "form")
	public String form(SingleSelection singleSelection, Model model) {
		model.addAttribute("singleSelection", singleSelection);
		return "modules/single/singleSelectionForm";
	}

	/**
	 * 保存单项选择题
	 */
	@RequiresPermissions("single:singleSelection:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated SingleSelection singleSelection) {
		singleSelectionService.save(singleSelection);
		return renderResult(Global.TRUE, text("保存单项选择题成功！"));
	}
	
	/**
	 * 删除单项选择题
	 */
	@RequiresPermissions("single:singleSelection:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(SingleSelection singleSelection) {
		singleSelectionService.delete(singleSelection);
		return renderResult(Global.TRUE, text("删除单项选择题成功！"));
	}
	
}