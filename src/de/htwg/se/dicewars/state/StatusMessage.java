package de.htwg.se.dicewars.state;

import java.util.HashMap;
import java.util.Map;

public class StatusMessage {
	 public static final Map<Status,String> text = new HashMap<Status, String>();
	 
	 private StatusMessage(){
		 
	 }

	 static{
		 text.put(Status.INVALIDATTACKNEIGHBOR ,"You can't attack: not a valid neighbour");
		 text.put(Status.INVALIDATTACKOWNER ,"You can't attack: don't attack yourself");
		 text.put(Status.INVALIDATTACKDICES, "You can't attack: not enough dices");
		 text.put(Status.INVALIDATTACKFIELD, "You can't attack: no valid Field");
		 text.put(Status.VALIDATTACK, "Attack is valid");
		 text.put(Status.ATTACKSUCCESS, "U WOT M8: REKT");
		 text.put(Status.ATTACKFAILED, "TOP KEK: U GOT REKT");
		 text.put(Status.DICEERROR,"DiceHandler Error: Not enough dices");
		 text.put(Status.NEW, "New Object");
		 text.put(Status.PLAYERUPDATE, "Player updated");
		 text.put(Status.NOTHINGTOUPDATE, "Nothing to update");
		 text.put(Status.INTERRUPTROUTINE, "Gameroutine interrupted");
		 text.put(Status.PLAYERSTURNERROR, "Wrong order of Player");
		 text.put(Status.INVALIDOWNER, "You can't attack from a field you don't own");
		 text.put(Status.SUCCESS, "Everything ok");
		 text.put(Status.FAILED, "Someting went wrong");
		 text.put(Status.ENDTURN, "No fields to attack");
		 text.put(Status.VALID, " ");
		 text.put(Status.CHOOSEAKTION, "Führe eine Aktion durch");
		 
	 }


}
