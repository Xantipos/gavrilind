package ru.chess;

import com.sun.corba.se.spi.orbutil.fsm.Input;
import ru.chess.firuges.Cell;
import ru.chess.firuges.Figure;
import ru.tracker.input.MenuOutException;

import java.security.InvalidKeyException;
import java.util.Optional;

/**
 * //TODO add comments.
 *
 * @author Dm Gavrilin (anubite@bk.ru)
 * @version $Id$
 * @since 0.1
 */
public class Logic {
    private final Figure[] figures = new Figure[32];
    private int index = 0;
    public void add(Figure figure) {
        this.figures[this.index++] = figure;
    }

    public boolean validatetarget(Cell source) {
        int index = this.findBy(source);
        boolean result = false;
        if (index == -1) {
            throw new FigureNotFoundException();
        } else {
            result = true;
        }
        return  result;
    }

    public boolean validateWay(Cell[] steps) {
        boolean result = true;
        for (int i = 0; i < steps.length; i++) {
            if  (this.findBy(steps[i]) != -1) {
                result = false;
                break;
            }
        }
        if (!result) {
            throw new OccupiedWayException();
        }
        return result;
    }

    public boolean move(Cell source, Cell dest) {
        boolean rst = false;
        try {
            int index = this.findBy(source);
            validatetarget(source);
            Cell[] steps = this.figures[index].way(source, dest);
            if (validateWay(steps)) {
                if (steps.length > 0 && steps[steps.length - 1].equals(dest)) {
                    rst = true;
                    this.figures[index] = this.figures[index].copy(dest);
                }
            }
        } catch (ChessOutException coe) {
            System.out.println("Ну кто так ходит?!!");
        } catch (OccupiedWayException owe) {
            System.out.println("Куда ставить то?!!(с)");
            System.out.println("Да подожди ты!!(с)");
        } catch (FigureNotFoundException fnfe) {
            System.out.println("Где слоник? Нет слоника");
        }

        return rst;
    }

    public void clean() {
        for (int position = 0; position != this.figures.length; position++) {
            this.figures[position] = null;
        }
        this.index = 0;
    }

    private int findBy(Cell cell) {
        int rst = -1;
        for (int index = 0; index != this.figures.length; index++) {
            if (this.figures[index] != null && this.figures[index].position().equals(cell)) {
                rst = index;
                break;
            }
        }
        return rst;
    }
}
