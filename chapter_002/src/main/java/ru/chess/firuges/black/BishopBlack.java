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
        int len = 0;
        Cell[] way = new Cell[] {source};

        if (Math.abs(diffY) == Math.abs(diffX)) {
            len = Math.abs(diffX) + 1;
        } else {
            throw new ChessOutException();
        }
        Cell[] steps = new Cell[len];
        if (Math.abs(diffY) == Math.abs(diffX)) {

            if (diffX < 0 && diffY < 0) {
                int counter = 0;
                for (int i = 1; i < len; i++) {
                    counter = 8 * (source.x + i) + (source.y + i);
                    steps[i] = Cell.values()[counter];
                }
            } else if (diffX > 0 && diffY > 0) {
                int counter = 0;
                for (int i = 1; i < len; i++) {
                    counter = 8 * (source.x - i) + (source.y - i);
                    steps[i] = Cell.values()[counter];
                }
            } else if (diffX > 0 && diffY < 0) {
                int counter = 0;
                for (int i = 1; i < len; i++) {
                    counter = 8 * (source.x - i) + (source.y + i);
                    steps[i] = Cell.values()[counter];
                }
            } else if (diffX < 0 && diffY > 0) {
                int counter = 0;
                for (int i = 1; i < len; i++) {
                    counter = 8 * (source.x + i) + (source.y - i);
                    steps[i] = Cell.values()[counter];
                }
            }
           way = Arrays.copyOf(steps, steps.length);
        }
        return way;
    }
            @Override
            public Figure copy(Cell dest) {
                return new BishopBlack(dest);
            }
        }