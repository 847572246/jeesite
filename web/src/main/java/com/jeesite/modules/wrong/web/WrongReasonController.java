/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.wrong.web;

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
import com.jeesite.modules.sys.utils.UserUtils;
import com.jeesite.modules.wrong.entity.WrongReason;
import com.jeesite.modules.wrong.service.WrongReasonService;
import com.jeesite.modules.exam.entity.Single;


/**
 * wrong_reasonController
 * @author xt
 * @version 2019-01-08
 */
@Controller
@RequestMapping(value = "${adminPath}/wrong/wrongReason")
public class WrongReasonController extends BaseController {

	@Autowired
	private WrongReasonService wrongReasonService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public WrongReason get(String id, boolean isNewRecord) {
		return wrongReasonService.get(id, isNewRecord);
	}
	@PostMapping(value = "wrongid")
	@ResponseBody
	public List<Single> getwrongid() {
		List<Single> list = new ArrayList<Single>();
		String user =   UserUtils.getUser().getUserCode();
		String wrongid=wrongReasonService.getwrongid(user);
		String[] sp=wrongid.split(",");
		for (int i = 0; i < sp.length; i++) {
			list.addAll(wrongReasonService.getwrong(sp[i]));
		}
		
		return list;
	}
	/*@PostMapping(value = "wrong")
	@ResponseBody
	public List<Single> getwrong(String wrongid){
		List<Single> list=wrongReasonService.getwrong(wrongid);
		return list;
	}*/
	/**
	 * 查询列表
	 */
	@RequiresPermissions("wrong:wrongReason:view")
	@RequestMapping(value = {"list", ""})
	public String list(WrongReason wrongReason, Model model) {
		model.addAttribute("wrongReason", wrongReason);
		return "modules/wrong/wrongReasonList";
	}
	@RequiresPermissions("wrong:wrongReason:view")
	@RequestMapping(value = {"test", ""})
	public String test(WrongReason wrongReason, Model model) {
		model.addAttribute("wrongReason", wrongReason);
		return "modules/test/test";
	}
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("wrong:wrongReason:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<WrongReason> listData(WrongReason wrongReason, HttpServletRequest request, HttpServletResponse response) {
		wrongReason.setPage(new Page<>(request, response));
		Page<WrongReason> page = wrongReasonService.findPage(wrongReason); 
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("wrong:wrongReason:view")
	@RequestMapping(value = "form")
	public String form(WrongReason wrongReason, Model model) {
		model.addAttribute("wrongReason", wrongReason);
		return "modules/wrong/wrongReasonForm";
	}

	/**
	 * 保存wrong_reason
	 */
	@RequiresPermissions("wrong:wrongReason:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated WrongReason wrongReason) {
		wrongReasonService.save(wrongReason);
		return renderResult(Global.TRUE, text("保存wrong_reason成功！"));
	}
	
	/**
	 * 删除wrong_reason
	 */
	@RequiresPermissions("wrong:wrongReason:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(WrongReason wrongReason) {
		wrongReasonService.delete(wrongReason);
		return renderResult(Global.TRUE, text("删除wrong_reason成功！"));
	}
	
}