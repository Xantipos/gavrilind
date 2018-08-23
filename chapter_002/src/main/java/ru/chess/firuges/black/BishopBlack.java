package ru.chess.firuges.black;

import ru.chess.Logic;
import ru.chess.firuges.Cell;
import ru.chess.firuges.Figure;

/**
 *
 * @author Petr Arsentev (parsentev@yandex.ru)
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

        int diffY = Math.abs(dest.y - source.y);
        int diffX = Math.abs(dest.x - source.x);
        Cell[] steps = new Cell[diffY];

        if (diffY == diffX) {
            for (int i = 0; i != diffY; i++) {
                if (dest.y - source.y > 0 && dest.x - source.x >0) {
                steps[i] = new Cell(source.x + i, source.y + i);

            }

            return steps;

        }


    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}
