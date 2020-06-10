package com.liuy307.j2se.collection;

import java.util.Arrays;

public class MyArrayList {
    private static final Object[] EMPTY = {};
    private static final Object[] DEFAULT_CAPCITY_EMPTY = {};
    private final int DEFAULT_CAPCITY = 20;

    private Object[] elementData;
    int size;

    public MyArrayList() {
        this.elementData = DEFAULT_CAPCITY_EMPTY;
    }

    public MyArrayList(int initCapcity) {
        if(initCapcity == 0)
            this.elementData = EMPTY;
        else
            this.elementData = new Object[initCapcity];
    }

    boolean add(Object e) {
        ensureCapcityInternal(size + 1);
        elementData[size++] = e;
        return true;
    }

    void ensureCapcityInternal(int minCapcity){
        minCapcity = reviseCapcity(minCapcity);
        if(minCapcity > elementData.length) //重要,判断需不需要扩容
            grow(minCapcity);
    }

    int reviseCapcity(int minCapcity) {
        if (this.elementData == DEFAULT_CAPCITY_EMPTY)
            return DEFAULT_CAPCITY;
        return minCapcity;
    }

    void grow(int minCapcity) {
        int oldCapcity = elementData.length;
        int newCapcity = oldCapcity + (oldCapcity>>1); //(oldCapcity>>1)要用括号，运算优先级
        if (newCapcity < minCapcity)
            newCapcity = minCapcity;
        this.elementData = Arrays.copyOf(elementData, newCapcity);
    }
}
