package graphics;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

public class DrawingPanel extends JPanel {

    public DrawingPanel(){
        this.setBackground(Color.white);

        MouseHandler handler = new MouseHandler();
		this.addMouseListener(handler);
		this.addMouseMotionListener(handler);
		this.addMouseWheelListener(handler);
    }

    public void paint(Graphics graphics){
        super.paint(graphics);
    }

    Rectangle rectangle;
    Oval oval;
    Line line;

    private void prepareDrawing(int x, int y){
        this.rectangle = new Rectangle(x, y);
        this.oval = new Oval(x, y);
        this.line = new Line(x, y);

        Graphics2D graphics2d = (Graphics2D) this.getGraphics();
		graphics2d.setXORMode(this.getBackground());
        this.rectangle.draw(graphics2d);
        this.oval.draw(graphics2d);
        this.line.draw(graphics2d);
    }

    private void keepDrawing(int x, int y){
        // erase
        Graphics2D graphics2d = (Graphics2D) this.getGraphics();
		graphics2d.setXORMode(this.getBackground());
        this.rectangle.draw(graphics2d);
        this.oval.draw(graphics2d);
        this.line.draw(graphics2d);


        // draw
        this.rectangle.resize(x, y);
        this.rectangle.draw(graphics2d);
        this.oval.resize(x, y);
        this.oval.draw(graphics2d);
        this.line.resize(x, y);
        this.line.draw(graphics2d);
    }

    private void finishDrawing(int x, int y){
        
    }

    private class Rectangle{
        private int x, y, w, h;
        private boolean draggedDirectionX, draggedDirectionY;

        public Rectangle(int x, int y){
            this.x = x;
            this.y = y;
            this.w = 0;
            this.h = 0;
        }

        public void resize(int currentX, int currentY){
            this.w = currentX - x > 0 ? currentX - x : x- currentX;
		    this.h = currentY - y > 0 ? currentY - y : y- currentY;
		    this.draggedDirectionX = currentX - x > 0 ? true : false;
		    this.draggedDirectionY = currentY - y > 0 ? true : false;
        }

        public void draw(Graphics2D graphics2d){
            graphics2d.drawRect(draggedDirectionX==true ? x: x-w,draggedDirectionY==true ? y: y-h, w,h);
        }
    }

    private class Oval{
        private int x, y, w, h;
        private boolean draggedDirectionX, draggedDirectionY;

        public Oval(int x, int y){
            this.x = x;
            this.y = y;
            this.w = 0;
            this.h = 0;
        }

        public void resize(int currentX, int currentY){
            this.w = currentX - x > 0 ? currentX - x : x- currentX;
		    this.h = currentY - y > 0 ? currentY - y : y- currentY;
		    this.draggedDirectionX = currentX - x > 0 ? true : false;
		    this.draggedDirectionY = currentY - y > 0 ? true : false;
        }

        public void draw(Graphics2D graphics2d){
            graphics2d.drawOval(draggedDirectionX==true ? x: x-w,draggedDirectionY==true ? y: y-h, w,h);
        }
    }

    private class Line{
        private int x, y, currentX, currentY;
	
        public Line(int x, int y) {
            this.x = x;
            this.y = y;
            this.currentX = 0;
            this.currentY = 0;
        }

        public void resize(int currentX, int currentY) {
            this.currentX = currentX;
            this.currentY = currentY;
        }
        
        public void draw(Graphics2D graphics2d) {
            graphics2d.drawLine(x, y, currentX==0? x : currentX, currentY==0? y : currentY); 
        }
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
