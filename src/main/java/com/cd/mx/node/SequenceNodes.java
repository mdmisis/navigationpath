package com.cd.mx.node;

import java.util.HashMap;
import java.util.Map;

import com.cd.mx.model.AddToBasketTrackingMessage;
import com.cd.mx.model.ProductSheetTrackingMessage;
import com.cd.mx.model.SearchTrackingMessage;

public class SequenceNodes {
	private Map<String,SearchNode> search;
	private Map<String,ProductNode> product;
	private Map<String,AddNode> add;
	
	public  SearchNode addSearch(SearchTrackingMessage stm){
		if(stm.getCleanUrl()==null||stm.getCleanUrl().isEmpty()){
			throw new RuntimeException("search url empty or null");
		}
		if(stm.getDateTime()==null||stm.getDateTime().isEmpty()){
			throw new RuntimeException("search datetime empty or null");
		}
		if(search==null){
			search=new HashMap<String,SearchNode>();
		}
		SearchNode sn=search.get(stm.getCleanUrl());
		if(sn==null){
			sn=new SearchNode();
			search.put(stm.getCleanUrl(), sn);
		}
		sn.setSearch(stm);
		
		return sn;
	}
	
	public ProductNode addProduct(ProductSheetTrackingMessage pstm){
		if(pstm.getCleanUrl()==null||pstm.getCleanUrl().isEmpty()){
			throw new RuntimeException("search url empty or null");
		}
		if(pstm.getDateTime()==null||pstm.getDateTime().isEmpty()){
			throw new RuntimeException("Product datetime empty or null");
		}
		if(search!=null){
			
			SearchNode sn=search.get(pstm.getCleanReferrer());
			if(sn!=null){
				
				SearchTrackingMessage stm= sn.findLinkedSearch(pstm.getDateTime());
				if(stm!=null){
					if(product==null){
						product=new HashMap<>();
					}
					ProductNode pn=new ProductNode(pstm, stm);
					product.put(pstm.getCleanUrl(), pn);
					return pn;
				}
				
			}
		}
		
		return null;
	}
	
	public AddNode addAddBasket(AddToBasketTrackingMessage atbtm){
		if(atbtm.getCleanUrl()==null||atbtm.getCleanUrl().isEmpty()){
			throw new RuntimeException("search url empty or null");
		}
		if(atbtm.getDateTime()==null||atbtm.getDateTime().isEmpty()){
			throw new RuntimeException("Product datetime empty or null");
		}
		if(search!=null){
			SearchNode sn=search.get(atbtm.getCleanReferrer());
			if(sn!=null){
				
				SearchTrackingMessage stm= sn.findLinkedSearch(atbtm.getDateTime());
				if(stm!=null){
					if(add==null){
						add=new HashMap<>();
					}
					AddNode an=new AddNode(atbtm, null, stm);
					add.put(atbtm.getCleanUrl(), an);
					return an;
				}
				
			}
		}else if(product!=null){
			ProductNode pn= product.get(atbtm.getCleanReferrer());
			if(pn!=null){
				if(add==null){
					add=new HashMap<>();
				}
				AddNode an=new AddNode(atbtm, pn.getPstm(), pn.getStm());
				add.put(atbtm.getCleanUrl(), an);
				return an;
			}
		}
		return null;
	}
	
}
