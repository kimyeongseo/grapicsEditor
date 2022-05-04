package graphics.frames;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.util.Vector;

import graphics.global.Constants.ETools;
import graphics.shapes.TShape;
import java.awt.Cursor;

public class DrawingPanel extends JPanel {

	// components
	private boolean bUpdated;
	private Vector<TShape> shapes;
	public int thick;

	// working variable
	private ETools selectedTool;
	private TShape currentShape;
	private TShape selectedShape;

	private enum EDrawingState {
		eIdle,
		e2PointDrawing,
		eNPointDrawing
	}

	EDrawingState eDrawingState;

	public DrawingPanel() {
		this.setBackground(Color.white);
		eDrawingState = EDrawingState.eIdle;

		this.bUpdated = false;
		this.shapes = new Vector<TShape>();

		MouseHandler handler = new MouseHandler();
		this.addMouseListener(handler);
		this.addMouseMotionListener(handler);
		this.addMouseWheelListener(handler);
	}

	public boolean isUpdated() {
		return this.bUpdated;
	}

	public boolean getUpdated() {
		return this.bUpdated;
	}

	public void setUpdated(boolean bUpdated) {
		this.bUpdated = bUpdated;
	}

	public void setSelectedTool(ETools selectedTool) {
		this.selectedTool = selectedTool;
	}

	public void paint(Graphics graphics) {
		super.paint(graphics);
		for (TShape shape : this.shapes) {
			shape.draw((Graphics2D) graphics);
			shape.drawAnchor((Graphics2D)graphics);
		}
	}

	public Vector<TShape> getShapes() {
		return shapes;
	}

	public void setShapes(Vector<TShape> shapes) {
		this.shapes = (Vector<TShape>) shapes;
		this.repaint();
	}

	private void prepareDrawing(int x, int y) {
		this.currentShape = this.selectedTool.newShape();

		Graphics2D graphics2d = (Graphics2D) this.getGraphics();
		graphics2d.setXORMode(this.getBackground());
		this.currentShape.setOrigin(x, y);

		this.currentShape.thickness = this.thick;
		this.currentShape.draw(graphics2d);
	}

	private void keepDrawing(int x, int y) {
		// erase
		Graphics2D graphics2d = (Graphics2D) this.getGraphics();
		graphics2d.setXORMode(this.getBackground());
		this.currentShape.draw(graphics2d);

		// draw
		this.currentShape.resize(x, y);
		this.currentShape.draw(graphics2d);
	}

	private void continueDrawing(int x, int y) {
		this.currentShape.addPoint(x, y);
	}

	private void finishDrawing(int x, int y) {
		Graphics2D graphics2d = (Graphics2D) this.getGraphics();
		graphics2d.setPaintMode();
		this.currentShape.draw(graphics2d);

		this.shapes.add(this.currentShape);
		this.setUpdated(true);
	}

	private boolean onShape(int x, int y) {
		for (TShape shape : this.shapes) {
			if (shape.contains(x, y)) {
				this.selectedShape = shape;
				return true;
			}
		}
		return false;
	}

	private void changeCursor(int x, int y) {
		Cursor cursor = new Cursor(Cursor.DEFAULT_CURSOR);
		if (onShape(x, y)) {
			cursor = new Cursor(Cursor.CROSSHAIR_CURSOR);
		}
		this.setCursor(cursor);
	}

	private void selectShape() {
		this.repaint();
		this.selectedShape.setSelected(true);
		Graphics2D g2d = (Graphics2D) this.getGraphics();
		this.selectedShape.drawAnchor(g2d);
	}

	public void newDrawingPanel() {
		this.shapes.clear();
		repaint();
	}

	private class MouseHandler implements MouseListener, MouseMotionListener, MouseWheelListener {

		public void mouseClicked(MouseEvent e) {
			if (e.getButton() == MouseEvent.BUTTON1) {
				if (e.getClickCount() == 1) {
					this.lButtonClicked(e);
				} else if (e.getClickCount() == 2) {
					this.lButtonDoubleClicked(e);
				}
			}
		}

		private void lButtonClicked(MouseEvent e) {
			if(eDrawingState == EDrawingState.eIdle) {
				if(selectedTool == ETools.ePolygon) {
					eDrawingState = EDrawingState.eNPointDrawing;
					prepareDrawing(e.getX(), e.getY());	
				}
			} else if(eDrawingState == EDrawingState.eNPointDrawing) {
				continueDrawing(e.getX(), e.getY());
			}

			if (selectedTool == ETools.eSelect) {
				if (onShape(e.getX(), e.getY())) {
					selectShape();
					System.out.println(selectedShape);
				}
			}
		}

		private void lButtonDoubleClicked(MouseEvent e) {
			if (eDrawingState == EDrawingState.eNPointDrawing) {
				finishDrawing(e.getX(), e.getY());
				eDrawingState = EDrawingState.eIdle;
			}
		}

		public void mouseMoved(MouseEvent e) {
			if (eDrawingState == EDrawingState.eNPointDrawing) {
				keepDrawing(e.getX(), e.getY());
			}
			if (eDrawingState == EDrawingState.eIdle && selectedTool == ETools.eSelect) {
				changeCursor(e.getX(), e.getY());
			}
		}

		public void mousePressed(MouseEvent e) {
			if (eDrawingState == EDrawingState.eIdle) {
				if (selectedTool != ETools.ePolygon) {
					eDrawingState = EDrawingState.e2PointDrawing;
					prepareDrawing(e.getX(), e.getY());
				}
			}
		}

		public void mouseReleased(MouseEvent e) {
			if (eDrawingState == EDrawingState.e2PointDrawing) {
				finishDrawing(e.getX(), e.getY());
				eDrawingState = EDrawingState.eIdle;
			}
		}

		public void mouseEntered(MouseEvent e) {
		}

		public void mouseExited(MouseEvent e) {
		}

		public void mouseDragged(MouseEvent e) {
			if (eDrawingState == EDrawingState.e2PointDrawing)
				keepDrawing(e.getX(), e.getY());
		}

		public void mouseWheelMoved(MouseWheelEvent e) {
		}
	}

}