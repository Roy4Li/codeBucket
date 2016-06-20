package org.roy.lessons.TIJ4th.Chpt20;

@ExtractInterface("IExecuteTest")
public class ExecuteTest {
	
	public int var1;
	public String var2;
	
	@Test
	public void execute(){
		System.out.println("Hello annotation");
	}
	
	@Test(id=1)
	public void execute2(){
		System.out.println("Hello annotation2");
	}
	
	@Test(id=2,value="annotation3")
	public void execute3(){
		System.out.println("Hello annotation3");
	}
	
}
