package com.java.zookeeper;

public class BatTest {

	public static void main(String[] args) {
		Bat bat = new Bat();
		
		System.out.println("Bat energy Level: " + bat.energyLevel);
		bat.attackTown();
		bat.attackTown();
		bat.attackTown();
		System.out.println("Bat energy Level: " + bat.energyLevel);
		bat.eatHumans();
		bat.eatHumans();
		System.out.println("Bat energy Level: " + bat.energyLevel);
		bat.fly();
		bat.fly();
		System.out.println("Bat energy Level: " + bat.energyLevel);
		System.out.println("Noticing that the Bat is weak and tired you grab the shovel nearby and do what needs to be done while it's sleeping.");
	}

}
