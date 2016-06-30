package de.htwg.se.dicewars.util;


import de.htwg.se.dicewars.model.impl.Field;
import de.htwg.se.dicewars.statistics.Statistics;
import de.htwg.se.dicewars.strategy.Context;

public abstract class Walktrough {
	private Walktrough(){
		
	}

	public static boolean[] visitField(Field field, boolean[] fields) {
		Field tmpField = field;
		int tmp = tmpField.getFieldNumber();
		fields[tmp - 1] = true;
		return fields;
	}

	public static boolean checkVisit(Field field, boolean[] fields) {
		Field tmpField = field;
		int tmp = tmpField.getFieldNumber();
		if (fields[tmp - 1])
			return true;
		return false;
	}

	public static Field walkTroughFields(Field node, boolean[] visit, Statistics stats, Context context) {
		boolean[] tmp = visit;
		
		if (node == null || node.getNachbar() == null)
			return node;

		if (checkVisit(node, visit))
			return node;
		
		Field[] neighborsList = node.getNachbar();

		
		tmp = visitField(node, tmp);
		

		stats.setField(node);
		context.executeStrategy(stats);
		
		for (int i = 0; i < neighborsList.length; i++) {
			if (neighborsList[i] == null)
				continue;
			walkTroughFields(neighborsList[i], tmp, stats, context);
		}

		return node;

	}
}
