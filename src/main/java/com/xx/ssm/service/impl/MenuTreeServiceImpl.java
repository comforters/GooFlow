package com.xx.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xx.ssm.dao.IMenuTreeDao;
import com.xx.ssm.entity.TreeNode;
import com.xx.ssm.service.IMenuTreeService;
@Service
public class MenuTreeServiceImpl implements IMenuTreeService {
	@Autowired
	private IMenuTreeDao menuTreeDao;
	@Override
	public String getMenuTreeJson(int topId) {
		List<TreeNode> list= getMenuTreeList(topId);
		return getListJson(list);
	}
	private String getListJson(List<TreeNode> list) {
		StringBuffer treeNodeJson = new StringBuffer("[");
		if (list != null) {
			for (int i = 0; i < list.size(); i++) {
				TreeNode treeNode = list.get(i);
				treeNodeJson.append("{\"id\":");
				treeNodeJson.append(treeNode.getId());
				treeNodeJson.append(",");
				treeNodeJson.append("\"text\":");
				treeNodeJson.append("\"");
				treeNodeJson.append(treeNode.getNodeName());
				treeNodeJson.append("\"");
				if(treeNode.getList()!=null && treeNode.getList().size()>0){
					treeNodeJson.append(",\""+"children"+"\":");
					treeNodeJson.append(getListJson(treeNode.getList()));
				}
				if(i==list.size()-1){
					treeNodeJson.append("}");
				}else{
					treeNodeJson.append("},");
				}
			}
			treeNodeJson.append("]");
			return treeNodeJson.toString();
		}else{
			return null;
		}
	}
	private List getMenuTreeList(int id){
		List<TreeNode> nodes = menuTreeDao.queryMenuTreeNodes(id);
		for (TreeNode treeNode : nodes) { 
			List<TreeNode> list = getMenuTreeList(treeNode.getId()); // 获取2级目录
			if(list!=null){
				treeNode.setList(list);
			}
		}
		return nodes;
	}
	
}
