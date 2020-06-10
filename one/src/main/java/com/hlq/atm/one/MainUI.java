package com.hlq.atm.one;

import java.util.Scanner;

public class MainUI {
    static String[][] accounts=new String[10][3];


    public static void main(String[] args) {
        MainUI ui=new MainUI();
        ui.mainManu();
    }

    public void mainManu(){
        System.out.println("welcome");
        System.out.println("请输入选项：1、登陆，2、注册，3、退出");
        Scanner sc=new Scanner(System.in);
        Integer option=sc.nextInt();
        switch (option){
            case 1:
                this.login();
                break;
            case 2:
                this.register();
                break;
            case 3:
                System.exit(0);
                break;
            default:
                System.out.println("输入错误，请重试");
                this.mainManu();
                break;
        }
    }

    public void subManu(){
        System.out.println("输入选项");
        System.out.println("1、查询余额，2、转账，3、取款，4、存款，5、返回主菜单，6、退出");
        Scanner sc=new Scanner(System.in);
        Integer option=sc.nextInt();
        switch (option){
            case 1:
                System.out.println("查余额");
                break;
            case 2:
                System.out.println("转账");
                break;
            case 3:
                System.out.println("取款");
                break;
            case 4:
                System.out.println("存款");
                break;
            case 5:
                System.out.println("返回主菜单");
                break;
            case 6:
                System.exit(0);
                break;
            default:
                System.out.println("输入错误，请重试");
                this.subManu();
                break;
        }

    }

    public void register(){
//        String[] users=new String[10];
//        String[] passes=new String[10];
//        int[] balance=new int[10];
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入用户名");
        String name=sc.next();
        System.out.println("请输入密码");
        String password=sc.next();

        accounts[0][0]=name;
        accounts[0][1]=password;
        accounts[0][2]="5000";
        System.out.println("开户成功");

        System.out.println("请选择：1、登陆，2、注册，3、返回");
        Integer option=sc.nextInt();
        switch (option){
            case 1:
                this.login();
            case 2:
                this.register();
            case 3:
                this.mainManu();
            default:
                this.mainManu();
                break;
        }
    }

    public void login(){
        String[] users=new String[10];
        String[] passes=new String[10];
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入用户名");
        String name=sc.next();

        boolean isUserOk=false;
        int index=-1;
        for (int i=0;i<users.length;i++){
            if (name.equals(users[1])){
                isUserOk=true;
                index=i;
                break;
            }
        }
        if (isUserOk==false){
            System.out.println("输入的用户名不正确，请重新输入");
            this.login();
        }
        System.out.println("请输入密码");
        String password=sc.next();

        if (password.equals(passes[index])){
            System.out.println("登陆成功");
            this.subManu();
        }else {
            System.out.println("输入密码错误");
            this.login();
        }
    }
}
