package com.imokhonko.model;

import com.imokhonko.model.exceptions.CellAlreadyTakenException;
import com.imokhonko.model.exceptions.InvalidMoveException;

import java.awt.*;

public class Field {

    private static final int FIELD_SIZE = 3;

    private static final int MIN_COORDINATE = 0;
    private static final int MAX_COORDINATE = FIELD_SIZE;

    private final Figure[][] field = new Figure[FIELD_SIZE][FIELD_SIZE];

    public int getSize() {
        return FIELD_SIZE;
    }

    public void setFigure(final Point point, final Figure figure)
            throws InvalidMoveException {
        if(checkPoint (point)) {
            throw new InvalidMoveException ();
        }

        this.field[point.x][point.y] = figure;
    }

    public Figure getFigure(final Point point)
            throws InvalidMoveException, CellAlreadyTakenException {
        if(checkPoint (point)) {
            throw new InvalidMoveException ();
        }
        if(this.field[point.x][point.y] != null) {
            throw new CellAlreadyTakenException ();
        }

        return field[point.x][point.y];
    }

    private boolean checkPoint(final Point point) {
        return checkPointCoordinate (point.x) && checkPointCoordinate (point.y);
    }

    private boolean checkPointCoordinate(final int coordinate) {
        return coordinate >= MIN_COORDINATE && coordinate <= MAX_COORDINATE;
    }

}
