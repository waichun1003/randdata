package com.chenjf.util.entity;

import java.math.BigDecimal;

import com.chenjf.util.Faker;

public class Number {
	private final Faker faker;

	public Number(Faker faker) {
		this.faker = faker;
	}

	public int integerBetween(int min, int max) {
		if (min == max)
			return min;

		int value = decimalBetween(min, max).setScale(0, BigDecimal.ROUND_HALF_DOWN).intValue();
		return value == max ? value - 1 : value;
	}

	/*
	 * maxNumberOfDecimals:小数点后位数
	 *  min:最小整数 
	 *  max:最大整数 
	 *  返回随时浮点数
	 */
	public double randomDouble(int maxNumberOfDecimals, int min, int max) {
		return randomDouble(maxNumberOfDecimals, (long) min, (long) max);
	}

	private double randomDouble(int maxNumberOfDecimals, long min, long max) {
		return decimalBetween(min, max).setScale(maxNumberOfDecimals, BigDecimal.ROUND_HALF_DOWN).doubleValue();
	}

	private BigDecimal decimalBetween(long min, long max) {
		if (min == max) {
			return new BigDecimal(min);
		}
		final long trueMin = Math.min(min, max);
		final long trueMax = Math.max(min, max);

		final double range = (double) trueMax - (double) trueMin;

		final double chunkCount = Math.sqrt(Math.abs(range));
		final double chunkSize = chunkCount;
		final long randomChunk = faker.random().nextLong((long) chunkCount);

		final double chunkStart = trueMin + randomChunk * chunkSize;
		final double adj = chunkSize * faker.random().nextDouble();
		return new BigDecimal(chunkStart + adj);
	}
	/*
	 * currentInt当前数
	 * step 每次增长整数
	 * 返回下一序列整数
	 */
	public int nextInt(int step,int currentInt) {
		if(step==0)step=1;
		return currentInt+step;
	}
}
