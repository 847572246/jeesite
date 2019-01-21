/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.wrong.dao;

import java.util.List;

import com.jeesite.common.dao.CrudDao;
import com.jeesite.common.mybatis.annotation.MyBatisDao;
import com.jeesite.modules.single.entity.SingleSelection;
import com.jeesite.modules.wrong.entity.WrongReason;

/**
 * wrong_reasonDAO接口
 * @author xt
 * @version 2019-01-08
 */
@MyBatisDao
public interface WrongReasonDao extends CrudDao<WrongReason> {
	public String getwrongid(String user);
	public List<SingleSelection> getwrong(String wrong);
}