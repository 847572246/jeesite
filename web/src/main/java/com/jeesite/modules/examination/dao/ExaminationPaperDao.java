/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.examination.dao;

import com.jeesite.common.dao.CrudDao;
import com.jeesite.common.mybatis.annotation.MyBatisDao;
import com.jeesite.modules.examination.entity.ExaminationPaper;

/**
 * examination_paperDAO接口
 * @author xt
 * @version 2019-03-18
 */
@MyBatisDao
public interface ExaminationPaperDao extends CrudDao<ExaminationPaper> {
	
}