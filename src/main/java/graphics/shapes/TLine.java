package graphics.shapes;

import java.awt.BasicStroke;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;

public class TLine extends TShape {
	
	public TLine() {
		this.shape = new Line2D.Double();
	}
	
	public TShape clone() {
		return new TLine();
	}
		
	public void setOrigin(int x, int y) {
		Line2D.Double line = (Line2D.Double) this.shape;
		line.setLine(x,y,x,y);
	}
	
	@Override
	public void resize(int x, int y) {
		Line2D.Double line = (Line2D.Double) this.shape;
		line.setLine(line.x1, line.y1, x, y);
	}
	
	public void draw(Graphics2D graphics2d) {
		((Graphics2D)graphics2d).setStroke(new BasicStroke(thickness()));		
		graphics2d.draw(this.shape);
	}

	@Override
	public boolean contains(int x, int y) {
		// TODO Auto-generated method stub
		return false;
	}
}