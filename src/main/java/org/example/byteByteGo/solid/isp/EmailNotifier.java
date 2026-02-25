package org.example.byteByteGo.solid.isp;

// Only sends email — forced to implement everything else
class EmailNotifier implements EmailNotifierInterface {
	public void sendEmail(String message) {
		System.out.println("Sending message using email notifier {" + message + "}");
	}
}
