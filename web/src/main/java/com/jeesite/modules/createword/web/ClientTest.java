/*package com.jeesite.modules.createword.web;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import com.jeesite.modules.exam.web.ExamController;
import com.jeesite.modules.single.entity.SingleSelection;


public class ClientTest{
	 public static List<SingleSelection> initUserList(String qid){
	  ExamController examController=new ExamController();
	  User user1=new User();
	  user1.setUserName("张三");
	  user1.setUserPassword("123");
	  user1.setAge(20);
	  
	  User user2=new User();
	  user2.setUserName("李四");
	  user2.setUserPassword("123");
	  user2.setAge(22);
	  
	  User user3=new User();
	  user3.setUserName("王五");
	  user3.setUserPassword("123");
	  user3.setAge(21);
	  //examController.getsingle();
	List<SingleSelection> list=new ArrayList<SingleSelection>();
	  list.add(user1);
	  list.add(user2);
	list.add(user3);
	return list;
	}
	  public static void main(String[] args){
		  List<SingleSelection> list=ClientTest.initUserList(null);  
		Map<String,Object> root=new HashMap<String,Object>();
		root.put("userList",list);
		FreeMarkertUtil.analysisTemplate("C:/create/","test.ftl","C:/create/use.doc" + Math.random() * 10000 + ".doc", root);
		//FreeMarkUtil类可以参考我上传得源码。
		}
	}
*/