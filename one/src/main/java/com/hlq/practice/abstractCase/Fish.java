package com.hlq.practice.abstractCase;

public class Fish extends Animal {

    public void run() {
        this.leg=0;
        System.out.println("不能跑，只能游");
    }

    public void vioce() {
        System.out.println("no vioce");
    }

    public void eat() {
        System.out.println("water");
    }
}
