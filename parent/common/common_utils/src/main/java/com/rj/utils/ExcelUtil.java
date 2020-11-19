package com.rj.utils;

import com.alibaba.excel.EasyExcel;
import com.rj.test.ExcelBean;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO
 *
 * @author rj
 * @version 1.0
 * @date 2020-11-02 20:11
 */
public class ExcelUtil {
    public static void produceExcel(String filePath,List<ExcelBean> list){
        // 会自动关闭流
        EasyExcel.write(filePath, ExcelBean.class).sheet("学生信息").doWrite(list);
    }

    public static void main(String[] args) {
        List<ExcelBean> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            ExcelBean excelBean = new ExcelBean();
            excelBean.setSno((i+1)+"");
            excelBean.setName("学生"+(i+1));
            list.add(excelBean);
        }
        produceExcel("/Users/rj/Desktop/student.xlsx",list);
    }
}
