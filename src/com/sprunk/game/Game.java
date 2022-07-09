package com.sprunk.game;

import com.sprunk.GameResult;
import com.sprunk.Prisoner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Game {
	private final HashMap<Integer, Integer> drawers;
	private final List<Prisoner> prisoners;
	private GameResult result;
	private boolean strategy;

	public Game(boolean strategy) {
		this.drawers = Utility.createDrawers();
		this.prisoners = Utility.createPrisoners();
		this.result = new GameResult();
		this.strategy = strategy;
	}

	public void run() {
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

	public HashMap<Integer, Integer> createDrawers() {
		var drawers = new HashMap<Integer, Integer>();
		var inmateCards = new ArrayList<Integer>();

		for (int i = 0; i < 100; i++) {
			inmateCards.add(i + 1);
		}

		Collections.shuffle(inmateCards);

		for (int i = 0; i < 100; i++) {
			drawers.put(i + 1, inmateCards.get(i));
		}
		return drawers;
	}

	public List<Prisoner> createPrisoners() {
		var prisoners = new ArrayList<Prisoner>();

		for (int i = 0; i < 100; i++) {
			prisoners.add(new Prisoner(i + 1));
		}
		return prisoners;
	}

	public HashMap<Integer, Integer> getDrawers() {
		return drawers;
	}

	public List<Prisoner> getPrisoners() {
		return prisoners;
	}

	public GameResult getGameResult() {
		return result;
	}

	public boolean isStrategy() {
		return strategy;
	}
}
