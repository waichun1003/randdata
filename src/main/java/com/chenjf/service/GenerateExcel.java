package com.chenjf.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chenjf.entity.Gcolumn;
import com.chenjf.entity.Gtable;
import com.chenjf.entity.ParaBean;
import com.chenjf.util.Faker;
import com.chenjf.util.JsonUtil;
import com.chenjf.util.UploadFile;

@Service
public class GenerateExcel {
	@Autowired 
	private ChinaAreaService chinaareaService;
	/*
	 * 生成Excel
	 */
	public HSSFWorkbook generate(List<Gcolumn> collist,Gtable gtable){
		HSSFWorkbook wb = new HSSFWorkbook();
		String value="";
		int nextInt=0;
		boolean isrun=false;
		Faker faker=new Faker();
		// 根据页面index 获取sheet页
		HSSFSheet sheet = wb.createSheet(gtable.getTablename());
		HSSFRow head = sheet.createRow(0);
		for(int i=0;i<collist.size();i++) {//循环生成条数
			head.createCell(i).setCellValue(collist.get(i).getColumnname());
		}
		for(int i=0;i<gtable.getGeneratecount();i++) {//循环生成条数
			// 创建HSSFRow对象
			HSSFRow row = sheet.createRow(i + 1);
			for(int j=0;j<collist.size();j++) {//所有列解析
				Gcolumn gcolumn=collist.get(j);
				String paratype=gcolumn.getParatype();
				String funcname=gcolumn.getFuncname();
				if(paratype.equalsIgnoreCase("system")) {//系统内方法
					ParaBean bean=null;
					if(gcolumn.getParams()!=null && !gcolumn.getParams().equals("") &&!funcname.equalsIgnoreCase("Expression.replaceStr"))bean=JsonUtil.JSON2Object(gcolumn.getParams());
					SimpleDateFormat dtformate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					SimpleDateFormat dformate = new SimpleDateFormat("yyyy-MM-dd");
					///////////////////////随机数字  start///////////////////////////
					if(funcname.equalsIgnoreCase("Number.integerBetween")) {value=faker.number().integerBetween(bean.getMinvalue(), bean.getMaxvalue())+"";}
					if(funcname.equalsIgnoreCase("Number.randomDouble")) {value=faker.number().randomDouble(bean.getMaxNumberOfDecimals(),bean.getMinvalue(), bean.getMaxvalue())+"";}
					if(funcname.equalsIgnoreCase("Number.nextInt")) {
						if(!isrun) {nextInt=bean.getMinvalue();isrun=true;}
						else {nextInt=faker.number().nextInt(bean.getStep(),nextInt);}
						value=nextInt+"";
					}
					///////////////////////随机数字  end///////////////////////////
					
					///////////////////////人员信息  start///////////////////////////
					if(funcname.equalsIgnoreCase("Name.fullName")) {value=faker.name().fullName();}
					if(funcname.equalsIgnoreCase("PhoneNumber.randomMobile")) {value=faker.phoneNumber().randomMobile();}
					if(funcname.equalsIgnoreCase("PhoneNumber.mobile")) {value=faker.phoneNumber().mobile();}
					if(funcname.equalsIgnoreCase("PhoneNumber.unicom")) {value=faker.phoneNumber().unicom();}
					if(funcname.equalsIgnoreCase("PhoneNumber.telecome")) {value=faker.phoneNumber().telecome();}
					if(funcname.equalsIgnoreCase("PhoneNumber.phoneNumber")) {value=faker.phoneNumber().phoneNumber();}
					if(funcname.equalsIgnoreCase("PersonId.generate")) {value=faker.PersonId().generate();}
					if(funcname.equalsIgnoreCase("School.PrimarySchool")) {value=faker.school().PrimarySchool();}
					if(funcname.equalsIgnoreCase("School.MiddleSchool")) {value=faker.school().MiddleSchool();}
					if(funcname.equalsIgnoreCase("School.University")) {value=faker.school().University();}
					if(funcname.equalsIgnoreCase("Name.job")) {value=faker.name().job();}
					if(funcname.equalsIgnoreCase("Name.level")) {value=faker.name().level();}
					if(funcname.equalsIgnoreCase("Name.descriptor")) {value=faker.name().descriptor();}
					if(funcname.equalsIgnoreCase("Name.bloodGroup")) {value=faker.name().bloodGroup();}
					if(funcname.equalsIgnoreCase("Name.gender")) {value=faker.name().gender();}
					if(funcname.equalsIgnoreCase("Name.marriage")) {value=faker.name().marriage();}
					if(funcname.equalsIgnoreCase("School.educational")) {value=faker.school().educational();}
					///////////////////////人员信息  end///////////////////////////
					
					///////////////////////地区信息  start///////////////////////////
					if(funcname.equalsIgnoreCase("Address.fullAddress")) {int areanum=faker.number().integerBetween(1, 547411);value=chinaareaService.getAreaByNum(5, areanum).getAreapath()+faker.address().fullAddress();}
					if(funcname.equalsIgnoreCase("Address.cityName")) {value=faker.address().cityName();}
					if(funcname.equalsIgnoreCase("Address.country")) {value=faker.address().country();}
					if(funcname.equalsIgnoreCase("Address.county")) {value=faker.address().county();}
					if(funcname.equalsIgnoreCase("Address.street")) {value=faker.address().street();}
					if(funcname.equalsIgnoreCase("Address.state")) {value=faker.address().state();}
					if(funcname.equalsIgnoreCase("Address.stateAbbr")) {value=faker.address().stateAbbr();}
					if(funcname.equalsIgnoreCase("Address.latitude")) {value=faker.address().latitude();}
					if(funcname.equalsIgnoreCase("Address.longitude")) {value=faker.address().longitude();}
					///////////////////////地区信息  end/////////////////////////////
					
					///////////////////////随机日期时间  start///////////////////////////
					try {
						if(funcname.equalsIgnoreCase("DateAndTime.betweenDay"))value=dformate.format(faker.date().betweenDay(dformate.parse(bean.getStartdate()), dformate.parse(bean.getEnddate())))+"";
						if(funcname.equalsIgnoreCase("DateAndTime.betweenTime"))value=dtformate.format(faker.date().betweenTime(dtformate.parse(bean.getStartdate()), dtformate.parse(bean.getEnddate())))+"";
					} catch (IllegalArgumentException e) {
						e.printStackTrace();
					} catch (ParseException e) {
						e.printStackTrace();
					}
					///////////////////////随机日期时间  end///////////////////////////
					
					///////////////////////字符串  start///////////////////////////
					if(funcname.equalsIgnoreCase("Expression.replaceStr")) {value=faker.expression().replaceStr(gcolumn.getParams());}
					if(funcname.equalsIgnoreCase("Sentence.quotation")) {value=faker.sentence().neutral();}
					///////////////////////字符串  end///////////////////////////
					
					///////////////////////网络  start///////////////////////////
					if(funcname.equalsIgnoreCase("Internet.uuid")) {value=faker.internet().uuid();}
					if(funcname.equalsIgnoreCase("Internet.ipV4Address")) {value=faker.internet().ipV4Address();}
					if(funcname.equalsIgnoreCase("Internet.ipV6Address")) {value=faker.internet().ipV6Address();}
					if(funcname.equalsIgnoreCase("Internet.macAddress")) {value=faker.internet().macAddress();}
					if(funcname.equalsIgnoreCase("Internet.password")) {value=faker.internet().password(bean.getMinvalue(), bean.getMaxvalue());}
					if(funcname.equalsIgnoreCase("Internet.md5Password")) {value=faker.internet().md5Password(gcolumn.getParams());}
					///////////////////////网络  end///////////////////////////
					
					///////////////////////金融  start///////////////////////////
					if(funcname.equalsIgnoreCase("Bank.bankname")) {value=faker.bank().bankname();}
					if(funcname.equalsIgnoreCase("Bank.ccbcard")) {value=faker.bank().ccbcard();}
					if(funcname.equalsIgnoreCase("Bank.abccard")) {value=faker.bank().abccard();}
					if(funcname.equalsIgnoreCase("Bank.bcmcard")) {value=faker.bank().bcmcard();}
					if(funcname.equalsIgnoreCase("Bank.bshcard")) {value=faker.bank().bshcard();}
					if(funcname.equalsIgnoreCase("Bank.psbccard")) {value=faker.bank().psbccard();}
					if(funcname.equalsIgnoreCase("Bank.bccard")) {value=faker.bank().bccard();}
					if(funcname.equalsIgnoreCase("Bank.icbccard")) {value=faker.bank().icbccard();}
					if(funcname.equalsIgnoreCase("Bank.cgbcard")) {value=faker.bank().cgbcard();}
					if(funcname.equalsIgnoreCase("Bank.bnbcard")) {value=faker.bank().bnbcard();}
					if(funcname.equalsIgnoreCase("Bank.cmbccard")) {value=faker.bank().cmbccard();}
					if(funcname.equalsIgnoreCase("Bank.spdbcard")) {value=faker.bank().spdbcard();}
					if(funcname.equalsIgnoreCase("Bank.cebcard")) {value=faker.bank().cebcard();}
					if(funcname.equalsIgnoreCase("Bank.pabcard")) {value=faker.bank().pabcard();}
					if(funcname.equalsIgnoreCase("Bank.hxbcard")) {value=faker.bank().hxbcard();}
					if(funcname.equalsIgnoreCase("Bank.cmbcard")) {value=faker.bank().cmbcard();}
					if(funcname.equalsIgnoreCase("Bank.citiccard")) {value=faker.bank().citiccard();}
					if(funcname.equalsIgnoreCase("Bank.cibcard")) {value=faker.bank().cibcard();}
					///////////////////////金融  end///////////////////////////
					
					///////////////////////布尔型  start///////////////////////////
					if(funcname.equalsIgnoreCase("Bool.bool")) {value=faker.bool().bool()+"";}
					if(funcname.equalsIgnoreCase("Bool.yOrN")) {value=faker.bool().yOrN();}
					if(funcname.equalsIgnoreCase("Bool.OneOrZero")) {value=faker.bool().OneOrZero()+"";}
					///////////////////////布尔型  end///////////////////////////
				}
				if(paratype.equalsIgnoreCase("file")) {//文件导入TXT，以换行为准
					String path=gcolumn.getParams();
					UploadFile file=new UploadFile();
					List<String> list=file.read(path);
					int ri=faker.number().integerBetween(0,list.size());
					value=list.get(ri);
				}
				if(paratype.equalsIgnoreCase("list")) {//用户自定义列表
					String str=gcolumn.getParams();
					String[] list=str.split(",");
					int ri=faker.number().integerBetween(0,list.length-1);
					value=list[ri];
				}
				// 创建HSSFCell对象 设置单元格的值
				//row.createCell(j).setCellValue(value);
				// 调整每一列宽度(自适应)
			    //sheet.autoSizeColumn((short) j);
			    // 解决自动设置列宽中文失效的问题(自适应)
			    //sheet.setColumnWidth(j, sheet.getColumnWidth(j) * 17 / 10);
				value="";
			}
		}
		return wb;
	}
}
