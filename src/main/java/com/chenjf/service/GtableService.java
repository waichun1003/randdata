package com.chenjf.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.chenjf.entity.Gtable;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author chenjunfeng
 * @since 2020-06-08
 */
public interface GtableService extends IService<Gtable> {
	/*
	 * 生成数据表分页查询
	 */
	public IPage<Gtable> tablelist(String tablename,int PageIndex,int PageSize);
	/*
	 * 生成数据表详情
	 */
	public Gtable getTableByGtid(int gtid);
}
