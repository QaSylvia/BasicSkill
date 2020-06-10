package com.hlq.practice.staticCase;

public class ST {
    private static ST baba=new ST();
    private int length=100;
    private static int size=100;

    public ST(){}

    public void setLength(int length){
        this.length=length;
    }

    public static void setSize(int size){
        ST.size=size;
    }

    public int getLength(){
        size=1;
        ST.size=2;
        this.size=3;
        baba.size=4;
        length=1;
        this.length=2;
//        ST.length=3;//非静态属性不支持这样访问
        baba.length=3;
        return this.length;
    }

    public static int getSize(){
        ST.setSize(200);//或者setSize(200)
//        this.setSize(200);//静态方法访问静态属性，不能使用this
        //不能访问非statis的方法或变量
//        System.out.println(baba.length);
        return size;
    }

    public static void main(String[] args) {
        ST st=new ST();
        ST st1=new ST();

//        st.setLength(200);
//        st1.setLength(500);
//        System.out.println(st.length);
//        System.out.println(st1.length+"\n");

        st.setSize(200);
        st1.setSize(500);
        System.out.println(st.size);
        System.out.println(st1.size);

        System.out.println("======");
        System.out.println(st.getLength());
        System.out.println(baba.length);
        System.out.println("======");
        System.out.println(size);
        System.out.println("======");
        System.out.println(st.getSize());
        System.out.println("或者是\n"+getSize());
        System.out.println("或者是\n"+ST.getSize());
    }
}
