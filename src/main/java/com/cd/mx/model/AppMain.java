package com.cd.mx.model;
import com.cd.mx.pattern.VirtualClient;
public class AppMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		VirtualClient<BasicTrackingMessage> vc=new VirtualClient<BasicTrackingMessage>();
		Search s=new Search();
		s.searchId="lol";
		vc.setAction(EventType.Search, "lol", s);
		//Search ss=(Search) vc.basicEvent.get(EventType.Search).get(EventType.Search).get(0);
		Search ss=vc.getlol(EventType.Search, "lol");
		 System.out.println(ss.searchId);
	}

}
