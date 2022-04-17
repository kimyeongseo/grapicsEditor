package graphics.shapes;

import java.awt.BasicStroke;
import java.awt.Graphics2D;

public class TRectangle extends TShape{
	private boolean draggedDirectionX, draggedDirectionY;
	private int x,y,w,h;

	public TRectangle() {
	}

	public TShape clone() {
		return new TRectangle();
	}

	public void setOrigin(int x, int y) {
		this.x = x;
		this.y = y;
		this.w = 0;
		this.h = 0;
	}
	public void resize(int currentX, int currentY) {
		this.w = currentX - x > 0 ? currentX - x : x- currentX;
		this.h = currentY - y > 0 ? currentY - y : y- currentY;
		this.draggedDirectionX = currentX - x > 0 ? true : false;
		this.draggedDirectionY = currentY - y > 0 ? true : false;
	}
	
	public void draw(Graphics2D graphics2d) {
		((Graphics2D)graphics2d).setStroke(new BasicStroke(thickness()));
		graphics2d.drawRect(draggedDirectionX==true ? x: x-w,draggedDirectionY==true ? y: y-h, w,h);
	}
}
