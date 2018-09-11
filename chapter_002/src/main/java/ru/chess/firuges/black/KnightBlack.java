package ru.chess.firuges.black;

import ru.chess.ChessOutException;
import ru.chess.firuges.Cell;
import ru.chess.firuges.Figure;

/**
 *
 * @author DmGavrilin(anubite@bk.ru)
 * @version $Id$
 * @since 0.1
 */
public class KnightBlack implements Figure {
    private final Cell position;

    public KnightBlack(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) {
        int diffX = Math.abs(source.x - dest.x);
        int diffY = Math.abs(source.y - dest.y);
        int len = 0;
        if ((diffX == 2 && diffY == 1) || (diffY == 2 && diffX == 1)) {
            len = 3;
        } else {
            throw new ChessOutException();
        }
        Cell[] steps = new Cell[len];
        int counter = 0;

        if ((diffX == 2 & diffY == 1) | (diffY == 2 & diffX == 1)) {
            if (diffY == 2 & (dest.y - source.y) > 0) {
                counter = 8 * (source.x + 0) + (source.y + 1);
                steps[0] = Cell.values()[counter];
                counter = 8 * (source.x + 0) + (source.y + 2);
                steps[1] = Cell.values()[counter];
                steps[2] = dest;
            } else if (diffY == 2 & (dest.y - source.y) < 0) {
                counter = 8 * (source.x - 0) + (source.y - 1);
                steps[0] = Cell.values()[counter];
                counter = 8 * (source.x - 0) + (source.y - 2);
                steps[1] = Cell.values()[counter];
                steps[2] = dest;
            } else if (diffX == 2 & (dest.x - source.x) > 0) {
                counter = 8 * (source.x + 1) + (source.y);
                steps[0] = Cell.values()[counter];
                counter = 8 * (source.x + 2) + (source.y);
                steps[1] = Cell.values()[counter];
                steps[2] = dest;
            } else if (diffX == 2 & (dest.x - source.x) < 0) {
                counter = 8 * (source.x - 1) + (source.y);
                steps[0] = Cell.values()[counter];
                counter = 8 * (source.x - 2) + (source.y);
                steps[1] = Cell.values()[counter];
                steps[2] = dest;
            }
        }
        return steps;
    }

    @Override
    public Figure copy(Cell dest) {
        return new KnightBlack(dest);
    }
}
