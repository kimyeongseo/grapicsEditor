package graphics.shapes;

import java.awt.BasicStroke;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class TRectangle extends TShape{
	private int startX, startY;
	
	public TRectangle() {
		this.shape = new Rectangle.Double();
	}
	
	public TShape clone() {
		return new TRectangle();
	}
	
	public void setOrigin(int x, int y) {
		Rectangle.Double rectangle = (Rectangle.Double) this.shape;
		rectangle.x = x;
		rectangle.y = y;
		startX = x;
		startY = y;
	}
	
	public void resize(int x, int y) {
		Rectangle.Double rectangle = (Rectangle.Double) this.shape;
		rectangle.setFrameFromDiagonal(startX, startY, x, y);

	}
	
	public void draw(Graphics2D graphics2d) {
		((Graphics2D)graphics2d).setStroke(new BasicStroke(thickness()));
		graphics2d.draw(this.shape);
	}


	@Override
	public boolean contains(int x, int y) {
		return this.shape.contains(x,y);
	}

}