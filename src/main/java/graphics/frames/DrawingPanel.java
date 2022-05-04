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

import graphics.global.Constants;
import graphics.global.Constants.ETools;
import graphics.shapes.TShape;

public class DrawingPanel extends JPanel {

    // components
    private Vector<TShape> shapes;
    // working variable
    private ETools selectedTool;
    private TShape currentShape;


    private enum EDrawingState{
        eIdle,
        e2PointDrawing,
        eNPointDrawing
    }

    EDrawingState eDrawingState;

    public DrawingPanel(){
        this.setBackground(Color.white);
        eDrawingState = EDrawingState.eIdle;

        this.shapes = new Vector<TShape>();

        MouseHandler handler = new MouseHandler();
		this.addMouseListener(handler);
		this.addMouseMotionListener(handler);
		this.addMouseWheelListener(handler);
    }

    public void setSelectedTool(ETools selectedTool){
        this.selectedTool = selectedTool;
    }

	public void paint(Graphics graphics){
		super.paint(graphics);
		for(TShape shape: this.shapes){
			shape.draw((Graphics2D)graphics);
		}
	}


    private void prepareDrawing(int x, int y) {
    	this.currentShape = this.selectedTool.newShape();
    	
		Graphics2D graphics2d = (Graphics2D) this.getGraphics();
		graphics2d.setXORMode(this.getBackground());
		this.currentShape.setOrigin(x,y);

		this.currentShape.thickness = 3;
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
	}

    private class MouseHandler implements MouseListener, MouseMotionListener, MouseWheelListener{

        public void mouseClicked(MouseEvent e){
            if(e.getButton() == MouseEvent.BUTTON1) {
				if(e.getClickCount() == 1) {
					this.lButtonClicked(e);
				} else if(e.getClickCount() == 2) {
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
		}
		

		private void lButtonDoubleClicked(MouseEvent e) {
			if(eDrawingState == EDrawingState.eNPointDrawing) {
				finishDrawing(e.getX(), e.getY());
				eDrawingState = EDrawingState.eIdle;
			}
		}
		
		public void mouseMoved(MouseEvent e){
            if(eDrawingState == EDrawingState.eNPointDrawing) {
				keepDrawing(e.getX(), e.getY());
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