package com.chenjf.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.chenjf.util.Faker;

public class Test {
	private static final Pattern InserInto_PATTERN = Pattern.compile("^insert into(.)+[;\r\n]$");
	private static final Pattern Comment_PATTERN = Pattern.compile("^-- records of(.)+[\r\n]$");
	public static void main(String[] args) {
		Faker faker=new Faker();
		/*int next=0;
		for(int i=0;i<10;i=i+1) {
			next=faker.number().nextInt(3, next);
			System.out.println(next);
		}*/
		/*SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat sdfdate = new SimpleDateFormat("yyyy-MM-dd");
		Date from = null,to=null;
        try {
            // 注意格式需要与上面一致，不然会出现异常
        	from = sdf.parse("2015-12-15 15:30:23");
        	to = sdf.parse("2020-12-15 15:30:23");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Date date=faker.date().between(from, to);
        Date day=faker.date().between(from, to);
		System.out.println(sdf.format(date)+"|"+sdfdate.format(day));
		System.out.println(faker.address().county());
		System.out.println(faker.school().University()+"|"+faker.school().MiddleSchool()+"|"+faker.school().PrimarySchool());
		String str="99999~lll-LLL**l9=###";
		System.out.println(faker.expression().replaceStr(str));
		System.out.println(faker.sentence().neutral()+"|"+faker.sentence().quotation());*/
		//System.out.println(faker.internet().md5Password("123"));
		//for(int i=0;i<20;i++)
		//System.out.println(faker.name().job()+"|"+faker.name().level()+"|"+faker.name().descriptor());
		System.out.println(faker.name().bloodGroup()+"|"+faker.name().gender()+"|"+faker.name().marriage());
		System.out.println(faker.bool().bool()+"|"+faker.bool().yOrN()+"|"+faker.bool().OneOrZero());
		System.out.println(System.getProperty("file.encoding"));
	}

}
