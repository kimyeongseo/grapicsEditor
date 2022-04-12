package graphics.shapes;

import java.awt.BasicStroke;
import java.awt.Graphics2D;


public class TPolygon extends TShape{
		
	private final int MAX_POINTS = 50;
	private int[] xPoints, yPoints;
	private int nPoints;

	public TPolygon() {
	}

	public void getCoord(int x, int y){
		this.nPoints = 0;
		this.xPoints = new int[MAX_POINTS];
		this.yPoints = new int[MAX_POINTS];

		this.xPoints[this.nPoints] = x;
		this.yPoints[this.nPoints] = y;
		this.nPoints++;

        this.addPoint(x, y);
        this.addPoint(x, y);
	}
	
	public void addPoint(int x, int y) {
		this.xPoints[this.nPoints] = x;
		this.yPoints[this.nPoints] = y;
		this.nPoints++;
	}

	@Override
	public void resize(int x, int y) {	
		this.xPoints[this.nPoints-1] = x;
		this.yPoints[this.nPoints-1] = y;
	}

	@Override
	public void draw(Graphics2D graphics2d) {
		((Graphics2D) graphics2d).setStroke(new BasicStroke(thickness()));
		graphics2d.drawPolyline(xPoints, yPoints, nPoints);
	}
		
}
