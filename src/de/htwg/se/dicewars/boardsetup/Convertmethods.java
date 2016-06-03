package de.htwg.se.dicewars.boardsetup;

import java.util.Random;

public abstract class Convertmethods {
	/* returns a random number in range of value */
	public static int randomNumber(int value) {
		Random r = new Random();
		return r.nextInt(value);
	}

	/* converts field in x/y size e.g. 49 = 7, 48 = 7, 37 = 6 */
	public static int converteFieldSize(int numberOfFields) {
		return (int) Math.ceil(Math.sqrt(numberOfFields));
	}

	/* converts Fieldnumber to index */
	public static int[] fieldNumberToIndex(int fieldSize, int fieldNumber) {
		int tmpFieldNumber = fieldNumber - 1;
		int[] index = new int[2];

		index[1] = tmpFieldNumber % fieldSize;
		index[0] = tmpFieldNumber / fieldSize;

		return index;
	}

	/* returns the biggest element */
	public static int getMax(int[] list) {
		int tmp = 0;
		for (int i = 0; i < list.length; i++) {
			if (list[i] > tmp) {
				tmp = list[i];
			}
		}
		return tmp;
	}

	public static boolean checkEmptyList(int[] list) {
		for (int i = 0; i < list.length; i++) {
			if (list[i] > 0) {
				return false;
			}
		}
		return true;
	}

	/*---------------------------------------------------*/
	public static int lowerIndex(int[] list, int index, int ctr) {
		int tmpIndex = index - ctr;
		if (tmpIndex < 0) {
			return -2;
		} else if (list[tmpIndex] > 0) {
			return tmpIndex;
		} else {
			return -1;
		}
	}

	public static int higherIndex(int[] list, int index, int ctr) {
		int tmpIndex = index + ctr;
		if (tmpIndex >= list.length) {
			return -3;
		} else if (list[tmpIndex] > 0) {
			return tmpIndex;
		} else {
			return -1;
		}
	}

	public static int wuerfelnOhneZurueckLegen(int[] list) {
		int index = randomNumber(list.length);
		if (list[index] > 0) {
			list[index] -= 1;
			return index;
		}
		int tmpP;
		int tmpN;
		for (int i = 1; i < list.length; i++) {
			tmpP = higherIndex(list, index, i);
			tmpN = lowerIndex(list, index, i);
			if (tmpP >= 0) {
				list[tmpP] -= 1;
				return tmpP;
			}
			if (tmpN >= 0) {
				list[tmpN] -= 1;
				return tmpN;
			}
		}

		return -1;
	}
	/*---------------------------------------------------*/
}
