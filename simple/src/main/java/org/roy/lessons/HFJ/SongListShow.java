package org.roy.lessons.HFJ;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

import javax.swing.*;

public class SongListShow {

	JTextArea textArea;
	JButton btnTitle, btnArtist, btnLength, btnFile;
	private final String FilePath = "Res/SongList.txt";

	private ArrayList<Song> arrayList;
	private HashSet<Song> hashSet;
	private TreeSet<Song> treeSet;

	public static void main(String[] args) {
		new SongListShow().go();
	}

	public void go() {
		LoadSong();
		buildGUI();
	}

	public void LoadSong() {
		FileReader f;
		BufferedReader r;
		String str;
		Song newSong;
		arrayList = new ArrayList<Song>();
		hashSet = new HashSet<Song>();
		treeSet = new TreeSet<Song>();
		try {
			f = new FileReader(FilePath);
			r = new BufferedReader(f);
			while ((str = r.readLine()) != null) {
				newSong = makeSong(str);
				if (null != newSong)
					arrayList.add(newSong);
			}
			Collections.sort(arrayList);
			hashSet.addAll(arrayList);
			treeSet.addAll(arrayList);
			r.close();
			f.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Song makeSong(String str) {
		Song song = new Song();
		System.out.println(str);
		String[] token = str.split("/");
		if (token.length < 3)
			return null;
		song.setTitle(token[0]);
		song.setArtist(token[1]);
		song.setLength(token[2]);
		return song;
	}

	public void buildGUI() {
		JFrame frame = new JFrame("SongListShow");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new JPanel(new BorderLayout());
		textArea = new JTextArea(200, 200);
		textArea.setText("Welcome to this test\r\n");
		
		JScrollPane scroll = new JScrollPane(textArea);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		
		panel.add(scroll, BorderLayout.CENTER);

		BtnEventHandler h = new BtnEventHandler();

		Box btnBox = new Box(BoxLayout.X_AXIS);
		btnFile = new JButton("File");
		btnTitle = new JButton("Title");
		btnArtist = new JButton("Artist");
		btnLength = new JButton("Length");
		btnFile.addActionListener(h);
		btnTitle.addActionListener(h);
		btnArtist.addActionListener(h);
		btnLength.addActionListener(h);
		btnBox.add(btnFile);
		btnBox.add(btnTitle);
		btnBox.add(btnArtist);
		btnBox.add(btnLength);

		panel.add(btnBox, BorderLayout.SOUTH);

		frame.setResizable(false);
		frame.getContentPane().add(panel);
		frame.setSize(400, 400);
		frame.setVisible(true);
	}

	private class BtnEventHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			System.out.println(e);
			String cmd = e.getActionCommand();
			textArea.setText("");
			if (cmd.equals("File")) {
				textArea.append("File content is  :\n\r");
				for (Song s : arrayList) {
					textArea.append(s.getTitle() + "/" + s.getArtist() + "/"
							+ s.getLength() + "\n\r");
				}
			} else if (cmd.equals("Title")) {
				textArea.append("In ArrayList<Song>,title is  :\n\r");
				for (Song s : arrayList) {
					textArea.append(s.getTitle() + "\n\r");
				}
				textArea.append("\n\rIn HashSet<Song>,title is  :\n\r");
				for (Song s : hashSet) {
					textArea.append(s.getTitle() + "\n\r");
				}
				textArea.append("\n\rIn TreeSet<Song>,title is  :\n\r");
				for (Song s : treeSet) {
					textArea.append(s.getTitle() + "\n\r");
				}

			} else if (cmd.equals("Artist")) {
				textArea.append("Artist  is  :\n\r");
				for (Song s : arrayList) {
					textArea.append(s.getTitle() + "/" + s.getArtist() + "/"
							+ s.getLength() + "\n\r");
				}

			} else if (cmd.equals("Length")) {
				textArea.append("Length is  :\n\r");
				for (Song s : arrayList) {
					textArea.append(s.getTitle() + "/" + s.getArtist() + "/"
							+ s.getLength() + "\n\r");
				}
			}
		}
	}
}

class Song implements Comparable<Song> {
	private String title, artist, length;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getLength() {
		return length;
	}

	public void setLength(String length) {
		this.length = length;
	}

	@Override
	public int hashCode() {
		return this.getTitle().hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		Song s = (Song) obj;
		return this.getTitle().equals(s.getTitle());
	}

	public int compareTo(Song o) {
		return this.getTitle().compareTo(o.getTitle());
	}
}
