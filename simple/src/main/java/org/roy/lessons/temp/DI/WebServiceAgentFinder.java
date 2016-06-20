package org.roy.lessons.temp.DI;

import java.util.*;

public class WebServiceAgentFinder implements AgentFinder {

	private String[] names = "Agent1 Agent2 Agent3 Agent4 Agent5".split(" ");
	public List<Agent> findAllAgents() {
		List<Agent> ret = new ArrayList<Agent>();
		for(String s:names){
			ret.add(new Agent(s));
		}
		return ret;
	}
}
