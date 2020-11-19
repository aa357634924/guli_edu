package com.rj.eduservice.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * TODO
 *
 * @author rj
 * @version 1.0
 * @date 2020-11-02 23:05
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value="SubjectExcel对象", description="课程科目excel对象")
public class SubjectExcel {
    @ExcelProperty(value ={"一级分类"},index = 0)
    private String columnOne;

    @ExcelProperty(value ={"二级分类"},index = 1)
    private String columnTwo;

}
