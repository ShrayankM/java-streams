package org.example.byteByteGo.solid.ocp;

interface DiscountCalculator {
	double calculateDiscount(double amount);
}

// Hint
//
// Adding a new customer type means modifying existing code.
// Goal: Make it extendable without modification.


//public double calculateDiscount(String customerType, double amount) {
//	if (customerType.equals("REGULAR")) {
//		return amount * 0.05;
//	} else if (customerType.equals("PREMIUM")) {
//		return amount * 0.10;
//	} else if (customerType.equals("VIP")) {
//		return amount * 0.20;
//	}
//	return 0;
//}