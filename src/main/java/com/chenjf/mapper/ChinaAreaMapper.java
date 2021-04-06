package com.chenjf.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chenjf.entity.ChinaArea;

public interface ChinaAreaMapper extends BaseMapper<ChinaArea> {
	//按行政级别和行政排列数获取对应的政行区域
	ChinaArea getAreaByNum(int arealevel,int areanum);
}
