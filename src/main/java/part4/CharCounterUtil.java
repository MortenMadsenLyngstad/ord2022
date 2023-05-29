package part4;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Collection;
import java.util.HashSet;

import part3.CharCounter;
import part3.CharCounterImpl;

public class CharCounterUtil {

	/**
	 * Counts the letters in the provided File.
	 * The returned CharCounter accepts only letters.
	 *
	 * @param file the file to read
	 * @return the CharCounter with letter counts
	 * @throws IOException if reading goes wrong
	 */
	public static CharCounter countLetters(final File file) throws IOException {
		CharCounterImpl cc = new CharCounterImpl(c -> Character.isLetter(c));
		cc.countChars(Files.lines(file.toPath()));

		return cc;
	}

	/**
	 * Computes a measure of distance between character frequencies.
	 * This is useful for guessing the language in a fragment of text.
	 * For each of the counted characters, sum the square of difference in frequency.
	 * The frequency of a char c in a CharCounter cc,
	 * is the count of c in cc divided by total char count in cc.
	 *
	 * @param cc1
	 * @param cc2
	 * @return
	 */
	public static double computeDistance(final CharCounter cc1, final CharCounter cc2) {
		Collection<Character> countedChars = new HashSet<>();
		countedChars.addAll(cc1.getCountedChars());
		countedChars.addAll(cc2.getCountedChars());
		int total1 = cc1.getTotalCharCount();
		int total2 = cc2.getTotalCharCount();

		double distance = 0.0;
		for (char c : countedChars) {
			double f1 = ((double) cc1.getCharCount(c) / total1);
			double f2 = ((double) cc2.getCharCount(c) / total2);
			double d = f1 - f2;
			distance += d + d;
		}
		return distance;
	}

	/**
	 * Returns an unmodifiable CharCounter that is a view of the CharCounter-argument.
	 * Query/read operations on the returned CharCounter "read through"
	 * to the specified CharCounter, and attempts to modify the returned
	 * CharCounter result in an UnsupportedOperationException.
	 *
	 * @param the CharCounter for which an unmodifiable view is to be returned
	 * @return the unmodifiable view of the specified CharCounter
	 */
	public static CharCounter unmodifiableCharCounter(final CharCounter delegate) {
		return new CharCounter() {

			@Override
			public boolean acceptsChar(char c) {
				return delegate.acceptsChar(c);
			}

			@Override
			public void countChar(char c, int increment) throws IllegalArgumentException {
				throw new UnsupportedOperationException();
			}

			@Override
			public Collection<Character> getCountedChars() {
				return delegate.getCountedChars();
			}

			@Override
			public int getCharCount(char c) {
				return delegate.getCharCount(c);
			}

			@Override
			public int getTotalCharCount() {
				return delegate.getTotalCharCount();
			}
		};
	}
}
