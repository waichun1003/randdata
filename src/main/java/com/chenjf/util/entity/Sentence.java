package com.chenjf.util.entity;

import com.chenjf.util.Faker;

public class Sentence {
    private final Faker faker;

    public Sentence(Faker faker) {
        this.faker = faker;
    }
    /*
     * 语录
     */
    public String neutral() {
        return faker.fakeValuesService().resolve("sentence.neutral", this, faker);
    }
    /*
     * 青春励志语录
     */
    public String quotation() {
        return faker.fakeValuesService().resolve("sentence.quotation", this, faker);
    }
}
