package org.roy.lessons.HFJ;

import java.awt.Color;
import java.awt.Graphics;

import javax.sound.midi.ControllerEventListener;
import javax.sound.midi.ShortMessage;
import javax.swing.JPanel;

public class MyDrawPanle extends JPanel implements ControllerEventListener {

	private boolean msg = false;
	/* (non-Javadoc)
	 * @see javax.sound.midi.ControllerEventListener#controlChange(javax.sound.midi.ShortMessage)
	 */
	public void controlChange(ShortMessage event) {
		// TODO Auto-generated method stub
		msg = true;
		repaint();
	}

	/* (non-Javadoc)
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	@Override
	protected void paintComponent(Graphics g) {
		int x = (int) (Math.random()* this.getWidth());
		int y = (int) (Math.random() * this.getHeight());
		int width = (int) (Math.random() * this.getWidth());
		int height = (int) (Math.random() * this.getHeight());
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		
		int r = (int) (Math.random()* 255);
		int cg = (int) (Math.random()* 255);
		int b = (int) (Math.random()* 255);
		g.setColor(new Color(r,cg,b));
		g.fillOval(x, y, width, height);
	}

}
