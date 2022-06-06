package part3;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class CharCounterImpl implements CharCounter {

	private final Predicate<Character> acceptedChars;
	private final Map<Character, Integer> counters = new HashMap<>();

	/**
	 * Initialises a CharCounterImpl that only counts the characters accepted by the provided Predicate.
	 *
	 * @param acceptedChars the predicate deciding which characters to accept for counting
	 */
	public CharCounterImpl(final Predicate<Character> acceptedChars) {
		super();
		this.acceptedChars = acceptedChars;
	}

	/**
	 * Initialises a CharCounterImpl that only counts the characters in the provided String.
	 *
	 * @param acceptedChars the characters to accept for counting
	 */
	public CharCounterImpl(final String acceptedChars) {
		this(c -> acceptedChars.indexOf(c) >= 0);
	}

	@Override
	public boolean acceptsChar(final char c) {
		return acceptedChars.test(c);
	}

	@Override
	public void countChar(final char c, final int increment) throws IllegalArgumentException {
		if (! acceptsChar(c)) {
			throw new IllegalArgumentException("Count of '" + c + "' is not supported");
		}
		if (increment < 1) {
			throw new IllegalArgumentException("Increment must be >= 1");
		}
		counters.put(c, getCharCount(c) + increment);
	}

	@Override
	public Collection<Character> getCountedChars() {
		return Collections.unmodifiableCollection(counters.keySet());
	}

	@Override
	public int getCharCount(final char c) {
		return counters.getOrDefault(c, 0);
	}

	@Override
	public int getTotalCharCount() {
		return counters.values().stream().mapToInt(n -> n).sum();
	}

	// extra methods

	/**
	 * Adds all the counters in the provided CharCounter to this one.
	 *
	 * @param cc the CharCounter from which to add counters
	 * @throws IllegalArgumentException if some characters are not accepted
	 */
	public void add(final CharCounter cc) {
		// TODO
	}

	/**
	 * Same as getCounterChars, but returns the result as a String
	 *
	 * @return the counted chars as a String
	 */
	public String getCountedCharsAsString() {
		// TODO
		return null;
	}

	/**
	 * Gets the char count ignoring case, i.e. for letters the count includes
	 * upper and lower case variants (if they differ, see doc for toUpperCase and toLowerCase).
	 * @param c the character
	 * @return the char count ignoring case
	 */
	public int getCharCountIgnoreCase(final char c) {
		// TODO
		return 0;
	}

	/**
	 * Gets the summed count for all characters satisfying the predicate.
	 * E.g. to find the number of lower case letters use getCharCount(Character::isLowerCase).
	 *
	 * @param chars the predicate
	 * @return the sum of the counts for characters satisfying the predicate
	 */
	public int getCharCount(final Predicate<Character> chars) {
		// TODO
		return 0;
	}

	/**
	 * Counts the characters in s that are accepted for counting.
	 *
	 * @param s the source of characters
	 */
	public void countChars(final String s) {
		// TODO
	}

	/**
	 * Counts the characters in chars that are accepted for counting.
	 *
	 * @param chars the source of characters
	 */
	public void countChars(final Iterator<Character> chars) {
		// TODO
	}

	/**
	 * Counts the characters in chars that are accepted for counting.
	 *
	 * @param chars the source of characters
	 */
	public void countChars(final Iterable<Character> chars) {
		// TODO
	}

	/**
	 * Counts the characters in chars that are accepted for counting.
	 *
	 * @param chars the source of characters
	 */
	public void countChars(final Stream<? extends CharSequence> chars) {
		// TODO
	}

	/**
	 * Counts the characters read from chars that are accepted for counting.
	 *
	 * @param chars the source of characters
	 * @throws IOException
	 */
	public void countChars(final Reader chars) throws IOException {
		// TODO
	}

	/**
	 * Counts the characters read from chars that are accepted for counting.
	 *
	 * @param chars the source of characters
	 * @throws IOException
	 */
	public void countChars(final InputStream chars) throws IOException {
		// TODO
	}

	public static void main(String[] args) {
		CharCounterImpl cc = new CharCounterImpl("abcd");
		cc.countChars("This is a test abcdefghijklmnopqrstuvwxyz");
		System.out.println(cc.getCountedCharsAsString());               // abcd 
		System.out.println(cc.getTotalCharCount());                     // 5

		CharCounterImpl cc2 = new CharCounterImpl("ac");
		cc2.countChars("This is a test abcdefghijklmnopqrstuvwxyz");
		cc.add(cc2);
		System.out.println(cc.getCharCountIgnoreCase('a'));           // 4

		CharCounterImpl cc3 = new CharCounterImpl("a123");
		cc3.countChars("All the digits: 0123456789");
		try {
			cc.add(cc3);
		} catch (IllegalArgumentException e) {
			System.out.println("This gives exception as expected: " + e.getMessage());
		}
	}

}
