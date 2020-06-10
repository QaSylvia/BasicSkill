package com.hlq.atm.two;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserManager {
    static List<UserData> uds=new ArrayList<UserData>();
    public static int loggedUserIndex=-1;//保存登陆用户在uds的下标

    public UserManager() {
        UserData ud1=new UserData();
        ud1.setUsername("admin");
        ud1.setPassword("admin111");
        ud1.setBalance(5000);
        ud1.setPhone("13800138000");
        ud1.setAdmin(true);
        uds.add(ud1);

        UserData ud2=new UserData("sylvia","admin111","13750008306",5000,true);
        uds.add(ud2);
    }

    //登陆
    public void login(){
        Scanner sc=new Scanner(System.in);
        System.out.println("输入登陆账户名");
        String username=sc.next();
        System.out.println("输入密码");
        String password=sc.next();

        int userIndex=this.checkUserExist(username);

        if (userIndex != -1){
            if (password.equals(uds.get(userIndex).getPassword())){
                System.out.println("登陆成功");
                loggedUserIndex=userIndex;
                new MainUI().subMenu();
            }else {
                System.out.println("密码错误， 请重试");
                this.login();
            }
        }else {
            System.out.println("用户名不存在，请重试");
            this.login();
        }
    }

    //检查用户是否存在，返回下标，否则返回-1
    public int checkUserExist(String username) {
        int index=-1;
        for (int i=0;i<uds.size();i++){
            if (username.equals(uds.get(i).getUsername())){
                index=i;
                break;
            }
        }
        return index;
    }

    //注册
    public void register(){
        Scanner sc=new Scanner(System.in);
        System.out.println("输入用户名");
        String username=sc.next();

        if (checkUserExist(username)>=0){
            System.out.println("用户名已存在，请重试");
            this.register();
        }else {
            System.out.println("输入密码");
            String password=sc.next();
            System.out.println("输入手机号");
            String phone=sc.next();

            UserData ud=new UserData(username,password,phone);
            uds.add(ud);

            System.out.println("注册成功，回主菜单");
            new MainUI().mainMenu();
        }
    }

}
