package graphics.shapes;

import java.awt.BasicStroke;
import java.awt.Graphics2D;


public class TLine extends TShape {
	private int x, y, currentX, currentY;
	
	public TLine() {
	}

	public void getCoord(int x, int y){
		this.x = x;
		this.y = y;
		this.currentX = 0;
		this.currentY = 0;
	}
	
	@Override
	public void resize(int currentX, int currentY) {
		this.currentX = currentX;
		this.currentY = currentY;
	}
	
	public void draw(Graphics2D graphics2d) {
		((Graphics2D)graphics2d).setStroke(new BasicStroke(thickness()));
		graphics2d.drawLine(x, y, currentX==0? x : currentX, currentY==0? y : currentY);
		
	}

}
