package com.example.integerview_test.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
/**
 * <p>
 * 
 * </p>
 *
 * @author xifeng
 * @since 2025-02-18
 */
@Getter
@Setter
@ToString
public class Article implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private Long columnId;

    private String title;

    private String shortTitle;

    private String picture;

    private LocalDateTime addTime;

    private LocalDateTime updateTime;

    private Integer status;
}
