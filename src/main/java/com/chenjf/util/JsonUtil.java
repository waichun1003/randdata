package com.chenjf.util;

import java.io.IOException;
import net.sf.json.JSON;  
import net.sf.json.JSONArray;  
import net.sf.json.JSONObject;

import com.chenjf.entity.ParaBean;
import com.fasterxml.jackson.databind.ObjectMapper;
/*
 * @author 陈俊丰
 * 微信:chenjunfeng0768
 * JSON工具类
 */
public class JsonUtil {
	private JsonUtil() {
	}
	/*
	 * 验证JSON是否有效
	 */
	public static boolean isJSONValid(String jsonInString) {
		try {
			final ObjectMapper mapper = new ObjectMapper();
			mapper.readTree(jsonInString);
			return true;
		} catch (IOException e) {
			return false;
		}
	}
	//将json字符串转换为java对象  
    public static ParaBean JSON2Object(String jsonStr){  
        //接收{}对象，此处接收数组对象会有异常  
        if(jsonStr.indexOf("[") != -1){  
            jsonStr = jsonStr.replace("[", "");  
        }  
        if(jsonStr.indexOf("]") != -1){  
            jsonStr = jsonStr.replace("]", "");  
        }  
        JSONObject obj = new JSONObject().fromObject(jsonStr);//将json字符串转换为json对象  
        ParaBean jb = (ParaBean)JSONObject.toBean(obj,ParaBean.class);//将建json对象转换为ParaBean对象  
        return jb;//返回一个ParaBean对象  
    }  
}
