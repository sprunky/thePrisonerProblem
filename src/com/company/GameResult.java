package com.company;

public class GameResult {
	private boolean allPrisonersFreed;
	private int correctGuesses;

	public GameResult() {
		this.allPrisonersFreed = true;
		this.correctGuesses = 0;
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

	@Override
	public String toString() {
		return "GameResult{" +
				"allPrisonersFreed=" + allPrisonersFreed +
				", correctGuesses=" + correctGuesses +
				'}';
	}
}
