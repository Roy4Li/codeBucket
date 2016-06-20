package org.roy.lessons.TIJ4th.Chpt11;

import java.util.*;

public class MultiIterable {
	private String[] words = "Hello World I am Roy Lee ".split(" ");

	public Iterable<String> reversed() {
		return new Iterable<String>() { // Anonymous inner class
			public Iterator<String> iterator() {
				return new Iterator<String>() {
					int current = words.length - 1;

					public boolean hasNext() {
						return current > -1;
					}

					public String next() {
						return words[current--];
					}

					public void remove() {
						throw new UnsupportedOperationException();
					}
				};
			}
		};
	}

	public Iterable<String> shuffled() {
		return new Iterable<String>() {
			public Iterator<String> iterator() {
				return new Iterator<String>() {
					int cnt = words.length;
					int index = 0;
					Random rand = new Random();
					
					public boolean hasNext() {
						return cnt > 0;
					}

					public String next() {
						cnt--;
						return words[rand.nextInt(words.length)];
					}
					
					public void remove() {
						throw new UnsupportedOperationException();
					}
				};
			}
		};
	}

	public static void main(String[] args) {
		MultiIterable example = new MultiIterable();
		for (String s : example.words)
			System.out.print(s + " ");
		System.out.println();
		for (String s : example.reversed())
			System.out.print(s + " ");
		System.out.println();
		for (String s : example.shuffled())
			System.out.print(s + " ");
	}
}
