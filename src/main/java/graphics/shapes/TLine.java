package graphics.shapes;

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
}