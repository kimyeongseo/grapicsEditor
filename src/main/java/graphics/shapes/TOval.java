package graphics.shapes;

import java.awt.geom.Ellipse2D;

public class TOval extends TShape {
	private int startX, startY;

	public TOval() {
		this.shape = new Ellipse2D.Double();
	}

	public TShape clone() {
		return new TOval();
	}

	public void setOrigin(int x, int y) {
		Ellipse2D.Double ellipse = (Ellipse2D.Double) this.shape;
		ellipse.x = x;
		ellipse.y = y;
		startX = x;
		startY = y;
	}

	public void resize(int x, int y) {
		Ellipse2D.Double ellipse = (Ellipse2D.Double) this.shape;
		ellipse.setFrameFromDiagonal(startX, startY, x, y);
	}
}