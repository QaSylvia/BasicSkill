package com.hlq.practice.abstractCase;

public abstract class Animal {
    int leg;

//    public Animal() {}
    public abstract void run();

    public abstract void vioce();

    public abstract void eat();

    public void breath(){
        System.out.println("有生命力的");
    }
}
