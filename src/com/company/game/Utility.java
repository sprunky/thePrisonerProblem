package com.company.game;

import com.company.Prisoner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Utility {
	public static HashMap<Integer, Integer> createBoxes() {
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

	public static List<Prisoner> createPrisoners() {
		var prisoners = new ArrayList<Prisoner>();

		for (int i = 0; i < 100; i++) {
			prisoners.add(new Prisoner(i + 1));
		}
		return prisoners;
	}
}
