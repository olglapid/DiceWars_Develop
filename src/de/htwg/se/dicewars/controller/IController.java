package de.htwg.se.dicewars.controller;

import de.htwg.se.dicewars.gameroutine.Gameroutine;
import de.htwg.se.dicewars.model.impl.Board;
import de.htwg.se.dicewars.model.impl.Player;
import de.htwg.se.dicewars.observer.IObservable;
import de.htwg.se.dicewars.state.Status;

public interface IController extends IObservable {


	
	int getAttack();

	int getDefend();

	void reset();
	
	void setGameroutine(Gameroutine gameroutine);

	Gameroutine getGameroutine();

	boolean checkRange(int index);

	void setAttack(int attack);

	void setDefend(int defend);

	Status getStatus();

	void setfieldSize(int tmpFieldSize);

	void setBoard(Board tmpBoard);

	void setPlayerlist(Player[] tmpPlayerList);

	void setSinglePlayer(Player player, int index);

	void setNumberOfFields(int tmpNumberOfFields);

	Board getBoard();

	Player[] getPlayerlist();

	Player getSinglePlayer(int index);

	int getFieldSize();

	int getNumberOfFields();

	void createBoard(int fieldSize, int numberOfFields);

	void connectPlayerToBoard(Player[] listOfPlayer);

	void spreadDicesToField(Board board, Player[] listOfPlayer);
	
	void init();
	
	void startGame();

	void create();
}
