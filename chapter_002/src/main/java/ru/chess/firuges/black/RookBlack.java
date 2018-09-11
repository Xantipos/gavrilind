package ru.chess.firuges.black;

import ru.chess.ChessOutException;
import ru.chess.firuges.Cell;
import ru.chess.firuges.Figure;
import java.util.Arrays;
/**
 *
 * @author DmGavrilin(anubite@bk.ru)
 * @version $Id$
 * @since 0.1
 */
public class RookBlack implements Figure {
    private final Cell position;

    public RookBlack(final Cell position) {
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
        if (diffX == 0 || diffY == 0) {
            int len = diffX == 0 ? Math.abs(diffY) + 1 : Math.abs(diffX) + 1;
            Cell[] way = new Cell[len];
            for (int i = 1; i < len; i++) {
                if (diffX != 0) {
                    int counter = diffX < 0 ? 8 * (source.x + i) + (source.y) : 8 * (source.x - i) + (source.y);
                    way[i] = Cell.values()[counter];
                } else if (diffY != 0) {
                    int counter = diffY < 0 ? 8 * (source.x) + (source.y + i) : 8 * (source.x) + (source.y - i);
                    way[i] = Cell.values()[counter];
                }
            }
            return way;
        } else {
            throw new ChessOutException();
        }
    }

    @Override
    public Figure copy(Cell dest) {
        return new RookBlack(dest);
    }
}
