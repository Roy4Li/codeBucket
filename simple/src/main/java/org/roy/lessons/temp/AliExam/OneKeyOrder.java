package org.roy.lessons.temp.AliExam;

import java.util.*;

public class OneKeyOrder {
	
	private  static OneKeyOrder instance = new  OneKeyOrder();
	private List<Product> trolley = new ArrayList<Product>();
	private String serverState = new String("ServerOk");
	
	public static void main(String[] args) {
		// before 00:00:00,put items to trolley
		instance.addToTrolley("店铺1", "A1",1999*100, 1);
		instance.addToTrolley("店铺1", "A2",20*100, 1);
		instance.addToTrolley("店铺2", "B1",120*100, 1);
		instance.addToTrolley("店铺3", "C1",56*100, 2);
		//  sleep,eat,drink, while waiting...
		// At last it comes...
		instance.batchOrder();
	}
	
	public void batchOrder(){
		for(Product p:trolley){
			this.order(p);
		}
	}
	
	public void order(Product p){
		if("ServerOk" == serverState){
			System.out.println("order" +p.store + " "+p.name+ " success");
		} else if("ServerBusy" == serverState){
			// wait some time and retry
		} else { 
			// 
		}
	}
	
	public void addToTrolley(String storeName,String name,int price,int num){
		Product p = instance.new Product(storeName,name,price,num);
		trolley.add(p);
	}
	
	private class Product{
		private String store;
		private String name;
		private int price; // unit is cent
		private int num;
		public Product(String store,String name,int price,int num){
			this.store = name;
			this.name = name;
			this.price = price;
			this.num = num;
		}
	}
}
