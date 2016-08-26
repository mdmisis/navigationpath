package com.cd.mx.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cd.mx.model.BasicTrackingMessage;

public class PathActions {
	private static final Logger logger = LoggerFactory.getLogger(PathActions.class);
	private BasicActions<BasicTrackingMessage> basicActions=new BasicActions<BasicTrackingMessage>();
	private Map<String,List<PathAction>> lastLinkedAction=new HashMap<String, List<PathAction>>();
	
	
	public void addStartActionPattern(BasicTrackingMessage btm){
		basicActions.addAction(btm);
		
	}
	public PathAction linkActionToPattern(BasicTrackingMessage btm){
		List<PathAction> listPathAction= lastLinkedAction.get(btm.getReferrerActionIdentifier());
		if(listPathAction==null){
			//Initialisation en créant niveaux deux
		
			logger.info("dsqfdsqf " +btm.getCleanUrl() + " "+btm.getCleanReferrer());
			BasicTrackingMessage btmFindLinked =basicActions.findLastReferrerAction(btm.getReferrerActionIdentifier());
			
			if(btmFindLinked!=null){
				
				List<PathAction> actionAlreadyMade=lastLinkedAction.get(btm.getActionIdentifier());
				if(actionAlreadyMade==null){
					listPathAction=new ArrayList<PathAction>();
				}
				
				PathAction pathAction=new PathAction();
				pathAction.addPathAction(btmFindLinked);
				pathAction.addPathAction(btm);
				listPathAction.add(pathAction);
				
				lastLinkedAction.put(btm.getActionIdentifier(), listPathAction);
				addStartActionPattern(btm);
				return pathAction;
			}else{
				return null;
			}
			
		}{
			//J'ai trouver quelquechose
			PathAction  lastPathActions=listPathAction.get(listPathAction.size()-1);
		
			PathAction pathAction=new PathAction(lastPathActions.copieAndLastPathAction(btm));
			
			listPathAction.add(pathAction);
	
			
			lastLinkedAction.put(btm.getActionIdentifier(),listPathAction);
			addStartActionPattern(btm);
			return pathAction;
		}
		
		
	}
}
