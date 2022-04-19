package graphics.shapes;

import java.awt.BasicStroke;
import java.awt.Graphics2D;
import java.awt.Polygon;

public class TPolygon extends TShape{
	
	public TPolygon() {
		this.shape = new Polygon();
	}
	
	public TShape clone() {
		return new TPolygon();
	}
	
	public void setOrigin(int x, int y) {
		Polygon polygon = (Polygon) this.shape;
		polygon.addPoint(x, y);
		polygon.addPoint(x, y);
	}
	

	public void addPoint(int x, int y) {
		Polygon polygon = (Polygon) this.shape;
		polygon.addPoint(x, y);
	}

	@Override
	public void resize(int x, int y) {	
		Polygon polygon = (Polygon) this.shape;
		polygon.xpoints[polygon.npoints -1] = x;
		polygon.ypoints[polygon.npoints -1] = y;
	}

	@Override
	public void draw(Graphics2D graphics2d) {
		((Graphics2D) graphics2d).setStroke(new BasicStroke(thickness()));
		graphics2d.draw(this.shape);
	}

	@Override
	public boolean contains(int x, int y) {
		// TODO Auto-generated method stub
		return false;
	}
		
}