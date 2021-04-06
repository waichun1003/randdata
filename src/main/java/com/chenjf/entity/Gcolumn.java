package com.chenjf.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author chenjunfeng
 * @since 2020-06-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("gcolumn")
@ApiModel(value="随机生成数据列")
public class Gcolumn extends Model<Gcolumn> {

    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value="主健", required = true, dataType = "int")
    @TableId(value = "gcid", type = IdType.AUTO)
    private Integer gcid;

    @ApiModelProperty(value="列名", required = true, dataType = "String")
    private String columnname;

    @ApiModelProperty(value="表id", required = true, dataType = "int")
    private Integer gtid;

    @ApiModelProperty(value="数据类型", required = false, dataType = "String")
    private String datatype;

    @ApiModelProperty(value="数据长度", required = false, dataType = "int")
    private Integer datalength;

    @ApiModelProperty(value="中文注析", required = false, dataType = "String")
    private String chinesename;
    
    @ApiModelProperty(value="类型名", required = true, dataType = "String")
    private String funcname;

    @ApiModelProperty(value="参数(JSON形式)", required = false, dataType = "String")
    private String params;

    @ApiModelProperty(value="参数类型(system系统方法,file用户文件列表,list用户自定义列表)", required = false, dataType = "String")
    private String paratype;
    
    @ApiModelProperty(value="临时字符串", required = false, dataType = "String")
    private String temp;
    
    @Override
    protected Serializable pkVal() {
        return this.gcid;
    }

}
