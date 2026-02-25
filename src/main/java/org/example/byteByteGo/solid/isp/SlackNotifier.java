package org.example.byteByteGo.solid.isp;

// Only sends Slack — same problem
class SlackNotifier implements SlackNotifierInterface {
	public void sendSlackMessage(String message) {
		System.out.println("Sending message through slack {" + message + "}");
	}
}
