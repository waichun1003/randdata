package com.chenjf.util.resolve;

import java.util.List;

import com.chenjf.entity.Gtable;

public interface ResolveDB {
	/*
	 * 加载解析sql字符串的DDL
	 */
	public List<String> loadSql(String sqlStr);
	/*
	 * 获取并保存表信息
	 */
	public Gtable getTable(String ddl);
	/*
	 * 保存所有列信息
	 */
	public int saveColumn(String ddl,int gtid);

}
