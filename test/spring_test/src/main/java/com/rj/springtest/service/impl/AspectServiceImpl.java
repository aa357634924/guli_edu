package com.rj.springtest.service.impl;

import com.rj.springtest.annotation.MyAnnotation;
import com.rj.springtest.service.AspectService;
import org.springframework.stereotype.Service;

@Service
public class AspectServiceImpl implements AspectService {

    @Override
    @MyAnnotation(name = "方法自定义姓名",data = "方法数据")
    public void div(int x, int y) {
        System.out.println("====== 进入方法体 ======");
        int n = x/y;
        System.out.println("方法体执行结果："+n);
    }
}
