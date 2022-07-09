package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		//create 100 prisoners with their inmate number
		var prisoners = createPrisoners();

		//create and shuffle 100 boxes with inmate cards

        var boxes = createBoxes();

		//each prisoner gets to open 50 boxes

        GameResult result = gameWithStrategy(prisoners, boxes, false);

        System.out.println(result);

		//every prisoner needs to find their own number without communication for all of them to be freed, they are allowed to discuss a strategy beforehand.

	}

    private static GameResult gameWithStrategy(List<Prisoner> prisoners, HashMap<Integer, Integer> boxes, boolean strategy) {
        var result = new GameResult();
        if (strategy) {
            for (int i = 0; i < prisoners.size(); i++) {
                if (openBoxesWithStrategy(prisoners.get(i), boxes)) {
                    result.setCorrectGuesses(result.getCorrectGuesses() + 1);
                } else {
                    result.setAllPrisonersFreed(false);
                }
            }
        } else {
            for (int i = 0; i < prisoners.size(); i++) {
                if (openBoxesWithoutStrategy(prisoners.get(i), boxes)) {
                    result.setCorrectGuesses(result.getCorrectGuesses() + 1);
                } else {
                    result.setAllPrisonersFreed(false);
                }
            }
        }
        return result;
    }

    private static boolean openBoxesWithStrategy(Prisoner prisoner, HashMap<Integer, Integer> boxes) {
        var currentBox = prisoner.getInmateNumber();
        for (int i = 0; i < 50; i++) {
            if (boxes.get(currentBox) == prisoner.getInmateNumber()){
                return true;
            } else {
                currentBox = boxes.get(currentBox);
            }
        }
        return false;
    }

    private static boolean openBoxesWithoutStrategy(Prisoner prisoner, HashMap<Integer, Integer> boxes) {
        var currentBox = (int)(Math.random()*boxes.size())+1;
        var boxesLeft = createListOfNumbers1to100();
        for (int i = 0; i < 50; i++) {
            if (boxes.get(currentBox) == prisoner.getInmateNumber()){
                return true;
            } else {
                currentBox = boxes.get(boxesLeft.get((int)(Math.random()*boxesLeft.size())));
            }
            boxesLeft.remove(Integer.valueOf(currentBox));
        }
        return false;
    }

    private static List<Integer> createListOfNumbers1to100(){
        var numbers = new ArrayList<Integer>();

        for (int i = 0; i < 100; i++) {
            numbers.add(i+1);
        }
        return numbers;
    }

    private static HashMap<Integer, Integer> createBoxes() {
        var boxes = new HashMap<Integer, Integer>();
        var inmateCards = new ArrayList<Integer>();

        for (int i = 0; i < 100; i++) {
            inmateCards.add(i+1);
        }

        Collections.shuffle(inmateCards);

        for (int i = 0; i < 100; i++) {
            boxes.put(i+1, inmateCards.get(i));
        }
        return boxes;
    }

    private static List<Prisoner> createPrisoners() {
		var prisoners = new ArrayList<Prisoner>();

		for (int i = 0; i < 100; i++) {
			prisoners.add(new Prisoner(i+1));
		}

		return prisoners;
	}



}