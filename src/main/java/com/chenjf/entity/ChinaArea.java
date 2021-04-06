package com.chenjf.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("china_area")
@ApiModel(value="行政区域")
public class ChinaArea extends Model<ChinaArea> {
	
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value="主健", required = true, dataType = "String")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value="父id", required = true, dataType = "String")
    private String pid;
    
    @ApiModelProperty(value="行政区名称", required = true, dataType = "String")
    private String areaname;
    
    @ApiModelProperty(value="抽数URL", required = true, dataType = "String")
    private String htmlpath;
    
    @ApiModelProperty(value="全称", required = true, dataType = "String")
    private String areapath;
    
    @ApiModelProperty(value="行政级别", required = true, dataType = "int")
    private String arealevel;
    
    @ApiModelProperty(value="行政排列数", required = true, dataType = "int")
    private String areanum;
    
    @ApiModelProperty(value="是否最小行政区域", required = true, dataType = "int")
    private String isleaf;
    
    protected Serializable pkVal() {
        return this.id;
    }
}
