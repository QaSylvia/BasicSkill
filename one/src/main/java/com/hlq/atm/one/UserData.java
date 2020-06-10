package com.hlq.atm.one;

import java.util.ArrayList;
import java.util.List;

public class UserData {
    private String username;
    private String password;
    private double balance;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public UserData() { }

    public UserData(String username, String password, double balance) {
        this.username = username;
        this.password = password;
        this.balance = balance;
    }
    //创建对象数组
    static List<UserData> uds=new ArrayList<UserData>();
    //初始化对象
    public void newUser(){
        UserData ud1=new UserData();
        ud1.setUsername("admin");
        ud1.setPassword("admin111");
        ud1.setBalance(5000);
        uds.add(ud1);

        UserData ud2=new UserData("hlq","admin111",5000);
        uds.add(ud2);
    }
    //打印
    public void listAllUser(){
        for (int i=0;i<uds.size();i++){
            System.out.println(uds.get(i).username);
            System.out.println(uds.get(i).password);
            System.out.println(uds.get(i).balance);
        }
    }
    //查找用户
    public boolean findUserByName(String username){
        boolean isExit=false;
        for (int i=0;i<uds.size();i++){
            if (uds.get(i).username.equals(username)){
                isExit=true;
                break;
            }
        }
        return isExit;
    }
}
