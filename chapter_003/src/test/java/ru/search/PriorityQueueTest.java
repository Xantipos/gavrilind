package ru.search;

import org.junit.Test;
import java.util.List;
import java.util.ArrayList;

import static java.util.Map.of;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PriorityQueueTest {
    @Test
    public void whenHigherPriority() {
        PriorityQueue queue = new PriorityQueue();
        List<Task> in2 = List.of(new Task("middle", 4),
                new Task("low", 6),
                new Task("urgent", 0),
                new Task("middle", 4),
                new Task("middle", 2));
        queue.put(in2);
        Task result = queue.take();
        queue.print();
        assertThat(result.getDesc(), is("low"));
    }
}
