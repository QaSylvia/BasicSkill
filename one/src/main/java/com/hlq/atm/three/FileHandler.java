package com.hlq.atm.three;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {
    //从txt读取用户列表
    public List<String> readDataFromFile(){
        List<String> contentList=new ArrayList<String>();
        String userDir=System.getProperty("user.dir");
        File file=new File(userDir+"/data/userdata.txt");
        try {
            InputStream inputStream=new FileInputStream(file);
            InputStreamReader inputStreamReader=new InputStreamReader(inputStream,"UTF-8");
            BufferedReader bufferedReader=new BufferedReader(inputStreamReader);
            String line="";
            while((line=bufferedReader.readLine())!=null){
                contentList.add(line);
            }
            bufferedReader.close();
            inputStreamReader.close();
            inputStream.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return contentList;
    }
    //查询用户信息
    public String[] getUserInfo(String username){
        List<String> contentList=this.readDataFromFile();
        String[] userArray=new String[3];
        for (int i=0;i<contentList.size();i++){
            if (contentList.get(i).split(",")[0].equals(username)){
                userArray[0]=username;
                userArray[1]=contentList.get(i).split(",")[1];
                userArray[2]=contentList.get(i).split(",")[2];
            }
        }
        return userArray;
    }
    //写入文件内容,isAppend=false，覆盖原来的文件
    public boolean writeDataToFile(String content,boolean isAppend){
        boolean isWriteOK=false;
        String userDir=System.getProperty("user.dir");
        String fileName=userDir+"/data/userdata.txt";

        File file=new File(fileName);
        try {
            OutputStream outputStream=new FileOutputStream(file,isAppend);
            OutputStreamWriter outputStreamWriter=new OutputStreamWriter(outputStream,"UTF-8");
            BufferedWriter bufferedWriter=new BufferedWriter(outputStreamWriter);
            bufferedWriter.write(content);
            bufferedWriter.flush();
            bufferedWriter.close();
            outputStreamWriter.close();
            outputStream.close();
            isWriteOK=true;
        }catch (Exception e){
            isWriteOK=false;
            System.out.println("数据写入失败"+e.getMessage());
        }
        return isWriteOK;
    }
    //更新内容
    public String updataData(String username,double money){
        List<String> contentList=this.readDataFromFile();
        String[] userInfo=getUserInfo(username);

        Double balance=Double.parseDouble(userInfo[2])+money;
        for(int i=0;i<contentList.size();i++){
            if (contentList.get(i).split(",")[0].equals(username)){
                String password=contentList.get(i).split(",")[1];
                contentList.set(i,username+","+password+","+balance);
            }
        }

        String newContent="";
        for (int i=0;i<contentList.size();i++){
            newContent+=contentList.get(i)+"\r\n";
        }
        return newContent;
    }

    public String updataData(String username,String password){
        List<String> contentList=this.readDataFromFile();
        String[] userInfo=getUserInfo(username);

        for(int i=0;i<contentList.size();i++){
            if (contentList.get(i).split(",")[0].equals(username)){
                String balance=contentList.get(i).split(",")[2];
                contentList.set(i,username+","+password+","+balance);
            }
        }

        String newContent="";
        for (int i=0;i<contentList.size();i++){
            newContent+=contentList.get(i)+"\r\n";
        }
        return newContent;
    }
}
