package com.chenjf.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chenjf.entity.Gcolumn;
import com.chenjf.mapper.GcolumnMapper;
import com.chenjf.service.GcolumnService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author chenjunfeng
 * @since 2020-06-08
 */
@Service
public class GcolumnServiceImpl extends ServiceImpl<GcolumnMapper, Gcolumn> implements GcolumnService {
	@Autowired
	private GcolumnMapper mapper;
	
	public List<Gcolumn> getColumnByGtid(int gtid) {
		List<Gcolumn> list=mapper.getColumnByGtid(gtid);
		return list;
	}
	 /* 
	  * 按表id获取生成数据列详情
	 */
	public List<Gcolumn> getColumnToRand(int gtid){
		List<Gcolumn> list=mapper.getColumnToRand(gtid);
		return list;
	}
	 /* 
	  * 通过表id获取已设计列数量
	 */
	public int columnNum(int gtid){
		return mapper.columnNum(gtid);
	}

}
