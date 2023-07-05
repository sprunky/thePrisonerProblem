package com.sprunk.model;

import com.sprunk.utility.Utility;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Game {
	private final HashMap<Integer, Integer> drawers;
	private final List<Prisoner> prisoners;
	private boolean strategy;

	public Game(boolean strategy) {
		this.drawers = Utility.createDrawers();
		this.prisoners = Utility.createPrisoners();
		this.strategy = strategy;
	}

	public GameResult run() {
		var result = new GameResult();
			for (int i = 0; i < prisoners.size(); i++) {
				if(strategy) {
					if (openDrawersWithStrategy(prisoners.get(i), drawers)) {
						result.setCorrectGuesses(result.getCorrectGuesses() + 1);
					} else {
						result.setAllPrisonersFreed(false);
					}
				} else {
					if (openDrawersWithoutStrategy(prisoners.get(i), drawers)) {
						result.setCorrectGuesses(result.getCorrectGuesses() + 1);
					} else {
						result.setAllPrisonersFreed(false);
					}
				}
				result.addPrisoner(prisoners.get(i));
			}
			return result;
	}

	private boolean openDrawersWithStrategy(Prisoner prisoner, HashMap<Integer, Integer> drawers) {
		var currentBox = prisoner.getInmateNumber();
		for (int i = 0; i < 50; i++) {
			prisoner.addToSequence(currentBox);
			if (drawers.get(currentBox) == prisoner.getInmateNumber()) {
				prisoner.addToSequence(drawers.get(currentBox));
				prisoner.setSurvived();
				return true;
			} else {
				currentBox = drawers.get(currentBox);
			}
		}
		return false;
	}

	private boolean openDrawersWithoutStrategy(Prisoner prisoner, HashMap<Integer, Integer> drawers) {
		var currentBox = (int) (Math.random() * drawers.size()) + 1;
		var drawersLeft = createListOfNumbers1to100();
		for (int i = 0; i < 50; i++) {
			prisoner.addToSequence(currentBox);
			if (drawers.get(currentBox) == prisoner.getInmateNumber()) {
				prisoner.addToSequence(drawers.get(currentBox));
				prisoner.setSurvived();
				return true;
			} else {
				currentBox = drawers.get(drawersLeft.get((int) (Math.random() * drawersLeft.size())));
			}
			drawersLeft.remove(Integer.valueOf(currentBox));
		}
		return false;
	}

	private List<Integer> createListOfNumbers1to100() {
		var numbers = new ArrayList<Integer>();

		for (int i = 0; i < 100; i++) {
			numbers.add(i + 1);
		}
		return numbers;
	}
}
