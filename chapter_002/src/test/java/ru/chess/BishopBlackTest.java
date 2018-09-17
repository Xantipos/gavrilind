package ru.chess;
import ru.chess.Logic;
import ru.chess.firuges.Cell;
import ru.chess.firuges.Figure;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.chess.firuges.black.BishopBlack;
import ru.chess.firuges.black.KingBlack;
import ru.chess.firuges.black.KnightBlack;
import ru.chess.firuges.black.RookBlack;

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
        public void test() {
            BishopBlack b = new BishopBlack(Cell.A1);
            Cell[] actual = b.way(b.position(), Cell.H8);
            Cell[] expected = {Cell.B2, Cell.C3, Cell.D4, Cell.E5, Cell.F6, Cell.G7, Cell.H8};
            assertThat(actual, is(expected));
        }
}