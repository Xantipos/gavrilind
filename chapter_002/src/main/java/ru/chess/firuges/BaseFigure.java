package ru.chess.firuges;

import ru.chess.Logic;
import ru.chess.firuges.Cell;
import ru.chess.firuges.Figure;
import ru.chess.Chess;
import ru.chess.firuges.black.*;
import ru.chess.firuges.white.*;

public abstract class BaseFigure implements Figure {
    public final Cell position;

    public BaseFigure(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) {
        Cell[] steps = new Cell[0];
                return steps;
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}