package de.htwg.se.dicewars.controller;

import de.htwg.se.dicewars.gameroutine.Gameroutine;
import de.htwg.se.dicewars.model.IBoard;
import de.htwg.se.dicewars.model.IPlayer;
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

	void setBoard(IBoard tmpBoard);

	void setPlayerlist(IPlayer[] tmpPlayerList);

	void setSinglePlayer(IPlayer player, int index);

	void setNumberOfFields(int tmpNumberOfFields);

	IBoard getBoard();

	IPlayer[] getPlayerlist();

	IPlayer getSinglePlayer(int index);

	int getFieldSize();

	int getNumberOfFields();

	void createBoard(int fieldSize, int numberOfFields);

	void connectPlayerToBoard(IPlayer[] listOfPlayer);

	void spreadDicesToField(IBoard board, IPlayer[] listOfPlayer);
	
	void init();
	
	void startGame();

	void create();

}
