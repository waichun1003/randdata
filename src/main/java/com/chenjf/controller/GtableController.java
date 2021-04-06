package com.chenjf.controller;

import java.io.BufferedOutputStream;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.chenjf.entity.Gcolumn;
import com.chenjf.entity.Gtable;
import com.chenjf.service.GcolumnService;
import com.chenjf.service.GenerateExcel;
import com.chenjf.service.GenerateSQL;
import com.chenjf.service.GtableService;
import com.chenjf.service.ResolveDDL;
import com.chenjf.util.ResultVO;
import com.chenjf.util.UploadFile;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
/**
 * 微信: chenjunfeng0768
 * @since 2020-06-08
 */
@RequestMapping("/gtable")
@RestController
@Api(value = "/gtable", tags = "数据表接口")
public class GtableController {
	@Autowired 
	private GtableService gtableService;
	@Autowired 
	private GcolumnService gcolumnService;
	@Autowired 
	private GenerateSQL generateSQL;
	@Autowired 
	private GenerateExcel generateExcel;
	
    @RequestMapping(value = "/tablelist", method = RequestMethod.GET)
	@ApiOperation(value = "通过表名查询随机生成数据表", notes = "通过表名查询随机生成数据表")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "tablename", value = "表名(英文)", paramType = "query", required = false, dataType = "String"), 
		@ApiImplicitParam(name = "PageIndex", value = "页码", paramType = "query", required = true, dataType = "int"),
		@ApiImplicitParam(name = "PageSize", value = "每页显示条数", paramType = "query", required = true, dataType = "int"),
	})
    public ResultVO<IPage<Gtable>> tablelist(String tablename,int PageIndex,int PageSize) {
    	IPage<Gtable> list=gtableService.tablelist(tablename, PageIndex, PageSize);
    	ResultVO<IPage<Gtable>> result=new ResultVO<IPage<Gtable>>();
    	result.setData(list);
        return result;
    }
	@RequestMapping(value = "/delete/{gtid}", method = RequestMethod.DELETE)
	@ApiOperation(value = "删除随机生成数据表", notes = "删除随机生成数据表")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "gtid", value = "数据表id", paramType = "path", required = true, dataType = "int"), })
	public ResultVO<String> deleteTable(@PathVariable int gtid) throws Exception {
		ResultVO<String> result = new ResultVO<String>();
		QueryWrapper<Gcolumn> querycolumn=new QueryWrapper<Gcolumn>();
		querycolumn.eq("gtid", gtid);
		gcolumnService.remove(querycolumn);//删除列
		QueryWrapper<Gtable> query=new QueryWrapper<Gtable>();
		query.eq("gtid", gtid);
		boolean flag=gtableService.remove(query);//删除表
		if(flag) {
			result.setMessage("删除数据表成功");
			result.setSuccess(true);
		}else {
			result.setMessage("数据表号:" + gtid + "没有相关记录！");
			result.setSuccess(false);
		}
		return result;
	}
	@RequestMapping(value = "/get/{gtid}", method = RequestMethod.GET)
	@ApiOperation(value = "按主健获取随机生成数据表信息", notes = "按主健获取随机生成数据表信息")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "gtid", value = "数据表id", paramType = "path", required = true, dataType = "int"), })
	public ResultVO<Gtable> get(@PathVariable int gtid) throws Exception {
		ResultVO<Gtable> result = new ResultVO<Gtable>();
		Gtable gtable=gtableService.getTableByGtid(gtid);
		result.setData(gtable);
		return result;
	}
	@PostMapping(value = "/save")
	@ApiOperation(value = "保存生成数据表信息", notes = "保存生成数据表信息", httpMethod = "POST")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "tablename", value = "表名", paramType = "query", required = true, dataType = "String"),
			@ApiImplicitParam(name = "issql", value = "是否导出SQL", paramType = "query", required = true, dataType = "boolean"),
			@ApiImplicitParam(name = "isexcel", value = "是否导出Excel", paramType = "query", required = false, dataType = "boolean"),
			@ApiImplicitParam(name = "isincludefield", value = "是否包括列名", paramType = "query", required = false, dataType = "boolean"),
			@ApiImplicitParam(name = "generatecount", value = "生成数据记录数", paramType = "query", required = false, dataType = "int"), })
	public ResultVO<String> save(String tablename, Boolean issql, Boolean isexcel, Boolean isincludefield, int generatecount) throws Exception {
		ResultVO<String> result = new ResultVO<String>();
		Gtable table=new Gtable();
		table.setTablename(tablename);
		table.setIssql(issql);
		table.setIsexcel(isexcel);
		table.setIsincludefield(isincludefield);
		table.setGeneratecount(generatecount);
		boolean flag=gtableService.save(table);
		if(flag) {
			result.setMessage("保存数据表" + tablename + "成功！");
			result.setSuccess(true);
		}else {
			result.setMessage("保存数据表:" + tablename + "失败！");
			result.setSuccess(false);
		}
		return result;
	}
	@RequestMapping(value = "/excel/{gtid}", method = RequestMethod.GET)
	@ApiOperation(value = "按表主健获取随机生成Excel数据", notes = "按表主健获取随机生成Excel数据")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "gtid", value = "数据表id", paramType = "path", required = true, dataType = "int"), })
	public String excel(@PathVariable int gtid, HttpServletResponse response) throws Exception {
		Gtable gtable=gtableService.getTableByGtid(gtid);
		List<Gcolumn> list=gcolumnService.getColumnToRand(gtid);
		String tablename=gtable.getTablename();
		try {
			HSSFWorkbook wb = generateExcel.generate(list, gtable);
			// 输出Excel文件
			OutputStream output = response.getOutputStream();
			response.reset();
			// 设置文件头
			response.setHeader("Access-Control-Allow-Origin", "*");
			response.setHeader("Access-Control-Allow-Credentials", "true");
			response.setHeader("Access-Control-Allow-Methods", "POST,GET,PATCH,DELETE,PUT");
			response.setHeader("Access-Control-Expose-Headers", "*");
			response.setHeader("Content-Disposition",
					"attchement;filename=" + new String((tablename+".xls").getBytes("gb2312"), "ISO8859-1"));
			response.setContentType("application/octet-stream;charset=UTF-8");// 定义输出类型
			wb.write(output);
			wb.close();
			return "下载成功";
		} catch (Exception e) {
			e.printStackTrace();
			return "文件生成失败！异常："+ e.getMessage();
		}
	}
	@RequestMapping(value = "/gsql/{gtid}", method = RequestMethod.GET)
	@ApiOperation(value = "按表主健获取随机生成SQL数据", notes = "按表主健获取随机生成SQL数据")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "gtid", value = "数据表id", paramType = "path", required = true, dataType = "int"), })
	public String gsql(@PathVariable int gtid,HttpServletResponse response) throws Exception {
		Gtable gtable=gtableService.getTableByGtid(gtid);
		List<Gcolumn> list=gcolumnService.getColumnToRand(gtid);
		List<String> sqllist=generateSQL.generate(list, gtable);
		String tablename=gtable.getTablename();
		BufferedOutputStream buff=null;
		OutputStream output =null;
		try {
			StringBuffer write=new StringBuffer();
			String enter="\r\n";
			output = response.getOutputStream();
			buff=new BufferedOutputStream(output);

			response.reset();
			// 设置文件头
			response.setHeader("Access-Control-Allow-Origin", "*");
			response.setHeader("Access-Control-Allow-Credentials", "true");
			response.setHeader("Access-Control-Allow-Methods", "POST,GET,PATCH,DELETE,PUT");
			response.setHeader("Access-Control-Expose-Headers", "*");
			response.setHeader("Content-Disposition",
					"attchement;filename=" + new String((tablename+".sql").getBytes("gb2312"), "ISO8859-1"));
			response.setContentType("application/octet-stream;charset=UTF-8");// 定义输出类型
			for(int i=0;i<sqllist.size();i++) {
				write.append(sqllist.get(i)+enter);
			}
			buff.write(write.toString().getBytes("UTF-8"));
			buff.flush();
			buff.close();
			return "下载成功";
		} catch (Exception e) {
			e.printStackTrace();
			return "文件生成失败！异常："+ e.getMessage();
		}finally {
			try {
				buff.close();
				output.close();
			}catch (Exception e) {
				e.printStackTrace();
				return "文件生成失败！异常："+ e.getMessage();
			}
		}
	}
	@RequestMapping(value = "/ishavecolumn/{gtid}", method = RequestMethod.GET)
	@ApiOperation(value = "对应表是否有对应列设置", notes = "对应表是否有对应列设置")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "gtid", value = "数据表id", paramType = "path", required = true, dataType = "int"), })
	public ResultVO<Boolean> ishavecolumn(@PathVariable int gtid) throws Exception {
		ResultVO<Boolean> result = new ResultVO<Boolean>();
		int num=gcolumnService.columnNum(gtid);
		boolean ishave=false;
		if(num>0)
			ishave=true;
		result.setData(ishave);
		return result;
	}
	@PostMapping(value = "/ddlfile", consumes = "multipart/*", headers = "content-type=multipart/form-data")
	@ApiOperation(value = "上传建表的SQL文件直接导入生成表和列(只支持SQL文件)", notes = "上传建表的SQL文件直接导入生成表和列", httpMethod = "POST")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "dbtype", value = "数据库类型(oracle,mysql,greenplum)", paramType = "query", required = true, dataType = "String"),
	})
	public ResultVO<String> ddlfile(@ApiParam(name = "file", value = "上传文件", required = true) MultipartFile file,String dbtype) throws Exception {
		ResultVO<String> result = new ResultVO<String>();
		String filename = file.getOriginalFilename();
		String attaname="";
		if (attaname == null || attaname.equals("")) {
			attaname = filename.substring(filename.lastIndexOf(".")+1);
		}
		// 校验文件
		if(!attaname.equalsIgnoreCase("sql")) {
			result.setMessage("只支持SQL的DDL文件！");
			result.setSuccess(false);
			result.setCode(500);
			return result;
		}
		if (file != null) {
			UploadFile uploadfile=new UploadFile();
			String sqlpath=uploadfile.upload(file);
			ResolveDDL ddl = new ResolveDDL();
			ddl.resolve(sqlpath,dbtype);
			result.setSuccess(true);
			result.setData("DDL文件解析成功!");
		}
		return result;
	}
	@PostMapping(value = "/update")
	@ApiOperation(value = "更新数据表信息", notes = "更新数据表信息", httpMethod = "POST")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "gtid", value = "表id", paramType = "query", required = true, dataType = "int"),
			@ApiImplicitParam(name = "tablename", value = "表名", paramType = "query", required = true, dataType = "String"),
			@ApiImplicitParam(name = "issql", value = "是否导出SQL", paramType = "query", required = true, dataType = "boolean"),
			@ApiImplicitParam(name = "isexcel", value = "是否导出Excel", paramType = "query", required = false, dataType = "boolean"),
			@ApiImplicitParam(name = "isincludefield", value = "是否包括列名", paramType = "query", required = false, dataType = "boolean"),
			@ApiImplicitParam(name = "generatecount", value = "生成数据记录数", paramType = "query", required = false, dataType = "int"), })
	public ResultVO<String> update(int gtid,String tablename, Boolean issql, Boolean isexcel, Boolean isincludefield, int generatecount) throws Exception {
		ResultVO<String> result = new ResultVO<String>();
		Gtable table=new Gtable();
		table.setGtid(gtid);
		table.setTablename(tablename);
		table.setIssql(issql);
		table.setIsexcel(isexcel);
		table.setIsincludefield(isincludefield);
		table.setGeneratecount(generatecount);
		boolean flag=gtableService.saveOrUpdate(table);
		if(flag) {
			result.setMessage("保存数据表" + tablename + "成功！");
			result.setSuccess(true);
		}else {
			result.setMessage("保存数据表:" + tablename + "失败！");
			result.setSuccess(false);
		}
		return result;
	}
	@RequestMapping(value = "/deltables/{gtids}", method = RequestMethod.DELETE)
	@ApiOperation(value = "删除随机生成数据表", notes = "删除随机生成数据表")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "gtids", value = "数据表id字符串(格式:id1,id2,id3。。。)", paramType = "path", required = true, dataType = "string"), })
	public ResultVO<String> deltables(@PathVariable String gtids) throws Exception {
		ResultVO<String> result = new ResultVO<String>();
		boolean flag=false;
		String[] gtidstr=gtids.split(",");
		for(String gtid:gtidstr) {
			QueryWrapper<Gcolumn> querycolumn=new QueryWrapper<Gcolumn>();
			QueryWrapper<Gtable> query=new QueryWrapper<Gtable>();
			querycolumn.eq("gtid", gtid);
			gcolumnService.remove(querycolumn);//删除列
		
			query.eq("gtid", gtid);
			flag=gtableService.remove(query);//删除表
		}
		if(flag) {
			result.setMessage("删除数据表成功");
			result.setSuccess(true);
		}else {
			result.setMessage("数据表号:" + gtids + "没有相关记录！");
			result.setSuccess(false);
		}
		return result;
	}
}

