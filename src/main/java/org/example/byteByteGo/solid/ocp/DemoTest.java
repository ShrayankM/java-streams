package org.example.byteByteGo.solid.ocp;

public class DemoTest {
	public static void main(String [] args) {
//		DiscountCalculatorService discountCalculatorService = new DiscountCalculatorService();

		double itemPrice = 100.0;
		DiscountCalculator discountCalculator = CustomerType.REGULAR.getCalculator();
		System.out.println("Discount for regular customer = "  + discountCalculator.calculateDiscount(itemPrice));


		discountCalculator = CustomerType.PREMIUM.getCalculator();
		System.out.println("Discount for premium customer = "  + discountCalculator.calculateDiscount(itemPrice));

		discountCalculator = CustomerType.VIP.getCalculator();
		System.out.println("Discount for vip customer = "  + discountCalculator.calculateDiscount(itemPrice));
	}
}
