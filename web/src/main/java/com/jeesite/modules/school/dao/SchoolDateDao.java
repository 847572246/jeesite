/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.school.dao;

import com.jeesite.common.dao.CrudDao;
import com.jeesite.common.mybatis.annotation.MyBatisDao;
import com.jeesite.modules.school.entity.SchoolDate;

import java.util.List;

/**
 * school_dateDAO接口
 * @author xt
 * @version 2019-05-23
 */
@MyBatisDao
public interface SchoolDateDao extends CrudDao<SchoolDate> {
	public List<SchoolDate> all(String schyear, String usercode) ;
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