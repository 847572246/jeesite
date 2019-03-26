/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.multiple.dao;

import java.util.List;

import com.jeesite.common.dao.CrudDao;
import com.jeesite.common.mybatis.annotation.MyBatisDao;
import com.jeesite.modules.multiple.entity.MultipleSelection;

/**
 * multiple_selectionDAO接口
 * @author xt
 * @version 2019-01-17
 */
@MyBatisDao
public interface MultipleSelectionDao extends CrudDao<MultipleSelection> {
	public List<MultipleSelection> getmultiple();
	public MultipleSelection findmultiple(String mulids);
}