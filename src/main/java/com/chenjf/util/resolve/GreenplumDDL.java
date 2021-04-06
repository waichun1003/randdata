package com.chenjf.util.resolve;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.chenjf.entity.Gcolumn;
import com.chenjf.entity.Gtable;

public class GreenplumDDL implements ResolveDB {
	private static final Pattern InserInto_PATTERN = Pattern.compile("^insert into(.)+[;]$");
	private static final String Comment_PATTERN = "-- ----------------------------";
	private static final Pattern Drop_Table = Pattern.compile("^drop table if exists (.)+[;]$");
	public List<String> loadSql(String sqlStr) {
		List<String> sqlList = new ArrayList<String>();
		String line="",ddl="";
		String dbpattern="";
		try {
			String temp= sqlStr.toLowerCase();
			temp= temp.substring(temp.indexOf("create table"));//从create table字符串开始计算
			if(temp.indexOf("drop view")>0)temp=temp.substring(0, temp.indexOf("drop view"));//删除drop view以下的字符串
			if(temp.indexOf("drop function")>0)temp=temp.substring(0, temp.indexOf("drop function"));//删除drop function以下的字符串
			Matcher matcher = null;
			String[] str=temp.split("\r\n");
			for(int i=0;i<str.length;i++) {
				line=str[i];
				matcher = InserInto_PATTERN.matcher(line);
				if(matcher.find()) {
					line=matcher.replaceAll("");//删除 insert into语句
				}
				matcher = Drop_Table.matcher(line);
				if(matcher.find()) {
					line=matcher.replaceAll("---eof---");//删除DROP TABLE IF EXISTS 语句
				}
				ddl=ddl+line+"\r\n";
			}
			String[] sqlArr = ddl.split("---eof---");
			for (int i = 0; i < sqlArr.length; i++) {
				String sql = sqlArr[i].trim();
				if(!sql.equals("")) {
					/////////////////////删除注析///////////////////////////////
					if(sql.indexOf(Comment_PATTERN)>0) {
						String comment=sql.substring(sql.indexOf(Comment_PATTERN), sql.lastIndexOf(Comment_PATTERN));
						sql=sql.replaceAll(comment, "\r\n");
					}
					/////////////////////删除注析///////////////////////////////
					sql=sql.replaceAll("\"", "");
					sql=sql.replaceAll(Comment_PATTERN, "");//干掉Comment_PATTERN注析
					dbpattern=sql.substring(13, sql.indexOf("("));
					dbpattern=dbpattern.substring(0,dbpattern.indexOf(".")+1);
					sql=sql.replaceAll(dbpattern, "");
					sqlList.add(sql);
				}
			}
		} catch (Exception ex) {
			System.out.println("dbpattern="+dbpattern);
			ex.printStackTrace();
		}
		return sqlList;
	}

	public Gtable getTable(String ddl) {
		String tablename=ddl.substring(0, ddl.indexOf("(")).replace("create table", "").trim();
		String chinesename="";
		String tablecomment="";
		if(ddl.lastIndexOf("comment on table")>0) {
			tablecomment=ddl.substring(ddl.lastIndexOf("comment on table"));//eg:comment on table dw_person is 'dw_人员基本信息';
			chinesename=tablecomment.substring(tablecomment.indexOf("'")+1, tablecomment.lastIndexOf("'"));
		}
		Gtable gtable = new Gtable();
		gtable.setChinesename(chinesename);
		gtable.setGeneratecount(1000);
		gtable.setIsincludefield(true);
		gtable.setIssql(true);
		gtable.setTablename(tablename);
		gtable.setIsexcel(true);
		gtable.insert();
		return gtable;
	}

	public int saveColumn(String ddl, int gtid) {
		int count=0;
		String tablename=ddl.substring(0, ddl.indexOf("(")).replace("create table", "").trim();
		String columnname="",datatype="",chinesename="",dltemp="0",commentStr="",comment="";
		int datalength=0,chindex=0;
		String[] cols=ddl.substring(ddl.indexOf("(")+1,ddl.lastIndexOf(")")).split(",\r\n");
		if(ddl.indexOf(";")>0)commentStr=ddl.substring(ddl.indexOf(";")+1);
		try {
			for(String colstr:cols) {
				String[] col=colstr.trim().split(" ");
					columnname=col[0];
					/*if(columnname.equalsIgnoreCase("ws_rksj")) {
						for(String mm:col)
						System.out.println(mm);
					}*/
					String typetemp=col[1];
					if(typetemp.indexOf("(")>0)datatype=getType(typetemp.substring(0,typetemp.indexOf("(")));
					else datatype=getType(typetemp);
					if(typetemp.indexOf("(")>0) dltemp=typetemp.substring(typetemp.indexOf("(")+1,typetemp.indexOf(")"));
					if(isInteger(dltemp))datalength=Integer.valueOf(dltemp);
					comment="comment on column "+tablename+"."+columnname +" is ";
					chindex=commentStr.indexOf(comment);
					if(chindex>0) {
						int indexof=commentStr.indexOf("\'",chindex);
						chinesename=commentStr.substring(indexof+1, commentStr.indexOf("\'",indexof+2));
					}
					Gcolumn column=new Gcolumn();
					column.setGtid(gtid);
					column.setChinesename(chinesename);
					column.setColumnname(columnname);
					column.setDatalength(datalength);
					column.setDatatype(datatype);
					column.insert();
					count++;
			}
		} catch (Exception ex) {
			System.out.println("columnname="+columnname);
			ex.printStackTrace();
		}
		return count;
	}
	/*
	 * 数据类型的统一
	 */
	private String getType(String type) {
		String datatype="";
		switch(type.toLowerCase()){
			case "int2":datatype="int";break;
			case "int4":datatype="int";break;
			case "int8":datatype="int";break;
			case "float4":datatype="double";break;
			case "float8":datatype="double";break;
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
