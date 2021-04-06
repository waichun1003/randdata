package com.chenjf.util.entity;

import org.apache.commons.lang3.StringUtils;

import com.chenjf.util.Faker;

public class Name {
    
    private final Faker faker;

    public Name(Faker faker) {
        this.faker = faker;
    }

    /**
     * 全名
     */
    public String name() {
        return faker.fakeValuesService().resolve("name.name", this, faker);
    }

    /**
     * 全名
     */
    public String fullName() {
        return name();
    }

    /**
     * 返回一个随机包含:叙词、水平、工作 的短语
     * @return a random three part job title
     */
    public String title() {
        return StringUtils.join(new String[] {
            faker.fakeValuesService().resolve("name.title.job", this, faker), 
            faker.fakeValuesService().resolve("name.title.level", this, faker), 
            faker.fakeValuesService().resolve("name.title.descriptor", this, faker) }, " ");
    }
    /**
     * 返回一个随机包含:工作
     * @return a random three part job title
     */
    public String job() {
    	return faker.fakeValuesService().resolve("name.title.job", this, faker);
    }
    /**
     * 返回一个随机包含:水平
     * @return a random three part job title
     */
    public String level() {
    	return faker.fakeValuesService().resolve("name.title.level", this, faker);
    }
    /**
     * 返回一个随机包含:职业描述
     * @return a random three part job title
     */
    public String descriptor() {
    	return faker.fakeValuesService().resolve("name.title.descriptor", this, faker);
    }
    /**
     * 血型
     */
    public String bloodGroup() {
        return faker.fakeValuesService().resolve("name.blood_group", this, faker);
    }
    /**
     * 性别
     */
    public String gender() {
        return faker.fakeValuesService().resolve("name.gender", this, faker);
    }
    /**
     * 婚姻
     */
    public String marriage() {
        return faker.fakeValuesService().resolve("name.marriage", this, faker);
    }
}
