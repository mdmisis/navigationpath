package com.cd.mx.pattern;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cd.mx.model.BasicTrackingMessage;
import com.cd.mx.model.EventType;
import com.cd.mx.node.type.NodeType;

public class VirtualClient<T extends BasicTrackingMessage>{
	public String id;
	public Map<EventType,Map<String,List<T>>> basicEvent =new HashMap<EventType, Map<String,List<T>>>();
	
	public  void setAction(EventType eventType,String pageUrl,T t){
		if(basicEvent.get(eventType)==null){
			
			basicEvent.put(eventType, new HashMap<String, List<T>>());
			List<T> l=new ArrayList<T>();
			l.add(t);
			basicEvent.get(eventType).put(pageUrl, l);
		}else{
			basicEvent.get(eventType).get(pageUrl).add(t);
		}
		
		
	}
	@SuppressWarnings({ "hiding", "unchecked" })
	public  <T extends BasicTrackingMessage> T getlol(EventType eventType,String pageUrl){
		
		return (T) basicEvent.get(eventType).get(pageUrl).get(0);
		
		
	}
	
}
