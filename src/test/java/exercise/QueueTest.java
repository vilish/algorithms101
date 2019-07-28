package exercise;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class QueueTest {


    private Queue queue;

    @Before
    public void setup() {
        queue = new Queue();
    }

    @Test
    public void Add() {
        queue.add(1);
        queue.add(2);
        queue.add(3);

        Assert.assertEquals(queue.size(), 3);
        Assert.assertEquals(queue.peek(), 1);
    }

    @Test
    public void Remove() {
        queue.add(2);
        queue.add(4);
        queue.add(6);
        queue.add(8);
        Assert.assertEquals(queue.size(), 4);

        queue.remove();
        Assert.assertEquals(queue.size(), 3);
        Assert.assertEquals(queue.peek(), 4);
    }


}
