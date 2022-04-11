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

import graphics.global.Constants;
import graphics.global.Constants.ETools;

import graphics.shapes.TLine;
import graphics.shapes.TOval;
import graphics.shapes.TPolygon;
import graphics.shapes.TRectangle;
import graphics.shapes.TShape;

public class DrawingPanel extends JPanel {

    private ETools eTool;
    private TShape selectedTool;

    public DrawingPanel(){
        this.setBackground(Color.white);

        MouseHandler handler = new MouseHandler();
		this.addMouseListener(handler);
		this.addMouseMotionListener(handler);
		this.addMouseWheelListener(handler);
    }

    public void setSelectedTool(Constants.ETools eTool){
        this.eTool = eTool;
    }

    public void paint(Graphics graphics){
        super.paint(graphics);
    }


    private void prepareDrawing(int x, int y) {
		if (this.eTool == ETools.ePolygon) {
			this.selectedTool = new TPolygon(x, y);

		} else if (this.eTool == ETools.eRectangle) {
			this.selectedTool = new TRectangle(x, y);

		} else if (this.eTool == ETools.eOval) {
			this.selectedTool = new TOval(x, y);

		} else if (this.eTool == ETools.eLine) {
			this.selectedTool = new TLine(x, y);
		}
		Graphics2D graphics2d = (Graphics2D) this.getGraphics();
		graphics2d.setXORMode(this.getBackground());
		this.selectedTool.draw(graphics2d);

	}

	private void keepDrawing(int x, int y) {
		// erase
		Graphics2D graphics2d = (Graphics2D) this.getGraphics();
		graphics2d.setXORMode(this.getBackground());
		this.selectedTool.draw(graphics2d);

		// draw
		this.selectedTool.resize(x, y);
		this.selectedTool.draw(graphics2d);
	}

    private void finishDrawing(int x, int y){
        
    }


    private class MouseHandler implements MouseListener, MouseMotionListener, MouseWheelListener{

        public void mouseClicked(MouseEvent e){
		}
		
		public void mouseMoved(MouseEvent e){
		}
		
		public void mousePressed(MouseEvent e) {
            prepareDrawing(e.getX(), e.getY());
		}

		public void mouseReleased(MouseEvent e) {
            finishDrawing(e.getX(), e.getY());
		}

		public void mouseEntered(MouseEvent e) {
		}

		public void mouseExited(MouseEvent e) {
		}

		public void mouseDragged(MouseEvent e) {
            keepDrawing(e.getX(), e.getY());
		}
	
		public void mouseWheelMoved(MouseWheelEvent e) {
		}
    }
    
}
