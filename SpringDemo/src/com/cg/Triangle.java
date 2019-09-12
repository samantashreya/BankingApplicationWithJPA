package com.cg;

public class Triangle {
	private String type;
	private int height;
	
	public Triangle() {
		super();

	}

	public Triangle(String type) {
		super();
		this.type = type;
	}

	public Triangle(String type, int height) {
		super();
		this.type = type;
		this.height = height;
	}

	public void draw() {
		System.out.println(type + " Traingle drawn of height "+height);
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
