package org.example.byteByteGo.solid.isp;

import java.util.List;

public class NotificationDemo {
	public static void main(String [] args) {
		NotificationServiceImpl notificationService = new NotificationServiceImpl(
				List.of(new EmailNotifier()), List.of(new SlackNotifier())
		);

		notificationService.sendMessage("Sending weather updates");
	}
}
