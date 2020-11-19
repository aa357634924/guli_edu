package com.rj.eduservice.vo;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * 二级课程
 *
 * @author rj
 * @since 2020-11-02
 */
@Data
public class SubjectVo2 implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    private String title;

    private String parentId;

}
