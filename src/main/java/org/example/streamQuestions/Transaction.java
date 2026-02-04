package org.example.streamQuestions;

public record Transaction(String id, TransactionStatus status) {
	public void processTransaction() {
		System.out.println("Transaction with id = " + id + " was processed successfully");
	}
}
