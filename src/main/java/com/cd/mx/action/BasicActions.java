package com.cd.mx.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cd.mx.model.BasicTrackingMessage;



public class BasicActions<T extends BasicTrackingMessage>{
	private static final Logger logger = LoggerFactory.getLogger(BasicActions.class);
	
	public String id;
	public Map<String,List<T>> basicEvent =new HashMap<String,List<T>>();
	
	
	
	public  T findLastReferrerAction(String idReferrerAction){
			logger.info("Try to find ->idReferrerAction " +idReferrerAction);
		
			List<T> listLastActions= basicEvent.get(idReferrerAction);
			
			if(listLastActions.size()>0){
				return (T) listLastActions.get(listLastActions.size()-1);
			}else{
				return null;
			}
		
	
	}
	
	public   void  addAction(T t ){
		
			List<T> listAction=basicEvent.get(t.getActionIdentifier());
			if(listAction==null){
				listAction=new ArrayList<T>();
			}
			listAction.add(t);
		
			basicEvent.put(t.getActionIdentifier(), listAction);
			logger.info("add single node -> id="+ t.getActionIdentifier()+ " listAction : "+ listAction.size());
		
		
	}
	
	public void removeAction(){
		
	}
	
	
	
	
	
}
