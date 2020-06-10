package com.hlq.practice.staticCase;

public class ST2 {
    private static int num=1;
    private int value=0;

    static {
        System.out.println("1、静态域，实例化对象前执行，只执行一次");
        System.out.println("只能加载静态变量"+num);
    }

    {
        System.out.println("2、代码块,实例化对象时才会执行");
        System.out.println("可以加载全部变量"+num+" "+value);
    }

    public ST2(){
        System.out.println("3、构造函数，实例化对象时执行");
    }

    public static void main(String[] args) {
        ST2 st2=new ST2();
        System.out.println("main函数");
    }
}
