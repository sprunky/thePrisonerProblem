package com.sprunk;

import com.sprunk.model.Game;

public class Main {

	public static void main(String[] args) {

			var game = new Game(true);
			var result = game.run();
			System.out.println(result);
	}
}