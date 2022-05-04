package graphics.shapes;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.io.Serializable;

public class TAnchors implements Serializable {
	private static final long serialVersionUID = 1L;

	// TAnchors size setting
	private final int WIDTH = 10;
	private final int HEIGHT = 10;

	public enum EAnchors {
		eNW, eWW, eSW, eSS, eSE, eEE, eNE, eNN, eRR;
		
		int dx, dy;
	}

	private Ellipse2D anchors[];

	public TAnchors() {
		this.anchors = new Ellipse2D[EAnchors.values().length];
		for (EAnchors eAnchor : EAnchors.values()) {
			this.anchors[eAnchor.ordinal()] = new Ellipse2D.Double();
			this.anchors[eAnchor.ordinal()].setFrame(0, 0, WIDTH, HEIGHT);
		}
	}

	public void draw(Graphics2D g2d, Rectangle boundingRectangle) {
		for (EAnchors eAnchor : EAnchors.values()) {
			int x = boundingRectangle.x;
			int y = boundingRectangle.y;
			int w = boundingRectangle.width;
			int h = boundingRectangle.height;
			
			switch (eAnchor) {
			case eNW:							break;
			case eWW:				y += h / 2;	break;
			case eSW:				y += h;		break;
			case eSS:	x += w / 2;	y += h;		break;
			case eSE:	x += w ;	y += h;		break;
			case eEE:	x +=w;		y += h / 2;	break;
			case eNE:	x += w;					break;
			case eNN:	x += w / 2;				break;
			case eRR:	x += w/2;	y = y - 30;	break;
			default:
				break;
			}
			
			x = x - WIDTH/2;
			y = y -  HEIGHT/2;
			
			g2d.setStroke(new BasicStroke(1));
			this.anchors[eAnchor.ordinal()].setFrame(x, y, WIDTH, HEIGHT);
			
//			Color foreground = g2d.getColor();
//			g2d.setColor(g2d.getBackground());
//			g2d.fill(this.anchors[eAnchor.ordinal()]);		
//			g2d.setColor(foreground);
			g2d.draw(this.anchors[eAnchor.ordinal()]);

		}
	}
}

