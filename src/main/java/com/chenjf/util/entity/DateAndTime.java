package com.chenjf.util.entity;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import com.chenjf.util.Faker;

/**
 * 随机生成日期或时间
 * Created and modified by 陈俊丰
 * 微信:chenjunfeng0768
 */
public class DateAndTime {
    private static final int DEFAULT_MIN_AGE = 18;
    private static final int DEFAULT_MAX_AGE = 65;

    private final Faker faker;

    public DateAndTime(Faker faker) {
        this.faker = faker;
    }

    /**
     * 在开始时间(日期)和结束时间(日期)中随机得到一个时间(日期)
     *
     * @param from 开始时间(日期)
     * @param to 结束时间(日期)
     */
    public Date betweenDay(Date from, Date to) throws IllegalArgumentException {
        if (to.before(from)) {
            throw new IllegalArgumentException("无效日期区间, 开始时间(日期)大于结束时间(日期).");
        }

        if (from.equals(to)) {
            return from;
        }

        long offsetMillis = faker.random().nextLong(to.getTime() - from.getTime());
        return new Date(from.getTime() + offsetMillis);
    }
    /**
     * 在开始时间(日期)和结束时间(日期)中随机得到一个时间(日期)
     *
     * @param from 开始时间(日期)
     * @param to 结束时间(日期)
     */
    public Date betweenTime(Date from, Date to) throws IllegalArgumentException {
        if (to.before(from)) {
            throw new IllegalArgumentException("无效日期区间, 开始时间(日期)大于结束时间(日期).");
        }

        if (from.equals(to)) {
            return from;
        }

        long offsetMillis = faker.random().nextLong(to.getTime() - from.getTime());
        return new Date(from.getTime() + offsetMillis);
    }
    /**
     * 随时生成18岁到65岁之间的出生日期
     */
    public Date birthday() {
        return birthday(DEFAULT_MIN_AGE, DEFAULT_MAX_AGE);
    }

    /**
     * 随时生成最小年龄到最大年龄之间的出生日期
     *
     * @param minAge 最小年龄
     * @param maxAge 最大年龄
     */
    public Date birthday(int minAge, int maxAge) {
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        int currentMonth = Calendar.getInstance().get(Calendar.MONTH);
        int currentDay = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
        Calendar from = new GregorianCalendar(currentYear - maxAge, currentMonth, currentDay);
        Calendar to = new GregorianCalendar(currentYear - minAge, currentMonth, currentDay);

        return betweenDay(from.getTime(), to.getTime());
    }

}
