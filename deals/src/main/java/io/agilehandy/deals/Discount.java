package io.agilehandy.deals;


import java.text.DecimalFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * By: Haytham Mohamed
 */
public class Discount {

	private final Category category;

	public Discount(Category category) {
		this.category = category;
	}

	public String printDiscountTicket() {
		String name = category.getName();

		List<DayOfWeek> dayOfWeeks = Arrays.asList(DayOfWeek.values());

		LocalDate date = LocalDate.now();
		DayOfWeek dow = date.getDayOfWeek();

		int dayIndex = dayOfWeeks.indexOf(dow);

		int categoryNameLength = name.length();
		int numberOfDigits = String.valueOf(categoryNameLength).length();

		float fraction = categoryNameLength % (10 * numberOfDigits);

		float discount = randFloat(0, dayIndex * fraction);

		DecimalFormat f = new DecimalFormat("#0.00");

		return new StringBuffer("Today ").append(dow)
				.append(", your ticket for ")
				.append(name)
				.append(" offers ")
				.append(f.format(discount))
				.append("% discount")
				.toString();
	}

	private static float randFloat(float min, float max) {
		Random rand = new Random();
		float result = rand.nextFloat() * (max - min) + min;
		return result;
	}

}
