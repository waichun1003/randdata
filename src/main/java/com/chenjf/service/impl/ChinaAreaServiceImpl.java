package com.chenjf.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chenjf.entity.ChinaArea;
import com.chenjf.mapper.ChinaAreaMapper;
import com.chenjf.service.ChinaAreaService;
@Service
public class ChinaAreaServiceImpl extends ServiceImpl<ChinaAreaMapper, ChinaArea> implements ChinaAreaService {
	@Autowired
	private ChinaAreaMapper mapper;
	public ChinaArea getAreaByNum(int arealevel, int areanum) {
		
		return mapper.getAreaByNum(arealevel, areanum);
	}

}
