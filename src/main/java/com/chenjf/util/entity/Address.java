package com.chenjf.util.entity;
import com.chenjf.util.Faker;
public class Address {
    private final Faker faker;

    public Address(Faker faker) {
        this.faker = faker;
    }

    public String zipCode() {
        return faker.bothify(faker.fakeValuesService().resolve("address.postcode", this,faker));
    }

    public String city() {
        return faker.fakeValuesService().resolve("address.city", this, faker);
    }

    public String cityName() {
    	return faker.fakeValuesService().resolve("address.city_name", this, faker);
    }

    public String state() {
        return faker.fakeValuesService().resolve("address.state", this, faker);
    }

    public String stateAbbr() {
        return faker.fakeValuesService().resolve("address.state_abbr", this, faker);
    }
    /*
     * 纬度
     */
    public String latitude() {
        return String.format("%.8g", (faker.random().nextDouble() * 180) - 90);
    }
    /*
     * 经度
     */
    public String longitude() {
        return String.format("%.8g", (faker.random().nextDouble() * 360) - 180);
    }
    /*
     * 国家
     */
    public String country() {
        return faker.fakeValuesService().resolve("address.country", this, faker);
    }
    /*
     * 县/区
     */
    public String county() {
    	return faker.fakeValuesService().resolve("address.county", this, faker);
    }
    /*
     * 街道
     */
    public String street() {
    	return faker.fakeValuesService().resolve("address.street_name", this, faker);
    }
    public String buildingNumber() {
        return faker.numerify(faker.fakeValuesService().resolve("address.building_number", this, faker));
    }
    /*
     * 详细地址:省-市-区/县-镇/街-村/社区
     */
    public String fullAddress() {
        return faker.fakeValuesService().resolve("address.vallage_suffix", this, faker);
    }
}
