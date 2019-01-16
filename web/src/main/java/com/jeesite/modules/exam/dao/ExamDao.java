/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.exam.dao;

import java.util.List;

import com.jeesite.common.dao.CrudDao;
import com.jeesite.common.mybatis.annotation.MyBatisDao;
import com.jeesite.modules.exam.entity.Multiple;
import com.jeesite.modules.exam.entity.Single;

/**
 * 代码生成表DAO接口
 * @author xt
 * @version 2019-01-02
 */
@MyBatisDao
public interface ExamDao extends CrudDao<Single>{
	public List<Single> getsingle();
	public List<Multiple> getmultiple();
	public Single findsingle(String id);
	public Multiple findmultiple(String id);
}