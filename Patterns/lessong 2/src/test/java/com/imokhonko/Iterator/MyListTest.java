package com.imokhonko.Iterator;

import static org.assertj.core.api.Assertions.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MyListTest {

    private MyList<String> list = null;

    @Before
    public void setUp() {
        list = new MyList<String>();
    }

    @After
    public void tearDown() {
        list = null;
    }

    @Test
    public void add() {
        list.add("Some element");
        list.add("Other elements");
        list.add("and last");

        assertThat(list.size()).isEqualTo(3);
    }

    @Test
    public void getListCapacity() {
        for(int i = 0; i < 11; i++) {
            list.add("element");
        }

        assertThat(list.getListCapacity()).isEqualTo(15);
    }

    @Test
    public void get() {
        list.add("Element");
        assertThat(list.get(0)).isEqualTo("Element");
    }

    @Test
    public void get_newString() {
        list.add(new String("element"));
        assertThat(list.get(0)).isEqualTo(new String("element"));
    }

    @Test
    public void size_emptyList() {
        assertThat(list.size()).isEqualTo(0);
    }

    @Test
    public void size_ListWith2Elements() {
        list.add("first");
        list.add("second");
        assertThat(list.size()).isEqualTo(2);
    }

    @Test
    public void isEmpty_actualyEmptyList() {
        assertThat(list.isEmpty()).isEqualTo(true);
    }

    @Test
    public void isEmpty_hasOneElement() {
        list.add("STRING");
        assertThat(list.isEmpty()).isEqualTo(false);
    }

    @Test
    public void iterator_NaturalOrdering() {
        list.add("first string");
        list.add("second string");
        assertThat(list.iterator().next()).isEqualTo("first string");
    }

    @Test
    public void iterator_ReverseOrdering() {
        list.add("first string");
        list.add("second string");
        list.setOrdering(MyList.IterationOrder.REVERSE);
        assertThat(list.iterator().next()).isEqualTo("second string");
    }

    @Test
    public void iterator_NaturalEmptyList() {
        assertThat(list.iterator().hasNext()).isEqualTo(false);
    }

    @Test
    public void iterator_ReverseEmptyList() {
        list.setOrdering(MyList.IterationOrder.REVERSE);
        assertThat(list.iterator().hasNext()).isEqualTo(false);
    }
}