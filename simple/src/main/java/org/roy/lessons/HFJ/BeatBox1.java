package org.roy.lessons.HFJ;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Track;
import javax.swing.*;

public class BeatBox1 {

	private Sequencer sequencer;
	private Sequence sequence;
	private Track track;
	private JLabel label;

	private String[] instrumentName = { "Bass Drum", "Closed Hi-Hat",
			"Open Hi-Hat", "Acoustic Snare", "Crash Cymbal", "Hand Clap",
			"High Tom", "Hi Bongo", "Maracas", "Whistle", "Low Congs",
			"Cowbell", "Vibraslap", "Low-mid Tom", "High Agogo",
			"Open Hi Conga" };
	private int[] instruments = { 35, 42, 46, 38, 49, 39, 50, 60, 70, 72, 64,
			56, 58, 47, 67, 63 };
	private String btnStartCmd = "Start";
	private String btnStopCmd = "Stop";
	private String btnTempoUpCmd = "TempoUp";
	private String btnTempoDownCmd = "TempoDown";
	private String btnSaveCmd = "Save";
	private String btnRestoreCmd = "Restore";
    private String btnClearCmd = "Clear";
    
	private final Integer Col = 16, Row = instrumentName.length;
	private ArrayList<JCheckBox> checkBoxList;

	private ButtonEventHandler btnHandler = new ButtonEventHandler();
	private final String FILE_NAME = "MyPatter.pa";
	private FileOutputStream fos;
	private FileInputStream fis;
	private ObjectOutputStream oos;
	private ObjectInputStream ois;
    private JPanel midPanel;
	public void buildGui() {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		LayoutManager border = new BorderLayout();
		JPanel bg = new JPanel(border);

		Box nameBox = new Box(BoxLayout.Y_AXIS);
		for (int i = 0; i < instrumentName.length; i++) {
			nameBox.add(new Label(instrumentName[i]));
		}

		Box buttonBox = new Box(BoxLayout.Y_AXIS);

		JButton btnStart = new JButton(btnStartCmd);
		btnStart.addActionListener(btnHandler);
		buttonBox.add(btnStart);

		JButton btnStop = new JButton(btnStopCmd);
		btnStop.addActionListener(btnHandler);
		buttonBox.add(btnStop);

		JButton btnTempoUp = new JButton(btnTempoUpCmd);
		btnTempoUp.addActionListener(btnHandler);
		buttonBox.add(btnTempoUp);

		JButton btnTempoDown = new JButton(btnTempoDownCmd);
		btnTempoDown.addActionListener(btnHandler);
		buttonBox.add(btnTempoDown);

		JButton btnSave = new JButton(btnSaveCmd);
		btnSave.addActionListener(btnHandler);
		buttonBox.add(btnSave);

		JButton btnRestore = new JButton(btnRestoreCmd);
		btnRestore.addActionListener(btnHandler);
		buttonBox.add(btnRestore);
		
		JButton btnClear = new JButton(btnClearCmd);
		btnClear.addActionListener(btnHandler);
		buttonBox.add(btnClear);
		label = new JLabel("               ");
		// buttonBox.add(label);

		GridLayout grid = new GridLayout(16, 16);
		grid.setVgap(5);
		grid.setHgap(5);
		midPanel = new JPanel(grid);
		checkBoxList = new ArrayList<JCheckBox>();
		for (int i = 0; i < 256; i++) {
			JCheckBox c = new JCheckBox();
			c.setSelected(false);
			checkBoxList.add(c);
			midPanel.add(c);
		}

		bg.add(BorderLayout.WEST, nameBox);
		bg.add(BorderLayout.EAST, buttonBox);
		bg.add(BorderLayout.CENTER, midPanel);

		setUpMidi();

		frame.getContentPane().add(bg);
		frame.setBounds(50, 50, 400, 400);
        frame.setResizable(true);
		frame.pack();
		frame.setVisible(true);
	}

	public void setUpMidi() {
		try {
			sequencer = MidiSystem.getSequencer();
			sequencer.open();
			sequence = new Sequence(Sequence.PPQ, 4);
			track = sequence.createTrack();
			sequencer.setTempoInBPM(120);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void buildMidiAndStart() {
		int[] trackList = null;
		sequence.deleteTrack(track);
		track = sequence.createTrack();
		for (int i = 0; i < Row; i++) {
			trackList = new int[16];
			int key = instruments[i];

			for (int j = 0; j < Col; j++) {
				if (checkBoxList.get(j + Row * i).isSelected()) {
					trackList[j] = key;
				} else {
					trackList[j] = 0;
				}
			}
			makeTracks(trackList);
			track.add(makeEvent(172, 1, 127, 0, Row));
		}
		track.add(makeEvent(192, 9, 1, 0, Row - 1));

		try {
			sequencer.setSequence(sequence);
			sequencer.setLoopCount(sequencer.LOOP_CONTINUOUSLY);
			sequencer.start();
			sequencer.setTempoInBPM(120);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void makeTracks(int[] list) {
		int key = 0;
		for (int i = 0; i < list.length; i++) {
			key = list[i];
			if (key != 0) {
				track.add(makeEvent(144, 9, key, 100, i));
				track.add(makeEvent(128, 9, key, 100, i + 1));
			}
		}
	}

	public MidiEvent makeEvent(int comb, int chan, int one, int two, int tick) {
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

	public class ButtonEventHandler implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			String cmd = e.getActionCommand();
			if (label != null)
				label.setText("Button Pressed is " + cmd);
			if (cmd.equals(btnStartCmd)) {
				buildMidiAndStart();
			} else if (cmd.equals(btnStopCmd)) {
				sequencer.stop();
			} else if (cmd.equals(btnTempoUpCmd)) {
				float tempFactor = sequencer.getTempoFactor();
				sequencer.setTempoFactor((float) (tempFactor * 1.03));
			} else if (cmd.equals(btnTempoDownCmd)) {
				float tempFactor = sequencer.getTempoFactor();
				sequencer.setTempoFactor((float) (tempFactor * 0.97));
			} else if (cmd.equals(btnSaveCmd)) {
				savePattern();
			} else if (cmd.equals(btnRestoreCmd)) {
				restorePattern();
			} else if(cmd.equals(btnClearCmd)){
				clearGrid();
			}
		}
	}
	
	public void clearGrid() {
		for(JCheckBox c:checkBoxList){
			c.setSelected(false);
		}
	}
	
	public void savePattern() {
		try {
			fos = new FileOutputStream(FILE_NAME);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(checkBoxList);
			oos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void restorePattern() {
		try {
			fis = new FileInputStream(FILE_NAME);
			ois = new ObjectInputStream(fis);
			ArrayList<JCheckBox> newList = (ArrayList<JCheckBox>) ois.readObject();
			updateGrid(newList);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void updateGrid(ArrayList<JCheckBox> newList) {
		for(int i=0;i<newList.size();i++){
			if(newList.get(i).isSelected()){
				checkBoxList.get(i).setSelected(true);
			}
			else{
				checkBoxList.get(i).setSelected(false);
			}
		}
	}

	public static void main(String[] args) {
		BeatBox1 box = new BeatBox1();
		box.buildGui();
	}
}
