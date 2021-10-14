package com.java.zookeeper;

public class Mammal {
	protected Integer energyLevel = 100;
	
	public Integer displayEnergy() {
		System.out.println("Energy Level: " + this.energyLevel);
		return this.energyLevel;
	}
	
	
}
