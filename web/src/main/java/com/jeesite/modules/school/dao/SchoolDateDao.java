/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.school.dao;

import java.util.List;

import com.jeesite.common.dao.CrudDao;
import com.jeesite.common.mybatis.annotation.MyBatisDao;
import com.jeesite.modules.school.entity.SchoolDate;

/**
 * school_dateDAO接口
 * @author xt
 * @version 2018-12-21
 */
@MyBatisDao
public interface SchoolDateDao extends CrudDao<SchoolDate> {
	public List<String> chinese(String schyear, String usercode) ;
	public List<String> math(String schyear, String usercode) ;
	public List<String> english(String schyear, String usercode) ;
	public List<String> chemical(String schyear, String usercode) ;
	public List<String> physical(String schyear, String usercode) ;
	public List<String> biological(String schyear, String usercode) ;
	public List<String> history(String schyear, String usercode) ;
	public List<String> geographic(String schyear, String usercode) ;
	public List<String> political(String schyear, String usercode) ;
	public List<String> examname(String schyear, String usercode) ;
	public List<String> schoolyear(String usercode);
}