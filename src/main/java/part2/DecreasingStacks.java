package part2;

import java.util.List;

/**
 * DecreasingStacks is a class that manages an ordered list of {@link DecreasingStack} instances
 * None of the stacks are allowed to be empty.
 */
public class DecreasingStacks {

	// TOOO: fields

	/**
	 * @return true if all stacks (if any) are empty
	 */
	public boolean isEmpty() {
		// TODO
		return false;
	}

	/**
	 * Pushes the provided element onto the first stack that accepts it.
	 * If there are no such stacks, add a new DecreasingStack to end of stack list,
	 * that is initialized with the element.
	 *
	 * @param element the element to push
	 */
	public void push(final int element) {
		// TODO
	}

	/**
	 * @return newline-separated string of stacks
	 */
	@Override
	public String toString() {
		// TODO
		return null;
	}

	/**
	 * Remove and return the smallest element across all stacks.
	 *
	 * @return (and remove) the element from the stacks that is smalles
	 * @throws an appropriate subclass of RuntimeException if no element can be popped
	 */
	public int pop() {
		// TODO
		return 0;
	}

	/**
	 * @return a List with the elements in increasing order.
	 * If there are no elements, return an empty list.
	 * The elements are also removed from this DecreasingStacks.
	 */
	public List<Integer> popAll() {
		// TODO
		return null;
	}

	// for your own use

	public static void main(final String[] args) {
		final DecreasingStacks stacks = new DecreasingStacks();
		List.of(5,3,8,2,1,4,4,7,6).forEach(stacks::push);
		System.out.println(stacks.toString());
		// Should print
		// [5, 3, 2, 1]
		// [8, 4]
		// [4]
		// [7, 6]

		System.out.println(stacks.popAll());
		// Should print
		// [1, 2, 3, 4, 4, 5, 6, 7, 8]
	}
}

