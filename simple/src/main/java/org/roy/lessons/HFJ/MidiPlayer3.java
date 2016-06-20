package org.roy.lessons.HFJ;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Track;
import javax.swing.JFrame;

public class MidiPlayer3 {
	static JFrame frame = new JFrame();
	static MyDrawPanle draw = new MyDrawPanle();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MidiPlayer3 midi = new MidiPlayer3();
		midi.go();
	}
	
	public void intGui(){
		frame.setVisible(true);
		frame.setSize(400,400);
		frame.setContentPane(draw);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void go(){
		try {
			intGui();
			Sequencer player = MidiSystem.getSequencer();
			player.open();
			
			int[] eventIWant = {127}; 
			player.addControllerEventListener(draw, eventIWant);
			
			Sequence seq = new Sequence(Sequence.PPQ, 4);
			Track track = seq.createTrack();
			for(int i = 5;i < 108;i+=1){
				track.add(makeEvent(144, 1, i, 100, i));
				track.add(makeEvent(176, 1, 127, 0, i));
				track.add(makeEvent(128, 1, i, 100, i + 2));
			}
			
			player.setSequence(seq);
			player.setTempoInBPM(220);
			player.start();
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static MidiEvent makeEvent(int comb, int chan, int one, int two,
			int tick) {
		MidiEvent event = null;

		try {
			ShortMessage msg = new ShortMessage(comb, chan, one, two);
			event = new MidiEvent(msg, tick);
		} catch (InvalidMidiDataException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return event;

	}

}
