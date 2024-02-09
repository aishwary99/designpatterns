package com.thinking.machines;

public class Driver {
	
	private static final ObjectPool<Bitmap> bitmapPool = 
			new ObjectPool(() -> new Bitmap("abcd.png"), 5);
	
	public static void main(String args[]) {
		Bitmap one = bitmapPool.get();
		one.setLocation(new Point2D(10, 10));
		
		Bitmap two = bitmapPool.get();
		two.setLocation(new Point2D(-10, 0));
		
		one.draw();
		two.draw();
		
		bitmapPool.release(one);
		bitmapPool.release(two);
	}
}
