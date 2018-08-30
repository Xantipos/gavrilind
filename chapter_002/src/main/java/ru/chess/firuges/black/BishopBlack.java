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
        int diffX = source.x - dest.x;
        int diffY = source.y - dest.y;
        int len = 0;

        if (Math.abs(diffY) == Math.abs(diffX)) {
            len = Math.abs(diffX) + 1;
        }
        Cell[] steps = new Cell[len];
        if (Math.abs(diffY) == Math.abs(diffX)) {

            if (diffX < 0 && diffY < 0) {
                int counter = 0;
                for (int i = 0; i < len; i++) {
                    counter = 8*(source.x + i) + (source.y +i);
                    steps[i] = Cell.values()[counter];
                }
            } else if (diffX > 0 && diffY > 0) {
                int counter = 0;
                for (int i = 0; i < len; i++) {
                    counter = 8*(source.x - i) + (source.y - i);
                    //System.out.println("- -");
                   // System.out.println("counter"+ counter);
                    steps[i] = Cell.values()[counter];
                }
            } else if (diffX > 0 && diffY < 0) {
                int counter = 0;
                for (int i = 0; i < len; i++) {
                    counter = 8*(source.x - i) + (source.y + i);
                   // System.out.println("- +");
                   // System.out.println("counter"+ counter);
                    steps[i] = Cell.values()[counter];
                }
            } else if (diffX < 0 && diffY > 0) {
                int counter = 0;
                for (int i = 0; i < len; i++) {
                    counter = 8*(source.x + i) + (source.y - i);
                  //  System.out.println("+ -"+ i);
                  //  System.out.println("counter"+ counter);
                    steps[i] = Cell.values()[counter];
                }
            }
        } return steps;
    }
            @Override
            public Figure copy(Cell dest) {
                return new BishopBlack(dest);
            }
        }