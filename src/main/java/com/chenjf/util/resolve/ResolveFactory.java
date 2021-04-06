package com.chenjf.util.resolve;

/*
 * DDL解析的工厂类
 */
public class ResolveFactory {
	public ResolveDB create(String dbtype) {
		if ("mysql".equals(dbtype)) {
			return new MysqlDDL();
		} else if ("greenplum".equals(dbtype)) {
			return new GreenplumDDL();
		} else if ("oracle".equals(dbtype)) {
			return new OracleDDL();
		} else {
			System.out.println("请输入正确的类型!");
			return null;
		}
	}
}
