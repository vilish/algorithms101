package exercise;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StackTest {

    private Stack stack;

    @Before
    public void setup() {
        stack = new Stack();
    }

    @Test
    public void Push(){
        stack.push(1);
        stack.push(2);
        stack.push(3);

        Assert.assertEquals(stack.size(), 3);
        Assert.assertEquals(stack.peek(), 3);
    }

    @Test
    public void Pop(){
        stack.push(1);
        stack.push(2);
        stack.push(3);

        stack.pop();
        Assert.assertEquals(stack.size(), 2);
        Assert.assertEquals(stack.peek(), 2);
    }
}
