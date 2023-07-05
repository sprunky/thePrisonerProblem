package com.sprunk.model;

import com.sprunk.utility.AnsiCodes;

import java.util.ArrayList;
import java.util.List;

import static com.sprunk.utility.AnsiCodes.ANSI_GREEN;
import static com.sprunk.utility.AnsiCodes.ANSI_RED;

public class GameResult {
	private boolean allPrisonersFreed;
	private int correctGuesses;
	private List<Prisoner> prisoners;

	public GameResult() {
		this.allPrisonersFreed = true;
		this.correctGuesses = 0;
		this.prisoners = new ArrayList<>();
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

		for (int i = 0; i < prisoners.size(); i++) {
			builder.append(" Inmate: ").append(i+1);

			if (prisoners.get(i).survived){
				builder.append(ANSI_GREEN).append("[o_o] STATUS: alive |");
			} else {
				builder.append(AnsiCodes.ANSI_RED).append("[x_x] STATUS: dead |");
			}

			builder.append(" Sequence: ").append(prisoners.get(i).getSequence()).append(AnsiCodes.ANSI_RESET).append("\n");

		}


		builder.append(allPrisonersFreed ?  "%sAll prisoners were freed!".formatted(ANSI_GREEN) : "%sThe prisoners failed the challenge!".formatted(ANSI_RED)).append("\nCorrect guesses: ").append(correctGuesses).append("\n");

		return builder.toString();
	}
}
