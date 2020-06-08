package com.liuy307.j2se.collection;

import org.junit.Test;

import java.util.*;

public class CollectionDemo {
    //ArrayList
    @Test
    public void test1() {
        Collection c=new ArrayList();//父类引用指向子类对象，提供了很大灵活性。只能用父类的方法，更换子类还是可以使用。
        c.add("hello");
        c.add(new Date());
        c.add(new Integer(100));
        c.add(new Name("yong", "liu"));
        System.out.println(c.size());
        System.out.println(c);//调用c的toString()方法
    }

    //HashSet
    @Test
    public void test2() {
        Collection c=new HashSet();//父类引用指向子类对象，提供了很大灵活性。只能用父类的方法，更换子类还是可以使用。
        c.add("hello");
        c.add(new Date());
        c.add(new Integer(100));
        c.add(new Name("yong", "liu"));
        c.remove("hello");
        c.remove(new Integer(100));//Integer重写了equals
        c.remove(new Date());
        c.remove(new Name("yong", "liu"));//重写equals方法必须重写hashcode，hashcode配合散列集合使用（包括HashSet、HashMap以及HashTable）
        //两个对象equals，则hashcode一定相等，反之不成立
        System.out.println(new Name("yong", "liu").hashCode());
        System.out.println(new Name("yong", "liu").hashCode());
        System.out.println("yong".hashCode());

        System.out.println(c.size());
        System.out.println(c);//调用c的toString()方法
    }

    //Iterator
    @Test
    public void test3() {
        Collection c = new HashSet();//父类引用指向子类对象，提供了很大灵活性。只能用父类的方法，更换子类还是可以使用。
        c.add(new Name("yong", "liu"));
        c.add(new Name("yu", "zhu"));
        c.add(new Name("dawei", "dai"));
        Iterator it = c.iterator();
        while(it.hasNext()) {
            Name name = (Name)it.next();//jdk1.4以前返回值为Object，1.4以后为泛型
            System.out.println(name);
        }
    }
}

