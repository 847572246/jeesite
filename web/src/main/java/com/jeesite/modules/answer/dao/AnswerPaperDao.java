/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.answer.dao;

import com.jeesite.common.dao.CrudDao;
import com.jeesite.common.mybatis.annotation.MyBatisDao;
import com.jeesite.modules.answer.entity.AnswerPaper;
import com.jeesite.modules.examination.entity.ExaminationPaper;
import com.jeesite.modules.multiple.entity.MultipleSelection;
import com.jeesite.modules.single.entity.SingleSelection;

import java.util.List;

/**
 * answer_paperDAO接口
 * @author xt
 * @version 2019-03-20
 */
@MyBatisDao
public interface AnswerPaperDao extends CrudDao<AnswerPaper> {
    public List<SingleSelection> findexamsingle(String ids);
    public String findexamsingleid(String examid);
    public List<MultipleSelection> findexammultiple(String ids);
    public String findexammultipleid(String examid);
    void changpaperstatus(String answerPaperid);
    public String findanswersingle(String paperid);
    public String findanswermultiple(String paperid);

    public List<ExaminationPaper> findanswer(String paperid);
}