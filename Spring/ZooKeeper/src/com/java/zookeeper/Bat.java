package com.java.zookeeper;

public class Bat extends Mammal {
	public Bat() {
		super();
		this.energyLevel = 300;
	}

//	private Integer energyLevel = 300;
	
	public void fly() {
		System.out.println("The wings of the Bat begin to move as it takes flight.");
		this.energyLevel -= 50;
	}
	
	public void eatHumans() {
		System.out.println("The Bat begins eating a hu.... oh God!");
		System.out.println("You begin to question if you should do something to stop this beast from remaining in this world...");
		this.energyLevel += 25;
	}
	
	public void attackTown() {
		System.out.println("The Bat begins to attack a town and the town begins to go up in flames...");
		this.energyLevel -= 100;
	}

	public Integer getEnergyLevel() {
		return energyLevel;
	}

	public void setEnergyLevel(Integer energyLevel) {
		this.energyLevel = energyLevel;
	}
	
	
	
}
