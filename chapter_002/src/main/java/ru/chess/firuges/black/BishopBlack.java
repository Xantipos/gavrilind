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

        int len = Math.abs(source.x - dest.x);
        Cell[] steps = new Cell[len];
        int diffX = source.x - dest.x;
        int diffY = source.y - dest.y;
        if (Math.abs(diffY) == Math.abs(diffX)) {
            if (diffX < 0 && diffY < 0) {
                for (int i = 1; i < len - 1; i++) {
           // steps[i] = Cell.(source.x + 1, source.y +1); вот как это присвоить.
                }
            }
            steps[len] = dest;
            return steps;
        }
    }
            @Override
            public Figure copy(Cell dest) {
                return new BishopBlack(dest);
            }
        }