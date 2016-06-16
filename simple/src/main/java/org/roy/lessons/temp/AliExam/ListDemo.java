package org.roy.lessons.temp.AliExam;

import java.util.*;

public class ListDemo {

	class ServiceEnv{
		private String showName;
		private String envName;
		private String envDefault;
		private Boolean isRequired;
		private Boolean isPassword;
		
		
		public String getShowName() {
			return showName;
		}


		public void setShowName(String showName) {
			this.showName = showName;
		}


		public String getEnvName() {
			return envName;
		}


		public void setEnvName(String envName) {
			this.envName = envName;
		}


		public String getEnvDefault() {
			return envDefault;
		}


		public void setEnvDefault(String envDefault) {
			this.envDefault = envDefault;
		}


		public Boolean getIsRequired() {
			return isRequired;
		}


		public void setIsRequired(Boolean isRequired) {
			this.isRequired = isRequired;
		}


		public Boolean getIsPassword() {
			return isPassword;
		}


		public void setIsPassword(Boolean isPassword) {
			this.isPassword = isPassword;
		}


		@Override
		public String toString(){
			return showName+";"+envName+";"+envDefault+";"
		+isPassword+";"+isRequired;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListDemo ins = new ListDemo();
		List<ServiceEnv> envs = new ArrayList<ServiceEnv>();
		envs.add(ins.newEnv());
		envs.add(ins.newEnv());
		envs.add(ins.newEnv());
		envs.add(ins.newEnv());
		System.out.println(envs);
		
		String s ="abcd,effe;kki;lskfie,";
		System.out.println(s.replaceAll(" ", ""));
		String[] ss = s.split("[,;]");
		for(String i:ss){
			System.out.println(i);
		}
	}
	
	public  ServiceEnv newEnv(){
		ServiceEnv env = new ServiceEnv();
		env.setShowName("SSH");
		env.setEnvName("ROOT_PASS");
		env.setEnvDefault("abcd1234");
		env.setIsPassword(true);
		env.setIsRequired(true);
		return env;
	}
	
	
	
	
}
