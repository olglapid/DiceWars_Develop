package de.htwg.se.dicewars.statistics;

import de.htwg.se.dicewars.model.Field;

public class Statistics {
	private Field field;
	private int numberOfDices;
	private int numberOfFields;
	private int numberOfAttackableFields;
	private int numberOfConnectedFields;
	
	public Statistics(){
		  field=null;
		  numberOfDices=0;
		  numberOfFields=0;
		  numberOfAttackableFields=0;
		  numberOfConnectedFields=0;
	}
	public void setField(Field field){
		this.field=field;
	}
	public void setNumberOfDices(int nbr){
		this.numberOfDices=nbr;
	}
	public void setNumberOfFields(int nbr){
		this.numberOfFields=nbr;
	}
	public void setNumberOfAttackableFields(int nbr){
		this.numberOfAttackableFields=nbr;
	}
	public void setNumberOfConnectedFields(int nbr){
		this.numberOfConnectedFields=nbr;
	}
	
	public int getNumberOfDices(){
		return this.numberOfDices;
	}
	public int getNumberOfFields(){
		return this.numberOfFields;
	}
	public int getNumberOfAttackableFields(){
		return this.numberOfAttackableFields;
	}
	public int getNumberOfConnectedFields(int nbr){
		return this.numberOfConnectedFields;
	}
	public Field getField(){
		return this.field;
	}
	
	

}
