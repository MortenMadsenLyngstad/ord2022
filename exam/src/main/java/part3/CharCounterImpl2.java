package part3;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Implementation of CharCounter that accepts only letters,
 * based on the corresponding method in Character.
 */

public class CharCounterImpl2 implements CharCounter {

	private int sumCountedChars = 0;
	private String countedChars = "";
	private final List<Integer> counters = new ArrayList<>();


	@Override
	public boolean acceptsChar(final char c) {
		return Character.isLetter(c);
	}

	@Override
	public void countChar(final char c, final int increment) throws IllegalArgumentException {
		if (!acceptsChar(c)) {
			throw new IllegalArgumentException("char not accepted");
		}
		if (increment <= 1) {
			throw new IllegalArgumentException("increment must be >= 1");
		}
		final int pos = countedChars.indexOf(c);
		if (pos >= 0) {
			counters.set(pos, counters.get(pos) + increment);
		}
		else {
			countedChars += c;
			counters.add(increment);
		}
		sumCountedChars += increment;
	}

	@Override
	public Collection<Character> getCountedChars() {
		final Collection<Character> chars = new ArrayList<>(countedChars.length());

		for (int i = 0; i < countedChars.length(); i++) {
			chars.add(countedChars.charAt(i));
		}
		return chars;
	}

	@Override
	public int getCharCount(final char c) {
		return (countedChars.indexOf(c) >= 0) ? counters.get(countedChars.indexOf(c)) : 0;
	}

	@Override
	public int getTotalCharCount() {
		return sumCountedChars;
	}

	public static void main(String[] args) {
		
		final CharCounterImpl2 counter = new CharCounterImpl2();
		System.out.println(counter.acceptsChar('A')); // true
		System.out.println(counter.acceptsChar('1')); // false
		counter.countChar('A', 2);
		counter.countChar('B', 3);
		System.out.println(counter.getCharCount('A')); // 2
		System.out.println(counter.getTotalCharCount()); // 5
		System.out.println(counter.getCountedChars()); // [A, B]
	}

}
