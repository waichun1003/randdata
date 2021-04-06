package com.chenjf.util.jsoup;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 
 * JDBC工具类，回去数据库连接和释放连接
 */
public class JdbcUtils {
    /**
     * 
     * 获取数据库连接
     * @throws Exception 
     */
    private Connection getConnection() {
    	Connection conection=null;
        try {
            // 加载驱动
            Class.forName("org.sqlite.JDBC");
            conection= DriverManager.getConnection("jdbc:sqlite::resource:rgdata.db", "", "");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
        return conection;
    }
    //执行SQL
    public boolean executeSql(String sql) {
    	boolean flag=false;
    	Statement statement=null;
    	Connection conection=null;
    	try {
    		conection=getConnection();
    		statement=conection.createStatement();
    		flag = statement.execute(sql);// 返回影响到的行数
    	}catch (SQLException e) {
            e.printStackTrace();
        } finally {
        	try {
				statement.close();
				conection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
        	
        }
    	return flag;
    }
    public int query(String sql) {
    	int num=0;
    	Statement statement=null;
    	Connection conection=null;
    	ResultSet resultSet = null;
    	try {
    		conection=getConnection();
    		statement=conection.createStatement();
    		resultSet=statement.executeQuery(sql);
            // 遍历结果集
            while (resultSet.next()) {
            	num=resultSet.getInt(1); 
            }
    	}catch (SQLException e) {
            e.printStackTrace();
        } finally {
        	try {
				statement.close();
				conection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
        }
    	return num;
    }
}
