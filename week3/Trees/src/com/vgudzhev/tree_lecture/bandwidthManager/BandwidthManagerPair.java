package com.vgudzhev.tree_lecture.bandwidthManager;

import java.util.HashMap;
import java.util.Map;

public class BandwidthManagerPair implements Comparable<BandwidthManagerPair>{
	private static Map<String, Integer> priorityMap = new HashMap<String, Integer>();
	public String protocol;
	public String payload;
	
	public BandwidthManagerPair(String protocol, String payload){
		this.protocol = protocol;
		this.payload = payload;
	}
	
	public static BandwidthManagerPair getInstance(String protocol, String payload){
		return new BandwidthManagerPair(protocol, payload);
	}
	
	static {
		priorityMap.put("ICMP", 100);
		priorityMap.put("UDP", 90);
		priorityMap.put("RTM", 80);
		priorityMap.put("IGMP", 70);
		priorityMap.put("DNS", 60);
		priorityMap.put("TCP", 50);
	}

	@Override
	public int compareTo(BandwidthManagerPair p) {
		int basePriority = priorityMap.get(protocol);
		int newElementPRiority = priorityMap.get(p.protocol);
		
		return Integer.compare(basePriority, newElementPRiority);
	}
}
