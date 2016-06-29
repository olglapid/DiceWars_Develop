package de.htwg.se.dicewars.state;

import java.util.HashMap;
import java.util.Map;

public class StatusMessage {
	 public static final Map<Status,String> text = new HashMap<Status, String>();
	 
	 private StatusMessage(){
		 
	 }

	 static{
		 text.put(Status.InvalidAttackNeighbour ,"You can't attack: not a valid neighbour");
		 text.put(Status.InvalidAttackOwner ,"You can't attack: don't attack yourself");
		 text.put(Status.InvalidAttackDices, "You can't attack: not enough dices");
		 text.put(Status.InvalidAttackField, "You can't attack: no valid Field");
		 text.put(Status.ValidAttack, "Attack is valid");
		 text.put(Status.AttackSuccess, "U WOT M8: REKT");
		 text.put(Status.AttackFailed, "TOP KEK: U GOT REKT");
		 text.put(Status.DiceError0,"DiceHandler Error: Not enough dices");
		 text.put(Status.New, "New Object");
		 text.put(Status.PlayerUpdated, "Player updated");
		 text.put(Status.NothingToUpdate, "Nothing to update");
		 text.put(Status.Interruptroutine, "Gameroutine interrupted");
		 text.put(Status.PlayersTurnError, "Wrong order of Player");
		 text.put(Status.InvalidOwner, "You can't attack from a field you don't own");
		 text.put(Status.Success, "Everything ok");
		 text.put(Status.Failed, "Someting went wrong");
		 text.put(Status.EndTurn, "No fields to attack");
		 text.put(Status.Valid, " ");
		 text.put(Status.ChooseAktion, "Führe eine Aktion durch");
		 
	 }


}
