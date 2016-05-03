package org.catolicasc.plandiet.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Food {

	@Id
	@GeneratedValue
	private int id;
	
	private String name;
	private double calorie;

	public Food(int id, String name, double calorie) {
		this.id = id;
		this.name = name;
		this.calorie = calorie;
	}

	public Food() {
	}

	public int getId() {
		return this.id;
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

	public double getCalorie() {
		return calorie;
	}

	public void setCalorie(double calorie) {
		this.calorie = calorie;
	}
}
