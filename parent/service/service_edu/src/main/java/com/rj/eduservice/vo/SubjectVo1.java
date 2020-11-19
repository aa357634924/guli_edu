package com.rj.eduservice.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 一级科目
 *
 * @author rj
 * @since 2020-11-02
 */
@Data
public class SubjectVo1 implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    private String title;

    private List<SubjectVo2> children = new ArrayList<>();

}
