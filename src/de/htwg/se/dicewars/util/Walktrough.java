package de.htwg.se.dicewars.util;


import de.htwg.se.dicewars.model.IField;
import de.htwg.se.dicewars.statistics.Statistics;
import de.htwg.se.dicewars.strategy.Context;

public abstract class Walktrough {
	private Walktrough(){
		
	}

	public static boolean[] visitField(IField field, boolean[] fields) {
		IField tmpField = field;
		int tmp = tmpField.getFieldNumber();
		fields[tmp - 1] = true;
		return fields;
	}

	public static boolean checkVisit(IField field, boolean[] fields) {
		IField tmpField = field;
		int tmp = tmpField.getFieldNumber();
		if (fields[tmp - 1])
			return true;
		return false;
	}

	public static IField walkTroughFields(IField field, boolean[] visit, Statistics stats, Context context) {
		boolean[] tmp = visit;
		
		if (field == null || field.getNachbar() == null)
			return field;

		if (checkVisit(field, visit))
			return field;
		
		IField[] neighborsList = field.getNachbar();

		
		tmp = visitField(field, tmp);
		

		stats.setField(field);
		context.executeStrategy(stats);
		
		for (int i = 0; i < neighborsList.length; i++) {
			if (neighborsList[i] == null)
				continue;
			walkTroughFields(neighborsList[i], tmp, stats, context);
		}

		return field;

	}
}
