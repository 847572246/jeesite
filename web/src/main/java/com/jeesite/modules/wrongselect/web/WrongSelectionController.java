/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.wrongselect.web;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jeesite.common.config.Global;
import com.jeesite.common.entity.Page;
import com.jeesite.common.web.BaseController;
import com.jeesite.modules.multiple.entity.MultipleSelection;
import com.jeesite.modules.single.entity.SingleSelection;
import com.jeesite.modules.sys.entity.EmpUser;
import com.jeesite.modules.sys.entity.Post;
import com.jeesite.modules.wrong.entity.WrongReason;
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
	
	
	@RequiresPermissions("wrongselect:wrongSelection:view")
	@RequestMapping(value = "selectselection")
	public List<List<String>> selectselection(@RequestParam String[] wrongreasonid, @RequestParam String[] singlecount, @RequestParam String[] multiplecount, Model model) {
		List<List<String>> list = new ArrayList<List<String>>();
		List<String> singleid=new ArrayList<String>();
		List<String> multipleid=new ArrayList<String>();
		for (int i = 0; i < wrongreasonid.length; i++) {
			singleid.addAll(wrongSelectionService.selectionsingle(wrongreasonid[i],singlecount[i]));
			multipleid.addAll(wrongSelectionService.selectionmultiple(wrongreasonid[i],multiplecount[i]));
		}
		list.add(singleid);
		list.add(multipleid);
		model.addAttribute("selectsinid", singleid);
		model.addAttribute("selectmulid", multipleid);
		//return "modules/createword/autocreateWordList";
		return list;
	}

	/*@RequiresPermissions("wrongselect:wrongSelection:view")
	@RequestMapping(value = "listwrongreason")
	public String transfer(@RequestParam List<List<String>> list, Model model) {
		//List<WrongSelection> userwrongs=wrongSelectionService.findwrong(usercode);
		model.addAttribute("userwrongs", list);
		return "modules/createword/autocreateWordList";
	}*/
	/**
	 * 根据用户查询错误原因
	 * @param usercode
	 * @return
	 */
	@RequiresPermissions("wrongselect:wrongSelection:view")
	@RequestMapping(value = "listwrongreason")
	public String finduserwrong(@RequestParam String usercode, Model model) {
		List<WrongSelection> userwrongs=wrongSelectionService.findwrong(usercode);
		model.addAttribute("userwrongs", userwrongs);
		return "modules/createword/userreason";
	}
	
	/**
	 * 查询错误原因列表
	 */
	@RequiresPermissions("wrongselect:wrongSelection:view")
	@RequestMapping(value = {"userreason", ""})
	public String userreason(WrongSelection wrongselection, Model model) {
		model.addAttribute("WrongSelection", wrongselection);
		return "modules/createword/userreason";
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
	 * 查询错误原因列表
	 */
	@RequiresPermissions("wrongselect:wrongSelection:view")
	@RequestMapping(value = {"wrongreason", ""})
	public String list(WrongReason wrongReason, Model model) {
		model.addAttribute("wrongReason", wrongReason);
		return "modules/wrongselect/wrongReasonList";
	}

	/**
	 * 查询单选题列表
	 */
	@RequiresPermissions("wrongselect:wrongSelection:view")
	@RequestMapping(value = {"single", ""})
	public String listsingle(SingleSelection singleSelection, Model model) {
		model.addAttribute("singleSelection", singleSelection);
		return "modules/wrongselect/wrongsingle";
	}
	/**
	 * 查询多选题列表
	 */
	@RequiresPermissions("wrongselect:wrongSelection:view")
	@RequestMapping(value = {"multiple", ""})
	public String listmultiple(MultipleSelection multipleSelection, Model model) {
		model.addAttribute("multipleSelection", multipleSelection);
		return "modules/wrongselect/wrongmultiple";
	}
	/**
	 * 
	 * @param empUser
	 * @param model
	 * @return
	 */
	@RequiresPermissions("wrongselect:wrongSelection:view")
	@RequestMapping(value = "listuser")
	public String list(EmpUser empUser, Model model) {
		// 获取岗位列表
		Post post = new Post();
		//model.addAttribute("postList", postService.findList(post));
		return "modules/wrongselect/empUserList";
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