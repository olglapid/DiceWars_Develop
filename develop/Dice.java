package develop;

import java.util.Random;

public class Dice {

	public int rollTheDice(int numberOfDices) {
		Random r = new Random();
		int gamble=0;
		for(int i = 0; i<numberOfDices;i++){
			gamble+=r.nextInt(6)  + 1;
		}
		return gamble;
	}

	public static Player initDiceToField(Player player, int numberOfFields) {
		player.numberOfDices = numberOfFields; // Muss noch angepasst werde,
													// da unfair
		return player;
	}

}
