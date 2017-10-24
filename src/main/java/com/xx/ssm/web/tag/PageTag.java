package com.xx.ssm.web.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.github.pagehelper.PageInfo;

public class PageTag extends SimpleTagSupport {
	@Override
	public void doTag() throws JspException, IOException {
		PageInfo pageInfo=(PageInfo) getJspContext().findAttribute("pageInfo");
		System.out.println(pageInfo);
		JspWriter out = getJspContext().getOut();
		//Displaying 1 to 10 of 114 items
		String str="<div class=\"easyui-panel\"><div class=\"easyui-pagination\" data-options=\"total: "+pageInfo.getTotal()+",pageSize:"+pageInfo.getPageSize()+",showPageList: true,pageList:[5,10,15],showRefresh: false,beforePageText:'��',afterPageText:'ҳ �� {pages} ҳ',pageNumber:"+pageInfo.getPageNum()+",onSelectPage:function(pageNumber,pageSize){window.location.href='?pageSize='+pageSize+'&pageNum='+pageNumber;},displayMsg: '��ʾ"+((pageInfo.getPageNum()-1)*pageInfo.getPageSize()+1)+"��"+pageInfo.getEndRow()+",��"+pageInfo.getTotal()+"��'\"></div></div>";
		out.write(str);
	}
}
