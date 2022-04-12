package graphics.shapes;

import java.awt.Graphics2D;

abstract public class TShape{
	public TShape() {
		}
	public abstract void resize(int x, int y);
	public abstract void draw(Graphics2D graphics2d);
	public int thickness() {
		int thickness = 3;
		return thickness;
	}
	public void addPoint(int x, int y) {		
	}; 
}
