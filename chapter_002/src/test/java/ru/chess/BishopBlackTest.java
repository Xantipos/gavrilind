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
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.C8));
        //assertThat (logic.move(Cell.C8, Cell.F5), is (true));
        BishopBlack slon = new BishopBlack(Cell.C8);
        Cell[] result = new Cell[0];
        Cell target = Cell.F5;
        result = slon.way(Cell.C8,target);

        assertThat (result[result.length - 1].equals(target), is (true));
       // assertThat(result[result.length - 1].getX(), is(target.getX()));
        //assertThat(result[result.length - 1].getY(), is(target.getY()));
    }
}