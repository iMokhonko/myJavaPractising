package com.imokhonko.controller;

import com.imokhonko.model.Field;
import com.imokhonko.model.Figure;
import com.imokhonko.model.exceptions.CellAlreadyTakenException;
import com.imokhonko.model.exceptions.InvalidMoveException;

import java.awt.*;

public class MoveController {

    public void applyFigure(final Point point,
                            final Figure figure,
                            final Field field) throws CellAlreadyTakenException,
                                                        InvalidMoveException {

        if(field.getFigure (point) != null) {
            throw new CellAlreadyTakenException ();
        }
        field.setFigure (point, figure);

    }

}
