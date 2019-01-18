package com.skilldistillery.snowboardingGame;

public abstract class Actor {
	private String gender;
	private String name;
	private int health;

	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getHealth() {
		return health;
	}
	public void setHealth(int health) {
		this.health = health;
	}
	public Actor() {
		super();
	}
	public Actor(String name, int health) {
		super();
		this.name = name;
		this.health = health;
	}
	public Actor(String gender, String name, int health) {
		super();
		this.gender = gender;
		this.name = name;
		this.health = health;
	}
	
	public void eat() {
		System.out.println("\"Mmmmmmm,\" says" + name);
	}
	
	

	
}

