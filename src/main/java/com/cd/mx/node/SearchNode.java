package com.cd.mx.node;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.cd.mx.model.BasicTrackingMessage;
import com.cd.mx.model.SearchTrackingMessage;

public class SearchNode {
	private List<SearchTrackingMessage> listBasicTrackingMessage =new ArrayList<SearchTrackingMessage>();
	
	public SearchTrackingMessage  findLinkedSearch(String dateTime){
		
		Collections.sort(listBasicTrackingMessage,  (o1, o2) -> o1.getDateTime().compareTo(o2.getDateTime()));
		SearchTrackingMessage sbt=null;
		SearchTrackingMessage lastSbt=null;
		for(int i=0; i<listBasicTrackingMessage.size();i++){
			sbt =listBasicTrackingMessage.get(i);
			if(lastSbt==null){
				lastSbt=sbt;
			}else if(sbt.getDateTime().compareTo(dateTime)<=0){
				if(lastSbt.getDateTime().compareTo(sbt.getDateTime())<0){
					lastSbt=sbt;
				}
			}
		}
		return lastSbt;		
	}
	
	public void setSearch(SearchTrackingMessage stm){
		listBasicTrackingMessage.add(stm);
	}
	
	
}
