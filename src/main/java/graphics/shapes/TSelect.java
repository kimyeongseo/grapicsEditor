package graphics.shapes;

import java.awt.Graphics2D;
import java.awt.Rectangle;

public class TSelect extends TShape{
	private int startX, startY;

	public TSelect() {
		this.shape = new Rectangle.Double();
	}
	
	@Override
	public void setOrigin(int x, int y) {
		Rectangle.Double select = (Rectangle.Double) this.shape;
		select.x = x;
		select.y = y;
		startX = x;
		startY = y;
	}

	@Override
	public void draw(Graphics2D graphics2d) {
		graphics2d.draw(this.shape);
	}

	@Override
	public void resize(int x, int y) {
		Rectangle.Double select = (Rectangle.Double) this.shape;
		select.setFrameFromDiagonal(startX, startY, x, y);
	}
	
	public void move(int x, int y) {
		Rectangle.Double select = (Rectangle.Double) this.shape;
		select.setFrameFromDiagonal(startX, startY, x, y);
	}

	@Override
	public boolean contains(int x, int y) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public TShape clone() {
		// TODO Auto-generated method stub
		return null;
	}

}
