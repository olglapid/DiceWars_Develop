package de.htwg.se.strategy;

import de.htwg.se.dicewars.model.Field;

public interface Strategy {
	public int doOperation(Field field, int dices);
}
