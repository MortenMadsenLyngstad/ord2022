package part2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class DecreasingStackTest {
    
    @Test
    public void testDecreasingStackPush() {
        DecreasingStack stack = new DecreasingStack(4);
        assertEquals(4, stack.peek());
        stack.push(2);
        assertEquals(2, stack.peek());
        stack.push(5);
        assertEquals(2, stack.peek());
    }

    @Test
    public void testDecreasingStackPop() {
        DecreasingStack stack = new DecreasingStack(4);
        stack.pop();
        assertTrue(stack.isEmpty());
    }

    // osv.
    
}
