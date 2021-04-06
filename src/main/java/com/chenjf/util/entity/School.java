package com.chenjf.util.entity;
import com.chenjf.util.Faker;
public class School {
    private final Faker faker;

    public School(Faker faker) {
        this.faker = faker;
    }
    /*
     * 大学/学院
     */
    public String University() {
        return faker.fakeValuesService().resolve("university.name", this, faker);
    }
    /*
     * 中学
     */
    public String MiddleSchool() {
    	String county=faker.address().county();
    	if(county.length()>2)county=county.substring(0,county.length()-1);
    	String middleschool=county+"中学";
    	return middleschool;
    }
    /*
     * 小学
     */
    public String PrimarySchool() {
    	String street=faker.address().street();
    	String middleschool=street+"小学";
    	return middleschool;
    }
    /*
     * 学历(水平)
     */
    public String educational() {
        return faker.fakeValuesService().resolve("university.educational", this, faker);
    }
}
