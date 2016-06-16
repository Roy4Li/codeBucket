package org.roy.lessons.HFJ;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class SimpleAnimation {
	
	private int x = 0,y = 0;
	private int SIZE_HEIGHT = 400,SIZE_WIDTH = 400;
	
	public static void main(String[] args) {
		SimpleAnimation gui = new SimpleAnimation();
		gui.go();
	}
	
	public void go(){
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(SIZE_WIDTH,SIZE_HEIGHT);
		frame.setVisible(true);
		MyDrawClass drawPanel = new MyDrawClass();
		frame.getContentPane().add(drawPanel);
		
		x =y = 0;
		for(int i = 0;i < 100;i++){
			x++;
			y++;
			drawPanel.repaint();
			try {
				Thread.sleep(50);
			} catch (Exception e) {
				
			}
		}
	}
	
	public class MyDrawClass extends JPanel{
		public void paintComponent(Graphics g){
			g.setColor(Color.WHITE);
			g.fillRect(0, 0, this.getWidth(), this.getHeight());
			
			g.setColor(Color.RED);
			g.fillOval(x, y, 60, 40);
		}
	}

}
