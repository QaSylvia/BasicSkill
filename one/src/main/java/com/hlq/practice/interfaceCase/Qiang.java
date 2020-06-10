package com.hlq.practice.interfaceCase;

public class Qiang {
    public IQiang iQiang;

    public void test(){
        iQiang.talk();
        iQiang.work();
        System.out.println("========");
    }

    public static void main(String[] args) {
        Qiang qiang=new Qiang();
//        qiang.iQiang.talk();
//        qiang.iQiang.work();
        qiang.iQiang=new Teacher();
        qiang.test();

        qiang.iQiang=new Husband();
        qiang.test();

        qiang.iQiang=new Father();
        qiang.test();
    }
}
