/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.school.web;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
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

import com.jeesite.modules.common.ApiConst;
import com.jeesite.common.config.Global;
import com.jeesite.common.entity.Page;
import com.jeesite.common.shiro.realm.LoginInfo;
import com.jeesite.common.web.BaseController;
import com.jeesite.modules.school.entity.SchoolDate;
import com.jeesite.modules.school.service.SchoolDateService;
import com.jeesite.modules.sys.entity.User;
import com.jeesite.modules.sys.utils.UserUtils;

/**
 * school_dateController
 * @author xt
 * @version 2019-05-23
 */
@Controller
@RequestMapping(value = "${adminPath}/school/schoolDate")
public class SchoolDateController extends BaseController {

	@Autowired
	private SchoolDateService schoolDateService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public SchoolDate get(String id, boolean isNewRecord) {
		return schoolDateService.get(id, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequiresPermissions("school:schoolDate:view")
	@RequestMapping(value = {"list", ""})
	public String list(SchoolDate schoolDate, Model model) {
		model.addAttribute("schoolDate", schoolDate);
		return "modules/school/schoolDateList";
	}
	/**
	 * 查询成绩
	 * @param schyear
	 * @param usercode
	 * @return
	 */

	@PostMapping(ApiConst.SCHOOL_SCORE_LIST)
	@ResponseBody
	public List<List<String>> schoolData(@RequestParam String schyear,@RequestParam String usercode, Model model){
		List<List<String>> list = new ArrayList<List<String>>();
		List<String> chinese=new ArrayList<String>();
		List<String> math=new ArrayList<String>();
		List<String> english=new ArrayList<String>();
		List<String> chemical=new ArrayList<String>();
		List<String> physical=new ArrayList<String>();
		List<String> biological=new ArrayList<String>();
		List<String> history=new ArrayList<String>();
		List<String> geographic=new ArrayList<String>();
		List<String> political=new ArrayList<String>();
		List<String> examname=new ArrayList<String>();
		List<SchoolDate> all=schoolDateService.all(schyear,usercode);
		for (int i=0;i<all.size();i++){
			chinese.add(all.get(i).getChineseScore());
			math.add(all.get(i).getMathScore());
			english.add(all.get(i).getEnglishScore());
			chemical.add(all.get(i).getChemicalScore());
			physical.add(all.get(i).getPhysicalScore());
			biological.add(all.get(i).getBiologicalScore());
			history.add(all.get(i).getHistoryScore());
			geographic.add(all.get(i).getGeographicScore());
			political.add(all.get(i).getPhysicalScore());
			examname.add(all.get(i).getExamName());
		}


		/*List<String> chinese=schoolDateService.chinese(schyear,usercode);
		List<String> math=schoolDateService.math(schyear,usercode);
		List<String> english=schoolDateService.english(schyear,usercode);
		List<String> chemical=schoolDateService.chemical(schyear,usercode);
		List<String> physical=schoolDateService.physical(schyear,usercode);
		List<String> biological=schoolDateService.biological(schyear,usercode);
		List<String> history=schoolDateService.history(schyear,usercode);
		List<String> geographic=schoolDateService.geographic(schyear,usercode);
		List<String> political=schoolDateService.political(schyear,usercode);
		List<String> examname=schoolDateService.examname(schyear,usercode);*/
		list.add(examname);
		list.add(chinese);
		list.add(math);
		list.add(english);
		list.add(chemical);
		list.add(physical);
		list.add(biological);
		list.add(history);
		list.add(geographic);
		list.add(political);
		return list;
	}
	/**
	 * 获取学年
	 * @param usercode
	 * @return
	 */
	@PostMapping(value = "school_year")
	@ResponseBody
	public List<String> schoolyear(@RequestParam String usercode){
		List<String> list=schoolDateService.schoolyear(usercode);
		LinkedHashSet<String> set = new LinkedHashSet<String>(list.size());
	    set.addAll(list);
	    list.clear();
	    list.addAll(set);
		return list;
	}
	/**
	 * 获取用户id
	 * @return
	 */
	@PostMapping(value = "userid")
	@ResponseBody
	public String getuserid() {
		String user =   UserUtils.getUser().getUserCode();
		return user;
	}
	/**
	 * 获取用户类型
	 * @return
	 */
	@PostMapping(value = "usertype")
	@ResponseBody
	public String getusertype() {
		String user =   UserUtils.getUser().getUserType();
		return user;
	}
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("school:schoolDate:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<SchoolDate> listData(SchoolDate schoolDate, HttpServletRequest request, HttpServletResponse response) {
		schoolDate.setPage(new Page<>(request, response));
		Page<SchoolDate> page = schoolDateService.findPage(schoolDate); 
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("school:schoolDate:view")
	@RequestMapping(value = "form")
	public String form(SchoolDate schoolDate, Model model) {
		model.addAttribute("schoolDate", schoolDate);
		return "modules/school/schoolDateForm";
	}

	/**
	 * 保存school_date
	 */
	@RequiresPermissions("school:schoolDate:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated SchoolDate schoolDate) {
		schoolDateService.save(schoolDate);
		return renderResult(Global.TRUE, text("保存school_date成功！"));
	}
	
	/**
	 * 删除school_date
	 */
	@RequiresPermissions("school:schoolDate:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(SchoolDate schoolDate) {
		schoolDateService.delete(schoolDate);
		return renderResult(Global.TRUE, text("删除school_date成功！"));
	}
	
}