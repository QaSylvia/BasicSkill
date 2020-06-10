package com.hlq.atm.three;

import java.util.List;
import java.util.Scanner;

public class UserManager {

    FileHandler handler=new FileHandler();

    public static String loggeduserName="";

    //检查用户是否存在，返回下标，否则返回-1
    public int checkUserExist(String username) {
        List<String> contentList=this.handler.readDataFromFile();
        int index=-1;
        for (int i=0;i<contentList.size();i++){
            if (contentList.get(i).split(",")[0].equals(username)){
                index=i;
                break;
            }
        }
        return index;
    }

    //登陆
    public void login(){
        Scanner sc=new Scanner(System.in);
        System.out.println("输入登陆账户名");
        String username=sc.next();
        System.out.println("输入密码");
        String password=sc.next();

        Boolean isLogin=this.doLogion(username,password);
        if (isLogin){
            System.out.println("登陆成功");
            this.loggeduserName=username;
            new MainUI().subMenu();
//            this.ui.subMenu();
        }else {
            System.out.println("用户名不存在，请重试");
            this.login();
        }
    }

    private boolean doLogion(String username,String password){
        List<String> contentList = this.handler.readDataFromFile();
        Boolean isLoginOK=false;
        int userIndex=this.checkUserExist(username);
        if (userIndex!=-1){
            String[] line=contentList.get(userIndex).split(",");
            if (line[1].equals(password)){
                isLoginOK=true;
            }
        }
        return isLoginOK;
    }

    //注册
    public void register(){
        Scanner sc=new Scanner(System.in);
        System.out.println("输入用户名");
        String username=sc.next();

        if (checkUserExist(username) != -1){
            System.out.println("用户名已存在，请重试");
            this.register();
        }else {
            System.out.println("输入密码");
            String password=sc.next();
            System.out.println("输入余额");
            Double balance=sc.nextDouble();

            String ud=username+","+password+","+balance;
            handler.writeDataToFile(ud,true);

            System.out.println("注册成功，回主菜单");
            new MainUI().mainMenu();
//            this.ui.mainMenu();
        }
    }

}
