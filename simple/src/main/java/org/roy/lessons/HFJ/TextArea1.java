package org.roy.lessons.HFJ;

import java.awt.BorderLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

public class TextArea1 implements ActionListener,ItemListener {

	private JTextArea text;
	private int cnt = 0;
	
	private String button1Cmd = "生成一条记录";
	private String button2Cmd = "清除记录";
	

	/**
	 * 
	 */
	public void go() {
		JFrame frame = new JFrame();
		JPanel centrlPanel = new JPanel();
		JPanel southPanel = new JPanel();

		JButton button1 = new JButton(button1Cmd);
		button1.setSize(50, 30);
		button1.addActionListener(this);

		JButton button2 = new JButton(button2Cmd);
		button2.setSize(50, 30);
		button2.addActionListener(this);

		southPanel.add(button1);
		southPanel.add(button2);

		text = new JTextArea(5, 20);
		text.setLineWrap(true);
		// text.setSize(300,300);
		JScrollPane scrol = new JScrollPane(text);
		scrol.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrol.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		
		JCheckBox checkbox1 = new JCheckBox("CheckBox 1");
		checkbox1.addItemListener(this);
		JCheckBox checkbox2 = new JCheckBox("CheckBox 2");
		checkbox2.addItemListener(this);
		
		LayoutManager mgr = new BoxLayout(centrlPanel,BoxLayout.Y_AXIS);
		centrlPanel.setLayout(mgr);
		centrlPanel.add(scrol);
		centrlPanel.add(checkbox1);
		centrlPanel.add(checkbox2);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(BorderLayout.CENTER,centrlPanel);
		frame.getContentPane().add(BorderLayout.SOUTH,southPanel);
		frame.setSize(400, 400);
		frame.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		System.out.println(e.paramString());
		if (e.getActionCommand().equals(button1Cmd)) {
			text.append("Ha~Ha~ You click me  " + (++cnt) + "  time"
					+ (cnt > 1 ? "s" : "") + "\n\r");
		}
		if (e.getActionCommand().equals(button2Cmd)){
			text.setText("");
			cnt = 0;
		}
	}
	
	/* (non-Javadoc)
	 * @see java.awt.event.ItemListener#itemStateChanged(java.awt.event.ItemEvent)
	 */
	public void itemStateChanged(ItemEvent e) {
		String state = "on";
		if(e.getItem() instanceof JCheckBox){
			JCheckBox check = (JCheckBox) e.getItem();
			if(!check.isSelected()) state = "off";
			text.append(check.getText() + " state is " + state + "\n\r");
		}	
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TextArea1 area = new TextArea1();
		area.go();
	}

}
