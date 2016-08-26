package com.cd.mx.action;

import java.util.ArrayList;
import java.util.List;

import com.cd.mx.model.BasicTrackingMessage;

public class PathAction {
	

	private List<BasicTrackingMessage> actionList=new ArrayList<BasicTrackingMessage>();
	
	public PathAction() {
		
	}
	
	public PathAction(List<BasicTrackingMessage> listBasicTrackingMessage) {
		actionList=listBasicTrackingMessage;
	}
	
	public int getDegreesAction(){
		return actionList.size();		
	}
	
	public void addPathAction(BasicTrackingMessage btm){
		actionList.add(btm);
	}
	
	public List<BasicTrackingMessage> copieAndLastPathAction(BasicTrackingMessage btm){
		List<BasicTrackingMessage> copieList= new ArrayList<BasicTrackingMessage>();
		for(int i=0;i<actionList.size();i++){
			copieList.add(actionList.get(i));
		}
		return copieList;
	}

	public List<BasicTrackingMessage> getActionList() {
		return actionList;
	}

	public void setActionList(List<BasicTrackingMessage> actionList) {
		this.actionList = actionList;
	}
	
	
}
