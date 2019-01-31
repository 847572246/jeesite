/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.wrongselect.dao;

import com.jeesite.common.dao.CrudDao;
import com.jeesite.common.mybatis.annotation.MyBatisDao;
import com.jeesite.modules.wrongselect.entity.WrongSelection;

/**
 * wrong_selectionDAO接口
 * @author xt
 * @version 2019-01-31
 */
@MyBatisDao
public interface WrongSelectionDao extends CrudDao<WrongSelection> {
	
}