package part4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collection;

import part3.CharCounter;
import part3.CharCounterImpl;

/**
 * TODO: Document the file format here
 */
public class CharCounterFileFormatImpl implements CharCounterFileFormat {

	private String escapeChar(final char c) {
		if (c == '\\') {
			return "\\\\";
		}
		else if (c == '\n') {
			return "\\n";
		}
		else {
			return String.valueOf(c);
		}
	}

	private char unescapeChar(final String s, final int[] pos) throws RuntimeException{
		char c = s.charAt(pos[0]);
		if (c == '\\') {
			if (pos[0] == s.length() -1) {
				throw new IllegalArgumentException("Premature end-of-string");
			}
			c = s.charAt(pos[0] +1);
			if (c == 'n') {
				c = '\n';
			}
			else if (c != '\\') {
				throw new IllegalArgumentException("Illegal escape character: '" + c + "'");
			}
			pos[0]++;
		}
		return c;
	}

	@Override
	public void save(final CharCounter cc, final OutputStream out) {
		final PrintStream ps = new PrintStream(out);

		final Collection<Character> countedChars = new ArrayList<>();

		for (Character character : countedChars) {
			ps.print(escapeChar(character));
		}
		ps.println();

		for (Character character : countedChars) {
			ps.print(escapeChar(character));
			ps.println(cc.getCharCount(character));
		}
		ps.flush();
	}

	@Override
	public CharCounterImpl load(final InputStream in) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		final String acceptedChars = loadAcceptedChars(br);
		final CharCounterImpl cc = new CharCounterImpl(acceptedChars);
		try {
			loadCounters(cc, br);
		}catch (RuntimeException e) {
			throw new IOException("Illegal format " + e);
		}
		return cc;
	}

	private void loadCounters(CharCounter cc, BufferedReader br) throws NumberFormatException, IllegalArgumentException, IOException, RuntimeException {
		String line = null;
		while ((line = br.readLine()) != null) {
			if (line.length() == 0) {
				break;
			}
			final int[] pos = { 0 };
			final char c = unescapeChar(line, pos);
			final int counter = Integer.valueOf(line.substring(pos[0] + 1));
			cc.countChar(c, counter);
		}
	}

	private String loadAcceptedChars(BufferedReader br) throws IOException {
		String acceptedChars = "";
		String line = br.readLine();
		if (line == null) {
			throw new IOException("Premature EOF");
		}
		int[] pos = { 0 };
		while (pos[0] < line.length()) {
			char c = unescapeChar(line, pos);
			pos[0]++;
			acceptedChars += c;
		}
		return acceptedChars;
	}

	@Override
	public void loadInto(final CharCounter cc, final InputStream in) throws IOException {
		final BufferedReader br = new BufferedReader(new InputStreamReader(in));

		try {
			loadCounters(cc, br);
		} catch (final RuntimeException e) {
			throw new IOException("Illegal format" + e);
		}
	}
}
