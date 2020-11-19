package com.rj.eduservice.vo;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO
 *  章节VO对象
 * @author rj
 * @version 1.0
 * @date 2020-11-04 16:52
 */
@Data
public class ChapterVo {
    private static final long serialVersionUID = 1L;

    private String id;

    private String title;

    private List<VideoVo> children = new ArrayList<>();
}
