package org.example.byteByteGo.solid.isp;

import java.util.List;

public class NotificationServiceImpl {
	private List<EmailNotifierInterface> emailNotifierInterfaceList;
	private List<SlackNotifierInterface> slackNotifierInterfacesList;

	public NotificationServiceImpl(List<EmailNotifierInterface> emailNotifierInterfaceList,
			List<SlackNotifierInterface> slackNotifierInterfacesList) {
		this.emailNotifierInterfaceList = emailNotifierInterfaceList;
		this.slackNotifierInterfacesList = slackNotifierInterfacesList;
	}

	public void sendMessage(String message) {
		emailNotifierInterfaceList.forEach(o -> o.sendEmail(message));
		this.slackNotifierInterfacesList.forEach(o -> o.sendSlackMessage(message));
	}
}
