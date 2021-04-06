package com.chenjf.util.entity;

import java.util.UUID;

import com.chenjf.util.Faker;
import com.chenjf.util.MD5;

public class Internet {
    private final Faker faker;

    public Internet(Faker faker) {
        this.faker = faker;
    }

    public String password() {
        return password(8, 16);
    }

    public String password(int minimumLength, int maximumLength) {
        return password(minimumLength, maximumLength, false);
    }

    private String password(int minimumLength, int maximumLength, boolean includeUppercase) {
        return password(minimumLength, maximumLength, includeUppercase, false);
    }

    private String password(int minimumLength, int maximumLength, boolean includeUppercase, boolean includeSpecial) {
        return password(minimumLength, maximumLength, includeUppercase, includeSpecial, true);
    }

    private String password(int minimumLength, int maximumLength, boolean includeUppercase, boolean includeSpecial, boolean includeDigit) {
        if (includeSpecial) {
            char[] password = faker.lorem().characters(minimumLength, maximumLength, includeUppercase, includeDigit).toCharArray();
            char[] special = new char[]{'!', '@', '#', '$', '%', '^', '&', '*'};
            for (int i = 0; i < faker.random().nextInt(minimumLength); i++) {
                password[faker.random().nextInt(password.length)] = special[faker.random().nextInt(special.length)];
            }
            return new String(password);
        } else {
            return faker.lorem().characters(minimumLength, maximumLength, includeUppercase, includeDigit);
        }
    }
    
    /**
     * <p>Returns a MAC address in the following format: 6-bytes in MM:MM:MM:SS:SS:SS format.</p>
     * @return a correctly formatted MAC address
     * @param prefix a prefix to put on the front of the address
     */
    private String macAddress(String prefix) {
        final String tmp = (prefix == null) ? "" : prefix;
        final int prefixLength = tmp.trim().length() == 0 
          ? 0 
          : tmp.split(":").length;
        
        final StringBuilder out = new StringBuilder(tmp);
        for (int i=0;i < 6 - prefixLength;i++) {
            if (out.length() > 0) {
                out.append(':');
            }
            out.append(Integer.toHexString(faker.random().nextInt(16)));
            out.append(Integer.toHexString(faker.random().nextInt(16)));
        }
        return out.toString();
    }

    /**
     * @see Internet#macAddress(String) 
     */
    public String macAddress() {
        return macAddress("");
    }

    /**
     * returns an IPv4 address in dot separated octets. 
     * @return a correctly formatted IPv4 address.
     */
    public String ipV4Address() {
        return String.format("%d.%d.%d.%d",
          faker.random().nextInt(254) + 2,
          faker.random().nextInt(254) + 2,
          faker.random().nextInt(254) + 2,
          faker.random().nextInt(254) + 2);
    }

    /**
     * <p>Returns an IPv6 address in hh:hh:hh:hh:hh:hh:hh:hh format.</p>
     * @return a correctly formatted IPv6 address.
     */
    public String ipV6Address() {
        final StringBuilder tmp = new StringBuilder();
        for (int i=0;i < 8;i++) {
            if (i > 0) {
                tmp.append(":");
            }
            tmp.append(Integer.toHexString(faker.random().nextInt(16)));
            tmp.append(Integer.toHexString(faker.random().nextInt(16)));
            tmp.append(Integer.toHexString(faker.random().nextInt(16)));
            tmp.append(Integer.toHexString(faker.random().nextInt(16)));
        }
        return tmp.toString();
    }

    /**
     * Returns a UUID (type 4) as String.
     * @return A UUID as String.
     */
    public String uuid() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
    /**password:明文密码
     * 返回经过MD5加密的密码
     * 
     */
    public String md5Password(String password) {
        return MD5.MD5Encode(password);
    }
}
