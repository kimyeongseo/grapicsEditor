package graphics.frames;

import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JRadioButton;
import javax.swing.JToolBar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import graphics.global.Constants;

public class ToolBar extends JToolBar {
    
    private JRadioButton rectangleTool;
    private JRadioButton ovalTool;
    private JRadioButton polygonTool;
    private JRadioButton lineTool;

    private Icon rectangleIcon;
	private Icon ovalIcon;
	private Icon lineIcon;
	private Icon polygonIcon;

    public ToolBar(){
        ButtonGroup buttonGroup = new ButtonGroup();
        ActionHandler actionHandler = new ActionHandler();

        this.rectangleIcon = new ImageIcon("Icon/icons8-rectangle-24.png");
		this.rectangleTool = new JRadioButton(rectangleIcon);
		this.add(this.rectangleTool);
		buttonGroup.add(this.rectangleTool);
		
		this.ovalIcon = new ImageIcon("Icon/icons8-oval-24.png");
		this.ovalTool = new JRadioButton(ovalIcon);
		this.add(this.ovalTool);
		buttonGroup.add(this.ovalTool);
		
		this.polygonIcon = new ImageIcon("Icon/icons8-polygon-24.png");
		this.polygonTool = new JRadioButton(polygonIcon);
		this.add(this.polygonTool);	
		buttonGroup.add(this.polygonTool);

        this.lineIcon = new ImageIcon("Icon/icons8-line-24.png");
		this.lineTool = new JRadioButton(lineIcon);
		this.add(this.lineTool);
		buttonGroup.add(this.lineTool);	

        this.rectangleTool.addActionListener(actionHandler);
		this.ovalTool.addActionListener(actionHandler);
        this.polygonTool.addActionListener(actionHandler);
		this.lineTool.addActionListener(actionHandler);
    }

    DrawingPanel drawingPanel = new DrawingPanel();

    public void assosiate(DrawingPanel drawingPanel) {
        this.drawingPanel = drawingPanel;
        this.rectangleTool.doClick();
    }

    private class ActionHandler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent event) {
			if(event.getSource() == rectangleTool ) {
                drawingPanel.setSelectedTool(Constants.ETools.eRectangle);		
			} else if(event.getSource() == ovalTool) {
				drawingPanel.setSelectedTool(Constants.ETools.eOval);	
            } else if(event.getSource() == polygonTool) {
                drawingPanel.setSelectedTool(Constants.ETools.ePolygon);	
			} else if(event.getSource() == lineTool) {
				drawingPanel.setSelectedTool(Constants.ETools.eLine);	
			} 
		}
		
	}

}
