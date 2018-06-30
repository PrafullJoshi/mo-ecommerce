package com.mediaocean.ecommerce;

public class CategorySelector {

	public static void main(String[] args) {
		System.out.println(getRandomIntegerBetweenRange(0, 2));
		System.out.println(getRandomIntegerBetweenRange(0, 2));
		System.out.println(getRandomIntegerBetweenRange(0, 2));
		System.out.println(getRandomIntegerBetweenRange(0, 2));
		System.out.println(getRandomIntegerBetweenRange(0, 2));
		System.out.println(getRandomIntegerBetweenRange(0, 2));
		System.out.println(getRandomIntegerBetweenRange(0, 2));
		System.out.println(getRandomIntegerBetweenRange(0, 2));
		System.out.println(getRandomIntegerBetweenRange(0, 2));
		

		System.out.println(getRandomIntegerBetweenRange(50, 100));
		System.out.println(getRandomIntegerBetweenRange(50, 100));
		System.out.println(getRandomIntegerBetweenRange(50, 100));
		System.out.println(getRandomIntegerBetweenRange(50, 100));
		System.out.println(getRandomIntegerBetweenRange(50, 100));
	}
	
	public static long getRandomIntegerBetweenRange(double min, double max){
	    double x = (Math.random() * ((max-min) + 1)) + min;
	   
	    return (long) (x);
	}
}
