package graphics.shapes;

import java.awt.BasicStroke;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.io.Serializable;

abstract public class TShape implements Serializable{
	// attributes
	private static final long serialVersionUID = 1L;

	// components
	protected Shape shape;
	public int thickness;

	// constructor
	public TShape(){}
	public abstract TShape clone();	
	public void initialize() {}

	// setters and getters
	public abstract void setOrigin(int x, int y);
	public void addPoint(int x, int y) {}

	// method
	public boolean contains(int x, int y){
		return this.shape.contains(x, y);
	}

	public  void draw(Graphics2D graphics2d){
		((Graphics2D) graphics2d).setStroke(new BasicStroke(this.thickness));
		graphics2d.draw(this.shape);
	}
	public abstract void resize(int x, int y);
}
