package com.sprunk;

import java.util.ArrayList;
import java.util.List;

public class Prisoner {
	private final int inmateNumber;
	private List<Integer> sequence;
	boolean survived;

	public Prisoner(int inmateNumber) {
		this.inmateNumber = inmateNumber;
		this.sequence= new ArrayList<>();
		this.survived = false;
	}

	public int getInmateNumber() {
		return inmateNumber;
	}

	public void addToSequence(int boxNumber){
		sequence.add(boxNumber);
	}
	public List<Integer> getSequence(){
		return this.sequence;
	}
	public void setSurvived(){
		survived = true;
	}

	@Override
	public String toString() {
		return "Prisoner{" +
				"inmateNumber=" + inmateNumber +
				", sequence=" + sequence +
				'}';
	}
}
