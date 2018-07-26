package com.imokhonko;

import com.imokhonko.interfaces.IAllocateStrategy;

public class AllocateStrategy implements IAllocateStrategy {

    @Override
    public int nextValue(int now) {
        return now << 1;
    }

}
