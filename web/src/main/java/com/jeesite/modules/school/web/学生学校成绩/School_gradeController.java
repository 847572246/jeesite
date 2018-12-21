/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.school.web.学生学校成绩;

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
import com.jeesite.modules.school.entity.学生学校成绩.School_grade;
import com.jeesite.modules.school.service.学生学校成绩.School_gradeService;

/**
 * 测试数据Controller
 * @author ThinkGem
 * @version 2018-12-20
 */
@Controller
@RequestMapping(value = "${adminPath}/school/学生学校成绩/school_grade")
public class School_gradeController extends BaseController {

	@Autowired
	private School_gradeService school_gradeService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public School_grade get(String id, boolean isNewRecord) {
		return school_gradeService.get(id, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequiresPermissions("school:学生学校成绩:school_grade:view")
	@RequestMapping(value = {"list", ""})
	public String list(School_grade school_grade, Model model) {
		model.addAttribute("school_grade", school_grade);
		return "modules/school/学生学校成绩/school_gradeList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("school:学生学校成绩:school_grade:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<School_grade> listData(School_grade school_grade, HttpServletRequest request, HttpServletResponse response) {
		school_grade.setPage(new Page<>(request, response));
		Page<School_grade> page = school_gradeService.findPage(school_grade); 
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("school:学生学校成绩:school_grade:view")
	@RequestMapping(value = "form")
	public String form(School_grade school_grade, Model model) {
		model.addAttribute("school_grade", school_grade);
		return "modules/school/学生学校成绩/school_gradeForm";
	}

	/**
	 * 保存数据
	 */
	@RequiresPermissions("school:学生学校成绩:school_grade:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated School_grade school_grade) {
		school_gradeService.save(school_grade);
		return renderResult(Global.TRUE, text("保存数据成功！"));
	}
	
	/**
	 * 删除数据
	 */
	@RequiresPermissions("school:学生学校成绩:school_grade:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(School_grade school_grade) {
		school_gradeService.delete(school_grade);
		return renderResult(Global.TRUE, text("删除数据成功！"));
	}
	
}