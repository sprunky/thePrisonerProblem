package com.company;

import com.company.game.Game;

public class Main {

	public static void main(String[] args) {

			var game = new Game(true);
			game.run();
			System.out.println(game.getGameResult());
	}
}