package com.cd.mx;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerRecord;

import com.cd.mx.action.PathAction;
import com.cd.mx.action.PathActions;
import com.cd.mx.model.BasicTrackingMessage;
import com.cd.mx.model.EventType;
import com.fasterxml.jackson.databind.ObjectMapper;

public class EnrichEventMain {

	public static void main(String[] args) {
		try {
			// TODO Auto-generated method stub
			ObjectMapper mapperJson = new ObjectMapper();
			File fileFromOmniture = new File("D:/result/omniture_converted_dev.csv");
			BufferedReader readerFileFromOmniture;
			readerFileFromOmniture = new BufferedReader(
					new InputStreamReader(new FileInputStream(fileFromOmniture), "UTF8"));
			String str = "";
			Map<String,PathActions> clientsActions=new HashMap<String, PathActions>();
			int i = 0;
			while ((str = readerFileFromOmniture.readLine()) != null && i < 4000) {
				String[] splitLine = str.split("\u0001");
				if (splitLine.length == 2) {
					if(!splitLine[1].contains("\"eventType\":\"UNKNOWN\"")){
						BasicTrackingMessage btm=mapperJson.readValue(splitLine[1], BasicTrackingMessage.class);
					
						PathActions clientActions= clientsActions.get(splitLine[0]);
						if(clientActions==null){
							clientActions=new PathActions();
							clientsActions.put(splitLine[0], clientActions);
						}
						if(btm.getEventType()==EventType.SEARCH){
							clientActions.addStartActionPattern(btm);
						}else if(btm.getEventType()!=EventType.PURCHASE){
							if(btm.getReferrerActionIdentifier()!=null || !btm.getReferrerActionIdentifier().isEmpty()){
								PathAction newLinkedAction=clientActions.linkActionToPattern(btm);
								System.out.println(mapperJson.writeValueAsString(newLinkedAction));
							}
							
						}
					}
					
				}
				i++;

			}

			readerFileFromOmniture.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
