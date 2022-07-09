package com.company.game;

import com.company.GameResult;
import com.company.Prisoner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Game {
	private final HashMap<Integer, Integer> boxes;
	private final List<Prisoner> prisoners;
	private GameResult result;
	private boolean strategy;

	public Game(boolean strategy) {
		this.boxes = Utility.createBoxes();
		this.prisoners = Utility.createPrisoners();
		this.result = new GameResult();
		this.strategy = strategy;
	}

	public void run() {
			for (int i = 0; i < prisoners.size(); i++) {
				if(strategy) {
					if (openBoxesWithStrategy(prisoners.get(i), boxes)) {
						result.setCorrectGuesses(result.getCorrectGuesses() + 1);
					} else {
						result.setAllPrisonersFreed(false);
					}
				} else {
					if (openBoxesWithoutStrategy(prisoners.get(i), boxes)) {
						result.setCorrectGuesses(result.getCorrectGuesses() + 1);
					} else {
						result.setAllPrisonersFreed(false);
					}
				}
				result.addPrisoner(prisoners.get(i));
			}
	}

	private boolean openBoxesWithStrategy(Prisoner prisoner, HashMap<Integer, Integer> boxes) {
		var currentBox = prisoner.getInmateNumber();
		for (int i = 0; i < 50; i++) {
			prisoner.addToSequence(currentBox);
			if (boxes.get(currentBox) == prisoner.getInmateNumber()) {
				prisoner.addToSequence(boxes.get(currentBox));
				prisoner.setSurvived();
				return true;
			} else {
				currentBox = boxes.get(currentBox);
			}
		}
		return false;
	}

	private boolean openBoxesWithoutStrategy(Prisoner prisoner, HashMap<Integer, Integer> boxes) {
		var currentBox = (int) (Math.random() * boxes.size()) + 1;
		var boxesLeft = createListOfNumbers1to100();
		for (int i = 0; i < 50; i++) {
			prisoner.addToSequence(currentBox);
			if (boxes.get(currentBox) == prisoner.getInmateNumber()) {
				return true;
			} else {
				currentBox = boxes.get(boxesLeft.get((int) (Math.random() * boxesLeft.size())));
			}
			boxesLeft.remove(Integer.valueOf(currentBox));
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

	public HashMap<Integer, Integer> createBoxes() {
		var boxes = new HashMap<Integer, Integer>();
		var inmateCards = new ArrayList<Integer>();

		for (int i = 0; i < 100; i++) {
			inmateCards.add(i + 1);
		}

		Collections.shuffle(inmateCards);

		for (int i = 0; i < 100; i++) {
			boxes.put(i + 1, inmateCards.get(i));
		}
		return boxes;
	}

	public List<Prisoner> createPrisoners() {
		var prisoners = new ArrayList<Prisoner>();

		for (int i = 0; i < 100; i++) {
			prisoners.add(new Prisoner(i + 1));
		}
		return prisoners;
	}

	public HashMap<Integer, Integer> getBoxes() {
		return boxes;
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
