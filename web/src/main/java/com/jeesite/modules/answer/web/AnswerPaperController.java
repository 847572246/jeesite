/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.answer.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jeesite.common.lang.StringUtils;
import com.jeesite.modules.examination.service.ExaminationPaperService;
import com.jeesite.modules.multiple.entity.AnswerMultiple;
import com.jeesite.modules.multiple.entity.MultipleSelection;
import com.jeesite.modules.multiple.service.MultipleSelectionService;
import com.jeesite.modules.paper.entity.PaperSelection;
import com.jeesite.modules.paper.entity.middlePaperSelection;
import com.jeesite.modules.paper.service.PaperSelectionService;
import com.jeesite.modules.single.entity.AnswerSingle;
import com.jeesite.modules.single.entity.SingleSelection;
import com.jeesite.modules.single.service.SingleSelectionService;
import com.jeesite.modules.sys.utils.UserUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.jeesite.common.config.Global;
import com.jeesite.common.entity.Page;
import com.jeesite.common.web.BaseController;
import com.jeesite.modules.answer.entity.AnswerPaper;
import com.jeesite.modules.answer.service.AnswerPaperService;

import java.lang.reflect.Array;
import java.util.*;

/**
 * answer_paperController
 * @author xt
 * @version 2019-03-20
 */
@Controller
@RequestMapping(value = "${adminPath}/answer/answerPaper")
public class AnswerPaperController extends BaseController {

