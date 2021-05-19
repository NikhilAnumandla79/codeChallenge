package com.playermanagement.model;

public class Player {
	private int id;
	private String name;
	private int age;
	private String gender;
	private String team;
	public Player() {
		// TODO Auto-generated constructor stub
	}
	public Player(int id, String name, int age, String gender, String team) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.team = team;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getTeam() {
		return team;
	}
	public void setTeam(String team) {
		this.team = team;
	}
	
}
