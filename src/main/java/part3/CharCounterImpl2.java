package part3;

import java.util.Collection;

/**
 * Implementation of CharCounter that accepts only letters,
 * based on the corresponding method in Character.
 */

public class CharCounterImpl2 implements CharCounter {

	// TODO: fields, but no use of Map or Map-implementation

	@Override
	public boolean acceptsChar(final char c) {
		// TODO
		return false;
	}

	@Override
	public void countChar(final char c, final int increment) throws IllegalArgumentException {
		// TODO
	}

	@Override
	public Collection<Character> getCountedChars() {
		// TODO
		return null;
	}

	@Override
	public int getCharCount(final char c) {
		// TODO
		return 0;
	}

	@Override
	public int getTotalCharCount() {
		// TODO
		return 0;
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
