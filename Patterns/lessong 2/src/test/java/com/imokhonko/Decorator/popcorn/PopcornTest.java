package com.imokhonko.Decorator.popcorn;

import static org.assertj.core.api.Assertions.*;

import com.imokhonko.Decorator.popcorn.popcornCondiments.Cheese;
import com.imokhonko.Decorator.popcorn.popcornCondiments.Chocolate;
import org.junit.Test;


public class PopcornTest {

    Popcorn popcorn;

    @Test
    public void createExtraSmallPopCorn() {
        popcorn = new ClassicPopcorn(Size.EXTRA_SMALL);
        assertThat(popcorn.getCost()).isEqualTo(1.5);
    }

    @Test
    public void createSmallPopCorn() {
        popcorn = new ClassicPopcorn(Size.SMALL);
        assertThat(popcorn.getCost()).isEqualTo(3);
    }

    @Test
    public void createSmallPopCornWIthSmallCheese() {
        /* If we don't set the size of Cheese it will be inherit it from previous condiment */
        popcorn = new Cheese(new ClassicPopcorn(Size.SMALL));
        assertThat(popcorn.getCost()).isEqualTo(4);
    }

    @Test
    public void createSmallPopCornWIthMiddleCheese() {
        popcorn = new Cheese(new ClassicPopcorn(Size.SMALL), Size.MIDDLE);
        assertThat(popcorn.getCost()).isEqualTo(4.5);
    }

    @Test
    public void createSmallPopCornWIthCheeseAndChocolate() {
        popcorn = new Chocolate(new Cheese(new ClassicPopcorn(Size.EXTRA_SMALL)));
        assertThat(popcorn.getCost()).isEqualTo(3);
    }
}