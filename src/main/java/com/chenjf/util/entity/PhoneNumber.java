package com.chenjf.util.entity;
import java.util.Random;

import com.chenjf.util.Faker;
public class PhoneNumber {
    private final Faker faker;

    public PhoneNumber(Faker faker) {
        this.faker = faker;
    }

    public String phoneNumber() {
        return faker.numerify(faker.fakeValuesService().resolve("phone_number.formats", this, faker));
    }
    //中国移动 前缀
    public static final String[] CHINA_MOBILE = {
            "134", "135", "136", "137", "138", "139", "150", "151", "152", "157", "158", "159",
            "182", "183", "184", "187", "188", "178", "147", "172", "198"
    };
    //中国联通 前缀
    public static final String[] CHINA_UNICOM = {
            "130", "131", "132", "145", "155", "156", "166", "171", "175", "176", "185", "186", "166"
    };
    //中国电信 前缀
    public static final String[] CHINA_TELECOME = {
            "133", "149", "153", "173", "177", "180", "181", "189", "199"
    };
    //随机中国移动号码
    public String mobile() {
    	return createMobile(0);
    }
    //随机中国联通号码
    public String unicom() {
    	return createMobile(1);
    }
    //随机中国电信号码
    public String telecome() {
    	return createMobile(2);
    }
    //随机生成手机号码
    public String randomMobile() {
    	Random r=new Random();
    	int i=r.nextInt(2);    //生成[0,10]区间的整数
    	return createMobile(i);
    }
    /**
     * 生成手机号
     *
     * @param op 0 移动 1 联通 2 电信
     */
    private String createMobile(int op) {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        String mobile01;//手机号前三位
        int temp;
        switch (op) {
            case 0:
                mobile01 = CHINA_MOBILE[random.nextInt(CHINA_MOBILE.length)];
                break;
            case 1:
                mobile01 = CHINA_UNICOM[random.nextInt(CHINA_UNICOM.length)];
                break;
            case 2:
                mobile01 = CHINA_TELECOME[random.nextInt(CHINA_TELECOME.length)];
                break;
            default:
                mobile01 = "op标志位有误！";
                break;
        }
        if (mobile01.length() > 3) {
            return mobile01;
        }
        sb.append(mobile01);
        //生成手机号后8位
        for (int i = 0; i < 8; i++) {
            temp = random.nextInt(10);
            sb.append(temp);
        }
        return sb.toString();
    }
}
