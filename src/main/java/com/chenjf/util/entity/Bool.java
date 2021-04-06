package com.chenjf.util.entity;

import com.chenjf.util.Faker;

public class Bool {
    private final Faker faker;

    public Bool(Faker faker) {
        this.faker = faker;
    }
    /**返回 true 或  false**/
    public boolean bool() {
        return faker.random().nextBoolean();
    }
    /**返回Y或N**/
    public String yOrN() {
    	if(faker.random().nextBoolean())return "Y";
    	else return "N";
    }
    /**返回0或1**/
    public int OneOrZero() {
    	if(faker.random().nextBoolean())return 1;
    	else return 0;
    }
}
