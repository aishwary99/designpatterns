package com.thinking.machines;

public interface Image extends Poolable {
	
	public void draw();
	
	public Point2D getLocation();
	
	public void setLocation(Point2D location);
}
