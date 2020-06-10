package com.hlq.atm.three;

import java.util.Scanner;

public class MainUI {
    UserManager um=new UserManager();
    AccountManager am=new AccountManager();

    public static void main(String[] args) {
        MainUI ui=new MainUI();
        ui.mainMenu();
    }

    public void mainMenu() {
        //登陆、注册、退出
        System.out.println("欢迎使用ATM系统");
        System.out.println("请输入你的操作：1 登陆|2 注册|3 退出");
        Scanner sc=new Scanner(System.in);
        int option=sc.nextInt();
        switch (option){
            case 1:
                System.out.println("开始登陆");
                um.login();
                break;
            case 2:
                System.out.println("开始注册");
                um.register();
                break;
            case 3:
                System.out.println("开始退出");
                System.exit(0);
                break;
            default:
                System.out.println("输入内容有误，请重新输入");
                this.mainMenu();
                break;
        }

    }

    public void subMenu(){
        //账户操作
        System.out.println("请输入你的操作：" +
                "1 查询余额|2 转账|3 取款|4 存款|5 修改密码|6 修改电话号码|7 返回主菜单|8 退出");
        Scanner sc=new Scanner(System.in);
        int option=sc.nextInt();
        switch (option){
            case 1:
                System.out.println("查询余额");
                am.query();
                break;
            case 2:
                System.out.println("转账");
                am.transfer();
                break;
            case 3:
                System.out.println("取款");
                am.withdraw();
                break;
            case 4:
                System.out.println("存款");
                am.deposit();
                break;
            case 5:
                System.out.println("修改密码");
                am.editPassword();
                break;
            case 6:
                System.out.println("修改电话号码");
                break;
            case 7:
                System.out.println("返回主菜单");
                this.mainMenu();
                break;
            case 8:
                System.out.println("退出");
                System.exit(0);
                break;
            default:
                System.out.println("输入内容有误，请重新输入");
                this.subMenu();
                break;
        }
    }
}
