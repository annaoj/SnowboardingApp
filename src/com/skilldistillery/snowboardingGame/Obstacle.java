package com.skilldistillery.snowboardingGame;

public abstract class Obstacle {
	private int damage;
	private int replenish;
	private int[] choices = new int[] { -2,1,0 };

	
	public Obstacle(int damage, int replenish) {
		super();
		this.damage = damage;
		this.replenish = replenish;
	}

	public Obstacle() {
		super();
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public int getReplenish() {
		return replenish;
	}

	public void setReplenish(int replenish) {
		this.replenish = replenish;
	}

	public int[] getChoices() {
		return choices;
	}

	public void setChoices(int[] choices) {
		this.choices = choices;
	}
	
	
	
}
