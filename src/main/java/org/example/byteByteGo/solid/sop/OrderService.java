package org.example.byteByteGo.solid.sop;

public class OrderService {
	private final OrderValidationService orderValidationService;
	private final OrderRepository orderRepository;
	private final OrderEmailService orderEmailService;

	public OrderService(OrderValidationService validationService, OrderRepository orderRepository, OrderEmailService emailService) {
		this.orderValidationService = validationService;
		this.orderRepository = orderRepository;
		this.orderEmailService = emailService;
	}

	public void placeOrder(String orderId, double amount) {
		// validate order
		this.orderValidationService.validateOrder(orderId, amount);

		// create order in DB
		this.orderRepository.createOrderInDB(orderId);

		// send email
		this.orderEmailService.generateOrderEmail();
	}
}

//Hint
//
// One class → multiple reasons to change.
// Goal: Make each responsibility change independently.