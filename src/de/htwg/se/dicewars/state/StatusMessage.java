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
		 text.put(Status.Dice_Error0,"DiceHandler Error: Not enough dices");
		 text.put(Status.New, "New Object");
		 text.put(Status.Player_Updated, "Player updated");
		 text.put(Status.Nothing_To_Update, "Nothing to update");
		 text.put(Status.Interrupt_routine, "Gameroutine interrupted");
		 text.put(Status.PlayersTurn_Error, "Wrong order of Player");
		 text.put(Status.Invalid_Owner, "You can't attack from a field you don't own");
		 text.put(Status.Success, "Everything ok");
		 text.put(Status.Failed, "Someting went wrong");
		 text.put(Status.End_Turn, "No fields to attack");
		 text.put(Status.Valid, " ");
		 
	 }


}
