package com.cnc.entity.homePage;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author 谭炜
 * @create 2021-01-11 23:19
 */
@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("精选头条")
@TableName("top_line")
public class TopLine {
    @ApiModelProperty("id")
    private long id;

    @ApiModelProperty("标题")
    private String title ;

    @ApiModelProperty("文章id")
    private long essayId ;
    @ApiModelProperty("标题图片路径")
    private String titleImg;
    @ApiModelProperty("作者")
    private String author;
    @ApiModelProperty("'作者id'")
    private long authorId ;
}
