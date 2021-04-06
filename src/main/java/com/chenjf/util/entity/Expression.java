package com.chenjf.util.entity;

import com.chenjf.util.Faker;

public class Expression {
    private final Faker faker;

    public Expression(Faker faker) {
        this.faker = faker;
    }
	private static char upperchar[]={'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
	private static char lowerchar[]={'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
	private static char number[]={'0','1','2','3','4','5','6','7','8','9'};
	public String replaceStr(String matcher) {
		if(matcher==null)return "";
		if(matcher.equals(""))return "";
		int index;
		String result=matcher;
		char charge='0';
		for(int i=0;i<matcher.length();i++) {
			char origin=matcher.charAt(i);
			if(origin=='9') {
				index=(int)(Math.random()*(number.length));
				charge=number[index];
				result=result.replaceFirst(Character.toString(origin), Character.toString(charge));
			}
			if(origin=='L') {
				index=(int)(Math.random()*(upperchar.length));
				charge=upperchar[index];
				result=result.replaceFirst(Character.toString(origin), Character.toString(charge));
			}
			if(origin=='l') {
				index=(int)(Math.random()*(lowerchar.length));
				charge=lowerchar[index];
				result=result.replaceFirst(Character.toString(origin), Character.toString(charge));
			}
			
		}
		return result;
	}
}
