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
	private TAnchors anchors;
	private boolean selected;

	// constructor
	public TShape(){
		this.anchors = new TAnchors();
	}
	public abstract TShape clone();	
	public void initialize() {}

	// setters and getters
	public boolean beSelected(){return selected;}
	public void setSelected(boolean selected){ this.selected = selected;}

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

	public void drawAnchor(Graphics2D graphics2d) {
		if(this.shape.getBounds().getWidth() == 0 && this.shape.getBounds().getHeight() ==0) {
			return;
		}
		if(this.selected) {
		this.anchors.draw(graphics2d, this.shape.getBounds());
		}
	}
	
	public abstract void resize(int x, int y);
}
