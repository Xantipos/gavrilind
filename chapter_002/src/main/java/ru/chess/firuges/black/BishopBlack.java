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
        int len = Math.abs(source.x - dest.x) + 1;
        Cell[] steps = new Cell[len];
        System.out.println(len);
        Cell cell = Cell.A1;
        int diffX = source.x - dest.x;
        int diffY = source.y - dest.y;
        if (Math.abs(diffY) == Math.abs(diffX)) {
            System.out.println("зашли в цикл");
            if (diffX < 0 && diffY < 0) {
                for (int i = 0; i < len; i++) {
                    cell.setXY(source.x + i, source.y + i);
                    System.out.println("+1 step + +");
                    steps[i] = cell;
                }
            } else if (diffX > 0 && diffY > 0) {
                for (int i = 0; i < len; i++) {
                    cell.setXY(source.x - i, source.y - i);
                    System.out.println("+1 step - -");
                    steps[i] = cell;
                }
            } else if (diffX > 0 && diffY < 0) {
                for (int i = 0; i < len; i++) {
                    cell.setXY(source.x - i, source.y + i);
                    System.out.println("+1 step - +");
                    steps[i] = cell;
                }
            } else if (diffX < 0 && diffY > 0) {
                for (int i = 0; i < len; i++) {
                    cell.setXY(source.x + i, source.y - i);
                    System.out.println("+1 step + -");
                    steps[i] = cell;
                }
               steps[len - 1] = dest;
            }
            else steps = new Cell[0];

        }
        return steps;
    }
            @Override
            public Figure copy(Cell dest) {
                return new BishopBlack(dest);
            }
        }