package com.chenjf.util;
import java.util.Locale;
import java.util.Random;

import com.chenjf.util.entity.Address;
import com.chenjf.util.entity.Bank;
import com.chenjf.util.entity.Bool;
import com.chenjf.util.entity.DateAndTime;
import com.chenjf.util.entity.Expression;
import com.chenjf.util.entity.Internet;
import com.chenjf.util.entity.Lorem;
import com.chenjf.util.entity.Name;
import com.chenjf.util.entity.Number;
import com.chenjf.util.entity.PersonId;
import com.chenjf.util.entity.PhoneNumber;
import com.chenjf.util.entity.School;
import com.chenjf.util.entity.Sentence;
import com.chenjf.util.service.FakeValuesService;
import com.chenjf.util.service.RandomService;
public class Faker {
    private final RandomService randomService;
    private final FakeValuesService fakeValuesService;
    
    private final Name name;
    private final Address address;
    private final School school;
    private final PhoneNumber phoneNumber;
    private final Number number;
    private final PersonId personid;
    private final Bool bool;
    private final Lorem lorem;
    private final Internet internet;
    private final DateAndTime dateAndTime;
    private final Expression expression;
    private final Sentence sentence;
    private final Bank bank;
    
    public Faker() {
        this(Locale.CHINA);
    }
    public Faker(Locale locale) {
        this(locale, (Random)null);
    }
    public Faker(Random random) {
        this(Locale.CHINA, random);
    }

    public Faker(Locale locale, Random random) {
        this(locale, new RandomService(random));
    }

    public Faker(Locale locale, RandomService randomService) {
        this(new FakeValuesService(locale, randomService), randomService);
    }
    public Faker(FakeValuesService fakeValuesService, RandomService random) {
        this.randomService = random;
        this.fakeValuesService = fakeValuesService;
        this.name = new Name(this);
        this.address = new Address(this);
        this.school = new School(this);
        this.phoneNumber = new PhoneNumber(this);
        this.number = new Number(this);
        this.personid = new PersonId(this);
        this.lorem = new Lorem(this);
        this.bool = new Bool(this);
        this.internet = new Internet(this);
        this.dateAndTime = new DateAndTime(this);
        this.expression = new Expression(this);
        this.sentence = new Sentence(this);
        this.bank = new Bank(this);
    }
    public static Faker instance() {
        return new Faker();
    }
    public static Faker instance(Locale locale) {
        return new Faker(locale);
    }
    
    public static Faker instance(Random random) {
        return new Faker(random);
    }
    public static Faker instance(Locale locale, Random random) {
        return new Faker(locale, random);
    }
    public String numerify(String numberString) {
        return fakeValuesService.numerify(numberString);
    }
    public String letterify(String letterString) {
        return fakeValuesService.letterify(letterString);
    }
    public String letterify(String letterString, boolean isUpper) {
        return fakeValuesService.letterify(letterString, isUpper);
    }

    public String bothify(String string) {
        return fakeValuesService.bothify(string);
    }

    public String bothify(String string, boolean isUpper) {
        return fakeValuesService.bothify(string, isUpper);
    }

    public String regexify(String regex) {
        return fakeValuesService.regexify(regex);
    }

    public RandomService random() {
        return this.randomService;
    }

    public FakeValuesService fakeValuesService() {
        return this.fakeValuesService;
    }
    public Name name() {
        return name;
    }
    public Address address() {
        return address;
    }
    public School school() {
        return school;
    }
    public PhoneNumber phoneNumber() {
        return phoneNumber;
    }
    public Number number() {
        return number;
    }
	public PersonId PersonId() {
		return personid;
	}
    public Bool bool() {
        return bool;
    }
    public Lorem lorem() {
        return lorem;
    }
    public Internet internet() {
        return internet;
    }
    public DateAndTime date() {
        return dateAndTime;
    }
    public Expression expression() {
        return expression;
    }
    public Sentence sentence() {
        return sentence;
    }
	public Bank bank() {
		return bank;
	}
    
}
