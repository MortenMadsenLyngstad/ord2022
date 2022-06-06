package part2;

/**
 * A stack of integers that is decreasing in size.
 */
public class DecreasingStack {

	// TODO: fields

	/**
	 * Initializes this DecreasingStack with the provided element.
	 */
	public DecreasingStack(final int firstValue) {
		// TODO
	}

	/**
	 * Pushed the provided element at the top, but
	 * only if it is less than the current topmost element.
	 *
	 * @param element to be pushed
	 * @return true if element is successfully pushed, false otherwise
	 */
	public boolean push(final int element) {
		// TODO
		return false;
	}

	/**
	 * Removes and return the topmost element (if any)
	 *
	 * @return the topmost element (if any)
	 * @throws an appropriate subclass of RuntimeException if is stack is empty.
	 */
	public int pop() {
		// TODO
		return 0;
	}

	/**
	 * Returns the topmost element (if any).
	 *
	 * @return top element of the stack (if any), or null if it is empty
	 * @throws an appropriate subclass of RuntimeException if is stack is empty.
	 */
	public int peek() {
		// TODO
		return 0;
	}

	@Override
	public String toString() {
		// TODO
		return null;
	}

	/**
	 * @return true if stack is empty, false otherwise
	 */
	public boolean isEmpty() {
		// TODO
		return false;
	}

	// for your own use

	public static void main(final String[] args) {
		final DecreasingStack ds = new DecreasingStack(10);
		ds.push(6);
		ds.push(3);
		System.out.println(ds);

		if (ds.push(5)) {
			System.out.println("Pushed 5");
		} else {
			System.out.println("Cannot push 5");
		}

		while (! ds.isEmpty()) {
			System.out.println(ds.pop());
		}

		// throws exception
		ds.peek();
	}
}

