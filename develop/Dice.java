package develop;

public class Dice {
	private Dice() {

	}

	public static Player initDiceToField(Player player, int numberOfFields) {
		player.setNumberOfFields(numberOfFields); // Muss noch angepasst werde,
												// da unfair
		return player;
	}

}
