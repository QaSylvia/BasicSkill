package com.hlq.practice.abstractCase;

public class Tiger extends Animal{
    public void run() {
        this.leg=4;
        System.out.println("两只老虎跑得快："+leg*2+"条腿跑");
    }

    public void vioce() {
        System.out.println("吼");
    }

    public void eat() {
        System.out.println("吃肉");
    }
}
