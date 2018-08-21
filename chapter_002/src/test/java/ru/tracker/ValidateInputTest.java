package ru.tracker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import ru.tracker.input.StubInput;
import ru.tracker.input.ValidateInput;


/**
 * @author Dm Gavrilin (mailto:anubite@bk.ru)
 * @version $Id$
 * @since 0.1
 */

public class ValidateInputTest {
    private final ByteArrayOutputStream mem = new ByteArrayOutputStream();
    private final PrintStream out = System.out;


    @Before
    public void loadMem() {
        System.setOut(new PrintStream(this.mem));
    }

    @After
    public void loadSys() {
        System.setOut(this.out);
    }

    @Test
    public void whenInvalidInput() {
        ValidateInput input = new ValidateInput(
                new StubInput(new String[] {"i", "1"})
        );
        input.ask("Enter", new int[] {0, 1, 2, 3, 4, 5});
        assertThat(
                this.mem.toString(),
                is(
                        String.format("Please enter validate data again.%n")
                )
        );
    }
}