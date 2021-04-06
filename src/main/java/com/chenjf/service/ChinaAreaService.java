package com.chenjf.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.chenjf.entity.ChinaArea;

public interface ChinaAreaService extends IService<ChinaArea> {
	//按行政级别和行政排列数获取对应的政行区域
	ChinaArea getAreaByNum(int arealevel,int areanum);
}
