package org.example.byteByteGo.solid.ocp;

public enum CustomerType {
	REGULAR {
		@Override
		public DiscountCalculator getCalculator() {
			return new RegularDiscountCalculator();
		}
	},

	PREMIUM {
		@Override
		public DiscountCalculator getCalculator() {
			return new PremiumDiscountCalculator();
		}
	},

	VIP {
		@Override
		public DiscountCalculator getCalculator() {
			return new VipDiscountCalculator();
		}
	};

	public abstract DiscountCalculator getCalculator();
}
