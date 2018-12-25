package ru.search;

import org.junit.Test;
import java.util.List;
import java.util.ArrayList;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PriorityQueueTest {
    @Test
    public void whenHigherPriority() {
        PriorityQueue queue = new PriorityQueue();
        List<Task> in = new ArrayList<Task>();
        in.add(new Task("middle", 4));
        in.add(new Task("low", 6));
        in.add(new Task("urgent", 0));
        in.add(new Task("middle", 4));
        in.add(new Task("middle", 2));
        queue.put(in);
        Task result = queue.take();
        queue.print();
        assertThat(result.getDesc(), is("low"));
    }
}
