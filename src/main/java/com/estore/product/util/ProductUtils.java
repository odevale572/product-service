package com.estore.product.util;

import java.util.Random;

public class ProductUtils {

	public static long getRandomNumber() {
		long min = 1000000000L;
		long max = 9999999999L;

		Random random = new Random();
		return random.nextLong() % (max - min) + max;

	}
}
