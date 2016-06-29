package de.htwg.se.dicewars.state;

/**
 * Stati for Controller and View
 */
public enum Status {

	validAttack , 
	InvalidAttackNeighbour , 
	InvalidAttackDices , 
	InvalidAttackOwner , 
	InvalidAttackField , 
	AttackSuccess , 
	AttackFailed , 
	New,PlayerUpdated ,
	NothingToUpdate ,
	Interruptroutine ,
	DiceError0 ,
	PlayersTurnError ,
	InvalidOwner ,
	Success ,
	Failed ,
	EndTurn ,
	Valid ,
	ChooseAktion ,

}
