package de.htwg.se.dicewars.state;

import java.util.HashMap;
import java.util.Map;

public class StatusMessage {
	 public static final Map<Status,String> text = new HashMap<Status, String>();
	 
	 private StatusMessage(){
		 
	 }

	 static{
		 text.put(Status.Invalid_Attack_Neighbour ,"You can't attack: not a valid neighbour");
		 text.put(Status.Invalid_Attack_Owner ,"You can't attack: don't attack yourself");
		 text.put(Status.Invalid_Attack_Dices, "You can't attack: not enough dices");
		 text.put(Status.Invalid_Attack_Field, "You can't attack: no valid Field");
		 text.put(Status.Valid_Attack, "Attack is valid");
		 text.put(Status.Attack_Success, "U WOT M8: REKT");
		 text.put(Status.Attack_Failed, "TOP KEK: U GOT REKT");
		 
	 }


}
