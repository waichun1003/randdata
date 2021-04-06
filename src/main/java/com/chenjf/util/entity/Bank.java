package com.chenjf.util.entity;

import java.util.ArrayList;
import java.util.List;

import com.chenjf.util.Faker;

public class Bank {
    private final Faker faker;

    public Bank(Faker faker) {
        this.faker = faker;
    }
    /*
     * 随机银行名称
     */
    public String bankname() {
        return faker.fakeValuesService().resolve("bank.bankname", this, faker);
    }
    //建行卡号
    public String ccbcard() {
    	return creditCard("ccb");
    }
    //农行卡号
    public String abccard() {
    	return creditCard("abc");
    }
    //交通银行卡号
    public String bcmcard() {
    	return creditCard("bcm");
    }
    //上海银行
    public String bshcard() {
    	return creditCard("bsh");
    }
    //中国邮政卡号
    public String psbccard() {
    	return creditCard("psbc");
    }
    //中国银行
    public String bccard() {
    	return creditCard("bc");
    }
    //中国工商银行
    public String icbccard() {
    	return creditCard("icbc");
    }
    //广东发展银行
    public String cgbcard() {
    	return creditCard("cgb");
    }
    //宁波银行
    public String bnbcard() {
    	return creditCard("bnb");
    }
    //民生银行
    public String cmbccard() {
    	return creditCard("cmbc");
    }
    //上海浦东发展银行
    public String spdbcard() {
    	return creditCard("spdb");
    }
    //光大银行
    public String cebcard() {
    	return creditCard("ceb");
    }
    //平安银行
    public String pabcard() {
    	return creditCard("pab");
    }
    //华夏银行
    public String hxbcard() {
    	return creditCard("hxb");
    }
    //招商银行
    public String cmbcard() {
    	return creditCard("cmb");
    }
    //中信银行
    public String citiccard() {
    	return creditCard("citic");
    }
    //兴业银行
    public String cibcard() {
    	return creditCard("cib");
    }
    private String creditCard(String creditCardType) {
        final String key = String.format("bank.bankcard.%s", creditCardType.toString().toLowerCase());
        String value = faker.fakeValuesService().resolve(key, this, faker);
        final String template = faker.numerify(value);

        String[] split = template.replaceAll("[^0-9]", "").split("");
        List<Integer> reversedAsInt = new ArrayList<Integer>();
        for (int i = 0; i < split.length; i++) {
            final String current = split[split.length - 1 - i];
            if (!current.isEmpty()) {
                reversedAsInt.add(Integer.valueOf(current));
            }
        }
        int luhnSum = 0;
        int multiplier = 1;
        for (Integer digit : reversedAsInt) {
            multiplier = (multiplier == 2 ? 1 : 2);
            luhnSum += sum(String.valueOf(digit * multiplier).split(""));
        }
        int luhnDigit = (10 - (luhnSum % 10)) % 10;
        return template.replace('\\', ' ').replace('/', ' ').trim().replace('L', String.valueOf(luhnDigit).charAt(0));
    }
    private static int sum(String[] string) {
        int sum = 0;
        for (String s : string) {
            if (!s.isEmpty()) {
                sum += Integer.valueOf(s);
            }
        }
        return sum;
    }
}
