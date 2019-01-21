/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.exam.dao;

import java.util.List;

import com.jeesite.common.dao.CrudDao;
import com.jeesite.common.mybatis.annotation.MyBatisDao;
import com.jeesite.modules.multiple.entity.MultipleSelection;
import com.jeesite.modules.single.entity.SingleSelection;

/**
 * 代码生成表DAO接口
 * @author xt
 * @version 2019-01-02
 */
@MyBatisDao
public interface ExamDao extends CrudDao<SingleSelection>{
	public List<SingleSelection> getsingle();
	public List<MultipleSelection> getmultiple();
	public MultipleSelection findmultiple(String id);
	public SingleSelection findsingle(String id);
}