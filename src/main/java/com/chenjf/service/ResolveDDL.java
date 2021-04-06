package com.chenjf.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import com.chenjf.entity.Gtable;
import com.chenjf.util.resolve.ResolveDB;
import com.chenjf.util.resolve.ResolveFactory;

//@Service
public class ResolveDDL {
	/*
	 * 解析SQL DDL语句
	 */
	public int resolve(String filepath,String dbtype) {
		int tablecount = 0;// 导入表数量
		String sqlStr=readSQL(filepath,dbtype);
		List<String> createtable=new ArrayList<String>();
		ResolveFactory factory=new ResolveFactory();
		ResolveDB resolve=factory.create(dbtype);
		createtable=resolve.loadSql(sqlStr);
		for(String table:createtable) {
			Gtable gtables=resolve.getTable(table);
			resolve.saveColumn(table,gtables.getGtid());
			tablecount=tablecount+1;
		}
		return tablecount;
	}


   public String readSQL(String sqlFile,String dbtype) {
	   String sql="";
	   List<String> list=new ArrayList<String>();
	   BufferedReader reader =null;
	   String encoding=System.getProperty("file.encoding");
		try {
			//获取当前项目路径
			File currentpath = new File(System.getProperty("user.dir"));
			//获取当前项目路径的父路径
			File parentfile = currentpath.getParentFile();
			//指定文件上传径路径
			File uploadpath= new File(parentfile.getAbsolutePath()+File.separator+"upload"+File.separator);
			File file=new File(uploadpath+File.separator+sqlFile);
			FileInputStream f4 = new FileInputStream(file);
			reader = new BufferedReader(new InputStreamReader(f4,"GB2312"));
	        String str="";
	        String temp="";
	        while ((str = reader.readLine()) != null) {
	        	temp=new String(str.getBytes(),encoding);
	        	list.add(temp.toLowerCase());
	        }
	        sql= String.join("\r\n", list);
		} catch (UnsupportedEncodingException ex) {
			ex.printStackTrace();
		}catch (Exception ex) {
			ex.printStackTrace();
		}finally {
	        if (reader != null) {
	            try {
	                reader.close();
	            } catch (IOException e1) {
	                e1.printStackTrace();
	            }
	        }
	    }
		return sql;
   }

	public static void main(String[] args) {
		ResolveDDL ddl = new ResolveDDL();
		System.out.println(ddl.resolve("d:\\test.sql","mysql"));
	}
}
