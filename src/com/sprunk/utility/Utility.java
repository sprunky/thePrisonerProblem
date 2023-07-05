package com.sprunk.utility;

import com.sprunk.model.Prisoner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Utility {
	public static HashMap<Integer, Integer> createDrawers() {
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

	public static List<Prisoner> createPrisoners() {
		var prisoners = new ArrayList<Prisoner>();

		for (int i = 0; i < 100; i++) {
			prisoners.add(new Prisoner(i + 1));
		}
		return prisoners;
	}
}
