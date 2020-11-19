package com.rj.test;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * TODO
 *
 * @author rj
 * @version 1.0
 * @date 2020-11-02 20:13
 */
@Data
public class ExcelBean {
    @ExcelProperty("学生编号")
    private String sno;

    @ExcelProperty("学生姓名")
    private String name;
}
