package ru.chess;
import ru.chess.Logic;
import ru.chess.firuges.Cell;
import ru.chess.firuges.Figure;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.chess.firuges.black.BishopBlack;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.StringJoiner;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


/**
 * @author Dm Gavrilin (mailto:anubite@bk.ru)
 * @version $Id$
 * @since 0.1
 */
/**
 */
public class BishopBlackTest {
    @Test
    public void whenBishopDiag() {
        BishopBlack slon = new BishopBlack(Cell.C8);
        Cell[] result = new Cell[8];
        Cell target = Cell.H3;
        result = slon.way(Cell.C8,target);
        int x = result[result.length - 1].getX();
        int y = result[result.length - 1].getY();
        System.out.print(x);
        System.out.print(y);

        assertThat (result[result.length - 1].equals(target), is (true));
        assertThat(result[result.length - 1].getX(), is(target.getX()));
        assertThat(result[result.length - 1].getY(), is(target.getY()));
    }
}