package com.chenjf.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @author chenjunfeng
 * @since 2020-06-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("gtable")
@ApiModel(value="随机生成数据表")
public class Gtable extends Model<Gtable> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value="主健", required = true, dataType = "int")
    @TableId(value = "gtid", type = IdType.AUTO)
    private Integer gtid;
    
    @ApiModelProperty(value="表名", required = false, dataType = "String")
    private String tablename;

    @ApiModelProperty(value="中文注析", required = false, dataType = "String")
    private String chinesename;
    
    @ApiModelProperty(value="是否导出SQL", required = false, dataType = "String")
    private boolean issql;

    @ApiModelProperty(value="是否导出Excel", required = false, dataType = "String")
    private boolean isexcel;

    @ApiModelProperty(value="是否包括列名", required = false, dataType = "String")
    private boolean isincludefield;

    @ApiModelProperty(value="生成数据记录数", required = false, dataType = "int")
    private Integer generatecount;


    @Override
    protected Serializable pkVal() {
        return this.gtid;
    }

}
