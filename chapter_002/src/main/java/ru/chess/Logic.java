package ru.chess;

import com.sun.corba.se.spi.orbutil.fsm.Input;
import ru.chess.firuges.Cell;
import ru.chess.firuges.Figure;
import ru.tracker.input.MenuOutException;

import java.security.InvalidKeyException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

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


    public boolean validateWay(Cell[] steps) {
        boolean result = true;
        for (int i = 0; i < steps.length; i++) {
            if  (this.findBy(steps[i]) != -1) {
                result = false;
                break;
            }
        }
        return result;
    }

    public boolean move(Cell source, Cell dest) throws FigureNotFoundException, OccupiedWayException, ChessOutException  {
        boolean rst = false;
        int index = this.findBy(source);
        if (index == -1) {
            throw new FigureNotFoundException();
        }
        Cell[] steps = this.figures[index].way(source, dest);
        if (!validateWay(steps)) {
            throw new OccupiedWayException();
        }
        if (steps.length > 0) {
            this.figures[index] = this.figures[index].copy(dest);
            rst = true;
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
        List<Figure> list = Arrays.asList(this.figures);
        Optional<Figure> res = list.stream().filter(figure -> figure.position().equals(cell)).findFirst();

        if (res.isPresent()) {
            rst = list.indexOf(res.get());
        }
       // for (int index = 0; index != this.figures.length; index++) {
         //   if (this.figures[index] != null && this.figures[index].position().equals(cell)) {
              //  rst = index;
               // System.out.println("Index from for =  " + index);
               // break;
           // }
      //  }
        return rst;
    }
}
