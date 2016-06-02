package de.htwg.se.command;

public class Invoker {
	private Command command;
	
	public void setCommand(Command tmpcommand){
		command=tmpcommand;
	}
	public Command getcommand(){
		return this.command;
	}
	public void executeMethod(){
		command.execute();
	}
}
