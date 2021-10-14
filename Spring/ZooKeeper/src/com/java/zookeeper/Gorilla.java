package com.java.zookeeper;

public class Gorilla extends Mammal {
	
	public void throwSomething () {
		System.out.println("The Gorilla has thown some brown stuff at you. Eww.");
//		Need to decrease energyLevel
		energyLevel -= 5;
	}
	
	public void eatBananas() {
		System.out.println("The Gorilla starts eating a banana and becomes satisfied.");
//		Need to increase energyLevel
		energyLevel += 10;
	}
	
	public void climb() {
		System.out.println("The Gorilla begins to climb a tree.");
		energyLevel -= 10;
	}

}