	@Autowired
	private AnswerPaperService answerPaperService;
	@Autowired
	private PaperSelectionService paperSelectionService;
	@Autowired
	private SingleSelectionService singleSelectionService;
	@Autowired
	private MultipleSelectionService multipleSelectionService;
	@Autowired
	private ExaminationPaperService examinationPaperService;
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public AnswerPaper get(String id, boolean isNewRecord) {
		return answerPaperService.get(id, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequiresPermissions("answer:answerPaper:view")
	@RequestMapping(value = {"list", ""})
	public String list(AnswerPaper answerPaper, Model model) {
		String userName =  UserUtils.getUser().getUserCode();
		model.addAttribute("answerPaper", answerPaper);
		model.addAttribute("userName", userName);
		return "modules/answer/answerPaperList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("answer:answerPaper:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<AnswerPaper> listData(AnswerPaper answerPaper, HttpServletRequest request, HttpServletResponse response) {
		answerPaper.setPage(new Page<>(request, response));
		Page<AnswerPaper> page = answerPaperService.findPage(answerPaper); 
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("answer:answerPaper:view")
	@RequestMapping(value = "form")
	public String form(AnswerPaper answerPaper, Model model) {
		model.addAttribute("answerPaper", answerPaper);
		return "modules/answer/answerPaperForm";
	}
	/**
	 * 查询已答列表试卷数据
	 */
	@RequiresPermissions("answer:answerPaper:view")
	@RequestMapping(value = "listAnswerData")
	public String listpaperData(String id,Model model) {
		String sinquestionId = "";
		String mulquestionId = "";
		List<AnswerSingle> answerSingles=new ArrayList<AnswerSingle>();
		List<AnswerMultiple> answerMultiples=new ArrayList<AnswerMultiple>();
		List<PaperSelection> paperSelections =answerPaperService.findanswer(id);
		/*提取paperSelections的实体id*/
		for (int i=0;i<paperSelections.size();i++){
			if (paperSelections.get(i).getSinQuestionId()!=null){
				sinquestionId+=paperSelections.get(i).getSinQuestionId();
			}
			if (paperSelections.get(i).getMulQuestionId()!=null){
				mulquestionId+=paperSelections.get(i).getMulQuestionId();
			}
		}
		List<AnswerSingle> single=examinationPaperService.listanswersin(sinquestionId);
		List<AnswerMultiple> multiple=examinationPaperService.listanswermul(mulquestionId);
		/*根据试题id获取题库中的每个选项的错误原因*/
		for (int i=0;i<single.size();i++){
			for (int j=0;j<paperSelections.size();j++){
				if(single.get(i).getId().equals(paperSelections.get(j).getSinQuestionId())){
					single.get(i).setAnswer(paperSelections.get(j).getAnswer());
					single.get(i).setModelAnswers(paperSelections.get(j).getModelAnswers());
					single.get(i).setCorrect(paperSelections.get(j).getCorrect());
                    if (paperSelections.get(j).getAnswer().equals("A")){
                        single.get(i).setWrongReasonId(single.get(i).getAwrongReasonId());
                        single.get(i).setWrongReason(single.get(i).getAwrongReason());
                    }
                    if (paperSelections.get(j).getAnswer().equals("B")){
                        single.get(i).setWrongReasonId(single.get(i).getBwrongReasonId());
                        single.get(i).setWrongReason(single.get(i).getBwrongReason());
                    }
                    if (paperSelections.get(j).getAnswer().equals("C")){
                        single.get(i).setWrongReasonId(single.get(i).getCwrongReasonId());
                        single.get(i).setWrongReason(single.get(i).getCwrongReason());
                    }
                    if (paperSelections.get(j).getAnswer().equals("D")){
                        single.get(i).setWrongReasonId(single.get(i).getDwrongReasonId());
                        single.get(i).setWrongReason(single.get(i).getDwrongReason());
                    }
				}
			}
		}
		/*根据试题id获取题库中的每个选项的错误原因*/
		for (int i=0;i<multiple.size();i++){
			for (int j=0;j<paperSelections.size();j++){
				if(multiple.get(i).getId().equals(paperSelections.get(j).getMulQuestionId())){
					String reasonid="";
					String reason="";
					multiple.get(i).setAnswer(paperSelections.get(j).getAnswer());
					multiple.get(i).setModelAnswers(paperSelections.get(j).getModelAnswers());
					multiple.get(i).setCorrect(paperSelections.get(j).getCorrect());
                    if (paperSelections.get(j).getAnswer().indexOf("A")!=-1){
                        reasonid+=multiple.get(i).getAwrongReasonId();
						reason+=multiple.get(i).getAwrongReason();
                    }
                    if (paperSelections.get(j).getAnswer().indexOf("B")!=-1){
                        if (!reasonid.equals(null)&&!reasonid.equals("")){
							reasonid+=",";
							reason+=",";
                        }
						reasonid+=multiple.get(i).getBwrongReasonId();
						reason+=multiple.get(i).getBwrongReason();
                    }
                    if (paperSelections.get(j).getAnswer().indexOf("C")!=-1){
                        if (!reasonid.equals(null)&&!reasonid.equals("")){
							reasonid+=",";
							reason+=",";
                        }
						reasonid+=multiple.get(i).getCwrongReasonId();
						reason+=multiple.get(i).getCwrongReason();
                    }
                    if (paperSelections.get(j).getAnswer().indexOf("D")!=-1){
                        if (!reasonid.equals(null)&&!reasonid.equals("")){
							reasonid+=",";
							reason+=",";
                        }
						reasonid+=multiple.get(i).getDwrongReasonId();
						reason+=multiple.get(i).getDwrongReason();
                    }
					String [] result=reasonid.split(",");
					LinkedHashSet<String> set = new LinkedHashSet<String>(result.length);
                    set.addAll(Arrays.asList(result));
					reasonid = StringUtils.join(set.toArray(), ",");
					multiple.get(i).setWrongReasonId(reasonid);
					multiple.get(i).setWrongReason(reason);
					reasonid="";
				}
			}
		}
		String userName = answerPaperService.findusername(paperSelections.get(0).getUserCode());
		String paperstatus=answerPaperService.findpaperstatus(paperSelections.get(0).getPaperId());
		model.addAttribute("single",single);
		model.addAttribute("multiple",multiple);
		model.addAttribute("paperSelections",paperSelections);
		model.addAttribute("userName",userName);
		model.addAttribute("paperstatus",paperstatus);
		return "modules/examination/answer";
	}
	/**
	 * 保存答题表
	 */
	/*@RequiresPermissions("answer:answerPaper:edit")*/
	@PostMapping(value = "savepaper")
	@ResponseBody
	public String savepaper(@RequestBody List<middlePaperSelection> middlepaperSelections, HttpServletRequest request,String answerPaperid) {
        String user =  UserUtils.getUser().getUserCode();
        String paperId = request.getParameter("paperId");
        String sinanswer;
		String mulanswer;
		answerPaperService.changpaperstatusone(answerPaperid);
        	PaperSelection paperSelection=null;
        	for (middlePaperSelection middlePaperSelection : middlepaperSelections) {
				paperSelection = new PaperSelection();
				paperSelection.setUserCode(user);
				paperSelection.setSinQuestionId(middlePaperSelection.getSinQuestionId());
				paperSelection.setMulQuestionId(middlePaperSelection.getMulQuestionId());
				if (middlePaperSelection.getSinQuestionId()!=null){
					sinanswer=singleSelectionService.getsingleanswer(middlePaperSelection.getSinQuestionId());
					paperSelection.setModelAnswers(sinanswer);
					if (sinanswer.equals(middlePaperSelection.getAnswer())){
						paperSelection.setCorrect("1");
					}
					else {
						paperSelection.setCorrect("0");
					}
				}
				if (middlePaperSelection.getMulQuestionId()!=null){
					mulanswer=multipleSelectionService.getmultipleanswer(middlePaperSelection.getMulQuestionId());
					paperSelection.setModelAnswers(mulanswer);
					if (mulanswer.equals(middlePaperSelection.getAnswer())){
						paperSelection.setCorrect("1");
					}
					else {
						paperSelection.setCorrect("0");
					}
				}
				paperSelection.setAnswer(middlePaperSelection.getAnswer());
				paperSelection.setPaperId(answerPaperid);
				paperSelectionService.save(paperSelection);
			}
		return "保存答题表成功！";
        	//return renderResult(Global.TRUE, text("保存答题表成功！"));
	}

	/**
	 * 跳转答题页面
	 */
	@RequiresPermissions("answer:answerPaper:view")
	@RequestMapping(value = "exam")
	public String exam( Model model,String examid,String answerid) {
		PaperSelection paperSelection=new PaperSelection();
		String user =  UserUtils.getUser().getUserCode();
		paperSelection.setUserCode(user);
		paperSelection.setPaperId(examid);
		AnswerPaper answerPaper=new AnswerPaper();
		answerPaper.setId(answerid);
		String sinids=answerPaperService.findexamsingleid(examid);
		String mulids=answerPaperService.findexammultipleid(examid);
		List<SingleSelection> singleSelection=answerPaperService.findexamsingle(sinids);
		List<MultipleSelection> multipleSelection=answerPaperService.findexammultiple(mulids);
		model.addAttribute("single", singleSelection);
		model.addAttribute("multiple", multipleSelection);
		model.addAttribute("paperSelection", paperSelection);
		model.addAttribute("answerPaper", answerPaper);
		return "modules/exam/newexam";
	}
	/**
	 * 保存试卷
	 */
	@RequiresPermissions("answer:answerPaper:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated AnswerPaper answerPaper) {
		answerPaperService.save(answerPaper);
		return renderResult(Global.TRUE, text("保存试卷成功！"));
	}
	/**
	 * 保存试卷
	 */
	@RequiresPermissions("answer:answerPaper:edit")
	@PostMapping(value = "answer")
	@ResponseBody
	public String answer(@Validated AnswerPaper answerPaper) {
		answerPaperService.save(answerPaper);
		return renderResult(Global.TRUE, text("保存试卷成功！"));
	}
	/**
	 * 删除试卷
	 */
	@RequiresPermissions("answer:answerPaper:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(AnswerPaper answerPaper) {
		answerPaperService.delete(answerPaper);
		return renderResult(Global.TRUE, text("删除试卷成功！"));
	}

}