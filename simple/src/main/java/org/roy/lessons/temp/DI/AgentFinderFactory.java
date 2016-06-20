package org.roy.lessons.temp.DI;

public class AgentFinderFactory {
	public AgentFinder getInstance(String type){
		if(type.equals("WebService"))
			return new WebServiceAgentFinder();
		else
			return new SpreadSheetAgentFinder();
	}
}
