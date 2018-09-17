package ru.chess.firuges.black;
import ru.chess.ChessOutException;
import ru.chess.Logic;
import ru.chess.firuges.Cell;
import ru.chess.firuges.Figure;
import java.util.Arrays;
/**
 *
 * @author DmGavrilin(anubite@bk.ru)
 * @version $Id$
 * @since 0.1
 */
public class BishopBlack implements Figure {
    private final Cell position;
    public BishopBlack(final Cell position) {
        this.position = position;
    }
    @Override
    public Cell position() {
        return this.position;
    }
    @Override
    public Cell[] way(Cell source, Cell dest) {
        int diffX = source.x - dest.x;
        int diffY = source.y - dest.y;
        if (Math.abs(diffY) != Math.abs(diffX)) {
            throw new ChessOutException();
        }
            int len = Math.abs(diffX);

        int deltaX = Integer.compare(source.x, dest.x);
        int deltaY = Integer.compare(source.y, dest.y);
        Cell[] steps = new Cell[len];
        int k = 0;
        for (int i = 0; i < len + 1; i++) {
            for (int j = 0; j < 64; j++) {
                if(source.x - deltaX * i == Cell.values()[j].x & source.y - deltaY * i == Cell.values()[j].y & i > 0) {
                    steps[k] = Cell.values()[j];
                    k++;
                }
            }
        }

        return steps;
    }
    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}