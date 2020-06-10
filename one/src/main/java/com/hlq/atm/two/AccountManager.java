package com.hlq.atm.two;

import java.util.Scanner;

public class AccountManager {

    //余额查询
    public void query(){
        int queryUserIndex=UserManager.loggedUserIndex;
        System.out.println("您的账户余额是:"+UserManager.uds.get(queryUserIndex).getBalance());
        new MainUI().subMenu();
    }

    //取款
    public void withdraw(){
        int userIndex=UserManager.loggedUserIndex;
        Scanner sc=new Scanner(System.in);
        System.out.println("输入取款金额");
        Double money=sc.nextDouble();
        if (money>0 && money<=UserManager.uds.get(userIndex).getBalance()){
            Double balance=UserManager.uds.get(userIndex).getBalance()-money;
            UserManager.uds.get(userIndex).setBalance(balance);
            System.out.println("您的账户余额是："+UserManager.uds.get(userIndex).getBalance());
            new MainUI().subMenu();
        }else {
            System.out.println("输入取款金额不正确，大于余额或小于0，请重试");
            this.withdraw();
        }
    }

    //存款
    public void deposit(){
        int userIndex=UserManager.loggedUserIndex;
        Scanner sc=new Scanner(System.in);
        System.out.println("输入存款金额");
        Double money=sc.nextDouble();
        if (money>0){
            Double balance=UserManager.uds.get(userIndex).getBalance()+money;
            UserManager.uds.get(userIndex).setBalance(balance);
            System.out.println("您的账户余额是："+UserManager.uds.get(userIndex).getBalance());
            new MainUI().subMenu();
        }else {
            System.out.println("输入取款金额不正确，请重试");
            this.deposit();
        }
    }

    public int inputCheck(String value){
        int money=0;
        try{
            money=Integer.parseInt(value);
            System.out.println("输入金额正确");
        }catch (Exception e){
            System.out.println("输入金额不正确，请重试");
            this.transfer();
        }
        return money;
    }

    //转账
    public void transfer(){
        Scanner sc=new Scanner(System.in);

        int fromUserIndex=UserManager.loggedUserIndex;
        UserData fromUserAccount=UserManager.uds.get(fromUserIndex);

        System.out.println("请输入转账人姓名");
        String toUsername=sc.next();
        int toUserIndex=new UserManager().checkUserExist(toUsername);
        if (toUserIndex != -1){
            System.out.println("请输入转账金额(整数)");
//            Double money=sc.nextDouble();
            String value=sc.next();
            int money=inputCheck(value);
            if (money>0 && money<=fromUserAccount.getBalance()){
                Double myBalance=UserManager.uds.get(fromUserIndex).getBalance()-money;
                UserManager.uds.get(fromUserIndex).setBalance(myBalance);
                Double toBalance=UserManager.uds.get(toUserIndex).getBalance()+money;
                UserManager.uds.get(toUserIndex).setBalance(toBalance);
                new MainUI().subMenu();
            }else {
                System.out.println("转账金额不正确，请重试");
                this.transfer();
            }
        }else {
            System.out.println("转账人不存在，请重试");
            this.transfer();
        }
    }

    //修改密码
    public void editPassword(){
        int userIndex=UserManager.loggedUserIndex;
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入原密码");
        String oldPassword=sc.next();
        System.out.println("请输入新密码");
        String newPassword=sc.next();

        if (oldPassword.equals(UserManager.uds.get(userIndex).getPassword())){
            UserManager.uds.get(userIndex).setPassword(newPassword);
            System.out.println("修改密码成功");
            new MainUI().mainMenu();
        }else {
            System.out.println("原密码输入错误，请重试");
            this.editPassword();
        }
    }

    //修改电话号码
    public void editPhone(){
        int userIndex=UserManager.loggedUserIndex;
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入新电话号码");
        String newPhone=sc.next();
        UserManager.uds.get(userIndex).setPassword(newPhone);
        System.out.println("电话号码修改成功");
        new MainUI().subMenu();
    }
}
