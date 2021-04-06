package com.chenjf.util.resolve;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.chenjf.entity.Gcolumn;
import com.chenjf.entity.Gtable;
/*
 * Oracle解析DDL
 */
public class OracleDDL implements ResolveDB {
	private static final Pattern Prompt_PATTERN = Pattern.compile("^prompt creating (.)+[...]$");
	/**
	 * 加载解析sql字符串的DDL
	 */
	public List<String> loadSql(String sqlStr) {
		List<String> sqlList = new ArrayList<String>();
		String line="",ddl="";
		Matcher matcher = null;
		try {
			String temp= sqlStr.toLowerCase();
			temp= temp.substring(temp.indexOf("create table"));
			if(temp.indexOf("prompt disabling triggers for ")>0)temp= temp.substring(0,temp.indexOf("prompt disabling triggers for "));
			String[] str=temp.split("\r\n");
			for(int i=0;i<str.length;i++) {
				line=str[i];
				matcher = Prompt_PATTERN.matcher(line);
				if(matcher.find()) {
					line=matcher.replaceAll("---eof---");//删除prompt creating 语句
				}
				ddl=ddl+line+"\r\n";
			}
			StringBuffer sqlbuffer=new StringBuffer(ddl);
			String[] sqlArr = sqlbuffer.toString().split("---eof---");
			for (int i = 0; i < sqlArr.length; i++) {
				String sql = sqlArr[i].trim();
				if(!sql.equals("") && sql.indexOf("create table")>=0) {
					sqlList.add(sql);
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return sqlList;
	}


	public Gtable getTable(String ddl) {
		String tablename=ddl.substring(0, ddl.indexOf("(")).replace("create table", "").trim();
		String chinesename="";
		String tablecomment="";
		if(ddl.indexOf("comment on table ")>0) {
			tablecomment=ddl.substring(ddl.indexOf(";")+1);
			tablecomment=tablecomment.substring(tablecomment.indexOf("comment on table "),tablecomment.indexOf(";"));//eg:comment on table RPT_CHECK_SUCCESS is '核对成功记录';
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

	@Override
	public int saveColumn(String ddl, int gtid) {
		int count=0;
		String tablename=ddl.substring(0, ddl.indexOf("(")).replace("create table", "").trim();
		String columnname="",datatype="",chinesename="",dltemp="0",commentStr="",comment="",typetemp="";
		int datalength=0,chindex=0;
		String columns=ddl.substring(0, ddl.indexOf(";"));
		String[] cols=columns.substring(columns.indexOf("(")+1,columns.lastIndexOf(")")).split(",");
		if(ddl.indexOf(";")>0)commentStr=ddl.substring(ddl.indexOf(";")+1);
		if(tablename.equalsIgnoreCase("rpt_ajlx")) {
			System.out.println(commentStr);
		}
		try {
			for(String colstr:cols) {
				String[] col=colstr.trim().split(" ");
					columnname=col[0];
					for(int i=1;i<col.length;i++)
						if(!col[i].equals(" "))typetemp=col[i];
					if(typetemp.indexOf("(")>0)datatype=getType(typetemp.substring(0,typetemp.indexOf("(")));
					else datatype=getType(typetemp);
					if(typetemp.indexOf("(")>0) dltemp=typetemp.substring(typetemp.indexOf("(")+1,typetemp.indexOf(")"));
					if(isInteger(dltemp))datalength=Integer.valueOf(dltemp);
					comment="comment on column "+tablename+"."+columnname;
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
			case "number":datatype="double";break;
			case "integer":datatype="int";break;
			case "float":datatype="double";break;
			case "decimal":datatype="double";break;
			case "date":datatype="date";break;
			case "time":datatype="date";break;
			case "datetime":datatype="date";break;
			case "timestamp":datatype="date";break;
			case "char":datatype="string";break;
			case "nchar":datatype="string";break;
			case "varchar":datatype="string";break;
			case "nvarchar2":datatype="string";break;
			case "varchar2":datatype="string";break;
			case "clob":datatype="string";break;
			case "nclob":datatype="string";break;
			case "blob":datatype="string";break;
			case "bfile":datatype="string";break;
			case "long":datatype="string";break;
			case "raw":datatype="string";break;
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
