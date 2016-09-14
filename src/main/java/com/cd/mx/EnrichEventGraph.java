package com.cd.mx;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.SingleGraph;

import com.cd.mx.action.PathAction;
import com.cd.mx.action.PathActions;
import com.cd.mx.model.AddToBasketTrackingMessage;
import com.cd.mx.model.BasicTrackingMessage;
import com.cd.mx.model.EventType;
import com.cd.mx.model.ProductSheetTrackingMessage;
import com.cd.mx.model.SearchTrackingMessage;
import com.cd.mx.node.AddNode;
import com.cd.mx.node.ProductNode;
import com.cd.mx.node.SequenceNodes;
import com.fasterxml.jackson.databind.ObjectMapper;

public class EnrichEventGraph {

	public static void main(String[] args) {
		try {
			// TODO Auto-generated method stub
			
			ObjectMapper mapperJson = new ObjectMapper();
			File fileFromOmniture = new File("D:/omniture_converted_dev.csv");
			BufferedReader readerFileFromOmniture;
			readerFileFromOmniture = new BufferedReader(
					new InputStreamReader(new FileInputStream(fileFromOmniture), "UTF8"));
			String str = "";
			Map<String,SequenceNodes> clientsActions=new HashMap<String, SequenceNodes>();
			int i = 0;
			while ((str = readerFileFromOmniture.readLine()) != null && i < 4000) {
				String[] splitLine = str.split("\u0001");
				if (splitLine.length == 2) {
					if(!splitLine[1].contains("\"eventType\":\"UNKNOWN\"")){
						BasicTrackingMessage btm=mapperJson.readValue(splitLine[1], BasicTrackingMessage.class);
						SequenceNodes sqn=clientsActions.get(btm.getVisidHigh()+btm.getVisidLow());
						if(sqn==null){
							sqn=new SequenceNodes();
							clientsActions.put(btm.getVisidHigh()+btm.getVisidLow(),sqn);
						}
						 switch(btm.getEventType()){
						 	case SEARCH:
						 		SearchTrackingMessage stm=(SearchTrackingMessage) btm;
						 		//System.out.println(mapperJson.writeValueAsString(stm));
						 		sqn.addSearch(stm);
						 		break;
						 	case PRODUCT_SHEET:
						 		ProductSheetTrackingMessage pstm=(ProductSheetTrackingMessage) btm;
						 		ProductNode pm= sqn.addProduct(pstm);
						 		if(pm!=null){
						 			//System.out.println(mapperJson.writeValueAsString(pm));
						 		}
						 		break;
						 	case ADD_TO_BASKET:
						 		AddToBasketTrackingMessage atbtm=(AddToBasketTrackingMessage) btm;
						 		AddNode an=sqn.addAddBasket(atbtm);
						 		if(an!=null){
						 			System.out.println(mapperJson.writeValueAsString(an));
						 		}
						 		break;
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
