package com.hlq.practice.abstractCase;

public class Zoo {
    public static void main(String[] args) {
        Animal animal1=new Fish();
        animal1.breath();
        animal1.eat();
        animal1.run();
        animal1.vioce();
        System.out.println(animal1.leg);

        Animal animal2=new Tiger();
        animal2.run();
        animal2.eat();
        animal2.breath();
        animal2.vioce();

    }
}
