/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.answer.dao;

import com.jeesite.common.dao.CrudDao;
import com.jeesite.common.mybatis.annotation.MyBatisDao;
import com.jeesite.modules.answer.entity.AnswerPaper;

/**
 * answer_paperDAO接口
 * @author xt
 * @version 2019-03-19
 */
@MyBatisDao
public interface AnswerPaperDao extends CrudDao<AnswerPaper> {
	
}