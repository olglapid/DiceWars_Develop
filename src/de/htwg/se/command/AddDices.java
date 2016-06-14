package de.htwg.se.command;



public class AddDices implements Command {
	private Method method;

	public AddDices(Method tmp) {
		this.method = tmp;
	}
	public Method getMethod(){
		return this.method;
	}
	
	@Override
	public void execute(){
		this.method.addDices();
	}
}
