package de.htwg.se.command;

public class CountFields implements Command {
	private Method method;

	public CountFields(Method tmp) {
		this.method = tmp;
	}
	public Method getMethod(){
		return this.method;
	}
	@Override
	public void execute(){
		method.countFields();
	}
}
