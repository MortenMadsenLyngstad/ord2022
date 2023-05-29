package part2;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

/**
 * A stack of integers that is decreasing in size.
 */
public class DecreasingStack {

	private List<Integer> stack = new ArrayList<>();

	/**
	 * Initializes this DecreasingStack with the provided element.
	 */
	public DecreasingStack(final int firstValue) {
		stack.add(firstValue);
	}

	/**
	 * Pushed the provided element at the top, but
	 * only if it is less than the current topmost element.
	 *
	 * @param element to be pushed
	 * @return true if element is successfully pushed, false otherwise
	 */
	public boolean push(final int element) {
		if (element < peek() || stack.isEmpty()) {
			stack.add(element);
			return true;
		}
		return false;
	}

	/**
	 * Removes and return the topmost element (if any)
	 *
	 * @return the topmost element (if any)
	 * @throws an appropriate subclass of RuntimeException if is stack is empty.
	 */
	public int pop() {
		if (stack.isEmpty()) {
			throw new IllegalStateException("Stack is empty");
		}
		return stack.remove(stack.size() - 1);
	}

	/**
	 * Returns the topmost element (if any).
	 *
	 * @return top element of the stack (if any), or null if it is empty
	 * @throws an appropriate subclass of RuntimeException if is stack is empty.
	 */
	public int peek() {
		if (stack.isEmpty()) {
			throw new EmptyStackException();
		}
		return stack.get(stack.size() - 1);
	}

	@Override
	public String toString() {
		return "DecreasingStack [stack=" + stack + "]";
	}

	/**
	 * @return true if stack is empty, false otherwise
	 */
	public boolean isEmpty() {
		return stack.isEmpty();
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

		while (!ds.isEmpty()) {
			System.out.println(ds.pop());
		}

		// throws exception
		ds.peek();
	}
}
