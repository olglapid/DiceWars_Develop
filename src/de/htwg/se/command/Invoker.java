package de.htwg.se.command;

public class Invoker {
	private Command command;
	
	public void addCommand(Command tmpcommand){
		command=tmpcommand;
	}
	public void executeMethod(){
		command.execute();
	}
}
