package de.htwg.se.dicewars.state;

/**
 * Stati for Controller and View
 */
public enum Status {

	Valid_Attack, 
	Invalid_Attack_Neighbour, 
	Invalid_Attack_Dices, 
	Invalid_Attack_Owner, 
	Invalid_Attack_Field, 
	Attack_Success, 
	Attack_Failed, 
	New,Player_Updated,
	Nothing_To_Update,
	Interrupt_routine,
	Dice_Error0,
	PlayersTurn_Error,

}
