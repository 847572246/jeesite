/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.single.dao;

import java.util.List;

import com.jeesite.common.dao.CrudDao;
import com.jeesite.common.mybatis.annotation.MyBatisDao;
import com.jeesite.modules.multiple.entity.MultipleSelection;
import com.jeesite.modules.single.entity.SingleSelection;

/**
 * single_selectionDAO接口
 * @author xt
 * @version 2019-01-18
 */
@MyBatisDao
public interface SingleSelectionDao extends CrudDao<SingleSelection> {
	public List<SingleSelection> getsingle();
	public SingleSelection findsingle(String id);
}