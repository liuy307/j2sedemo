package com.liuy307.j2se.generics;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GenericsDemo {
    @Test
    //使用ArrayList时，如果不定义泛型类型时，泛型类型实际上就是Object：
    public void test1() {
        List list = new ArrayList();
        list.add("Hello");
        list.add("World");
        int i = 1;
        list.add(i);//自动装箱,因为list是object
        list.add(new Date());
//        if (list == null) {
//            ;
//        }
        String first = (String) list.get(0);
        String second = (String) list.get(1);
        int third = (Integer) list.get(2);//自动拆箱
        Date forth = (Date) list.get(3);
        System.out.println("second = " + second);
        System.out.println(forth);
    }
}
