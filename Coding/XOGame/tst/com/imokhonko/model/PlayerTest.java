package com.imokhonko.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerTest {
    @Test
    public void getName() throws Exception {

        final String inputValue = "Ivan";
        final String expectedValue = inputValue;

        Player player = new Player ("Ivan", null);

        final String actualValue = player.getName ();

        assertEquals(expectedValue, actualValue);

    }

    @Test
    public void getFigure() throws Exception {

        final Figure inputValue = Figure.X;
        final Figure expectedValue = inputValue;

        Player player = new Player (null, Figure.X);

        final Figure actualValue = player.getFigure ();

        assertEquals(expectedValue, actualValue);

    }

}