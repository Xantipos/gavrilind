package ru.chess.firuges.black;

import ru.chess.ChessOutException;
import ru.chess.firuges.Cell;
import ru.chess.firuges.Figure;

/**
 *
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class KingBlack implements Figure {
    private final Cell position;
    public KingBlack(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) {
        Cell[] steps = new Cell[0];
        int diffX = Math.abs(source.x - dest.x);
        int diffY =  Math.abs(source.y - dest.y);

        if ((diffY == 1) & (diffX == 1) | (diffY == 1 & diffX == 0) | (diffY == 0 & diffX == 1)) {
            steps = new Cell[] {dest};
        } else {
            throw new ChessOutException();
        }
        return steps;
    }

    @Override
    public Figure copy(Cell dest) {
        return new KingBlack(dest);
    }
}
