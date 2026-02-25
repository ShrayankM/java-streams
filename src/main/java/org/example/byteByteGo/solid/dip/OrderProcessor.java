package org.example.byteByteGo.solid.dip;

public class OrderProcessor {
	private PaymentGateway paymentGateway;
	private NotificationService notificationService;
	private Logger logger;

	public OrderProcessor(PaymentGateway paymentGateway, NotificationService notificationService,
			Logger logger) {
		this.paymentGateway = paymentGateway;
		this.notificationService = notificationService;
		this.logger = logger;
	}

	public void processOrder(String orderId, double amount) {
		paymentGateway.charge(amount);        // what if we switch to PayPal?
		notificationService.sendConfirmation(orderId); // what if we switch to SMS?
		logger.log("Order processed: " + orderId); // what if we switch to DB logging?
	}
}
