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
    public void whenBishopDiag() {
        Logic logic = new Logic();

        //logic.add(new RookBlack(Cell.A8));
        //assertThat (logic.move(Cell.C8, Cell.F5), is (true));
        Cell source = Cell.F4;
        Cell target = Cell.D3;
        KnightBlack figure = new KnightBlack(source);
        Cell[] result = new Cell[0];

        result = figure.way(source, target);
        System.out.println("Первая точка координата X " + result[0].x);
        System.out.println("Первая точка координата Y " + result[0].y);
        System.out.println("Вторая точка координата X " + result[1].x);
        System.out.println("Вторая точка координата Y " + result[1].y);
        System.out.println("Третья точка координата X " + result[2].x);
        System.out.println("Третья точка координата Y " + result[2].y);


        //assertThat (logic.move(Cell.A8, target), is (true));
       assertThat(result[result.length - 1].x, is(target.x));
        assertThat(result[result.length - 1].y, is(target.y));
    }
}