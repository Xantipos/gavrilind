
package ru.pseudo;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Dm Gavrilin (mailto:anubite@bk.ru)
 * @version $Id$
 * @since 0.1
 */
public class PaintTest {
    @Test
    public void whenDrawSquare() {

        PrintStream stdout = System.out;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        new Paint().draw(new Square());

        assertThat(
                new String(out.toByteArray()),
                is(
                        new StringBuilder()
                                .append("++++")
                                .append("+  +")
                                .append("+  +")
                                .append("++++")
                                .append(System.lineSeparator())
                                .toString()
                )
        );

        System.setOut(stdout);
    }
}