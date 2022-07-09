package com.company;

import com.company.game.AnsiCodes;

import java.util.ArrayList;
import java.util.List;

public class GameResult {
	private boolean allPrisonersFreed;
	private int correctGuesses;
	private List<Prisoner> prisoners;

	public GameResult() {
		this.allPrisonersFreed = true;
		this.correctGuesses = 0;
		this.prisoners = new ArrayList<>();
	}

	public boolean isAllPrisonersFreed() {
		return allPrisonersFreed;
	}

	public void setAllPrisonersFreed(boolean allPrisonersFreed) {
		this.allPrisonersFreed = allPrisonersFreed;
	}

	public int getCorrectGuesses() {
		return correctGuesses;
	}

	public void setCorrectGuesses(int correctGuesses) {
		this.correctGuesses = correctGuesses;
	}

	public void addPrisoner(Prisoner prisoner){
		prisoners.add(prisoner);
	}

	@Override
	public String toString() {
		var builder = new StringBuilder();
		builder.append("GameResult{" + "allPrisonersFreed=").append(allPrisonersFreed).append(", correctGuesses=").append(correctGuesses).append('}').append("\n");

		for (int i = 0; i < prisoners.size(); i++) {
			if (prisoners.get(i).survived){
				builder.append(AnsiCodes.ANSI_GREEN).append("o_o");
			} else {
				builder.append(AnsiCodes.ANSI_RED).append("x_x");
			}

			builder.append("\nInmate: ").append(i+1).append("\n chosen sequence").append(prisoners.get(i)).append(AnsiCodes.ANSI_RESET).append("\n");

		}

		return builder.toString();
	}
}
