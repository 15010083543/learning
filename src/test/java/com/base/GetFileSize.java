package com.base;

import com.sun.rowset.internal.Row;
import lombok.Data;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
// 读取excle处理数据后写入excle
public class GetFileSize {

    public static void main(String[] args) {

        List<Bean> data = new ArrayList<Bean>();
        //输入一个路径
        String path = "F:\\M698视频+音频\\M698yin";
        getFile(data, path);
        save(data);
        System.out.println("统计完毕");
        String a = "002_002.杨宗纬+张碧晨-凉凉-国语-情歌对唱";
        String s = a.replaceAll("[0-9]{1,}_[0-9]{1,}", "");
        System.out.println(s);
    }

    //写入Xlsx
    public static void save(List<Bean> data) {
        try {
            XSSFWorkbook wb = new XSSFWorkbook();
            int count1 = 54;
            int count2 = 108;
            for (int sheetnum = 0; sheetnum < 1; sheetnum++) {
                XSSFSheet sheet = wb.createSheet("" + sheetnum);
                for (int i = 0; i < 54; ) {
                    XSSFRow row = sheet.createRow(i);
                    XSSFCell cell = row.createCell(0);
                    cell.setCellValue(data.get(i).getFileName().replaceAll("[0-9]{1,}_[0-9]{1,}", ++i+"").replaceAll(".mp3",""));
                    XSSFCell cell1 = row.createCell(1);
                    cell1.setCellValue(data.get(++count1).getFileName().replaceAll("[0-9]{1,}_[0-9]{1,}", count1+"").replaceAll(".mp3",""));
                    if (++count2 < data.size()) {
                        XSSFCell cell2 = row.createCell(2);
                        cell2.setCellValue(data.get(count2).getFileName().replaceAll("[0-9]{1,}_[0-9]{1,}", count2+"").replaceAll(".mp3",""));
                    }
                }
            }
            FileOutputStream outputStream = new FileOutputStream(new File("F:\\M698视频+音频\\歌曲.xlsx"));
            wb.write(outputStream);
            outputStream.close();
        } catch (Exception e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        }
    }

    private static void getFile(List<Bean> data, String path) {
        File f = new File(path);
        File[] fs = f.listFiles();
        if (fs == null) {
            return;
        }
        int count = 0;
        for (File file : fs) {
            //将统计的文件的字节数(单位：B)    方便计算大小
            if (file.isFile()) {
                System.out.println("文件名：" + file.getName() + ",文件大小是：" + file.length());
                data.add(new Bean(file.getName(), ++count));
            } else {
                getFile(data, file.getAbsolutePath());
            }
        }
    }
}

@Data
class Bean {
    private String fileName;
    private int size;

    public Bean(String fileName, int size) {
        this.fileName = fileName;
        this.size = size;
    }
}
