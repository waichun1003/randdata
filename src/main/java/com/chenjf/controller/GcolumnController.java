package com.chenjf.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.chenjf.entity.Gcolumn;
import com.chenjf.service.GcolumnService;
import com.chenjf.util.JsonUtil;
import com.chenjf.util.ResultVO;
import com.chenjf.util.UploadFile;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * <p>
 *  数据列接口
 * </p>
 * 微信: chenjunfeng0768
 * @since 2020-06-08
 */
@RequestMapping("/gcolumn")
@RestController
@Api(value = "/gcolumn", tags = "数据列接口")
public class GcolumnController {
	@Autowired 
	private GcolumnService gcolumnService;
	
	@RequestMapping(value = "/columnlist/{gtid}", method = RequestMethod.GET)
	@ApiOperation(value = "按表id获取数据列信息", notes = "按表id获取数据列信息")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "gtid", value = "数据表id", paramType = "path", required = true, dataType = "int"), })
	public ResultVO<List<Gcolumn>> columnlist(@PathVariable int gtid) throws Exception {
		ResultVO<List<Gcolumn>> result = new ResultVO<List<Gcolumn>>();
		List<Gcolumn> list=gcolumnService.getColumnByGtid(gtid);
		result.setData(list);
		return result;
	}
	@RequestMapping(value = "/get/{gcid}", method = RequestMethod.GET)
	@ApiOperation(value = "按列主健获取随机生成数据列信息", notes = "按列主健获取随机生成数据列信息")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "gcid", value = "数据列id", paramType = "path", required = true, dataType = "int"), })
	public ResultVO<Gcolumn> get(@PathVariable int gcid) throws Exception {
		ResultVO<Gcolumn> result = new ResultVO<Gcolumn>();
		QueryWrapper<Gcolumn> query=new QueryWrapper<Gcolumn>();
		query.eq("gcid", gcid);
		List<Gcolumn> list=gcolumnService.list(query);
		Gcolumn column=null;
		if(list.size()>0)
			column=list.get(0);
		result.setData(column);
		return result;
	}
	@PostMapping(value = "/save")
	@ApiOperation(value = "保存生成数据列信息", notes = "保存生成数据列信息", httpMethod = "POST")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "columnname", value = "列名(英文)", paramType = "query", required = true, dataType = "String"),
			@ApiImplicitParam(name = "gtid", value = "表id", paramType = "query", required = true, dataType = "int"),
			@ApiImplicitParam(name = "funcname", value = "生成数据方法(后端提供)", paramType = "query", required = true, dataType = "String"),
			@ApiImplicitParam(name = "params", value = "参数字符串(JSON格式)", paramType = "query", required = false, dataType = "String"),
			@ApiImplicitParam(name = "temp", value = "临时字符串", paramType = "query", required = false, dataType = "String"),})
	public ResultVO<String> save(String columnname, int gtid, String funcname, String params, String temp) throws Exception {
		ResultVO<String> result = new ResultVO<String>();
		if(params!=null && !params.equals("")) {
			if(!funcname.equalsIgnoreCase("Expression.replaceStr")) {
				if(!JsonUtil.isJSONValid(params)) {
					result.setMessage("参数:" + params + "不是正确的JSON样式！请重生编辑。");
					result.setSuccess(false);
					return result;
				}
			}
		}
		Gcolumn column=new Gcolumn();
		column.setGcid(0);
		column.setGtid(gtid);
		column.setColumnname(columnname);
		column.setFuncname(funcname);
		column.setParams(params);
		column.setParatype("system");
		column.setTemp(temp);
		boolean flag=gcolumnService.save(column);
		if(flag) {
			result.setMessage("保存数据列" + columnname + "成功！");
			result.setSuccess(true);
		}else {
			result.setMessage("保存数据列:" + columnname + "失败！");
			result.setSuccess(false);
		}
		return result;
	}
	@PostMapping(value = "/update")
	@ApiOperation(value = "更新生成数据列信息", notes = "更新生成数据列信息", httpMethod = "POST")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "columnname", value = "列名(英文)", paramType = "query", required = true, dataType = "String"),
			@ApiImplicitParam(name = "gcid", value = "列id", paramType = "query", required = true, dataType = "int"),
			@ApiImplicitParam(name = "funcname", value = "生成数据方法(后端提供)", paramType = "query", required = false, dataType = "String"),
			@ApiImplicitParam(name = "params", value = "参数字符串(JSON格式)", paramType = "query", required = false, dataType = "String"), 
			@ApiImplicitParam(name = "temp", value = "临时字符串", paramType = "query", required = false, dataType = "String"),})
	public ResultVO<String> update(String columnname, int gcid, String funcname, String params, String temp) throws Exception {
		ResultVO<String> result = new ResultVO<String>();
		if(params!=null && !params.equals("")) {
			if(!funcname.equalsIgnoreCase("Expression.replaceStr")) {
				if(!JsonUtil.isJSONValid(params)) {
					result.setMessage("参数:" + params + "不是正确的JSON样式！请重生编辑。");
					result.setSuccess(false);
					return result;
				}
			}
		}
		Gcolumn column=new Gcolumn();
		column.setGcid(gcid);
		column.setColumnname(columnname);
		column.setFuncname(funcname);
		column.setParams(params);
		column.setTemp(temp);
		boolean flag=gcolumnService.updateById(column);
		if(flag) {
			result.setMessage("更新数据列" + columnname + "成功！");
			result.setSuccess(true);
		}else {
			result.setMessage("更新数据列:" + columnname + "失败！");
			result.setSuccess(false);
		}
		return result;
	}
	@RequestMapping(value = "/delete/{gcid}", method = RequestMethod.DELETE)
	@ApiOperation(value = "删除随机生成数据列", notes = "删除随机生成数据列")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "gcid", value = "列id", paramType = "path", required = true, dataType = "int"), })
	public ResultVO<String> deleteTable(@PathVariable int gcid) throws Exception {
		ResultVO<String> result = new ResultVO<String>();
		QueryWrapper<Gcolumn> query=new QueryWrapper<Gcolumn>();
		query.eq("gcid", gcid);
		boolean flag=gcolumnService.remove(query);
		if(flag) {
			result.setMessage("删除数据列成功");
			result.setSuccess(true);
		}else {
			result.setMessage("数据列号:" + gcid + "没有相关记录！");
			result.setSuccess(false);
		}
		return result;
	}

	@PostMapping(value = "/uploadfile", consumes = "multipart/*", headers = "content-type=multipart/form-data")
	@ApiOperation(value = "用户采用上传TXT文本文件自定义数据列保存", notes = "用户采用上传TXT文本文件自定义数据列保存", httpMethod = "POST")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "columnname", value = "列名(英文)", paramType = "query", required = true, dataType = "String"),
			@ApiImplicitParam(name = "gtid", value = "表id", paramType = "query", required = true, dataType = "int"),
			@ApiImplicitParam(name = "temp", value = "临时字符串", paramType = "query", required = false, dataType = "String"),})
	public ResultVO<String> uploadfile(@ApiParam(name = "file", value = "上传文件", required = true) MultipartFile file,String columnname,int gtid, String temp) throws Exception {
		ResultVO<String> result = new ResultVO<String>();
		String filename = file.getOriginalFilename();
		String attaname="";
		if (attaname == null || attaname.equals("")) {
			attaname = filename.substring(filename.lastIndexOf(".")+1);
		}
		if (file != null) {
			UploadFile uploadfile=new UploadFile();
			// 校验文件
			if (file.getSize() > (1024 * 1024)) {
				result.setMessage("文件过大(请上传小于1M文件)！");
				result.setSuccess(false);
				result.setCode(500);
				return result;
			}
			if(!attaname.equalsIgnoreCase("txt")) {
				result.setMessage("只支持上传txt类型的文本文件！");
				result.setSuccess(false);
				result.setCode(500);
				return result;
			}
			String path=uploadfile.upload(file);
			Gcolumn column=new Gcolumn();
			column.setColumnname(columnname);
			column.setGtid(gtid);
			column.setParams(path);
			column.setParatype("file");
			column.setTemp(temp);
			//boolean flag=gcolumnService.save(column);
			boolean flag=gcolumnService.saveOrUpdate(column);
			if(flag) {
				result.setMessage("保存数据列" + columnname + "成功！");
				result.setSuccess(true);
			}else {
				result.setMessage("保存数据列:" + columnname + "失败！");
				result.setSuccess(false);
			}
		}
		return result;
	}
	@PostMapping(value = "/listsave")
	@ApiOperation(value = "采用自定义列表的数据列保存", notes = "采用自定义列表的数据列保存", httpMethod = "POST")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "columnname", value = "列名(英文)", paramType = "query", required = true, dataType = "String"),
			@ApiImplicitParam(name = "gtid", value = "表id", paramType = "query", required = true, dataType = "int"),
			@ApiImplicitParam(name = "params", value = "参数字符串(str1,str2,...格式)", paramType = "query", required = true, dataType = "String"),
			@ApiImplicitParam(name = "temp", value = "临时字符串", paramType = "query", required = false, dataType = "String"),})
	public ResultVO<String> listsave(String columnname, int gtid, String params, String temp) throws Exception {
		ResultVO<String> result = new ResultVO<String>();
		Gcolumn column=new Gcolumn();
		column.setGtid(gtid);
		column.setColumnname(columnname);
		column.setParams(params);
		column.setParatype("list");
		column.setTemp(temp);
		boolean flag=gcolumnService.save(column);
		if(flag) {
			result.setMessage("保存数据列" + columnname + "成功！");
			result.setSuccess(true);
		}else {
			result.setMessage("保存数据列:" + columnname + "失败！");
			result.setSuccess(false);
		}
		return result;
	}
}

