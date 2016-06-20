package org.roy.lessons.temp.DI;

import java.util.*;

public class SpreadSheetAgentFinder implements AgentFinder {

	private String[] names = "AgentA AgentB AgentC AgentD AgentE".split(" ");
	public List<Agent> findAllAgents() {
		List<Agent> ret = new ArrayList<Agent>();
		for(String s:names){
			ret.add(new Agent(s));
		}
		return ret;
	}
}
