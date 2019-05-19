/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.answer.dao;

import com.jeesite.common.dao.CrudDao;
import com.jeesite.common.mybatis.annotation.MyBatisDao;
import com.jeesite.modules.answer.entity.AnswerPaper;
import com.jeesite.modules.examination.entity.ExaminationPaper;
import com.jeesite.modules.multiple.entity.MultipleSelection;
import com.jeesite.modules.paper.entity.PaperSelection;
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
    void changpaperstatusone(String answerPaperid);
    void changpaperstatustwo(String answerPaperid);
    public String findanswersingle(String paperid);
    public String findanswermultiple(String paperid);
    public List<PaperSelection> findanswer(String paperid);
    public String findusername(String usercode);
    public String findpaperstatus(String id);

}