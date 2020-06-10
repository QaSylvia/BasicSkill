package com.hlq.practice.excelCase;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class ExcelReadWrite {

    public static void main(String[] args) {
        ExcelReadWrite erw=new ExcelReadWrite();
        String path=System.getProperty("user.dir");
        String fileName="/data/Students.xls";

        erw.readExcelByJxl(path+fileName);
        System.out.println("========================");
        erw.re(path+fileName);
//        erw.createExcelByJxl();
//        erw.writeExcelByJxl(path+fileName);//编辑保存新文件
    }

    public void re(String pathName) {
        try {
            //创建workbook
            Workbook workbook=Workbook.getWorkbook(new File(pathName));
            //获取第一个工作表sheet
            Sheet sheet=workbook.getSheet(0);
            //获取数据
            for (int i=0;i<sheet.getRows();i++){
                for (int j=0;j<sheet.getColumns();j++){
                    Cell cell=sheet.getCell(j,i);
                    System.out.print(cell.getContents()+" ");
                }
                System.out.println();
            }

            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (BiffException e) {
            e.printStackTrace();
        }
    }

    public void readExcelByJxl(String fileName) {
        File file=new File(fileName);
        try {
            Workbook workbook=Workbook.getWorkbook(file);
            Sheet[] sheet=workbook.getSheets();
            for (int i=0;i<sheet.length;i++){
                Sheet rs=workbook.getSheet(i);
                //遍历行
                for (int j=0;j<rs.getRows();j++){
                    Cell[] cells=rs.getRow(j);
                    //遍历列
                    for (int z=0;z<cells.length;z++){
                        System.out.print(cells[z].getContents());
                        System.out.print("\t");
                    }
                    System.out.println();
                }
            }
            workbook.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (BiffException e) {
            e.printStackTrace();
        }
    }

    public void createExcelByJxl(){
        String path=System.getProperty("user.dir");
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入新建文件名.xls");
        String fileName=sc.next();
        System.out.println("请输入sheetName");
        String sheetName=sc.next();

        WritableWorkbook book=null;
//        String[] info={"序号","学号","姓名","性别","年龄","学历"};
        String[] info={"账户","密码","金额"};
        try{
            File file=new File(path+fileName);
            if (file.isFile()){
                System.out.println("文件已存在");
                Workbook wb=Workbook.getWorkbook(file);
                int length=wb.getSheets().length;
                for (int i=0;i<length;i++){
                    if (wb.getSheet(i).getName()
                            .equals(sheetName)){
                        System.out.println("存在相同的sheet，请重试");
                        this.createExcelByJxl();
                    }
                }
                System.out.println("新建sheet");
                book=Workbook.createWorkbook(file,wb);
                WritableSheet sheet=book.createSheet(sheetName,length);
                for (int j=0;j<6;j++) {
                    Label label = new Label(j, 0, info[j]);
                    sheet.addCell(label);
                }
            }else {
                book=Workbook.createWorkbook(file);
                WritableSheet sheet=book.createSheet(sheetName,0);
                for (int j=0;j<6;j++){
                    Label label=new Label(j,0,info[j]);
                    sheet.addCell(label);
                }
            }
            book.write();
            book.close();
            System.out.println("写入sheet成功～");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (RowsExceededException e) {
            e.printStackTrace();
        } catch (WriteException e) {
            e.printStackTrace();
        } catch (BiffException e) {
            e.printStackTrace();
        }
    }

    public void writeExcelByJxl(String fileName){
        try {
            Workbook wb=Workbook.getWorkbook(new File(fileName));
            int num=wb.getSheet(0).getRows();
            String filename=System.getProperty("user.dir")+"/data/EditStudents.xls";
            WritableWorkbook wwb=Workbook.createWorkbook(new File(filename),wb);
            WritableSheet sheet=wwb.getSheet(0);
            sheet.addCell(new Label(0,num,String.valueOf(num)));
            sheet.addCell(new Label(1,num,"ST00"+num));
            sheet.addCell(new Label(2,num,"张杰"));
            sheet.addCell(new Label(3,num,"男"));
            sheet.addCell(new Label(4,num,"33"));
            sheet.addCell(new Label(5,num,"本科"));
            sheet.addCell(new Label(6,num,"音乐学院"));

            wwb.write();
            wwb.close();
            wb.close();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (BiffException e) {
            e.printStackTrace();
        } catch (RowsExceededException e) {
            e.printStackTrace();
        } catch (WriteException e) {
            e.printStackTrace();
        }
    }

}
