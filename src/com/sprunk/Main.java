package com.sprunk;

import com.sprunk.game.Game;

public class Main {

	public static void main(String[] args) {

			var game = new Game(true);
			game.run();
			System.out.println(game.getGameResult());
	}
}