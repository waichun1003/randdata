package com.chenjf.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.chenjf.entity.Gcolumn;
import com.chenjf.entity.Gtable;
import com.chenjf.entity.ParaBean;
import com.chenjf.util.Faker;
import com.chenjf.util.JsonUtil;
import com.chenjf.util.UploadFile;
@Service
public class GenerateSQL {
	/*
	 * 生成SQL列表
	 */
	public List<String> generate(List<Gcolumn> collist,Gtable gtable){
		List<String> sqllist=new ArrayList<String>();
		String column="",value="",sql="";
		int nextInt=0;
		boolean isrun=false;
		Faker faker=new Faker();
		for(int i=0;i<gtable.getGeneratecount();i++) {//循环生成条数
			sql="insert into "+gtable.getTablename()+"(";
			for(Gcolumn gcolumn:collist) {//所有列解析
				String paratype=gcolumn.getParatype();
				String funcname=gcolumn.getFuncname();
				column=column+gcolumn.getColumnname()+",";//列名拼成字符串
				if(paratype.equalsIgnoreCase("system")) {//系统内方法
					ParaBean bean=null;
					if(gcolumn.getParams()!=null && !gcolumn.getParams().equals("") &&!funcname.equalsIgnoreCase("Expression.replaceStr"))bean=JsonUtil.JSON2Object(gcolumn.getParams());
					SimpleDateFormat dtformate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					SimpleDateFormat dformate = new SimpleDateFormat("yyyy-MM-dd");
					///////////////////////随机数字  start///////////////////////////
					if(funcname.equalsIgnoreCase("Number.integerBetween")) {value=value+faker.number().integerBetween(bean.getMinvalue(), bean.getMaxvalue())+",";}
					if(funcname.equalsIgnoreCase("Number.randomDouble")) {value=value+faker.number().randomDouble(bean.getMaxNumberOfDecimals(),bean.getMinvalue(), bean.getMaxvalue())+",";}
					if(funcname.equalsIgnoreCase("Number.nextInt")) {
						if(!isrun) {nextInt=bean.getMinvalue();isrun=true;}
					    else {nextInt=faker.number().nextInt(bean.getStep(),nextInt);}
						value=value+nextInt+",";
					}
					///////////////////////随机数字  end///////////////////////////
					
					///////////////////////人员信息  start///////////////////////////
					if(funcname.equalsIgnoreCase("Name.fullName")) {value=value+"'"+faker.name().fullName()+"',";}
					if(funcname.equalsIgnoreCase("PhoneNumber.randomMobile")) {value=value+"'"+faker.phoneNumber().randomMobile()+"',";}
					if(funcname.equalsIgnoreCase("PhoneNumber.mobile")) {value=value+"'"+faker.phoneNumber().mobile()+"',";}
					if(funcname.equalsIgnoreCase("PhoneNumber.unicom")) {value=value+"'"+faker.phoneNumber().unicom()+"',";}
					if(funcname.equalsIgnoreCase("PhoneNumber.telecome")) {value=value+"'"+faker.phoneNumber().telecome()+"',";}
					if(funcname.equalsIgnoreCase("PhoneNumber.phoneNumber")) {value=value+"'"+faker.phoneNumber().phoneNumber()+"',";}
					if(funcname.equalsIgnoreCase("PersonId.generate")) {value=value+"'"+faker.PersonId().generate()+"',";}
					if(funcname.equalsIgnoreCase("School.PrimarySchool")) {value=value+"'"+faker.school().PrimarySchool()+"',";}
					if(funcname.equalsIgnoreCase("School.MiddleSchool")) {value=value+"'"+faker.school().MiddleSchool()+"',";}
					if(funcname.equalsIgnoreCase("School.University")) {value=value+"'"+faker.school().University()+"',";}
					if(funcname.equalsIgnoreCase("Name.job")) {value=value+"'"+faker.name().job()+"',";}
					if(funcname.equalsIgnoreCase("Name.level")) {value=value+"'"+faker.name().level()+"',";}
					if(funcname.equalsIgnoreCase("Name.descriptor")) {value=value+"'"+faker.name().descriptor()+"',";}
					if(funcname.equalsIgnoreCase("Name.bloodGroup")) {value=value+"'"+faker.name().bloodGroup()+"',";}
					if(funcname.equalsIgnoreCase("Name.gender")) {value=value+"'"+faker.name().gender()+"',";}
					if(funcname.equalsIgnoreCase("Name.marriage")) {value=value+"'"+faker.name().marriage()+"',";}
					if(funcname.equalsIgnoreCase("School.educational")) {value=value+"'"+faker.school().educational()+"',";}
					///////////////////////人员信息  end///////////////////////////
					
					///////////////////////地区信息  start///////////////////////////
					if(funcname.equalsIgnoreCase("Address.fullAddress")) {value=value+"'"+faker.address().fullAddress()+"',";}
					if(funcname.equalsIgnoreCase("Address.cityName")) {value=value+"'"+faker.address().cityName()+"',";}
					if(funcname.equalsIgnoreCase("Address.country")) {value=value+"'"+faker.address().country()+"',";}
					if(funcname.equalsIgnoreCase("Address.county")) {value=value+"'"+faker.address().county()+"',";}
					if(funcname.equalsIgnoreCase("Address.street")) {value=value+"'"+faker.address().street()+"',";}
					if(funcname.equalsIgnoreCase("Address.state")) {value=value+"'"+faker.address().state()+"',";}
					if(funcname.equalsIgnoreCase("Address.stateAbbr")) {value=value+"'"+faker.address().stateAbbr()+"',";}
					if(funcname.equalsIgnoreCase("Address.latitude")) {value=value+"'"+faker.address().latitude()+"',";}
					if(funcname.equalsIgnoreCase("Address.longitude")) {value=value+"'"+faker.address().longitude()+"',";}
					///////////////////////地区信息  end/////////////////////////////
					
					///////////////////////随机日期时间  start///////////////////////////
					try {
						if(funcname.equalsIgnoreCase("DateAndTime.betweenDay"))value=value+"'"+dformate.format(faker.date().betweenDay(dformate.parse(bean.getStartdate()), dformate.parse(bean.getEnddate())))+"',";
						if(funcname.equalsIgnoreCase("DateAndTime.betweenTime"))value=value+"'"+dtformate.format(faker.date().betweenTime(dtformate.parse(bean.getStartdate()), dtformate.parse(bean.getEnddate())))+"',";
					} catch (IllegalArgumentException e) {
						e.printStackTrace();
					} catch (ParseException e) {
						e.printStackTrace();
					}
					///////////////////////随机日期时间  end///////////////////////////
					
					///////////////////////字符串  start///////////////////////////
					if(funcname.equalsIgnoreCase("Expression.replaceStr")) {value=value+"'"+faker.expression().replaceStr(gcolumn.getParams())+"',";}
					if(funcname.equalsIgnoreCase("Sentence.quotation")) {value=value+"'"+faker.sentence().neutral()+"',";}
					///////////////////////字符串  end///////////////////////////
					
					///////////////////////网络  start///////////////////////////
					if(funcname.equalsIgnoreCase("Internet.uuid")) {value=value+"'"+faker.internet().uuid()+"',";}
					if(funcname.equalsIgnoreCase("Internet.ipV4Address")) {value=value+"'"+faker.internet().ipV4Address()+"',";}
					if(funcname.equalsIgnoreCase("Internet.ipV6Address")) {value=value+"'"+faker.internet().ipV6Address()+"',";}
					if(funcname.equalsIgnoreCase("Internet.macAddress")) {value=value+"'"+faker.internet().macAddress()+"',";}
					if(funcname.equalsIgnoreCase("Internet.password")) {value=value+"'"+faker.internet().password(bean.getMinvalue(), bean.getMaxvalue())+"',";}
					if(funcname.equalsIgnoreCase("Internet.md5Password")) {value=value+"'"+faker.internet().md5Password(gcolumn.getParams())+"',";}
					///////////////////////网络  end///////////////////////////
					
					///////////////////////金融  start///////////////////////////
					if(funcname.equalsIgnoreCase("Bank.bankname")) {value=value+"'"+faker.bank().bankname()+"',";}
					if(funcname.equalsIgnoreCase("Bank.ccbcard")) {value=value+"'"+faker.bank().ccbcard()+"',";}
					if(funcname.equalsIgnoreCase("Bank.abccard")) {value=value+"'"+faker.bank().abccard()+"',";}
					if(funcname.equalsIgnoreCase("Bank.bcmcard")) {value=value+"'"+faker.bank().bcmcard()+"',";}
					if(funcname.equalsIgnoreCase("Bank.bshcard")) {value=value+"'"+faker.bank().bshcard()+"',";}
					if(funcname.equalsIgnoreCase("Bank.psbccard")) {value=value+"'"+faker.bank().psbccard()+"',";}
					if(funcname.equalsIgnoreCase("Bank.bccard")) {value=value+"'"+faker.bank().bccard()+"',";}
					if(funcname.equalsIgnoreCase("Bank.icbccard")) {value=value+"'"+faker.bank().icbccard()+"',";}
					if(funcname.equalsIgnoreCase("Bank.cgbcard")) {value=value+"'"+faker.bank().cgbcard()+"',";}
					if(funcname.equalsIgnoreCase("Bank.bnbcard")) {value=value+"'"+faker.bank().bnbcard()+"',";}
					if(funcname.equalsIgnoreCase("Bank.cmbccard")) {value=value+"'"+faker.bank().cmbccard()+"',";}
					if(funcname.equalsIgnoreCase("Bank.spdbcard")) {value=value+"'"+faker.bank().spdbcard()+"',";}
					if(funcname.equalsIgnoreCase("Bank.cebcard")) {value=value+"'"+faker.bank().cebcard()+"',";}
					if(funcname.equalsIgnoreCase("Bank.pabcard")) {value=value+"'"+faker.bank().pabcard()+"',";}
					if(funcname.equalsIgnoreCase("Bank.hxbcard")) {value=value+"'"+faker.bank().hxbcard()+"',";}
					if(funcname.equalsIgnoreCase("Bank.cmbcard")) {value=value+"'"+faker.bank().cmbcard()+"',";}
					if(funcname.equalsIgnoreCase("Bank.citiccard")) {value=value+"'"+faker.bank().citiccard()+"',";}
					if(funcname.equalsIgnoreCase("Bank.cibcard")) {value=value+"'"+faker.bank().cibcard()+"',";}
					///////////////////////金融  end///////////////////////////
					
					///////////////////////布尔型  start///////////////////////////
					if(funcname.equalsIgnoreCase("Bool.bool")) {value=value+"'"+faker.bool().bool()+"',";}
					if(funcname.equalsIgnoreCase("Bool.yOrN")) {value=value+"'"+faker.bool().yOrN()+"',";}
					if(funcname.equalsIgnoreCase("Bool.OneOrZero")) {value=value+"'"+faker.bool().OneOrZero()+"',";}
					///////////////////////布尔型  end///////////////////////////
				}
				if(paratype.equalsIgnoreCase("file")) {//文件导入TXT，以换行为准
					String path=gcolumn.getParams();
					UploadFile file=new UploadFile();
					List<String> list=file.read(path);
					int ri=faker.number().integerBetween(0,list.size());
					value=value+"'"+list.get(ri)+"',";
				}
				if(paratype.equalsIgnoreCase("list")) {//用户自定义列表
					String str=gcolumn.getParams();
					String[] list=str.split(",");
					int ri=faker.number().integerBetween(0,list.length-1);
					value=value+"'"+list[ri]+"',";
				}
			}
			//bug  :单行就会数组越界
			if(column.lastIndexOf(",")>1)sql=sql+column.substring(0, column.length()-1)+") values("+value.substring(0, value.length()-1)+");";
			sqllist.add(sql);
			sql="";
			column="";
			value="";
		}
		return sqllist;
	}
}
