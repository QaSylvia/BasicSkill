package com.hlq.atm.three;

import java.util.Scanner;

public class AccountManager {
    FileHandler handler=new FileHandler();
    UserManager um=new UserManager();

    //余额查询
    public void query(){
        String userName=um.loggeduserName;
        String[] userInfo=handler.getUserInfo(userName);
        System.out.println("您的账户余额是:"+userInfo[2]);
        new MainUI().subMenu();
    }

    //取款
    public void withdraw(){
        String userName=um.loggeduserName;
        String balance=handler.getUserInfo(um.loggeduserName)[2];

        Scanner sc=new Scanner(System.in);
        System.out.println("输入取款金额");
        Double money=sc.nextDouble();
        if (money>0 && money<=Double.parseDouble(balance)){
            String content=handler.updataData(userName,-money);
            handler.writeDataToFile(content,false);
            System.out.println("您的账户余额是："+handler.getUserInfo(userName)[2]);
            new MainUI().subMenu();
        }else {
            System.out.println("输入取款金额不正确，大于余额或小于0，请重试");
            this.withdraw();
        }
    }

    //存款
    public void deposit(){
        String userName=um.loggeduserName;
        String balance=handler.getUserInfo(userName)[2];
        Scanner sc=new Scanner(System.in);
        System.out.println("输入存款金额");
        Double money=sc.nextDouble();
        if (money>0){
            String content=handler.updataData(userName,money);
            handler.writeDataToFile(content,false);
            System.out.println("您的账户余额是："+handler.getUserInfo(userName)[2]);
            new MainUI().subMenu();
        }else {
            System.out.println("输入取款金额不正确，请重试");
            this.deposit();
        }
    }

    //转账
    public void transfer(){
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入转账人姓名");
        String toUsername=sc.next();

        if (um.checkUserExist(toUsername)!=-1){
            System.out.println("请输入转账金额");
            Double money=sc.nextDouble();
            String mainMoney=handler.getUserInfo(um.loggeduserName)[2];

            if (money>0 && money < Double.parseDouble(mainMoney)){
                String fromAccount=um.loggeduserName;
                String fromContent=handler.updataData(fromAccount,-money);
                handler.writeDataToFile(fromContent,false);
                String toAccount=toUsername;
                String toContent=handler.updataData(toAccount,money);
                handler.writeDataToFile(toContent,false);

                System.out.println("恭喜你，转账成功");
                new MainUI().subMenu();
            }else {
                System.out.println("账户余额不足，请重试");
                this.transfer();
            }
        }else {
            System.out.println("账户不存在，请重新输入");
            this.transfer();
        }

    }

    //修改密码
    public void editPassword(){
        String userName=um.loggeduserName;
        String password=handler.getUserInfo(userName)[2];

        Scanner sc=new Scanner(System.in);
        System.out.println("请输入原密码");
        String oldPassword=sc.next();
        System.out.println("请输入新密码");
        String newPassword=sc.next();

        if (oldPassword.equals(password)){
            handler.updataData(userName,newPassword);
            System.out.println("修改密码成功");
            new MainUI().mainMenu();
        }else {
            System.out.println("原密码输入错误，请重试");
            this.editPassword();
        }
    }

}
