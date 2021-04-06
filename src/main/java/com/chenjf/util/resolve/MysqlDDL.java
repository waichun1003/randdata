package com.chenjf.util.resolve;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import com.chenjf.entity.Gcolumn;
import com.chenjf.entity.Gtable;
/*
 * MySQL解析DDL
 */
public class MysqlDDL implements ResolveDB{
	/**
	 * 加载解析sql字符串的DDL
	 */
	public List<String> loadSql(String sqlStr) {
		List<String> sqlList = new ArrayList<String>();
		try {
			String temp= sqlStr.toLowerCase();
			temp= temp.substring(temp.indexOf("create table"));
			if(temp.indexOf("drop view")>0)temp=temp.substring(0, temp.indexOf("drop view"));
			if(temp.indexOf("drop function")>0)temp=temp.substring(0, temp.indexOf("drop function"));
			StringBuffer sqlbuffer=new StringBuffer(temp);
			String[] sqlArr = sqlbuffer.toString().split(";");
			for (int i = 0; i < sqlArr.length; i++) {
				String sql = sqlArr[i].trim();
				if(!sql.equals("") && sql.indexOf("create table")>=0) {
					sql=sql.replaceAll("`", "");
					sqlList.add(sql);
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return sqlList;
	}
	/*
	 * 获取并保存表信息
	 */
	public Gtable getTable(String ddl) {
		Gtable gtable = new Gtable();
		String tablename=ddl.substring(0, ddl.indexOf("(")).replace("create table", "").trim();
		String chinesename="";
		String[] tablestr=ddl.substring(ddl.lastIndexOf(")")).replaceAll(" = ", "=").split(" ");
		for(int i=0;i<tablestr.length;i++) {
			if(tablestr[i].indexOf("comment=")>=0) {
				String[] temp=tablestr[i].split("=");
				chinesename=temp[1].replaceAll("'","");
			}
		}
		gtable.setChinesename(chinesename);
		gtable.setGeneratecount(1000);
		gtable.setIsincludefield(true);
		gtable.setIssql(true);
		gtable.setTablename(tablename);
		gtable.setIsexcel(true);
		gtable.insert();
		//boolean flag=gtable.insert();
		//System.out.println(flag);
		//int gid=gtable.getGtid();
		//System.out.print(gid);
		return gtable;
	}
	/*
	 * 保存所有列信息
	 */
	public int saveColumn(String ddl,int gtid) {
		int count=0;
		String columnname="",datatype="",chinesename="",dltemp="0";
		int datalength=0;
		String[] cols=ddl.substring(ddl.indexOf("(")+1,ddl.lastIndexOf(")")).split(",");
		for(String colstr:cols) {
			String[] col=colstr.trim().split(" ");
			columnname=col[0];
			String typetemp=col[1];
			if(typetemp.indexOf("(")>0)datatype=getType(typetemp.substring(0,typetemp.indexOf("(")));
			else datatype=getType(typetemp);
			if(typetemp.indexOf("(")>0) dltemp=typetemp.substring(typetemp.indexOf("(")+1,typetemp.indexOf(")"));
			if(isInteger(dltemp))datalength=Integer.valueOf(dltemp);
			chinesename=col[col.length-1].replaceAll("'", "");
			Gcolumn column=new Gcolumn();
			column.setGtid(gtid);
			column.setChinesename(chinesename);
			column.setColumnname(columnname);
			column.setDatalength(datalength);
			column.setDatatype(datatype);
			column.insert();
		}
		return count;
	}
	/*
	 * 数据类型的统一
	 */
	private String getType(String type) {
		String datatype="";
		switch(type.toLowerCase()){
			case "tinyint":datatype="int";break;
			case "smallint":datatype="int";break;
			case "mediumint":datatype="int";break;
			case "int":datatype="int";break;
			case "integer":datatype="int";break;
			case "bigint":datatype="int";break;
			case "float":datatype="double";break;
			case "double":datatype="double";break;
			case "decimal":datatype="double";break;
			case "date":datatype="date";break;
			case "time":datatype="date";break;
			case "datetime":datatype="date";break;
			case "timestamp":datatype="date";break;
			case "char":datatype="string";break;
			case "varchar":datatype="string";break;
			case "text":datatype="string";break;
			default:datatype="string";break;
		}
		return datatype;
	}
	  /*
     * 判断是否为整数
     * @param str 传入的字符串
     * @return 是整数返回true,否则返回false
     */
   private boolean isInteger(String str) {
       Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
       return pattern.matcher(str).matches();
   }
}
