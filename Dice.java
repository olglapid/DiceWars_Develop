package egal;
public class Dice {

	public int roll_the_Dice(int number_of_Dices) {
		return (int) (Math.random() * 6 * number_of_Dices) + 1;
	}

	public static Player init_Dice_to_Field(Player player, int number_of_Fields) {
		player.number_of_Dices = number_of_Fields; // Muss noch angepasst werde,
													// da unfair
		return player;
	}

}
