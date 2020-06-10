package com.liuy307.j2se.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ArrayListDemo {
    @Test
    public void test1() {
        List<String> list1 = new ArrayList<>(0);
        for (int i = 0; i < 10; i++) {
            list1.add("21");
        }
        List<String> list2 = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list2.add("22");
        }
    }

    @Test
    public void MyArrayListTest() {
        MyArrayList list1 = new MyArrayList(0);
        for (int i = 0; i < 10; i++) {
            list1.add("21");
        }
        list1.add(21);
        MyArrayList list2 = new MyArrayList();
        for (int i = 0; i < 10; i++) {
            list2.add("22");
        }
    }
}
