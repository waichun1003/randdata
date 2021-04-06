package com.chenjf.entity;

import java.util.Date;
/*
 * JSON解析成Bean
 */
public class ParaBean {
	private int minvalue;//最小值
	private int maxvalue;//最大值
	private String startdate;//开始日期
	private String enddate;//结束日期
	private int maxNumberOfDecimals;//小数点后多少位
	private int step;//增长量

	public int getMinvalue() {
		return minvalue;
	}
	public void setMinvalue(int minvalue) {
		this.minvalue = minvalue;
	}
	public int getMaxvalue() {
		return maxvalue;
	}
	public void setMaxvalue(int maxvalue) {
		this.maxvalue = maxvalue;
	}
	public int getMaxNumberOfDecimals() {
		return maxNumberOfDecimals;
	}
	public void setMaxNumberOfDecimals(int maxNumberOfDecimals) {
		this.maxNumberOfDecimals = maxNumberOfDecimals;
	}
	public int getStep() {
		return step;
	}
	public void setStep(int step) {
		this.step = step;
	}
	public String getStartdate() {
		return startdate;
	}
	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}
	public String getEnddate() {
		return enddate;
	}
	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}
	
}
