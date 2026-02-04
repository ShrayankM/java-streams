package org.example.remoteControl;

public class RemoteControl {
	private Command [] onCommands;
	private Command [] offCommands;
	private Command lastCommandExecuted;

	public RemoteControl() {
		this.onCommands = new Command[7];
		this.offCommands = new Command[7];
		this.lastCommandExecuted = new NoCommand();

		for (int i = 0; i < 7; i++) {
			this.onCommands[i] = new NoCommand();
			this.offCommands[i] = new NoCommand();
		}
	}

	public void setCommand(int slot, Command onCommand, Command offCommand) {
		this.onCommands[slot] = onCommand;
		this.offCommands[slot] = offCommand;
	}

	public void pressOnButton(int slot) {
		Command commandToExecute = this.onCommands[slot];
		commandToExecute.execute();
		this.lastCommandExecuted = commandToExecute;
	}

	public void pressOffButton(int slot) {
		Command commandToExecute = this.offCommands[slot];
		this.offCommands[slot].execute();
		this.lastCommandExecuted = commandToExecute;
	}

	public void pressUndoButton() {
		this.lastCommandExecuted.undo();
	}

	@Override
	public String toString() {
		StringBuffer stringBuff = new StringBuffer();
		stringBuff.append("\n------ Remote Control -------\n");
		for (int i = 0; i < onCommands.length; i++) {
			stringBuff.append("[slot " + i + "] " + onCommands[i].getClass().getName() + " " + offCommands[i].getClass().getName() + "\n");
		}

		System.out.println("Last executed command = [" + lastCommandExecuted.getClass().getName() + "]");
		return stringBuff.toString();
	}
}
