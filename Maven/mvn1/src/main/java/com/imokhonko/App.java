package com.imokhonko;


import com.imokhonko.components.food.Corn;
import com.imokhonko.components.food.PopCorn;
import com.imokhonko.decorators.food.ArrayListPrint;
import com.imokhonko.decorators.food.Cheese;
import com.imokhonko.decorators.food.Chocolate;

import java.util.HashSet;
import java.util.Set;


public class App {

    public static void main(String[] args) {

        Corn popCorn = new ArrayListPrint(new Cheese(new Cheese(new Chocolate(new PopCorn()))));


    }

}
