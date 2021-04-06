package com.chenjf.mapper;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chenjf.entity.Gcolumn;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author chenjunfeng
 * @since 2020-06-08
 */
public interface GcolumnMapper extends BaseMapper<Gcolumn> {
	 /* 
	  * 按表id获取全部数据列
	 */
	List<Gcolumn> getColumnByGtid(int gtid);
	 /* 
	  * 按表id获取生成数据列详情
	 */
	List<Gcolumn> getColumnToRand(int gtid);
	 /* 
	  * 通过表id获取已设计列数量
	 */
	int columnNum(int gtid);
}
