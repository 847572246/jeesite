/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.paper.dao;

import com.jeesite.common.dao.CrudDao;
import com.jeesite.common.mybatis.annotation.MyBatisDao;
import com.jeesite.modules.paper.entity.PaperSelection;

/**
 * paper_selectionDAO接口
 * @author xt
 * @version 2019-03-26
 */
@MyBatisDao
public interface PaperSelectionDao extends CrudDao<PaperSelection> {
	
}