package com.rj.eduservice.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.rj.baseservice.exception.config.CustomException;
import com.rj.eduservice.entity.Subject;
import com.rj.eduservice.entity.SubjectExcel;
import com.rj.eduservice.service.SubjectService;
import com.rj.utils.ExceptionUtil;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO
 *
 * @author rj
 * @version 1.0
 * @date 2020-11-02 23:03
 */
public class BasicExcelListener extends AnalysisEventListener<SubjectExcel> {

    private SubjectService subjectService;

    /**
     * 批处理阈值2000
     */
    private Integer batchCount = 1000;
    List<SubjectExcel> list = new ArrayList<SubjectExcel>();

    public BasicExcelListener(SubjectService subjectService, Integer batchCount) {
        this.subjectService = subjectService;
        this.batchCount = batchCount;
    }

    public BasicExcelListener(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    public BasicExcelListener() {
    }

    /**
     * 每读取excel一行数据，执行一次该方法
     * */
    @Override
    public void invoke(SubjectExcel subjectExcel, AnalysisContext analysisContext) {
        if(null == subjectExcel){
            throw new CustomException(20001,"文件数据为空");
        }
        String title1 = subjectExcel.getColumnOne();
        String title2 = subjectExcel.getColumnTwo();
        if(!StringUtils.isEmpty(title1)){
            // 判断一级分类是否存在
            Subject subject = new Subject();
            subject.setTitle(title1);
            subject.setParentId("0");
            Subject subjectTemp = this.isExistSubject(subject);
            if(null == subjectTemp){
                subjectService.saveOrUpdate(subject);
                subjectTemp = subject;
            }
            if(!StringUtils.isEmpty(title2)){
                // 判断二级分类是否存在
                Subject subject2 = new Subject();
                subject2.setTitle(title2);
                subject2.setParentId(subjectTemp.getId());
                subjectTemp = this.isExistSubject(subject2);
                if(null == subjectTemp){
                    subjectService.saveOrUpdate(subject2);
                }
            }
        }else{
            int num = analysisContext.readRowHolder().getRowIndex()+1;
            throw new CustomException(20001,"第"+num+"行，一级分类数据为空");
        }
    }

    /**
     * 判断分类是否存在
     * */
    private Subject isExistSubject(Subject subject) {
        QueryWrapper<Subject> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("title",subject.getTitle());
        queryWrapper.eq("parent_id",subject.getParentId());
        Subject one = subjectService.getOne(queryWrapper);
        return one;
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }
}
