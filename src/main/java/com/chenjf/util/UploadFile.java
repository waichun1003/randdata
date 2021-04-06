package com.chenjf.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.web.multipart.MultipartFile;

public class UploadFile {
	/*
	 * 如果当前项目路径为:D:\\workspace\\rand
	 * 那么上传文件路径为:D:\\workspace\\upload
	 * 上传文件
	 */
	public String upload(MultipartFile file) {
		//获取当前项目路径
		File currentpath = new File(System.getProperty("user.dir"));
		//获取当前项目路径的父路径
		File parentfile = currentpath.getParentFile();
		//指定文件上传径路径
		File uploadpath= new File(parentfile.getAbsolutePath()+File.separator+"upload"+File.separator);
		//如果文件上传路径不存在，创建文件夹
		if(!uploadpath.exists())uploadpath.mkdir();
		//获取上传文件名,包含后缀
        String originalFilename = file.getOriginalFilename();
        //获取后缀
        String substring = originalFilename.substring(originalFilename.lastIndexOf("."));
        String id=UUID.randomUUID().toString();
        //保存的文件名
        String dFileName = id.replace("-","")+substring;
        //保存路径
        String path=uploadpath.getAbsolutePath();
        //生成保存文件
        File uploadFile = new File(path+File.separator+dFileName);
        //将上传文件保存到路径
        try {
        	InputStream ins = file.getInputStream();
        	 inputStreamToFile(ins, uploadFile);
             ins.close();
        } catch (IOException e) {
            e.printStackTrace();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return dFileName;
	}
	/* 读取upload目录的文件
	 * path为文件名
	 */
	public List<String> read(String path) {
		List<String> list=new ArrayList<String>();
		//获取当前项目路径
		File currentpath = new File(System.getProperty("user.dir"));
		//获取当前项目路径的父路径
		File parentfile = currentpath.getParentFile();
		//指定文件上传径路径
		File uploadpath= new File(parentfile.getAbsolutePath()+File.separator+"upload");
		File file=new File(uploadpath.getAbsolutePath()+File.separator+path);
		BufferedReader reader = null;
	    try {
	        reader = new BufferedReader(new FileReader(file));
	        String str="";
	        while ((str = reader.readLine()) != null) {
	        	list.add(str);
	        }
	        reader.close();
	    } catch (IOException e) {
	        e.printStackTrace();
	    } finally {
	        if (reader != null) {
	            try {
	                reader.close();
	            } catch (IOException e1) {
	                e1.printStackTrace();
	            }
	        }
	    }
        return list;
	}
	//获取流文件
	private static void inputStreamToFile(InputStream ins, File file) {
	    try {
	        OutputStream os = new FileOutputStream(file);
	        int bytesRead = 0;
	        byte[] buffer = new byte[8192];
	        while ((bytesRead = ins.read(buffer, 0, 8192)) != -1) {
	            os.write(buffer, 0, bytesRead);
	        }
	        os.close();
	        ins.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
}
