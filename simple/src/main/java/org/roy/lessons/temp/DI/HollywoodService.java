package org.roy.lessons.temp.DI;

import java.util.*;

public class HollywoodService {
	// traditional way
	public static List<Agent> getFriendlyAgents1(){
		AgentFinder finder = new SpreadSheetAgentFinder();
		List<Agent>	agents = finder.findAllAgents();
		List<Agent> friendlyAgents = filterAgents(agents,"Java Developer");
		return friendlyAgents;
	}
	
	public static List<Agent> filterAgents(List<Agent> list,String filterRule){
		return list;
	}
	
	// use simple factory pattern
	public static List<Agent> getFriendlyAgents2(String agentFinderType){
		AgentFinder finder = new AgentFinderFactory().getInstance(agentFinderType);
		List<Agent>	agents = finder.findAllAgents();
		List<Agent> friendlyAgents = filterAgents(agents,"Java Developer");
		return friendlyAgents;
	}
	
	// simple Dependency Injection implementation
	public static List<Agent> getFriendlyAgents3(AgentFinder finder){
		List<Agent>	agents = finder.findAllAgents();
		List<Agent> friendlyAgents = filterAgents(agents,"Java Developer");
		return friendlyAgents;
	}
	
	
}
