package com.imokhonko.decorators.food;

import com.imokhonko.components.food.Corn;

import java.util.ArrayList;
import java.util.List;

public class ArrayListPrint extends CondimentArrayList {

    private List<String> arrayList;
    private final Corn corn;

    public ArrayListPrint(final Corn corn) {
        this.corn = corn;
    }

    @Override
    public List<String> getTitleAsList() {
        arrayList = new ArrayList<>();
        String[] condiments = corn.getTitle().split(", ");
        for(String condiment : condiments) {
            arrayList.add(condiment);
        }
        return arrayList;
    }

    @Override
    public double cost() {
        return 0 + corn.cost();
    }
}
