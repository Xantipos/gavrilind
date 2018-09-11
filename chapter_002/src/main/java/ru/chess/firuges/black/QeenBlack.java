package ru.chess.firuges.black;

import ru.chess.ChessOutException;
import ru.chess.Logic;
import ru.chess.firuges.Cell;
import ru.chess.firuges.Figure;

/**
 *
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class QeenBlack implements Figure {
    private final Cell position;

    public QeenBlack(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) {
        Cell[] way = new Cell[0];
        int diffX = source.x - dest.x;
        int diffY = source.y - dest.y;
        if (diffX == 0 || diffY == 0) {
            Logic logic = new Logic();
            RookBlack lada = new RookBlack(source);
            logic.add(lada);
            boolean rookmove = logic.move(source, dest);
        } else if (Math.abs(diffY) == Math.abs(diffX)) {
            Logic logic = new Logic();
            BishopBlack slon = new BishopBlack(source);
            logic.add(slon);
            boolean slonmove = logic.move(source, dest);
            if (slonmove) {
                way = slon.way(source, dest);
            }
        } else {
            throw new ChessOutException();
        }

        return way;
    }

    @Override
    public Figure copy(Cell dest) {
        return new QeenBlack(dest);
    }
}
