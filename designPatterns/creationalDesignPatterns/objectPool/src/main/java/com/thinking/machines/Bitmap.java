package com.thinking.machines;

public class Bitmap implements Image {
	
	private String name;
	
	private Point2D location;
	
	public Bitmap(String name) {
		this.name = name;
	}

	@Override
	public void reset() {
		this.location = null;
		System.out.println("Bitmap is reset");
	}

	@Override
	public void draw() {
		System.out.println("Drawing " + this.name + " @ " + this.location);
	}

	@Override
	public Point2D getLocation() {
		return this.location;
	}

	@Override
	public void setLocation(Point2D location) {
		this.location = location;
	}

}
